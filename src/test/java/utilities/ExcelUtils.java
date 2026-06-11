package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(int row, int col) {

        String data = "";

        try {

            FileInputStream fis =
                    new FileInputStream(
                            "testdata/Logindata.xlsx");

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheetAt(0);

            data =
                    sheet.getRow(row + 1)
                         .getCell(col)
                         .getStringCellValue();

            workbook.close();
            fis.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return data;
    }
}