/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.nguoichat;

/**
 *
 * @author Admin
 */
public class chatseverform extends javax.swing.JFrame {

ObjectInputStream is;
ObjectOutputStream os;
  public   String name;
    ArrayList<nguoichat>dsnc;
    public chatseverform(ObjectInputStream is,ObjectOutputStream os ,ArrayList<nguoichat>dsnc) {
        initComponents();
        this.is=is;
        this.os=os;
       this.dsnc=dsnc;
       tarec.removeAll();
        init();
        nguoichat nc= new nguoichat();
        nc.setChat(this);
        nc.setName(name);     
        this.dsnc.add(nc);
        setlayout();
    }
 public void setlayout()
    {
       
        Toolkit toolkit=this.getToolkit();
        Dimension dimension=toolkit.getScreenSize();
        
        this.setLocation((dimension.width-this.getWidth())/2,(dimension.height-this.getHeight())/2);
      
    }
public void init()
{
 
          
                                 
                          
                    
               
  
              
               try{    
                   name=(String)is.readObject();
                   this.setTitle(name);
                  
               //   String s=(String)is.readObject();
                
              
//            if(tarec.getText().equals("")|| tarec.getText().equals(" "))
//        {
//            tarec.setText(name+":"+s);
//        }
//            else
//        {
//          tarec.setText(tarec.getText()+"\n"+name+":"+s);
//        }
        
               }catch(Exception e)
        {
            
        }
            
             
          
   
}
public String getcontentchat(String []s)
{
    String kq=" ";
    for(int i=1;i<s.length;i++)
    {
        kq+=s[i]+" ";
    }
    return kq.trim();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarec = new javax.swing.JTextArea();
        tf_send = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        tarec.setColumns(20);
        tarec.setRows(5);
        tarec.setEnabled(false);
        jScrollPane2.setViewportView(tarec);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Gửi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tf_send, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_send, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
              
                if(tf_send.getText()!=" ")
                {
                    try {
                       
                        os.writeObject(tf_send.getText().trim());
                        os.flush();
                        
                         if(tarec.getText().equals("")|| tarec.getText().equals(" "))
                         {
                             tarec.setText("Bạn:"+tf_send.getText());
                         }
                         else
                         {
                              tarec.setText(tarec.getText()+"\n"+"Bạn:"+tf_send.getText().trim());
                         }
                         tf_send.setText("");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea tarec;
    private javax.swing.JTextField tf_send;
    // End of variables declaration//GEN-END:variables
}
