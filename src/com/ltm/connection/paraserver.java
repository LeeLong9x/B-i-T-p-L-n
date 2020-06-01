/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.connection;

import com.ltm.gui.chatseverform;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.customer;
import object.nguoichat;
import object.product;


public class paraserver extends Thread{

    ObjectInputStream is;
    ObjectOutputStream os;
    ArrayList<customer>dskh;
    chatseverform chat;
    ArrayList<nguoichat>dsnc;
     String check;
   public paraserver(ObjectInputStream is,ObjectOutputStream os,ArrayList<customer>dskh,ArrayList<nguoichat>dsnc)
   {
       this.is=is;
       this.dskh=dskh;
       this.os=os;
       this.dsnc=dsnc;
   }
   public void  xulypara(String para) throws IOException, ClassNotFoundException
   {
       switch(para)
       {
           case "addkh":
             
                addkh();
               break;
           case "chat":
               chat();
               break;
               default:df();
               break;
       }
   }
    @Override
    public void run() {
        while (true) {            
            try {
                System.out.println("da vao para sever");
                check=(String)is.readObject();
                System.out.println("para="+check);
                xulypara(check);
//             if(check=="addkh"||check.equals("chat"))
//             {
//                
//             }
//             else 
//     if(!check.equals("addkh")&&!check.equals("chat"))
//        {
//                 if( chat.tarec.getText().equals(" ")&& check!=" ")
//        {
//            chat.tarec.setText(chat.name+": "+check);
//        }
//            else
//        {
//           
//            chat.tarec.setText(chat.tarec.getText()+"\n"+chat.name+": "+check);
//        }
//        }
            } catch (IOException ex) {
                Logger.getLogger(paraserver.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(paraserver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
 ArrayList<product> pro;
    private void addkh() throws IOException, ClassNotFoundException {
        customer ct= new customer();
        String tenkh=(String)is.readObject();
        String diachi=(String)is.readObject();
     
        String sdt=(String)is.readObject();
      
        int loop=(int)is.readObject();
        System.out.println("loop server"); 
        pro= new ArrayList<>();
        for(int i=0;i<loop;i++)
        {
         
            String tensp=(String)is.readObject();
            int soluong=(int)is.readObject();
            long gia=(long)is.readObject();
            int khuyenmai=(int)is.readObject();
            product pr= new product();
            pr.setTen(tensp);
            pr.setSoluong(soluong);
            pr.setGia(gia);
            pr.setKhuyenmai(khuyenmai);
            pro.add(pr);
            
        }
        System.out.println("pro size: "+pro.size());
        ct.setTen(tenkh);
        ct.setDiachi(diachi);
        ct.setSdt(sdt);
        ct.setDssp(pro);
        dskh.add(ct);
        
    }

    private void chat() {
       
                       
            
          chat=  new chatseverform(is,os,dsnc);
          chat.setVisible(true);
       
          
    }
    public void df()
    {
        if( chat.tarec.getText().equals(" ")&& check!=" ")
        {
            chat.tarec.setText(chat.name+": "+check);
        }
            else
        {
           
            chat.tarec.setText(chat.tarec.getText()+"\n"+chat.name+": "+check);
        }
    }
    
}
