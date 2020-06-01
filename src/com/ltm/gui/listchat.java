/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import object.nguoichat;

/**
 *
 * @author Admin
 */
public class listchat extends javax.swing.JFrame {

    ArrayList<nguoichat>dsnc;
    DefaultTableModel modeltbl_lischat;
    public listchat(ArrayList<nguoichat>dsnc) {
        initComponents();    
        this.dsnc=dsnc;
         init();

    }

   public void init()
   {
       
       modeltbl_lischat= (DefaultTableModel) tbl_listchat.getModel();
       tbl_listchat.getColumnModel().getColumn(0).setWidth(25);
       setdefaulttb();
   }
   public void setdefaulttb()
   {
       for(int i=0;i<dsnc.size();i++)
       {
           modeltbl_lischat.addRow(new Object[]{
              i+1, dsnc.get(i).getName()
           });
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_listchat = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Danh sách chát");

        tbl_listchat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_listchat.getTableHeader().setReorderingAllowed(false);
        tbl_listchat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_listchatMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_listchat);
        if (tbl_listchat.getColumnModel().getColumnCount() > 0) {
            tbl_listchat.getColumnModel().getColumn(0).setResizable(false);
            tbl_listchat.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_listchatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_listchatMouseClicked
      if(tbl_listchat.getSelectedRow()>=0)
      {
          if(dsnc.get(tbl_listchat.getSelectedRow()).getChat().isVisible())
          {
              JOptionPane.showConfirmDialog(null, "Cửa sổ chát của người này đang mở","Chú Ý",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
          }
          else
          {
              dsnc.get(tbl_listchat.getSelectedRow()).getChat().setVisible(true);
          }
      }
    }//GEN-LAST:event_tbl_listchatMouseClicked


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_listchat;
    // End of variables declaration//GEN-END:variables
}
