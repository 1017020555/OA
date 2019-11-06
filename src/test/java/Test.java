import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    @org.junit.Test
    public void tests02() throws Exception{
        Workbook wb = WorkbookFactory.create(new File("D:\\a\\20191025 100049customers表.xlsx"));

        Sheet sheet = wb.getSheetAt(0);

        for (int i=sheet.getFirstRowNum();i<=sheet.getLastRowNum();i++){
            Row row = sheet.getRow(i);
            for(int j=row.getFirstCellNum();j<row.getLastCellNum();j++){
                Cell cell = row.getCell(j);
                String cellValue = getCellValue(cell);
                System.out.print(cellValue+"  ");
            }
            System.out.println();
        }
    }
    private String getCellValue(Cell c){
        String o = null;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd");
        switch(c.getCellType()){
            case Cell.CELL_TYPE_BLANK:
                o = "";
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                o = String.valueOf(c.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:

                o = String.valueOf(c.getCellFormula());
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if(HSSFDateUtil.isCellDateFormatted(c)){
                    Date date = c.getDateCellValue();
                    o = sdf.format(date);
                }else {
                    BigDecimal one = new BigDecimal(c.getNumericCellValue());
                    o = one+"";
             }
                break;
            case Cell.CELL_TYPE_STRING:
                o = c.getStringCellValue();
                break;
            default:
                o = null;
                break;
        }
        return o;
    }
}
