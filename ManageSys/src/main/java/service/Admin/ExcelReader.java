package service.Admin;

import dao.BulkInsertDao;
import dao.ClassInfoInsertDao;
import dao.Factory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ExcelReader {

    BulkInsertDao bidao = Factory.getFactory().getInstance(BulkInsertDao.class);
    ClassInfoInsertDao ciidao= Factory.getFactory().getInstance(ClassInfoInsertDao.class);

    /**
     * xls文件读取函数
     * @param excel_url
     * @param args
     * @return
     * @throws IOException
     */
    public boolean classxlsReader(String excel_url, int args) throws IOException {

        //读取xls文件
        HSSFWorkbook hssfWorkbook = null;
        //寻找目录读取文件
        File excelFile = new File(excel_url);
        InputStream is = new FileInputStream(excelFile);
        if(is == null){
            return false;
        }

        hssfWorkbook = new HSSFWorkbook(is);
        if (hssfWorkbook == null) {
            return false;
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        //遍历xlsx中的sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 对于每个sheet，读取其中的每一行
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) continue;
                ArrayList<String> curarr = new ArrayList<String>();
                for (int columnNum = 0; columnNum < args; columnNum++) {
                    HSSFCell cell = hssfRow.getCell(columnNum);
                    curarr.add(Trim_str(getValue(cell)));
                }
                ans.add(curarr);
            }
        }
        return ciidao.classInfoInsert(ans);
    }

    /**
     * xlsx文件读取函数
     * @param excel_url
     * @param args
     * @return
     * @throws IOException
     */
    public boolean classxlsxReader(String excel_url, int args) throws IOException {

        //读取xlsx文件
        XSSFWorkbook xssfWorkbook = null;
        //寻找目录读取文件
        File excelFile = new File(excel_url);
        InputStream is = new FileInputStream(excelFile);
        if(is == null){
            return false;
        }

        xssfWorkbook = new XSSFWorkbook(is);
        if (xssfWorkbook == null) {
            return false;
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        //遍历xlsx中的sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 对于每个sheet，读取其中的每一行
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) continue;
                ArrayList<String> curarr = new ArrayList<String>();
                for (int columnNum = 0; columnNum < args; columnNum++) {
                    XSSFCell cell = xssfRow.getCell(columnNum);
                    curarr.add(Trim_str(getValue(cell)));
                }
                ans.add(curarr);
            }
        }
        return ciidao.classInfoInsert(ans);
    }
    /**
     * xls文件读取函数
     * @param excel_url
     * @param type
     * @param args
     * @return
     * @throws IOException
     */
    public boolean xlsReader(String excel_url, String type, int args) throws IOException {

        //读取xls文件
        HSSFWorkbook hssfWorkbook = null;
        //寻找目录读取文件
        File excelFile = new File(excel_url);
        InputStream is = new FileInputStream(excelFile);
        if(is == null){
            return false;
        }

        hssfWorkbook = new HSSFWorkbook(is);
        if (hssfWorkbook == null) {
            return false;
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        //遍历xlsx中的sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 对于每个sheet，读取其中的每一行
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) continue;
                ArrayList<String> curarr = new ArrayList<String>();
                for (int columnNum = 0; columnNum < args; columnNum++) {
                    HSSFCell cell = hssfRow.getCell(columnNum);
                    curarr.add(Trim_str(getValue(cell)));
                }
                ans.add(curarr);
            }
        }
        return bidao.bulkInsert(ans,type);
    }

    /**
     * xlsx文件读取函数
     * @param excel_url
     * @param args
     * @return
     * @throws IOException
     */
    public boolean xlsxReader(String excel_url, String type, int args) throws IOException {

        //读取xlsx文件
        XSSFWorkbook xssfWorkbook = null;
        //寻找目录读取文件
        File excelFile = new File(excel_url);
        InputStream is = new FileInputStream(excelFile);
        if(is == null){
            return false;
        }

        xssfWorkbook = new XSSFWorkbook(is);
        if (xssfWorkbook == null) {
            return false;
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        //遍历xlsx中的sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 对于每个sheet，读取其中的每一行
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow == null) continue;
                ArrayList<String> curarr = new ArrayList<String>();
                for (int columnNum = 0; columnNum < args; columnNum++) {
                    XSSFCell cell = xssfRow.getCell(columnNum);
                    curarr.add(Trim_str(getValue(cell)));
                }
                ans.add(curarr);
            }
        }
        return bidao.bulkInsert(ans,type);
    }

    /**
     * 判断后缀为xlsx的excel文件的数据类
     */
    @SuppressWarnings("deprecation")
    private static String getValue(XSSFCell xssfCell) {
        if (xssfCell == null) {
            return "";
        }
        //判断单元格是否为布尔型，数值型，空型或错误
        if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfCell.getBooleanCellValue());
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
            double cur = xssfCell.getNumericCellValue();
            long longVal = Math.round(cur);
            Object inputValue = null;
            if (Double.parseDouble(longVal + ".0") == cur)
                inputValue = longVal;
            else
                inputValue = cur;
            return String.valueOf(inputValue);
        } else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BLANK || xssfCell.getCellType() == xssfCell.CELL_TYPE_ERROR) {
            return "";
        } else {
            return String.valueOf(xssfCell.getStringCellValue());
        }
    }

    /**
     * 判断后缀为xls的excel文件的数据类型
     */
    @SuppressWarnings("deprecation")
    private static String getValue(HSSFCell hssfCell) {
        if(hssfCell==null){
            return "";
        }
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            double cur=hssfCell.getNumericCellValue();
            long longVal = Math.round(cur);
            Object inputValue = null;
            if(Double.parseDouble(longVal + ".0") == cur)
                inputValue = longVal;
            else
                inputValue = cur;
            return String.valueOf(inputValue);
        } else if(hssfCell.getCellType() == hssfCell.CELL_TYPE_BLANK || hssfCell.getCellType() == hssfCell.CELL_TYPE_ERROR){
            return "";
        }
        else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 字符串修剪  去除所有空白符号 ，问号 ，中文空格
     */
    static private String Trim_str(String str) {
        if (str == null)
            return null;
        return str.replaceAll("[\\s\\?]", "").replace("　", "");
    }
}
