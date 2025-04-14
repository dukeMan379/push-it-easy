package utilities;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {

    @DataProvider(name = "Login Data from Excel")

    public Object[][] loginData() throws IOException {

        FileInputStream fis = new FileInputStream("C:\\Users\\Duke\\IdeaProjects\\CucumberBDDFramework\\src\\main\\resources\\ExcelFiles\\ExcelData.xlsx");

        XSSFWorkbook book = new XSSFWorkbook(fis); // Reading the excel file
        XSSFSheet sheet = book.getSheet("LoginInfo"); //Getting the Sheet

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colmCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount][colmCount];

        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < colmCount; j++) {
                data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        return data;
    }
}