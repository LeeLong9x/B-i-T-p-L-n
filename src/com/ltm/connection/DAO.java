/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import object.nhanvien;
import object.sanpham;

public class DAO {
    
  

   Connection conn = null;
   PreparedStatement ptmt= null;
   public DAO() throws ClassNotFoundException, InstantiationException, IllegalAccessException
   {
       ketnoi();
   }
 public void ketnoi() throws ClassNotFoundException, InstantiationException, IllegalAccessException
{
    
    String url       = "jdbc:mysql://localhost:3306/appbanhang";
    String user      = "root";
    String password  = "123456";
 
      
       try {
           Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           
           conn = DriverManager.getConnection(url, user, password);
           if(conn!=null)
           {
               System.out.println("ket noi thanh cong");
               
           }
       
          
       } catch (SQLException ex) {
           System.out.println("ket noi ko thanh cong");
       }
       
} 
 public void addlsp(String lsp)
 {
        String sql="insert into tbllsp(name) values(?)";
           try {
               ptmt= conn.prepareStatement(sql);
               ptmt.setString(1,lsp );
               int check=ptmt.executeUpdate();
           if(check!=0)
           {
               JOptionPane.showConfirmDialog(null, "Thêm thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
               
           }
           else
           {
                JOptionPane.showConfirmDialog(null, "Thêm không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
               
           } catch (SQLException ex) {
               Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
           }
 }
           public void addhsp(String hsp)
   {
        String sql="insert into tblhsp(name) values(?)";
           try {
               ptmt= conn.prepareStatement(sql);
               ptmt.setString(1,hsp );
               int check=ptmt.executeUpdate();
           if(check!=0)
           {
               JOptionPane.showConfirmDialog(null, "Thêm thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
               
           }
           else
           {
                JOptionPane.showConfirmDialog(null, "Thêm không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
               
           } catch (SQLException ex) {
               Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
           }
 }
        public void addnhanvien(nhanvien nv)
   {
        String sql="insert into tbl_nhanvien(ten,gioitinh,ngaysinh,diachi,sdt,CMND,email,tendn,matkhau,trangthai,linkanh,time,luong,chucvu) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           try {
               ptmt= conn.prepareStatement(sql);
               ptmt.setString(1,nv.getTen() );
               ptmt.setString(2, nv.getGioitinh());
               ptmt.setString(3, nv.getNgaysinh());
               ptmt.setString(4, nv.getDiachi());
               ptmt.setInt(5, nv.getSdt());
               ptmt.setLong(6, nv.getCmnd());
               ptmt.setString(7, nv.getEmail());
               ptmt.setString(8, nv.getTendn());
               ptmt.setString(9, nv.getMatkhau());
               ptmt.setString(10, nv.getTrangthai());
               ptmt.setString(11, nv.getLinkanh());
               ptmt.setLong(12, nv.getTime());
               ptmt.setLong(13, nv.getLuong());
               ptmt.setString(14, nv.getChucvu());
               int check=ptmt.executeUpdate();
           if(check!=0)
           {
               JOptionPane.showConfirmDialog(null, "Thêm thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
               
           }
           else
           {
                JOptionPane.showConfirmDialog(null, "Thêm không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
               
           } catch (SQLException ex) {
               Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
           }
 }
    public ArrayList<String> getloaisp() throws SQLException
    {
        ArrayList<String> list= new ArrayList<>();
          String sql="select * from tbllsp";
          String s;
             try {
           ptmt=conn.prepareStatement(sql);
           ResultSet rs= ptmt.executeQuery(); 
          
           while (rs.next()) {   
              
              s=rs.getString("name");
              list.add(s);
           }
             }catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       
    
      return list;
    }
     public ArrayList<String> gethangsp()
    {
       ArrayList<String> list= new ArrayList<>();
          String sql="select * from tblhsp";
          String s;
             try {
           ptmt=conn.prepareStatement(sql);
           ResultSet rs= ptmt.executeQuery(); 
          
           while (rs.next()) {   
              
              s=rs.getString("name");
              list.add(s);
           }
             }catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       
    
      return list;
        
    }
     public ArrayList<sanpham>getsp()
     {
         ArrayList<sanpham> list= new ArrayList<>();
          String sql="select * from tbldssp";
          sanpham sp;
       try {
           ptmt=conn.prepareStatement(sql);
           ResultSet rs= ptmt.executeQuery(); 
          
           while (rs.next()) {   
               sp= new sanpham();
               sp.setID(rs.getInt("ID"));
               sp.setMa(rs.getString("ma"));
                sp.setTen(rs.getString("ten"));
               sp.setLoaisp(rs.getString("loai"));
               sp.setHangsx(rs.getString("hang"));
               sp.setSoluong(rs.getInt("soluong"));
               sp.setKhuyenmai(rs.getInt("khuyenmai"));
               sp.setGia(rs.getLong("gia"));
               sp.setNgayhangve(rs.getString("ngaynhap"));
               sp.setLinkanh1(rs.getString("linkanh1"));
               sp.setLinkanh2(rs.getString("linkanh2"));
               sp.setLinkanh3(rs.getString("linkanh3"));
               sp.setLinhanh4(rs.getString("linkanh4"));
               sp.setMota(rs.getString("mota"));
               list.add(sp);
           }
          
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       return list;
     }
     
     
     public ArrayList<nhanvien> getdsnv()
     {
           ArrayList<nhanvien> list= new ArrayList<>();
          String sql="select * from tbl_nhanvien";
          nhanvien nv;
       try {
           ptmt=conn.prepareStatement(sql);
           ResultSet rs= ptmt.executeQuery(); 
          
           while (rs.next()) {   
               nv= new nhanvien();
              nv.setMa(rs.getInt("ma"));
              nv.setTen(rs.getString("ten"));
              nv.setGioitinh(rs.getString("gioitinh"));
              nv.setNgaysinh(rs.getString("ngaysinh"));
              nv.setDiachi(rs.getString("diachi"));
              nv.setSdt(rs.getInt("sdt"));
              nv.setCmnd(rs.getInt("CMND"));
              nv.setEmail(rs.getString("email"));
              nv.setTendn(rs.getString("tendn"));
              nv.setMatkhau(rs.getString("matkhau"));
              nv.setTrangthai(rs.getString("trangthai"));
              nv.setLuong(rs.getLong("luong"));
              nv.setLinkanh(rs.getString("linkanh"));
              nv.setTime(rs.getInt("time"));
              nv.setChucvu(rs.getString("chucvu"));
              list.add(nv);
              
           }
          
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
       return list;
     }
     public void themsanpham(String ma,String ten,String loai,String hang,int soluong,int khuyenmai,long gia,String ngaynhap,String linkanh1,String linkanh2,String linkanh3,String linkanh4,String mota) throws IOException
{
            String sql="insert into tbldssp(ma,ten,loai,hang,soluong,khuyenmai,gia,ngaynhap,linkanh1,linkanh2,linkanh3,linkanh4,mota) values(?,?,?,?,?,?,?,?,?,?,?,?,?)" ;
           
       try {
           ptmt=conn.prepareStatement(sql);
          
           ptmt.setString(1,ma);
           ptmt.setString(2, ten);
           ptmt.setString(3, loai);
           ptmt.setString(4, hang);
           ptmt.setInt(5, soluong);
           ptmt.setInt(6, khuyenmai);
           ptmt.setLong(7, gia);
           ptmt.setString(8, ngaynhap);
           ptmt.setString(9, linkanh1);
           ptmt.setString(10, linkanh2);
           ptmt.setString(11, linkanh3);
           ptmt.setString(12, linkanh4);
           ptmt.setString(13, mota);
          
           int check=ptmt.executeUpdate();
           if(check!=0)
           {
               JOptionPane.showConfirmDialog(null, "Thêm thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
               
           }
           else
           {
                JOptionPane.showConfirmDialog(null, "Thêm không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
       } catch (SQLException ex) {
           System.out.println("loi:"+ex.getMessage());       }
            
            
}
     public void updatenhanvien(nhanvien nv)
     {
    String sql="update tbl_nhanvien set ten=?,gioitinh=?,ngaysinh=?,diachi=?,sdt=?,CMND=?,email=?,tendn=?,matkhau=?,trangthai=?,linkanh=?,time=?,luong=? where ma=?";
   try {
               ptmt= conn.prepareStatement(sql);
               ptmt.setString(1,nv.getTen() );
               ptmt.setString(2, nv.getGioitinh());
               ptmt.setString(3, nv.getNgaysinh());
               ptmt.setString(4, nv.getDiachi());
               ptmt.setInt(5, nv.getSdt());
               ptmt.setLong(6, nv.getCmnd());
               ptmt.setString(7, nv.getEmail());
               ptmt.setString(8, nv.getTendn());
               ptmt.setString(9, nv.getMatkhau());
               ptmt.setString(10, nv.getTrangthai());
               ptmt.setString(11, nv.getLinkanh());
               ptmt.setLong(12, nv.getTime());
               ptmt.setLong(13, nv.getLuong());
               ptmt.setInt(14, nv.getMa());
               
              int check= ptmt.executeUpdate();
           if(check!=0)
           {
                JOptionPane.showConfirmDialog(null, "Sửa thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
           }
           else
           {
               JOptionPane.showConfirmDialog(null, "Sửa không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
     }
     public void updatetrangthai(String tt,int ma,String content)
     {
         String sql="update tbl_nhanvien set trangthai=? where ma=?";
           try {
               ptmt=conn.prepareStatement(sql);
               ptmt.setString(1,tt);
               ptmt.setInt(2, ma);
               
           int check= ptmt.executeUpdate();
           if(check!=0)
           {
                JOptionPane.showConfirmDialog(null, "Đã "+content,"Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
           }
           else
           {
               JOptionPane.showConfirmDialog(null, "Sửa không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
     }
     public void updatedssp(int ID,String ma,String ten,String loai,String hang,int soluong,int khuyenmai,long gia,String ngaynhap,String linkanh1,String linkanh2,String linkanh3,String linkanh4,String mota)
     {
          String sql="update tbldssp SET  ma=?,ten=?,loai=?,hang=?,soluong=?,khuyenmai=?,gia=?,ngaynhap=?,linkanh1=?,linkanh2=?,linkanh3=?,linkanh4=?,mota=? WHERE ID=?";
       try {
           ptmt=conn.prepareStatement(sql);
           ptmt.setString(1, ma);
           ptmt.setString(2, ten);
           ptmt.setString(3, loai);
           ptmt.setString(4, hang);
           ptmt.setInt(5, soluong);
           ptmt.setInt(6, khuyenmai);
           ptmt.setLong(7, gia);
           ptmt.setString(8, ngaynhap);
           ptmt.setString(9, linkanh1);
           ptmt.setString(10, linkanh2);
           ptmt.setString(11, linkanh3);
           ptmt.setString(12, linkanh4);
           ptmt.setString(13, mota);
           ptmt.setInt(14, ID);
                
           int check= ptmt.executeUpdate();
           if(check!=0)
           {
                JOptionPane.showConfirmDialog(null, "Sửa thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
           }
           else
           {
               JOptionPane.showConfirmDialog(null, "Sửa không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
     }
     public void deletesp(int ID)
     {
          
        String sql="delete from tbldssp where ID=?";

        
       try {
           ptmt=conn.prepareStatement(sql);
           ptmt.setInt(1,ID);
           
           int check=ptmt.executeUpdate();
           if(check!=0)
           {
               JOptionPane.showConfirmDialog(null, "Xóa thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
               ptmt.close();
               conn.close();
           }
           else
           {
                JOptionPane.showConfirmDialog(null, "Xóa không thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
           }
       } catch (SQLException ex) {
           System.out.println(ex.getMessage());
       }
        
    
     }
    
}
