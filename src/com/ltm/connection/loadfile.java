/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import object.customer;

/**
 *
 * @author Admin
 */
public class loadfile {
    
 
    public void ghipath(String s) throws FileNotFoundException, IOException
   {
       File file= new File("path.txt");
       FileOutputStream out= new FileOutputStream(file);
       if(!file.exists())
       {
           file.createNewFile();
       
       }
       
       out.write(s.getBytes());
      out.close();
   }
    public String laypath() throws FileNotFoundException, IOException
    {
        String tmp=" ";
        
          File file= new File("path.txt");
           if(!file.exists())
        {
           file.createNewFile();
       
        }
          FileInputStream in= new FileInputStream(file);
          int c= in.read();
          tmp+=(char)c;
          while (c!=-1) {            
            c=in.read();
            if(c!=-1)
            {
            tmp+=(char)c;
            }
              
        }
          in.close();
         
        return  tmp.trim();
    }
    public  String converttien(long tien)
{
    
    String s = String.valueOf(tien);

    byte[] bf = s.getBytes();

    String kq = " ";
    int k = 0;

    for (int i = bf.length - 1; i >= 0; i--) {

        if (k % 3 == 0 && i != bf.length-1) {
            kq = "." + kq.trim();
        }

        kq = (char) bf[i] + kq;
        k++;

    }
   
    return kq.trim();
}
    public void in(customer kh,String name) throws IOException
    {
        File f = new File("C:\\Users\\Lee\\Desktop\\hoadon");
        if(!f.exists())
        {
            f.mkdir();
        }
        File file =new File("C:\\Users\\Lee\\Desktop\\hoadon\\"+name+".txt");
        long tienthuctmp=0;
        long tiengiamtmp=0;
        long tongtienthuc=0;
        long tongtiengiam=0;
         if(!file.exists())
       {
           file.createNewFile();
       
       }
        FileWriter fileWriter= new FileWriter(file,true);
        fileWriter.write("                      Shop Máy Tính TTM58DH                      \r\n");
        fileWriter.write("                        Hóa Đơn Bán Hàng                          \r\n\r\n");
        fileWriter.write("          Họ tên khách hàng :  "+kh.getTen()+"\r\n");
        fileWriter.write("          Địa chỉ :"+kh.getDiachi()+"\r\n");
        fileWriter.write("          Sản phẩm đã mua:\r\n");
        fileWriter.write("          -----------------------------------------\r\n");
        fileWriter.write("            STT             Ten        Soluong        Tổng Tiền \r\n");
        for(int i=0;i<kh.getDssp().size();i++)
        {
            tienthuctmp=kh.getDssp().get(i).getGia()*kh.getDssp().get(i).getSoluong();
            tiengiamtmp=tienthuctmp-((tienthuctmp/100)*kh.getDssp().get(i).getKhuyenmai());
            fileWriter.write("             "+(i+1)+"         "+kh.getDssp().get(i).getTen()+"         "+kh.getDssp().get(i).getSoluong()+"       "+converttien(tienthuctmp)+" VNĐ"+"\r\n");
            tongtienthuc+=tienthuctmp;
            tongtiengiam+=tiengiamtmp;
        }
        fileWriter.write("           -----------------------------------------\r\n\r\n");
        fileWriter.write("         Tổng tiền đã giảm:                    "+converttien(tongtiengiam)+" VNĐ"+"\r\n");
        fileWriter.write("         Tổng cộng:                             "+converttien(tongtienthuc)+" VNĐ"+"\r\n");
           fileWriter.write("           -----------------------------------------\r\n");
        fileWriter.write("                        Xin chân thành cảm ơn !");
        System.out.println("path"+file.getPath());
        fileWriter.close();
        
    }
    
}
