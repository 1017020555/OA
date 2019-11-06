package com.offcn.cust.utils;

import com.offcn.cust.bean.Customer;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WDWUtil {
    public static String stuList2Excel(List<Customer> customers) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd hhmmss");
        Workbook wb = new XSSFWorkbook();
        //标题行抽出字段
        String[] title = {"序号","id", "comname", "companyperson", "comaddress", "comphone", "camera","present","remark","addtime"};
        //设置sheet名称，并创建新的sheet对象
        String sheetName = "customers表";
        Sheet stuSheet = wb.createSheet(sheetName);
        //获取表头行
        Row titleRow = stuSheet.createRow(0);
        //创建单元格，设置style居中，字体，单元格大小等
        CellStyle style = wb.createCellStyle();
        Cell cell = null;
        //把已经写好的标题行写入excel文件中
        for (int i = 0; i < title.length; i++) {
            cell = titleRow.createCell(i);
            cell.setCellValue(title[i]);
            cell.setCellStyle(style);
        }
        //把从数据库中取得的数据一一写入excel文件中
        Row row = null;
        for (int i = 0; i < customers.size(); i++) {
            //创建list.size()行数据
            row = stuSheet.createRow(i + 1);
            //把值一一写进单元格里
            //设置第一列为自动递增的序号
            row.createCell(0).setCellValue(i + 1);
            row.createCell(1).setCellValue(customers.get(i).getId());
            row.createCell(2).setCellValue(customers.get(i).getComname());
            row.createCell(3).setCellValue(customers.get(i).getCompanyperson());
            row.createCell(4).setCellValue(customers.get(i).getComaddress());
            row.createCell(5).setCellValue(customers.get(i).getComphone());
            row.createCell(6).setCellValue(customers.get(i).getCamera());
            row.createCell(7).setCellValue(customers.get(i).getPresent());
            row.createCell(8).setCellValue(customers.get(i).getRemark());
            //把时间转换为指定格式的字符串再写入excel文件中
            if (customers.get(i).getAddtime() != null) {
                row.createCell(9).setCellValue(sdf.format(customers.get(i).getAddtime()));
            }
        }
        //设置单元格宽度自适应，在此基础上把宽度调至1.5倍
        for (int i = 0; i < title.length; i++) {
            stuSheet.autoSizeColumn(i, true);
            stuSheet.setColumnWidth(i, stuSheet.getColumnWidth(i) * 15 / 10);
        }
        //获取配置文件中保存对应excel文件的路径，本地也可以直接写成F：excel/stuInfoExcel路径
        String folderPath = "d:\\a";

        //创建上传文件目录
        File folder = new File(folderPath);
        //如果文件夹不存在创建对应的文件夹
        if (!folder.exists()) {
            folder.mkdirs();
        }
        //设置文件名
        String fileName = sdf1.format(new Date()) + sheetName + ".xlsx";
        String savePath = folderPath + File.separator + fileName;

        OutputStream fileOut = new FileOutputStream(savePath);
        wb.write(fileOut);
        fileOut.close();
        //返回文件保存全路径
        return savePath;
    }
}
