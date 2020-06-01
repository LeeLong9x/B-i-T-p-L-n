/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.connection;

import com.ltm.gui.LoginForm;
import com.ltm.gui.chatseverform;
import com.sun.corba.se.impl.io.IIOPInputStream;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import object.customer;
import object.nguoichat;
import object.sanpham;
public class socketconnection implements Runnable{
    ServerSocket server;
    ObjectOutputStream os;
    ObjectInputStream is;
    DataOutputStream dos;
    ArrayList<sanpham>dssp;
     Socket socket;
     Thread thread;
     ArrayList<customer>dskh;
     ArrayList<nguoichat>dsnc;
    public socketconnection() {
    }

    public socketconnection(ServerSocket sv,ArrayList<sanpham>dssp,Socket socket,ArrayList<customer>dskh,ArrayList<nguoichat>dsnc)
    {
        this.server=sv;
        this.dssp=dssp;
        this.socket=socket;
        this.dskh=dskh;
        this.dsnc=dsnc;
    }
   
   String check=" ";
      public void addforclient(sanpham sp) throws IOException
{
   
                
               Image img = ImageIO.read(new File(sp.getLinkanh1()));
               ImageIcon icon1 = new ImageIcon(img);
               Image img2 = ImageIO.read(new File(sp.getLinkanh2()));
               ImageIcon icon2 = new ImageIcon(img2);
               Image img3 = ImageIO.read(new File(sp.getLinkanh3()));
               ImageIcon icon3 = new ImageIcon(img3);
               Image img4 = ImageIO.read(new File(sp.getLinhanh4()));
               ImageIcon icon4 = new ImageIcon(img4);
               int id = sp.getID();
               String ma = sp.getMa();
               String ten = sp.getTen();
               int soluong = sp.getSoluong();
               int khuyenmai = sp.getKhuyenmai();
               long gia= sp.getGia();
               String loaisp = sp.getLoaisp();
               String hangsx = sp.getHangsx();
               String mota=sp.getMota();
               os.writeObject("add");
               os.flush();
               os.writeObject(icon1);
               os.flush();
               os.writeObject(icon2);
               os.flush();
               os.writeObject(icon3);
               os.flush();
               os.writeObject(icon4);
               os.flush();
               os.writeObject(id);
               os.flush();
               os.writeObject(ma);
               os.flush();
               os.writeObject(ten);
               os.flush();
               os.writeObject(soluong);
               os.flush();
               os.writeObject(khuyenmai);
               os.flush();
               os.writeObject(loaisp);
               os.flush();
               os.writeObject(hangsx);
           os.flush();
        os.writeObject(mota);
        os.flush();
        os.writeObject(gia);
        os.flush();
    }
        public void updateclient(sanpham sp,int vitri) throws IOException
{
   
                
               Image img = ImageIO.read(new File(sp.getLinkanh1()));
               ImageIcon icon1 = new ImageIcon(img);
               Image img2 = ImageIO.read(new File(sp.getLinkanh2()));
               ImageIcon icon2 = new ImageIcon(img2);
               Image img3 = ImageIO.read(new File(sp.getLinkanh3()));
               ImageIcon icon3 = new ImageIcon(img3);
               Image img4 = ImageIO.read(new File(sp.getLinhanh4()));
               ImageIcon icon4 = new ImageIcon(img4);
               int id = sp.getID();
               String ma = sp.getMa();
               String ten = sp.getTen();
               int soluong = sp.getSoluong();
               int khuyenmai = sp.getKhuyenmai();
               long gia=sp.getGia();
               String loaisp = sp.getLoaisp();
               String hangsx = sp.getHangsx();
               String mota=sp.getMota();
               os.writeObject("update");
               os.flush();
               os.writeObject(icon1);
               os.flush();
               os.writeObject(icon2);
               os.flush();
               os.writeObject(icon3);
               os.flush();
               os.writeObject(icon4);
               os.flush();
               os.writeObject(id);
               os.flush();
               os.writeObject(ma);
               os.flush();
               os.writeObject(ten);
               os.flush();
               os.writeObject(soluong);
               os.flush();
               os.writeObject(khuyenmai);
               os.flush();
               os.writeObject(loaisp);
               os.flush();
               os.writeObject(hangsx);
               os.flush();
               os.writeObject(mota);
               os.flush();
               os.writeObject(gia);
               os.flush();
               os.writeObject(vitri);
               os.flush();
}
public void deleteforclient(int vitri) throws IOException
{
    os.writeObject("delete");
    os.flush();
    os.writeObject(vitri);
    os.flush();
}
    public void start()
    {
       
             
             if(thread==null) thread= new Thread(this);
             if(thread!=null) thread.start();
                 
    
    }

    @Override
    public void run() {
        if(dssp.size()>0)
                 
    {
            try {
                os = new ObjectOutputStream(socket.getOutputStream());
                is= new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(socketconnection.class.getName()).log(Level.SEVERE, null, ex);
            }
       for(int i=0;i<dssp.size();i++)
       { 
          
           sanpham sp= dssp.get(i);
                   
        
           try {
             
          

              
               Image img = ImageIO.read(new File(sp.getLinkanh1()));
               ImageIcon icon1 = new ImageIcon(img);
               Image img2 = ImageIO.read(new File(sp.getLinkanh2()));
               ImageIcon icon2 = new ImageIcon(img2);
               Image img3 = ImageIO.read(new File(sp.getLinkanh3()));
               ImageIcon icon3 = new ImageIcon(img3);
               Image img4 = ImageIO.read(new File(sp.getLinhanh4()));
               ImageIcon icon4 = new ImageIcon(img4);
               int id = sp.getID();
               String ma = sp.getMa();
               String ten = sp.getTen();
               int soluong = sp.getSoluong();
               int khuyenmai = sp.getKhuyenmai();
               long gia= sp.getGia();
               String loaisp = sp.getLoaisp();
               String hangsx = sp.getHangsx();
               String mota=sp.getMota();
               os.writeObject(icon1);
               os.flush();
               os.writeObject(icon2);
               os.flush();
               os.writeObject(icon3);
               os.flush();
               os.writeObject(icon4);
               os.flush();
               os.writeObject(id);
               os.flush();
               os.writeObject(ma);
               os.flush();
               os.writeObject(ten);
               os.flush();
               os.writeObject(soluong);
               os.flush();
               os.writeObject(khuyenmai);
               os.flush();
               os.writeObject(loaisp);
               os.flush();
               os.writeObject(hangsx);
               os.flush();
               os.writeObject(mota);
               os.flush();
               os.writeObject(gia);
               os.flush();
            if(i<dssp.size()-1)
            {         
                   os.writeObject("tt");
                
               }
               if (i == dssp.size() - 1) {
                   os.writeObject("end");
                   new paraserver(is,os,dskh,dsnc).start();
            
               }
          } catch (IOException ex) {
               System.out.println(ex.getMessage());           }
          }}else
                     {
                         try {
                             os = new ObjectOutputStream(socket.getOutputStream());
                               os.writeObject("end");
                                new paraserver(is,os,dskh,dsnc).start();
                              
                         } catch (IOException ex) {
                             System.out.println(ex.getMessage());
                         }
                     }
    }
}
