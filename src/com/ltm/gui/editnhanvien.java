/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import com.ltm.connection.DAO;
import com.ltm.connection.loadfile;
import com.ltm.control.SetImage;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import object.nhanvien;

/**
 *
 * @author Admin
 */
public class editnhanvien extends javax.swing.JFrame {

    ArrayList<nhanvien> nhanvien;
    DefaultTableModel model;
    int vitri;
    public editnhanvien(ArrayList<nhanvien> dsnv,DefaultTableModel model,int vitri) throws ParseException {
        initComponents();
        this.nhanvien=dsnv;
        this.model=model;
        this.vitri=vitri;
        init();
    }
public void init() throws ParseException
{
    btn_anh.setSize(30,30);
    new SetImage().setImageButton(btn_anh, "image//folder.png");
    jd_ngaysinh.setDateFormatString("dd/MM/yyyy");
    btn_mat.setSize(35,35);
    new SetImage().setImageButton(btn_mat, "image//mat.png");
    btn_them.setSize(30, 30);
    new SetImage().setImageButton(btn_them, "image//addnv.png");
    btn_lammoi.setSize(30, 30);
    new SetImage().setImageButton(btn_lammoi, "image//refresh.png");
    btn_huybo.setSize(30, 30);
    new SetImage().setImageButton(btn_huybo, "image//huybo.png");
    this.setLocation((this.getToolkit().getScreenSize().width-this.getWidth())/2, (this.getToolkit().getScreenSize().height-this.getHeight())/2);
    loadinfo();
    
}
public void loadinfo() throws ParseException
{
    nhanvien nv =this.nhanvien.get(vitri);
     tf_tenv.setText(nv.getTen());
       tf_cmnd.setText(String.valueOf(nv.getCmnd()));
       tf_anh.setText(nv.getLinkanh());
       tf_diachi.setText(nv.getDiachi());
       tf_email.setText(nv.getEmail());
       tf_matkhau.setText(nv.getMatkhau());
       tf_sdt.setText(String.valueOf(nv.getSdt()));
       tf_tendangnhap.setText(nv.getTendn());
       cbb_gioitinh.setSelectedItem(nv.getGioitinh());
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(nv.getNgaysinh());
       jd_ngaysinh.setDate(date);
}
public void reloadtbl()
{
    model.setRowCount(0);
     for(int i=0;i<this.nhanvien.size();i++)
        {
            if(this.nhanvien.get(i).getChucvu().equals("Nhân viên"))
            {
            model.addRow(new Object[]
            {
                this.nhanvien.get(i).getMa(),this.nhanvien.get(i).getTen()
            });
            }
        }
}
public String getlinkanh() throws IOException
{
      String kq = null;
      String path= new loadfile().laypath();
      String tmppath=" ";
      if(path!=null && path!="")
      {
          tmppath=path;
      }
       JFileChooser fc = new JFileChooser(tmppath) {
            @Override
            protected JDialog createDialog(Component parent) throws HeadlessException {
                JDialog dialog = super.createDialog(parent);
                BufferedImage image;
                try {
                    image = ImageIO.read(new File("image//coffee.png"));
                    dialog.setIconImage(image);
                    dialog.setSize(800, 600);
                    dialog.setResizable(false);
                    dialog.setLocation((this.getToolkit().getScreenSize().width - 800) / 2, (this.getToolkit().getScreenSize().height - 600) / 2);
                  
                } catch (IOException ex) {
                    Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                }

                return dialog;
            }
        };
        fc.setDialogTitle("Chọn Ảnh");
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "png", "gif");
        fc.addChoosableFileFilter(filter);
        int check = fc.showOpenDialog(null);
        if (check == fc.APPROVE_OPTION) {
            File a = fc.getSelectedFile();
            kq = a.getPath();
            new loadfile().ghipath(a.getParentFile().toString());

        }
        return kq;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("image//nene.jpg");
            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, -10, d.width, d.height+10, null);

                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tf_tenv = new javax.swing.JTextField();
        cbb_gioitinh = new javax.swing.JComboBox<>();
        tf_diachi = new javax.swing.JTextField();
        tf_sdt = new javax.swing.JTextField();
        tf_cmnd = new javax.swing.JTextField();
        tf_email = new javax.swing.JTextField();
        tf_tendangnhap = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_huybo = new javax.swing.JButton();
        btn_lammoi = new javax.swing.JButton();
        tf_anh = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btn_anh = new javax.swing.JButton();
        tf_matkhau = new javax.swing.JPasswordField();
        btn_mat = new javax.swing.JButton();
        jd_ngaysinh = new com.toedter.calendar.JDateChooser();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Tên nhân viên :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("Giới Tính :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("Ngày sinh :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("Địa chỉ :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("Số điện thoại :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 51));
        jLabel11.setText("Số CMND :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("Email :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setText("Tên đăng nhập:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("Mật khẩu :");

        cbb_gioitinh.setBackground(new java.awt.Color(102, 255, 51));
        cbb_gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ", "Khác" }));

        tf_sdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_sdtKeyReleased(evt);
            }
        });

        tf_cmnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_cmndKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Sửa nhân viên");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 51), 3));

        btn_them.setText("Update");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_huybo.setText("Hủy bỏ");
        btn_huybo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyboActionPerformed(evt);
            }
        });

        btn_lammoi.setText("Làm mới");
        btn_lammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lammoiActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Ảnh :");

        btn_anh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anhActionPerformed(evt);
            }
        });

        btn_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_matActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(tf_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jd_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tf_tenv)
                                        .addComponent(cbb_gioitinh, 0, 360, Short.MAX_VALUE)
                                        .addComponent(tf_diachi)
                                        .addComponent(tf_sdt)
                                        .addComponent(tf_cmnd)
                                        .addComponent(tf_email)
                                        .addComponent(tf_tendangnhap)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(15, 15, 15)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(31, 31, 31)
                        .addComponent(tf_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_anh, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(btn_mat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(btn_huybo, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_tenv, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jd_ngaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tf_tendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_matkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_anh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_lammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huybo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public boolean nhandangso(String s)
{
     char []tmp=s.trim().toCharArray();
     Pattern pattern = Pattern.compile("\\d*"); 
        Matcher matcher ;
        for(int i=0;i<tmp.length;i++)
        {
           matcher = pattern.matcher(String.valueOf(tmp[i]));
           if(matcher.matches())
           {
              return  true;
           }
           else
           {
             return  false;
           }
                      
        }
    return false;
}
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        if(tf_tenv.getText().equals("") || cbb_gioitinh.getSelectedItem().toString().equals("") || jd_ngaysinh.getDate().toString().equals("")|| tf_diachi.getText().equals("") || tf_sdt.getText().equals("")|| tf_cmnd.getText().equals("")|| tf_email.getText().equals("")|| tf_tendangnhap.getText().equals("")|| tf_matkhau.getText().equals("")||tf_anh.getText().equals(""))
        {
            JOptionPane.showConfirmDialog(null, "Vui lòng điền đầy đủ thông tin","chú ý",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            return;
        }
        else
        {
            nhanvien nv = this.nhanvien.get(vitri);
            
            nv.setTen(tf_tenv.getText());
            nv.setGioitinh(cbb_gioitinh.getSelectedItem().toString());
            Date ntmp = jd_ngaysinh.getDate();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String fomat = formatter.format(ntmp);
            nv.setNgaysinh(fomat);
            nv.setDiachi(tf_diachi.getText());
            nv.setSdt(Integer.parseInt(tf_sdt.getText()));
            nv.setCmnd(Integer.parseInt(tf_cmnd.getText()));
            nv.setEmail(tf_email.getText());
            nv.setTendn(tf_tendangnhap.getText());
            nv.setMatkhau(tf_matkhau.getText());
            nv.setLinkanh(tf_anh.getText());
            nv.setTrangthai("hoạt động");           
            reloadtbl();
            try {
                new DAO().updatenhanvien(nv);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(editnhanvien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(editnhanvien.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(editnhanvien.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_anhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anhActionPerformed
        try {
            tf_anh.setText(getlinkanh());
        } catch (IOException ex) {
            Logger.getLogger(editnhanvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_anhActionPerformed
int check=0;
    private void btn_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_matActionPerformed
     if(check==0){
        tf_matkhau.setEchoChar((char)0);
        btn_mat.setBackground(Color.yellow);
     }
       else
       {
           tf_matkhau.setEchoChar('*');
           btn_mat.setBackground(new Color(240,240,240));
       }
       check=(check==0) ? 1:0;
    }//GEN-LAST:event_btn_matActionPerformed

    private void tf_sdtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_sdtKeyReleased
          if(nhandangso(tf_sdt.getText())==false)
        {
          
             JOptionPane.showConfirmDialog(null,"Trường này không cho phép nhập chữ hoặc kí tự!vui lòng nhập lại","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
             tf_sdt.setText("");
        }
        else if(nhandangso(tf_sdt.getText()))
        {
            if(tf_sdt.getText().length()>11)
            {
                             JOptionPane.showConfirmDialog(null,"Số điện thoại không thể dài hơn 11 số!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
               
                tf_sdt.setText("");
            }
        }
    }//GEN-LAST:event_tf_sdtKeyReleased

    private void tf_cmndKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_cmndKeyReleased
      if(nhandangso(tf_cmnd.getText())==false)
        {
          
             JOptionPane.showConfirmDialog(null,"Trường này không cho phép nhập chữ hoặc kí tự!vui lòng nhập lại","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
             tf_cmnd.setText("");
        }
    }//GEN-LAST:event_tf_cmndKeyReleased

    private void btn_lammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lammoiActionPerformed
   int check =JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn làm mới ?","Chú Ý", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if(check==JOptionPane.YES_OPTION)
    {
        resetform();
    }
    }//GEN-LAST:event_btn_lammoiActionPerformed

    private void btn_huyboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyboActionPerformed
    int check =JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn hủy bỏ tác vụ này?","Chú Ý", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if(check==JOptionPane.YES_OPTION)
    {
        this.setVisible(false);
    }

    }//GEN-LAST:event_btn_huyboActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         int check =JOptionPane.showConfirmDialog(null,"Bạn có chắc muốn hủy bỏ tác vụ này?","Chú Ý", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
    if(check==JOptionPane.YES_OPTION)
    {
        this.setVisible(false);
    }
    else
    {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    }//GEN-LAST:event_formWindowClosing

   public void resetform()
   {
       tf_tenv.setText("");
       tf_cmnd.setText("");
       tf_anh.setText("");
       tf_diachi.setText("");
       tf_email.setText("");
       tf_matkhau.setText("");
       tf_sdt.setText("");
       tf_tendangnhap.setText("");
       cbb_gioitinh.setSelectedIndex(0);
       jd_ngaysinh.setDate(new Date());
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anh;
    private javax.swing.JButton btn_huybo;
    private javax.swing.JButton btn_lammoi;
    private javax.swing.JButton btn_mat;
    private javax.swing.JButton btn_them;
    private javax.swing.JComboBox<String> cbb_gioitinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private com.toedter.calendar.JDateChooser jd_ngaysinh;
    private javax.swing.JTextField tf_anh;
    private javax.swing.JTextField tf_cmnd;
    private javax.swing.JTextField tf_diachi;
    private javax.swing.JTextField tf_email;
    private javax.swing.JPasswordField tf_matkhau;
    private javax.swing.JTextField tf_sdt;
    private javax.swing.JTextField tf_tendangnhap;
    private javax.swing.JTextField tf_tenv;
    // End of variables declaration//GEN-END:variables
}
