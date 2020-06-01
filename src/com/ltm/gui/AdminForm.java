/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import com.ltm.connection.socketconnection;
import com.ltm.control.SetImage;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.DirectoryStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.naming.spi.DirectoryManager;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import object.customer;
import object.nguoichat;

/**
 *
 * @author Tung
 */
public class AdminForm extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Home
     */
    Thread t1;
    Socket socket;
    Color []colors ={Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.DARK_GRAY,Color.GRAY,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.WHITE,Color.YELLOW};
    ArrayList<Color>dscl;
    ArrayList<customer>dskh;
    ArrayList<nguoichat>dsnc;
    socketconnection sstn;
    public AdminForm(socketconnection sstn,ArrayList<customer>dskh,ArrayList<nguoichat>dsnc) {
        initComponents();
        ImageIcon img = new ImageIcon("image//ADMIN-OUTSOURCING.jpg");
        this.setIconImage(img.getImage());
        btnProduct.setSize(190, 190);
        new SetImage().setImageButton(btnProduct, "image//qlsp.png");
        btn_qlnv.setSize(190, 190);
        new SetImage().setImageButton(btn_qlnv, "image//Employee.png");
//        btn_thongke.setSize(190, 190);
//        new SetImage().setImageButton(btn_thongke, "image//pricing.png");
        btn_donhang.setSize(190, 190);
        new SetImage().setImageButton(btn_donhang, "image//Order.png");
//        btn_chat.setSize(190, 190);
//        new SetImage().setImageButton(btn_chat, "image//Promotions.jpg");
        btn_chat.setSize(190, 190);
        new SetImage().setImageButton(btn_chat, "image//messs.png");
//        btn_thongtintk.setSize(190, 190);
//        new SetImage().setImageButton(btn_thongtintk, "image//history-icon-68319.png");
        btnLogout.setSize(20, 20);
        new SetImage().setImageButton(btnLogout, "image//logout.png");
        dscl= new ArrayList<>();
        Collections.addAll(dscl, colors);
        this.sstn=sstn;
        this.dskh=dskh;
        this.dsnc=dsnc;
         chayhu();
    }
