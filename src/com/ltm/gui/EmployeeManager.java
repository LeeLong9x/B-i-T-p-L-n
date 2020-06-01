/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import com.ltm.connection.DAO;
import com.ltm.control.SetImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import object.nhanvien;

/**
 *
 * @author Admin
 */
public class EmployeeManager extends javax.swing.JFrame {
    public ArrayList<nhanvien> dsnv;
    public DefaultTableModel modetbl;
    public String linkanhtmp=" ";
     BufferedImage img;
    public EmployeeManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        initComponents();
      
        init();
        
    }

     public void repointship() 
    {
      
        lbtitle.setBounds(jPanel1.getSize().width/2-220,10, 450,60);
     
    }
     public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException
     {
          btn_them.setSize(35, 35);
        new SetImage().setImageButton(btn_them, "image//manageradd.png");
          btn_sua.setSize(60, 60);
        new SetImage().setImageButton(btn_sua, "image//managerfix.png");
         btn_xoa.setSize(40, 40);
        new SetImage().setImageButton(btn_xoa, "image//khoa.png");
         btn_timkiem.setSize(60, 60);
        new SetImage().setImageButton(btn_timkiem, "image//timnguoi.png");
          btn_xemmk.setSize(60, 60);
        new SetImage().setImageButton(btn_xemmk, "image//mat.png");
          btn_tinhluong.setSize(60, 60);
        new SetImage().setImageButton(btn_tinhluong, "image//pricing.png");
        
          plht.setVisible(false);
          dsnv= new DAO().getdsnv();
        modetbl= (DefaultTableModel) tblqlnv.getModel();
        for(int i=0;i<dsnv.size();i++)
        {
               if(dsnv.get(i).getChucvu().equals("Nhân viên"))
            {
            modetbl.addRow(new Object[]
            {
                dsnv.get(i).getMa(),dsnv.get(i).getTen()
            });
            }
        }
       
     }
     public void resettbl()
     {
         modetbl.setRowCount(0);
          for(int i=0;i<dsnv.size();i++)
        {
              if(dsnv.get(i).getChucvu().equals("Nhân viên"))
            {
            modetbl.addRow(new Object[]
            {
                dsnv.get(i).getMa(),dsnv.get(i).getTen()
            });
            }
        }
     }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("image//nenadd.jpg");
            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, -10, d.width, d.height+10, null);
                lbtitle.setBounds(jPanel1.getSize().width/2-220,10, 450,60);

                setOpaque(false);
                super.paintComponent(g);
            }
        };
        lbtitle = new javax.swing.JLabel();
        tf_timkiem = new javax.swing.JTextField();
        cbb_tk = new javax.swing.JComboBox<>();
        btn_timkiem = new javax.swing.JButton();
        btn_tinhluong = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblqlnv = new javax.swing.JTable();
        plht = new javax.swing.JPanel() {
            ImageIcon icon= new ImageIcon("image//khunganh.png");

            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.setColor(Color.RED);
                g.setFont(new Font("Arial",Font.BOLD,20));
                g.drawString("Chân dung:",getX()+90,45);
                g.drawImage(img, getX()+162, 112, 300,320,null);
                g.drawImage(icon.getImage(),getX()+90, 50, 450, 450, null);
                lbtitle.setBounds(jPanel1.getSize().width/2-220,10, 450,60);

                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel1 = new javax.swing.JLabel();
        lbmnv = new javax.swing.JLabel();
        lbtnv = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbgioitinh = new javax.swing.JLabel();
        lb_ngaysinh = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lb_diachi = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb_sdt = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_cmnd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_tendangnhap = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_mk = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lb_trangthai = new javax.swing.JLabel();
        lb_giodalam = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_xemmk = new javax.swing.JButton();

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 920));

        lbtitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbtitle.setForeground(new java.awt.Color(255, 0, 0));
        lbtitle.setText("     Quản Lí Nhân Viên");
        lbtitle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));

        tf_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_timkiemKeyReleased(evt);
            }
        });

        cbb_tk.setBackground(new java.awt.Color(153, 255, 51));
        cbb_tk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbb_tk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo mã", "Tìm kiếm theo tên" }));

        btn_timkiem.setBackground(new java.awt.Color(102, 255, 51));

        btn_tinhluong.setText("Tính Lương");

        btn_xoa.setText("Khóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        tblqlnv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên"
            }
        ));
        tblqlnv.getTableHeader().setReorderingAllowed(false);
        tblqlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblqlnvMouseReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblqlnv);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("Mã nhân viên :");

        lbmnv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbmnv.setText("jLabel10");

        lbtnv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtnv.setText("jLabel10");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Tên nhân viên :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Giới Tính :");

        lbgioitinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbgioitinh.setText("jLabel10");

        lb_ngaysinh.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_ngaysinh.setText("jLabel10");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Ngày sinh :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Địa chỉ :");

        lb_diachi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_diachi.setText("jLabel10");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Số điện thoại :");

        lb_sdt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_sdt.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Số CMND :");

        lb_cmnd.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_cmnd.setText("jLabel10");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Email :");

        lb_email.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_email.setText("jLabel10");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Tên đăng nhập:");

        lb_tendangnhap.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_tendangnhap.setText("jLabel10");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Mật khẩu :");

        lb_mk.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_mk.setText("jLabel10");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("Trạng thái:");

        lb_trangthai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_trangthai.setText("jLabel10");

        lb_giodalam.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lb_giodalam.setText("jLabel10");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 51));
        jLabel13.setText("giờ đã làm :");

        btn_xemmk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemmkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plhtLayout = new javax.swing.GroupLayout(plht);
        plht.setLayout(plhtLayout);
        plhtLayout.setHorizontalGroup(
            plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plhtLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plhtLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plhtLayout.createSequentialGroup()
                                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(plhtLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lb_giodalam))
                                    .addGroup(plhtLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(lb_trangthai))))
                            .addComponent(jLabel9)))
                    .addGroup(plhtLayout.createSequentialGroup()
                        .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_sdt)
                            .addComponent(lb_cmnd)
                            .addComponent(lb_diachi)
                            .addComponent(lb_ngaysinh)
                            .addComponent(lbgioitinh)
                            .addComponent(lbtnv)
                            .addComponent(lbmnv)
                            .addComponent(lb_email)
                            .addComponent(lb_tendangnhap)
                            .addComponent(lb_mk))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_xemmk, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(891, Short.MAX_VALUE))
        );
        plhtLayout.setVerticalGroup(
            plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plhtLayout.createSequentialGroup()
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbmnv))
                .addGap(23, 23, 23)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbtnv))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbgioitinh))
                .addGap(26, 26, 26)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_ngaysinh))
                .addGap(23, 23, 23)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lb_diachi))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lb_sdt))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lb_cmnd))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lb_email))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lb_tendangnhap))
                .addGap(28, 28, 28)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(lb_mk))
                    .addComponent(btn_xemmk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lb_trangthai))
                .addGap(18, 18, 18)
                .addGroup(plhtLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lb_giodalam))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(484, 484, 484)
                        .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_tinhluong, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_timkiem)
                            .addComponent(cbb_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plht, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_tinhluong, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbb_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jScrollPane5.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1608, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public String getmkchar(String mk)
{
    String tmp=" ";
    for(int i=0;i<mk.length();i++)
    {
        tmp+="*";
    }
    return  tmp.trim();
}
    public void hienthi(nhanvien nv)
{
    lbmnv.setText(String.valueOf(nv.getMa()).trim());
    lbtnv.setText(nv.getTen().trim());
    lbgioitinh.setText(nv.getGioitinh().trim());
    lb_ngaysinh.setText(nv.getNgaysinh().trim());
    lb_diachi.setText(nv.getDiachi().trim());
    lb_sdt.setText(String.valueOf(nv.getSdt()).trim());
    lb_cmnd.setText(String.valueOf(nv.getCmnd()).trim());
    lb_email.setText(nv.getEmail().trim());
    lb_tendangnhap.setText(nv.getTendn().trim());
    lb_mk.setText(getmkchar(nv.getMatkhau().trim()));
    lb_trangthai.setText(nv.getTrangthai().trim());
    lb_giodalam.setText(String.valueOf(nv.getTime()).trim());
    
    
}
String block="khóa";
int vitriclick=0;
    private void tblqlnvMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblqlnvMouseReleased
        plht.setVisible(true);
        if(tblqlnv.getSelectedRowCount()>0)
          {
              for(int i=0;i<dsnv.size();i++)
              {
                  if(dsnv.get(i).getMa()==Integer.parseInt(tblqlnv.getValueAt(tblqlnv.getSelectedRow(),0).toString()))
                  {
                      hienthi(dsnv.get(i));
                      block= (dsnv.get(i).getTrangthai().equals("bị khóa"))?"mở khóa":"khóa";
                      btn_xoa.setText(block);
                      vitriclick=i;
                      try {
                          img =ImageIO.read(new File(dsnv.get(i).getLinkanh()));
                      } catch (IOException ex) {
                          Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      plht.repaint();
                      break;
                  }
              }
              
          }else
          {
              JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng nào để xem","Chú Ý",JOptionPane.DEFAULT_OPTION);
          }
        
    }//GEN-LAST:event_tblqlnvMouseReleased

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        new addnhanvien(dsnv,modetbl).setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
   
        if(tblqlnv.getSelectedRowCount()>0)
        {
            
       
        for(int i=0;i<dsnv.size();i++)
      {
          if(tblqlnv.getValueAt(tblqlnv.getSelectedRow(),0).equals(dsnv.get(i).getMa()))
          {
              try {
                  new editnhanvien(dsnv, modetbl, i).setVisible(true);
              } catch (ParseException ex) {
                  Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
              }
              break;
          }
      }
         }
        else
        {
         JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng nào để sửa","Chú Ý",JOptionPane.DEFAULT_OPTION);

        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
      
        String tmp=null;
        tmp=(btn_xoa.getText()=="khóa")?"mở khóa":"khóa";
        btn_xoa.setText(tmp);
        if(tblqlnv.getSelectedColumnCount()>0)
       {
           for(int i=0;i<dsnv.size();i++)
           {
               if(tblqlnv.getValueAt(tblqlnv.getSelectedRow(),0).equals(dsnv.get(i).getMa()) && dsnv.get(i).getTrangthai().equals("hoạt động"))
               {
                   
                   dsnv.get(i).setTrangthai("bị khóa");
                   try {
                       new DAO().updatetrangthai(dsnv.get(i).getTrangthai(),dsnv.get(i).getMa(),"khóa");
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InstantiationException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IllegalAccessException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   hienthi(dsnv.get(i));
                  break;
               }
               else
                    if(tblqlnv.getValueAt(tblqlnv.getSelectedRow(),0).equals(dsnv.get(i).getMa()) && dsnv.get(i).getTrangthai().equals("bị khóa"))
               {
                   
                  dsnv.get(i).setTrangthai("hoạt động");
                   try {
                       new DAO().updatetrangthai(dsnv.get(i).getTrangthai(),dsnv.get(i).getMa(),"mở khóa");
                   } catch (ClassNotFoundException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (InstantiationException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   } catch (IllegalAccessException ex) {
                       Logger.getLogger(EmployeeManager.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   hienthi(dsnv.get(i));
                  break;
               }
           }
       }
       else
       {
        JOptionPane.showConfirmDialog(null, "vui lòng chọn 1 nhân viên để thực hiện thao tác này!","Chú Ý",JOptionPane.DEFAULT_OPTION);

       }
    }//GEN-LAST:event_btn_xoaActionPerformed
public void xulytimkiem()
{
      String key=cbb_tk.getSelectedItem().toString();
     
     if(tf_timkiem.getText().equals(""))
     {
        resettbl();
     }
      else  if(key.equals("Tìm kiếm theo mã")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dsnv.size();i++)
            {
                if( String.valueOf(dsnv.get(i).getMa()).indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||String.valueOf(dsnv.get(i).getMa()).toLowerCase().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("")||String.valueOf(dsnv.get(i).getMa()).equals(tf_timkiem.getText()) )
                {
                    if(dsnv.get(i).getChucvu().equals("Nhân viên"))
            {
                  modetbl.setRowCount(0);
                  modetbl.addRow(new Object[]
                  {
                      dsnv.get(i).getMa(),dsnv.get(i).getTen()
                  });
            }
                }
                
            }
            
            
        }
      else  if(key.equals("Tìm kiếm theo tên")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dsnv.size();i++)
            {
                if( dsnv.get(i).getTen().toLowerCase().indexOf(tf_timkiem.getText())>=0  || dsnv.get(i).getTen().indexOf(tf_timkiem.getText())>=0 ||dsnv.get(i).getTen().equals(tf_timkiem.getText()) )
                {
                     if(dsnv.get(i).getChucvu().equals("Nhân viên"))
            {
                  modetbl.setRowCount(0);
                  modetbl.addRow(new Object[]
                  {
                    dsnv.get(i).getMa(),dsnv.get(i).getTen()
                  });
            }
                }

            }
        }
}
    private void tf_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_timkiemKeyReleased
        xulytimkiem();
    }//GEN-LAST:event_tf_timkiemKeyReleased
 
    int check=0;
    private void btn_xemmkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemmkActionPerformed
    
     if(check==0)
     {
         btn_xemmk.setBackground(Color.red);
         lb_mk.setText(dsnv.get(vitriclick).getMatkhau());
         
     }
     else 
     {
          btn_xemmk.setBackground(new Color(240,240,240));
          
         lb_mk.setText(getmkchar(dsnv.get(vitriclick).getMatkhau()));
     }
     check=(check==0)?1:0;
    }//GEN-LAST:event_btn_xemmkActionPerformed

    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_tinhluong;
    private javax.swing.JButton btn_xemmk;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> cbb_tk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lb_cmnd;
    private javax.swing.JLabel lb_diachi;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_giodalam;
    private javax.swing.JLabel lb_mk;
    private javax.swing.JLabel lb_ngaysinh;
    private javax.swing.JLabel lb_sdt;
    private javax.swing.JLabel lb_tendangnhap;
    private javax.swing.JLabel lb_trangthai;
    private javax.swing.JLabel lbgioitinh;
    private javax.swing.JLabel lbmnv;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JLabel lbtnv;
    private javax.swing.JPanel plht;
    private javax.swing.JTable tblqlnv;
    private javax.swing.JTextField tf_timkiem;
    // End of variables declaration//GEN-END:variables
      
                }
