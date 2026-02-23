package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

    private static final String path =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/testdata.xlsx";

    public static Object[][] getTestData(String sheetName) {

        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException(
                        "Sheet not found: " + sheetName);
            }

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rows - 1][cols];

            DataFormatter formatter = new DataFormatter();

            for (int i = 1; i < rows; i++) {
                Row row = sheet.getRow(i);

                for (int j = 0; j < cols; j++) {

                    Cell cell = (row == null) ? null : row.getCell(j);

                    data[i - 1][j] =
                            (cell == null)
                                    ? ""
                                    : formatter.formatCellValue(cell);
                }
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read Excel: " + e.getMessage(), e);
        }
    }
}