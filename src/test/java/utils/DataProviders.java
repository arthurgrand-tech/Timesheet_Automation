package utils;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "customerData")
    public static Object[][] getCustomerData() {
        return ExcelUtil.getTestData("Customers");
    }

   
}