/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import com.ltm.connection.loadfile;
import com.ltm.control.cutomstableheader;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import object.customer;
import object.product;

/**
 *
 * @author Admin
 */
public class cartformserver extends javax.swing.JFrame {

    DefaultTableModel tbl_dskhmd,tbl_dsspm;
    ArrayList<customer>dskh;
    public cartformserver(ArrayList<customer>dskh) {
        initComponents();
        this.dskh= dskh;
        detialcumtor.setVisible(false);
        tbl_dskhmd=(DefaultTableModel) tbl_dskh.getModel();
        tbl_dsspm=(DefaultTableModel) tbl_spdm.getModel();
        tbl_dskh.getTableHeader().setDefaultRenderer(new cutomstableheader(Color.black, Color.white));
        init();
    }

  public void init()
  {
      for(int i=0;i<dskh.size();i++)
      {
          tbl_dskhmd.addRow(new Object[]{
              dskh.get(i).getTen()
          });
      }
      
  }
  public void setdetailkh(int vitri)
  {
      detialcumtor.setVisible(true);
      lb_tkh.setText(dskh.get(vitri).getTen());
      lb_diachi.setText(dskh.get(vitri).getDiachi());
      lb_sdt.setText(dskh.get(vitri).getSdt());
      System.out.println("vitri"+vitri);
      settblsp(dskh.get(vitri).getDssp());
      System.out.println("sizemang:"+dskh.get(vitri).getDssp().size());
      lb_tongtien.setText(converttien(getmonney(dskh.get(vitri).getDssp()))+" VNĐ");
      
  }
  public long getmonney(ArrayList<product>dspr)
  {
     long kq=0;
     for(int i=0;i<dspr.size();i++)
     {
         long tiengiam=((dspr.get(i).getGia()*dspr.get(i).getSoluong())/100)*dspr.get(i).getKhuyenmai();
         long phaitra=dspr.get(i).getGia()*dspr.get(i).getSoluong()-tiengiam;
         kq+=phaitra;
     }
     return kq;
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
  public void settblsp(ArrayList<product> dspr)
  {
      tbl_dsspm.setRowCount(0);
      for(int i=0;i<dspr.size();i++ )
      tbl_dsspm.addRow(new Object[]
              {
              dspr.get(i).getTen(),dspr.get(i).getSoluong(),dspr.get(i).getKhuyenmai(),converttien(dspr.get(i).getGia())+" VNĐ",converttien(dspr.get(i).getGia()*dspr.get(i).getSoluong()-(((dspr.get(i).getGia()*dspr.get(i).getSoluong())/100)*dspr.get(i).getKhuyenmai()))+" VNĐ"
          
      });
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        detialcumtor = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_spdm = new javax.swing.JTable();
        btn_inhd = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lb_tkh = new javax.swing.JLabel();
        lb_diachi = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        lb_tongtien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dskh = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Danh sách khách hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 51));
        jLabel2.setText("Thông tin chi tiết");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên khách hàng :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Địa chỉ :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Điện Thoại :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Tổng cộng :");

        tbl_spdm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Khuyến mại", "Giá", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_spdm.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_spdm);
        if (tbl_spdm.getColumnModel().getColumnCount() > 0) {
            tbl_spdm.getColumnModel().getColumn(0).setResizable(false);
            tbl_spdm.getColumnModel().getColumn(1).setResizable(false);
            tbl_spdm.getColumnModel().getColumn(2).setResizable(false);
            tbl_spdm.getColumnModel().getColumn(3).setResizable(false);
            tbl_spdm.getColumnModel().getColumn(4).setResizable(false);
        }

        btn_inhd.setText("In Hóa Đơn");
        btn_inhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inhdActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sản Phẩm : ");

        lb_tkh.setText("jLabel9");

        lb_diachi.setText("jLabel9");

        lb_sdt.setText("jLabel9");

        lb_tongtien.setText("jLabel9");

        javax.swing.GroupLayout detialcumtorLayout = new javax.swing.GroupLayout(detialcumtor);
        detialcumtor.setLayout(detialcumtorLayout);
        detialcumtorLayout.setHorizontalGroup(
            detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detialcumtorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(226, 226, 226))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detialcumtorLayout.createSequentialGroup()
                .addGap(0, 130, Short.MAX_VALUE)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, detialcumtorLayout.createSequentialGroup()
                        .addComponent(btn_inhd)
                        .addGap(232, 232, 232))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(detialcumtorLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(detialcumtorLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(detialcumtorLayout.createSequentialGroup()
                        .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(detialcumtorLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_tongtien))
                            .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, detialcumtorLayout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_sdt))
                                .addGroup(detialcumtorLayout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_diachi))
                                .addGroup(detialcumtorLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(29, 29, 29)
                                    .addComponent(lb_tkh))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        detialcumtorLayout.setVerticalGroup(
            detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(detialcumtorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lb_tkh))
                .addGap(18, 18, 18)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_diachi))
                .addGap(18, 18, 18)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_sdt))
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(detialcumtorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lb_tongtien))
                .addGap(59, 59, 59)
                .addComponent(btn_inhd, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        tbl_dskh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Họ và Tên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dskh.getTableHeader().setReorderingAllowed(false);
        tbl_dskh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dskhMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dskh);
        if (tbl_dskh.getColumnModel().getColumnCount() > 0) {
            tbl_dskh.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(detialcumtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detialcumtor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_dskhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dskhMouseClicked
       if(tbl_dskh.getSelectedRow()>=0)
       {
           setdetailkh(tbl_dskh.getSelectedRow());
       }
    }//GEN-LAST:event_tbl_dskhMouseClicked

    private void btn_inhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inhdActionPerformed
          String name= JOptionPane.showInputDialog(null, "Nhập Tên Hóa Đơn:","Xuất Hóa Đơn");
          if(name.equals("")||name.equals(null))
          {
              JOptionPane.showConfirmDialog(null, "Không được để trống trường này","Chú Ý",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
              
          }else
          {
              try {
                  new loadfile().in(dskh.get(tbl_dskh.getSelectedRow()),name );
                  JOptionPane.showConfirmDialog(null, "Xuất thành công","Thông báo",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
              } catch (IOException ex) {
                  Logger.getLogger(cartformserver.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
    }//GEN-LAST:event_btn_inhdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inhd;
    private javax.swing.JPanel detialcumtor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_diachi;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JLabel lb_tkh;
    private javax.swing.JLabel lb_tongtien;
    private javax.swing.JTable tbl_dskh;
    private javax.swing.JTable tbl_spdm;
    // End of variables declaration//GEN-END:variables
}