public void chayhu()
{
    if(t1==null)
    {
        t1= new Thread(this);
        
    }
    if(t1!=null)
    {
        t1.start();
    }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        backgroundql = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("image//bgrco.jpg");
            ImageIcon icon2= new ImageIcon("image//bgql2.png");
            public void paintComponent(Graphics g){
                Dimension d = backgroundql.getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width+80, d.height, null);
                g.drawImage(icon2.getImage(),85,-100,d.width-120,520,null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        btnLogout = new javax.swing.JButton();
        btn_qlnv = new javax.swing.JButton();
        btnProduct = new javax.swing.JButton();
        btn_donhang = new javax.swing.JButton();
        btn_chat = new javax.swing.JButton();
        lbql = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        backgroundql.setBackground(new java.awt.Color(255, 255, 255));

        btnLogout.setBackground(new java.awt.Color(102, 255, 0));
        btnLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLogout.setText("Đăng xuất");
        btnLogout.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnLogoutMouseMoved(evt);
            }
        });
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogoutMouseExited(evt);
            }
        });
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btn_qlnv.setBackground(new java.awt.Color(51, 255, 0));
        btn_qlnv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_qlnv.setForeground(new java.awt.Color(204, 0, 0));
        btn_qlnv.setToolTipText("Quản lý nhân viên");
        buttonGroup1.add(btn_qlnv);
        btn_qlnv.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_qlnvMouseMoved(evt);
            }
        });
        btn_qlnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_qlnvMouseExited(evt);
            }
        });
        btn_qlnv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_qlnvActionPerformed(evt);
            }
        });

        btnProduct.setBackground(new java.awt.Color(0, 255, 0));
        btnProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnProduct.setForeground(new java.awt.Color(204, 0, 0));
        btnProduct.setToolTipText("Quản lý sản phẩm");
        btnProduct.setBorder(null);
        buttonGroup1.add(btnProduct);
        btnProduct.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnProductMouseMoved(evt);
            }
        });
        btnProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnProductMouseExited(evt);
            }
        });
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btn_donhang.setBackground(new java.awt.Color(102, 255, 0));
        btn_donhang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_donhang.setForeground(new java.awt.Color(204, 0, 0));
        btn_donhang.setToolTipText("Quản lí đơn hàng");
        buttonGroup1.add(btn_donhang);
        btn_donhang.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_donhangMouseMoved(evt);
            }
        });
        btn_donhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_donhangMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_donhangMouseExited(evt);
            }
        });
        btn_donhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_donhangActionPerformed(evt);
            }
        });

        btn_chat.setBackground(new java.awt.Color(51, 255, 0));
        btn_chat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_chat.setForeground(new java.awt.Color(204, 0, 0));
        btn_chat.setToolTipText("Quản lý Tin Nhắn");
        buttonGroup1.add(btn_chat);
        btn_chat.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_chatMouseMoved(evt);
            }
        });
        btn_chat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_chatMouseExited(evt);
            }
        });
        btn_chat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chatActionPerformed(evt);
            }
        });

        lbql.setBackground(new java.awt.Color(255, 255, 51));
        lbql.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbql.setForeground(new java.awt.Color(255, 51, 51));
        lbql.setText("    Chọn Chức năng muốn quản lí");
        lbql.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 3, 8, 3, new java.awt.Color(0, 51, 255)));
        lbql.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                lbqlMouseMoved(evt);
            }
        });

        javax.swing.GroupLayout backgroundqlLayout = new javax.swing.GroupLayout(backgroundql);
        backgroundql.setLayout(backgroundqlLayout);
        backgroundqlLayout.setHorizontalGroup(
            backgroundqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundqlLayout.createSequentialGroup()
                .addGroup(backgroundqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundqlLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnLogout))
                    .addGroup(backgroundqlLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_qlnv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_donhang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundqlLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbql, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        backgroundqlLayout.setVerticalGroup(
            backgroundqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundqlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addComponent(lbql, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(backgroundqlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_qlnv, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_donhang, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(246, 246, 246))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundql, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backgroundql, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        int click = JOptionPane.showConfirmDialog(null, "Đăng xuất ngay bây giờ?","Chú Ý",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        if (click == 0) {
            this.setVisible(false);
            
            try {
                new LoginForm().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btn_donhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donhangActionPerformed
new cartformserver(dskh).setVisible(true);       
    }//GEN-LAST:event_btn_donhangActionPerformed

    private void btn_chatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chatActionPerformed
        new listchat(dsnc).setVisible(true);
    }//GEN-LAST:event_btn_chatActionPerformed

    private void btn_qlnvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_qlnvActionPerformed
        try {
            new EmployeeManager().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_qlnvActionPerformed

    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        try {
            new productform(sstn).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductActionPerformed

    private void btnLogoutMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseMoved
        btnLogout.setBackground(Color.YELLOW);
    }//GEN-LAST:event_btnLogoutMouseMoved

    private void btnLogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseExited
 btnLogout.setBackground(Color.green);    }//GEN-LAST:event_btnLogoutMouseExited

    private void lbqlMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbqlMouseMoved
     
       
    }//GEN-LAST:event_lbqlMouseMoved

    private void btnProductMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseMoved
      btnProduct.setBackground(Color.yellow);
    }//GEN-LAST:event_btnProductMouseMoved

    private void btnProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductMouseExited
     btnProduct.setBackground(Color.GREEN);
    }//GEN-LAST:event_btnProductMouseExited

    private void btn_donhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_donhangMouseClicked
      
    }//GEN-LAST:event_btn_donhangMouseClicked

    private void btn_qlnvMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlnvMouseMoved
       btn_qlnv.setBackground(Color.yellow);
    }//GEN-LAST:event_btn_qlnvMouseMoved

    private void btn_qlnvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlnvMouseExited
          btn_qlnv.setBackground(Color.green);
    }//GEN-LAST:event_btn_qlnvMouseExited

    private void btn_donhangMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_donhangMouseMoved
        btn_donhang.setBackground(Color.yellow);
    }//GEN-LAST:event_btn_donhangMouseMoved

    private void btn_donhangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_donhangMouseExited
       btn_donhang.setBackground(Color.GREEN);
    }//GEN-LAST:event_btn_donhangMouseExited

    private void btn_chatMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_chatMouseMoved
        btn_chat.setBackground(Color.yellow);
    }//GEN-LAST:event_btn_chatMouseMoved

    private void btn_chatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_chatMouseExited
        btn_chat.setBackground(Color.GREEN);
    }//GEN-LAST:event_btn_chatMouseExited



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundql;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProduct;
    private javax.swing.JButton btn_chat;
    private javax.swing.JButton btn_donhang;
    private javax.swing.JButton btn_qlnv;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel lbql;
    // End of variables declaration//GEN-END:variables
int vitrimau;
    @Override
    public void run() {
        Random rd= new Random();
        while (true) {            
            vitrimau=rd.nextInt(dscl.size());
            lbql.setForeground(dscl.get(vitrimau));
             lbql.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 15, 15, 15,dscl.get(vitrimau)));
            try {
                Thread.sleep(160);
            } catch (InterruptedException ex) {
                Logger.getLogger(AdminForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
