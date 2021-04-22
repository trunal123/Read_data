import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {

            public static void main(String args[]) throws IOException {
            //Create an object of File class to open xlsx file
            File file = new File("C:\\Users\\Perennial - QA\\Desktop\\Datafile_1.xlsx");

            //Create an object of FileInputStream class to read excel file
            FileInputStream inputStream = new FileInputStream(file);

            //creating workbook instance that refers to .xls file
            XSSFWorkbook Wd = new XSSFWorkbook(inputStream);
            //HSSFWorkbook wb = new HSSFWorkbook(inputStream);
            XSSFSheet sheet = Wd.getSheet("STUDENT_DATA");

            //HSSFSheet sheet=wb.getSheet("STUDENT_DATA");

                //get all rows in the sheet
                int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

                //iterate over all the row to print the data present in each cell.
                for(int i=0;i<=rowCount;i++) {

                    //get cell count in a row
                    int cellcount = sheet.getRow(i).getLastCellNum();

                    //iterate over each cell to print its value
                    System.out.println("Row" + i + " data is :");

                    for (int j = 0; j < cellcount; j++) {
                       // System.out.print(sheet.getRow(i).getCell(j).toString()+ ",");
                        System.out.print(sheet.getRow(i).getCell(j).toString()+ ",");
                    }
                    System.out.println();
                }
        }
    }


