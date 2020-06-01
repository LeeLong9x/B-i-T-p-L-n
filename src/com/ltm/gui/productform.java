/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.gui;

import com.ltm.connection.DAO;
import com.ltm.connection.loadfile;
import com.ltm.connection.socketconnection;
import com.ltm.control.SetImage;
import com.ltm.control.cutomstableheader;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.print.Collation;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import object.sanpham;
import sun.java2d.pipe.SpanShapeRenderer;


public class productform extends javax.swing.JFrame {


    ArrayList<sanpham> dssp;
    ArrayList<String> dslsp;
    ArrayList<String> dshsp;
    DefaultListModel model = new DefaultListModel();
    DefaultTableModel modeltb;
    String link1, link2, link3, link4;
    DefaultComboBoxModel cbb,cbblsp;
     Boolean sateedit=false;
       Font fontvip;
     ServerSocket sever;
     Socket socket;
     socketconnection ssnt;
private static final Font SERIF_FONT = new Font("serif", Font.PLAIN, 24);
    public productform(socketconnection ssnt) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        dssp = new DAO().getsp();
      
        initComponents();
        setimgbutton();
        cumstom_mouse();
        cbb = (DefaultComboBoxModel) cbbhss.getModel();
        xulyscoll4();
        modeltb = (DefaultTableModel) tbl_qlsp.getModel();

        dslsp = new DAO().getloaisp();
        dshsp = new DAO().gethangsp();

        jd_ngaynhap.setDateFormatString("d/M/yyyy");
        adddefaultable();
        setdefaullsp();
        cbblsp= (DefaultComboBoxModel) cbb_lsp.getModel();
        setheaderjtable();
        this.socket=socket;
            this.ssnt=ssnt;
        
    }
    public  void setheaderjtable()
    {
         tbl_qlsp.getTableHeader().setDefaultRenderer(new cutomstableheader(Color.RED, Color.yellow));
    }
   public void adddefaultable()
   {
       for(int i=0;i<dssp.size();i++)
       {
            modeltb.addRow(new Object[]
           {
               dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false
           });
       }
   }
    public void setdefaullsp()
    {
        for(int i=0;i<dslsp.size();i++)
        {
            cbb_lsp.addItem(dslsp.get(i));
        }
    }
    public void repointship() throws FontFormatException, IOException
    {
      
        lbtitle.setBounds(jPanel2.getSize().width/2-220,10, 450,60);
     
    }
    public  static  int w;
    public static  int h;
    public void xulyscoll4()
    {
        w=jScrollPane4.getWidth();
        h=jScrollPane4.getHeight();
        listtk.setVisible(false);
        if(listtk.isVisible()==false)
        {
           JPanel js= new JPanel()
           {
               ImageIcon img= new ImageIcon("image//colordon1.png");
               @Override
               protected void paintComponent(Graphics g) {
                   
                   g.drawImage(img.getImage(), 0,0,w, h+32, null);
                setOpaque(false);
                   super.paintComponent(g); 
               }
             
               
           };
         
           jScrollPane4.setViewportView(js);
           jScrollPane4.setBorder(null);
        }
        else   if(listtk.isVisible()==true)
        {
            jScrollPane4.setViewportView(listtk);
        }
        
       
        
      }
    
public void setimgbutton()
{
    String s = "image//folder.png";
    String s2="image//st.png";
    btn_capnhat.setVisible(false);
     btn_capnhat.setSize(60,60);
     new SetImage().setImageButton(btn_capnhat, "image//sign.png");
    btnanh1.setSize(30, 30);
    new SetImage().setImageButton(btnanh1, s);
    btnanh2.setSize(30, 30);
    new SetImage().setImageButton(btnanh2, s);
    btnanh3.setSize(30, 30);
    new SetImage().setImageButton(btnanh3, s);
    btnanh4.setSize(30, 30);
    new SetImage().setImageButton(btnanh4, s);

    new SetImage().setImageButton(btncumtomvbb, s2);
    new SetImage().setImageButton(btncthsx, s2);
    btn_them.setSize(60,60);
    new SetImage().setImageButton(btn_them, "image//add.png");
    btn_sua.setSize(60,60);
    new SetImage().setImageButton(btn_sua, "image//edit2.png");
    btn_xoa.setSize(60,60);
    new SetImage().setImageButton(btn_xoa, "image//deleted.png");
    btn_timkiem.setSize(60,60);
    new SetImage().setImageButton(btn_timkiem, "image//search.png");
       
    
    



}
public static Font getFont(String name) {
    Font font = null;
    if (name == null) {
        return SERIF_FONT;
    }
  
	

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        try {   
            InputStream in= productform.class.getResourceAsStream("/com/ltm/font/"+name+".ttf");
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,in));
        } catch (FontFormatException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }
	font = new Font(name, Font.PLAIN, 18);
	
   return font;
}
public void cumstom_mouse()
{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
Image image = toolkit.getImage("icons/unavail.gif");
Cursor c = toolkit.createCustomCursor(image , new Point(tbl_qlsp.getX(), 
           tbl_qlsp.getY()), "img");
tbl_qlsp.setCursor(c);
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel() {
            ImageIcon icon = new ImageIcon("image//bgrqlsp.jpg");
            public void paintComponent(Graphics g) {
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, -10, d.width, d.height+10, null);
                lbtitle.setBounds(jPanel2.getSize().width/2-220,10, 450,60);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        lbtitle = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_qlsp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("image//bgrqlsp.jpg");

            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width+80, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        tf_tsp = new javax.swing.JTextField();
        btnanh2 = new javax.swing.JButton();
        btnanh3 = new javax.swing.JButton();
        jd_ngaynhap = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_msp = new javax.swing.JTextField();
        btnanh4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf_gia = new javax.swing.JTextField();
        tf_sl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbb_lsp = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tar_mt = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnanh1 = new javax.swing.JButton();
        tf_km = new javax.swing.JTextField();
        cbbhss = new javax.swing.JComboBox<>();
        btncumtomvbb = new javax.swing.JButton();
        btncthsx = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("image//colordon.png");

            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                if(listtk.isVisible())
                {
                    g.setFont(new Font("Arial", Font.BOLD, 13));
                    g.setColor(Color.RED);

                    g.drawString("Gợi Ý Dành Cho Bạn:", tf_timkiem.getX()+2,tf_timkiem.getY()+tf_timkiem.getHeight()+13);
                }
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        btn_sua = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        tf_timkiem = new javax.swing.JTextField();
        btn_timkiem = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listtk = new javax.swing.JList<>();
        btn_capnhat = new javax.swing.JButton();
        cbb_timkiem = new javax.swing.JComboBox<>();

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 941));

        lbtitle.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbtitle.setForeground(new java.awt.Color(255, 0, 0));
        lbtitle.setText("     Quản Lí Sản Phẩm");
        lbtitle.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 0)));

        tbl_qlsp.setAutoCreateRowSorter(true);
        tbl_qlsp.setBackground(new java.awt.Color(153, 255, 255));
        tbl_qlsp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_qlsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng", "Số lượng", "khuyến mãi", "Giá", "ngày nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_qlsp.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbl_qlsp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_qlsp.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        tbl_qlsp.setDropMode(javax.swing.DropMode.ON);
        tbl_qlsp.setFocusable(false);
        tbl_qlsp.setGridColor(new java.awt.Color(255, 51, 51));
        tbl_qlsp.setRowHeight(30);
        tbl_qlsp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_qlsp.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbl_qlsp);
        tbl_qlsp.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tbl_qlsp.getColumnModel().getColumnCount() > 0) {
            tbl_qlsp.getColumnModel().getColumn(0).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(1).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(2).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(3).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(4).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(5).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(6).setResizable(false);
            tbl_qlsp.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(51, 255, 51), new java.awt.Color(0, 255, 102), java.awt.Color.yellow, java.awt.Color.yellow), "<html><u><i>Form nhập dữ liệu</i></u></html>", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 24), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(204, 204, 204));

        btnanh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanh2ActionPerformed(evt);
            }
        });

        btnanh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanh3ActionPerformed(evt);
            }
        });

        jd_ngaynhap.setBackground(new java.awt.Color(153, 255, 51));
        jd_ngaynhap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
        jd_ngaynhap.setAutoscrolls(true);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Giá  :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Mô tả:");

        tf_msp.setEnabled(false);

        btnanh4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanh4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("Ngày nhập về :");

        tf_gia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_giaKeyReleased(evt);
            }
        });

        tf_sl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_slKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tên sản phẩm :");

        cbb_lsp.setBackground(new java.awt.Color(255, 153, 102));
        cbb_lsp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_lspItemStateChanged(evt);
            }
        });
        cbb_lsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_lspActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setText("Hãng sản xuất :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Khuyến mãi:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Số lượng :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setText("Ảnh minh họa :");

        Tar_mt.setBackground(new java.awt.Color(102, 255, 255));
        Tar_mt.setColumns(20);
        Tar_mt.setRows(5);
        jScrollPane1.setViewportView(Tar_mt);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Mã sản phẩm :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setText("Loại sản phẩm :");

        btnanh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanh1ActionPerformed(evt);
            }
        });

        tf_km.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_kmActionPerformed(evt);
            }
        });
        tf_km.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_kmKeyReleased(evt);
            }
        });

        cbbhss.setBackground(new java.awt.Color(255, 153, 102));

        btncumtomvbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncumtomvbbActionPerformed(evt);
            }
        });

        btncthsx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncthsxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnanh2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnanh3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnanh4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_tsp)
                            .addComponent(cbb_lsp, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncumtomvbb, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(cbbhss, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncthsx, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tf_km, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel1))
                                    .addGap(25, 25, 25))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_msp)
                                .addComponent(tf_sl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(tf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addComponent(jd_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tsp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbb_lsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncumtomvbb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncthsx, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbbhss, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_msp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_km, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jd_ngaynhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnanh3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnanh4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnanh1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnanh2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(8, 8, 8, 8, new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\severbanmaytinh\\image\\color.jpg"))); // NOI18N

        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        tf_timkiem.setBackground(new java.awt.Color(255, 255, 153));
        tf_timkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_timkiemKeyReleased(evt);
            }
        });

        btn_timkiem.setBackground(new java.awt.Color(153, 255, 0));
        btn_timkiem.setToolTipText("Tìm kiếm");

        listtk.setBackground(new java.awt.Color(255, 255, 51));
        listtk.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(51, 51, 51)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        listtk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        listtk.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listtk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listtkMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(listtk);
        listtk.getAccessibleContext().setAccessibleDescription("");
        listtk.getAccessibleContext().setAccessibleParent(this);

        btn_capnhat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_capnhat.setText("Cập Nhật");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        cbb_timkiem.setBackground(new java.awt.Color(51, 255, 51));
        cbb_timkiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbb_timkiem.setForeground(new java.awt.Color(51, 51, 51));
        cbb_timkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo mã", "Tìm kiếm theo tên", "Tìm kiếm theo loại sản phẩm", "Tìm kiễm theo hãng", "Tìm kiếm theo số lượng", "Tìm kiếm theo khuyến mại", "Tìm kiếm theo giá", " " }));
        cbb_timkiem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbb_timkiemItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                    .addComponent(tf_timkiem)
                    .addComponent(cbb_timkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbb_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tf_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(656, 656, 656)
                .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(553, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_kmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_kmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_kmActionPerformed

    private void btncumtomvbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncumtomvbbActionPerformed
       
        String itemnew= JOptionPane.showInputDialog(null,"Vui lòng nhập Loại sản phẩm:","Thêm loại sản phẩm",JOptionPane.INFORMATION_MESSAGE);
        if(!itemnew.equals(" ")&&!itemnew.equals(null))
        {
        cbb_lsp.addItem(itemnew);
        dslsp.add(itemnew);
            try {
                new DAO().addlsp(itemnew);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btncumtomvbbActionPerformed
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
    private void btnanh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanh1ActionPerformed
        
   
        try {
            link1=getlinkanh();
        } catch (IOException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnanh1ActionPerformed
public void resetlinkanh()
{
    link1="";
    link2="";
    link3="";
    link4="";
}
    private void btncthsxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncthsxActionPerformed
      new formaddhang(this, dslsp,dshsp).setVisible(true);
      
    }//GEN-LAST:event_btncthsxActionPerformed
public String catktgiua(String s)
{
    char []tmp=s.toCharArray();
    String kq=" ";
    for(int i=0;i<tmp.length;i++)
    {
      if(tmp[i]!=' ')  kq+=tmp[i];
    }
    return kq.trim();
}
    private void btnanh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanh2ActionPerformed
        try {
            link2=getlinkanh();
        } catch (IOException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnanh2ActionPerformed

    private void btnanh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanh3ActionPerformed
       
        try {
            link3=getlinkanh();
        } catch (IOException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnanh3ActionPerformed

    private void btnanh4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanh4ActionPerformed
       
        try {
            link4=getlinkanh();
        } catch (IOException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnanh4ActionPerformed

 
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
    
        if(sateedit)
        {
            JOptionPane.showConfirmDialog(null,"Đang chế độ sửa không thể thêm","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            return;
        }
       else if(tf_tsp.getText().equals("") ||  tf_msp.getText().equals("") || tf_gia.getText().equals("") || tf_sl.getText().equals("") || Tar_mt.getText().equals("") ||jd_ngaynhap.getDate().equals(new Date())||link1.equals("")||link2.equals("")||link3.equals("")||link4.equals(""))
       {
          JOptionPane.showConfirmDialog(null,"Vui lòng nhập đủ dữ liệu","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
           return;
       }else
       {
           try {
               
          
           sanpham spm= new sanpham();
           spm.setTen(tf_tsp.getText());
           spm.setLoaisp(cbb_lsp.getSelectedItem().toString());
           spm.setHangsx(cbbhss.getSelectedItem().toString());
           spm.setMa(tf_msp.getText());
           spm.setSoluong(Integer.parseInt(tf_sl.getText()));
           spm.setKhuyenmai(Integer.parseInt(tf_km.getText()));
           spm.setGia(Long.parseLong(tf_gia.getText()));
           Date ntmp=jd_ngaynhap.getDate();
           SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");
           String fomat= formatter.format(ntmp);
           spm.setNgayhangve(fomat);
       
           
           spm.setMota(Tar_mt.getText());
           spm.setLinkanh1(link1);
           spm.setLinkanh2(link2);
           spm.setLinkanh3(link3);
           spm.setLinhanh4(link4);
            
           dssp.add(spm);
           new DAO().themsanpham(spm.getMa(),spm.getTen(),spm.getLoaisp(),spm.getHangsx(),spm.getSoluong(),spm.getKhuyenmai(), spm.getGia(),spm.getNgayhangve(), link1, link2, link3, link4,spm.getMota());
           int vitri=dssp.size()-1;
           modeltb.addRow(new Object[]
           {
               dssp.get(vitri).getMa(),dssp.get(vitri).getTen(),dssp.get(vitri).getLoaisp(),dssp.get(vitri).getHangsx(),dssp.get(vitri).getSoluong(),dssp.get(vitri).getKhuyenmai(),converttien(dssp.get(vitri).getGia())+" VNĐ",dssp.get(vitri).getNgayhangve(),false
           });
         resetlinkanh();
           resetformsp();
         ssnt.addforclient(spm);
//           sever= new ServerSocket(3333);
//            ArrayList<sanpham> dssptmp= new ArrayList<>();
//            dssptmp.add(spm);
//            new socketconnection(sever,dssptmp).connection();
            } catch (Exception e) {
              JOptionPane.showConfirmDialog(null, "vui lòng kiểm tra lại thông tin đã nhập!","Chú ý",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
           }
       }
        
    }//GEN-LAST:event_btn_themActionPerformed

    private void cbb_lspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_lspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_lspActionPerformed

    public void tachmaso(String mabd)
    {
        Pattern pattern = Pattern.compile("\\d*"); 
        Matcher matcher ;
        
        char []s= mabd.trim().toCharArray();
        String tmp=" ";
        for(int i=0;i<s.length;i++)
        {
           matcher = pattern.matcher(String.valueOf(s[i]));
           if(matcher.matches())
           {
               tmp+=s[i];
           }
           else
           {
             ma+=s[i];  
           }
                      
        }
        
        ma=ma.trim();
        tmp=tmp.trim();
       so=Integer.parseInt(tmp);
        
    } 
    String ma=" ";
        int so=0;
    private void cbb_lspItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_lspItemStateChanged
      
      
        cbb= (DefaultComboBoxModel) cbbhss.getModel();
      
        cbb.removeAllElements();
        String s= cbb_lsp.getSelectedItem().toString();
        String [] tmp ;
        String stmp=" ";
            
        
     
        for(int i=0;i<dshsp.size();i++)
        {
            tmp= dshsp.get(i).split(" ");
                
           if(tmp[0].trim().equals(catktgiua(s)))
           {
               for(int j=1;j<tmp.length;j++)
               {
                   stmp+=tmp[j]+" ";
               }
               cbb.addElement(stmp.trim());
               stmp=" ";
           }
          
        }
       int max=0;
        for(int i=0;i<dssp.size();i++)
        {           
              tachmaso(dssp.get(i).getMa());
               
              if(ma.trim().equals(cbb_lsp.getSelectedItem().toString().trim()))
              {
                  if(so>max) {
                      max=so;
                 // System.out.println("max:"+max);
                  }
              }
        ma=" ";
        so=0;
        
        }
        if(sateedit==false)
        { 
        tf_msp.setText(catktgiua(cbb_lsp.getSelectedItem().toString())+(max+1));
        }
        else
            if(sateedit)
            {
                if(cbb_lsp.getSelectedItem().equals(lsptmp))
                {
                    tf_msp.setText(dssp.get(vttmp).getMa());
                }
                else
                {
                     tf_msp.setText(catktgiua(cbb_lsp.getSelectedItem().toString())+(max+1));
                }
            }
     
    }//GEN-LAST:event_cbb_lspItemStateChanged
String lsptmp;
int vttmp=0;
    private void tf_slKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_slKeyReleased
        
        if(nhandangso(tf_sl.getText())==false)
        {
          
             JOptionPane.showConfirmDialog(null,"Trường này không cho phép nhập chữ hoặc kí tự!vui lòng nhập lại","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
             tf_sl.setText("");
        }
        else if(nhandangso(tf_sl.getText()))
        {
            if(Integer.parseInt(tf_sl.getText())<0)
            {
                             JOptionPane.showConfirmDialog(null,"Số lượng sản phẩm không được nhỏ hơn 0!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
               
                tf_sl.setText("");
            }
        }
        
    }//GEN-LAST:event_tf_slKeyReleased

    private void tf_kmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_kmKeyReleased
        
        if(nhandangso(tf_km.getText())==false )
        {
            
           
       JOptionPane.showConfirmDialog(null,"Trường này không cho phép nhập chữ hoặc kí tự!vui lòng nhập lại!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);

            tf_km.setText("");
        }
        else if(nhandangso(tf_km.getText()))
        {
            if(Integer.parseInt(tf_km.getText().trim())>100|| Integer.parseInt(tf_km.getText().trim())<0)
            {
              JOptionPane.showConfirmDialog(null,"Khuyến mại chỉ được lớn hơn hoặc bằng 0 và nhỏ hơn 100!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
              
            tf_km.setText("");
            }
          
                
        }
    }//GEN-LAST:event_tf_kmKeyReleased

    private void tf_giaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_giaKeyReleased
       
        if(nhandangso(tf_gia.getText())==false)
        {
           
         JOptionPane.showConfirmDialog(null,"Trường này không cho phép nhập chữ hoặc kí tự!vui lòng nhập lại!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);

            tf_gia.setText("");
        }
        else if(nhandangso(tf_gia.getText()))
        {
            if(Integer.parseInt(tf_gia.getText())<0)
            {
                
                 JOptionPane.showConfirmDialog(null,"Gíá của sản phẩm không được nhỏ hơn 0!","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);

                tf_gia.setText("");
            }
        }
    }//GEN-LAST:event_tf_giaKeyReleased
int vitriupdate=0;
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
     
    String s=(btn_sua.getText()=="Sửa") ? "Hủy":"Sửa";
    btn_sua.setText(s);
    if(btn_sua.getText().equals("Hủy"))
    {
        btn_sua.setSize(60,60);
        new SetImage().setImageButton(btn_sua, "image//delete1.png");
        btn_capnhat.setVisible(true);
        sateedit=true;
        if(tbl_qlsp.getSelectedRowCount()>0)
        {
            for(int i=0;i<dssp.size();i++)
            {
                if(dssp.get(i).getMa().equals(tbl_qlsp.getValueAt(tbl_qlsp.getSelectedRow(), 0)))
                {
                    try {
                        tf_tsp.setText(dssp.get(i).getTen());
                        cbblsp.setSelectedItem(dssp.get(i).getLoaisp());
                        cbb.setSelectedItem(dssp.get(i).getHangsx());
                        tf_msp.setText(dssp.get(i).getMa());
                        tf_sl.setText(String.valueOf(dssp.get(i).getSoluong()));
                        tf_km.setText(String.valueOf(dssp.get(i).getKhuyenmai()));
                        tf_gia.setText(String.valueOf(dssp.get(i).getGia()));
                        
                        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dssp.get(i).getNgayhangve());
                        jd_ngaynhap.setDate(date);
                        Tar_mt.setText(dssp.get(i).getMota());
                        vttmp=i;
                        lsptmp=dssp.get(i).getLoaisp();
                        link1=dssp.get(i).getLinkanh1();
                        link2=dssp.get(i).getLinkanh2();
                        link3=dssp.get(i).getLinkanh3();  
                        link4=dssp.get(i).getLinhanh4();
                            vitriupdate=i;
                        break;
                    } catch (ParseException ex) {
                        Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
         
          
            }
        }
        else
        {
             btn_sua.setSize(60,60);
              new SetImage().setImageButton(btn_sua, "image//edit2.png");
            JOptionPane.showConfirmDialog(null,"Bạn phải chọn 1 hàng để sửa","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
            btn_sua.setText("Sửa");

        }
    }
    else if(btn_sua.getText().equals("Sửa"))
    {
         btn_sua.setSize(60,60);
          new SetImage().setImageButton(btn_sua, "image//edit2.png");
        resetformsp();
        sateedit=false;
        btn_capnhat.setVisible(false);
    }
 
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
     if(tf_tsp.getText().equals("") ||  tf_msp.getText().equals("") || tf_gia.getText().equals("") || tf_sl.getText().equals("") || Tar_mt.getText().equals("") ||jd_ngaynhap.getDate().equals(new Date())||link1.equals("")||link2.equals("")||link3.equals("")||link4.equals(""))
       {
          JOptionPane.showConfirmDialog(null,"Vui lòng nhập đủ dữ liệu","Chú Ý", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
        
          
           return;
       }
     else
     {
         try {
          
                sanpham spm = dssp.get(vttmp);

                spm.setTen(tf_tsp.getText());
                spm.setLoaisp(cbb_lsp.getSelectedItem().toString());
                spm.setHangsx(cbbhss.getSelectedItem().toString());
                spm.setMa(tf_msp.getText());
                spm.setSoluong(Integer.parseInt(tf_sl.getText()));
                spm.setKhuyenmai(Integer.parseInt(tf_km.getText()));
                spm.setGia(Long.parseLong(tf_gia.getText()));
                Date ntmp = jd_ngaynhap.getDate();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String fomat = formatter.format(ntmp);
                spm.setNgayhangve(fomat);

                spm.setMota(Tar_mt.getText());
                spm.setLinkanh1(link1);
                spm.setLinkanh2(link2);
                spm.setLinkanh3(link3);
                spm.setLinhanh4(link4);

                new DAO().updatedssp(dssp.get(vttmp).getID(), tf_msp.getText(), tf_tsp.getText(), cbb_lsp.getSelectedItem().toString(), cbbhss.getSelectedItem().toString(), Integer.parseInt(tf_sl.getText()), Integer.parseInt(tf_km.getText()), Long.parseLong(tf_gia.getText()), fomat, link1, link2, link3, link4, Tar_mt.getText());
                updatetablesp();
                btn_capnhat.setVisible(false);
                btn_sua.setSize(60, 60);
                new SetImage().setImageButton(btn_sua, "image//edit2.png");
                btn_sua.setText("Sửa");
                resetlinkanh();
                resetformsp();
                ssnt.updateclient(spm, vitriupdate);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
             Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
         }
        }


    }//GEN-LAST:event_btn_capnhatActionPerformed
    public void updatetablesp() {
        modeltb.setRowCount(0);
        adddefaultable();
    }
     int check2;
    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        try {
            dssp= new DAO().getsp();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (tbl_qlsp.getSelectedRowCount() > 0) {
                int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Chú Ý", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(check==JOptionPane.YES_OPTION)
                {
                check2 = JOptionPane.showConfirmDialog(null, "Bạn sẽ không thể phục hồi sản phẩm này sau khi xóa ! Tiếp Tục?", "Chú Ý", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                }
            if (check == JOptionPane.YES_OPTION && check2==JOptionPane.YES_OPTION) {
                for (int i = 0; i < dssp.size(); i++) {
                    if (dssp.get(i).getMa().equals(tbl_qlsp.getValueAt(tbl_qlsp.getSelectedRow(), 0))) {
                        try {
                            
                            new DAO().deletesp(dssp.get(i).getID());
                            dssp.remove(i);
                            updatetablesp();
                            ssnt.deleteforclient(i);
                            break;
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(productform.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }

            }
        } else {
            JOptionPane.showConfirmDialog(null, "Chưa có dòng nào được chọn không thể xóa", "Chú Ý", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    public  GraphicsEnvironment cutomfont(String path) throws FontFormatException
    {
        GraphicsEnvironment ge = null;
        try {
           ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
        } catch (IOException | FontFormatException e) {
    
}
        return ge;
    }
    public void xulytimkiem()
    {
          String key=cbb_timkiem.getSelectedItem().toString();
      jPanel1.repaint();
     if(tf_timkiem.getText().equals(""))
     {
         listtk.setVisible(false);
         modeltb.setRowCount(0);
         adddefaultable();
         xulyscoll4();
     }
     
      else  if(key.equals("Tìm kiếm theo mã")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( dssp.get(i).getMa().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||dssp.get(i).getMa().toLowerCase().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("")||dssp.get(i).getMa().equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                    model.addElement(dssp.get(i).getMa());
                    listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
                
            }
            
            
        }
      else  if(key.equals("Tìm kiếm theo tên")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( dssp.get(i).getTen().toLowerCase().indexOf(tf_timkiem.getText())>=0  || dssp.get(i).getTen().indexOf(tf_timkiem.getText())>=0 ||dssp.get(i).getTen().equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getTen());
                   listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }

            }
        }
      else  if(key.equals("Tìm kiếm theo loại sản phẩm")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( dssp.get(i).getLoaisp().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||dssp.get(i).getLoaisp().toLowerCase().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("")||dssp.get(i).getLoaisp().equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getLoaisp());
                  listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
                
            }
        }
      else  if(key.equals("Tìm kiếm theo hãng")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( dssp.get(i).getHangsx().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") || dssp.get(i).getHangsx().toLowerCase().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||dssp.get(i).getHangsx().equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getHangsx());
                  listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
               
            }
        }
      else  if(key.equals("Tìm kiếm theo số lượng")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( String.valueOf(dssp.get(i).getSoluong()).indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("")||String.valueOf(dssp.get(i).getSoluong()).toLowerCase().indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||String.valueOf(dssp.get(i).getSoluong()).equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getSoluong());
                  listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
                  else
                {
                      modeltb.setRowCount(0);
                }
            }
        }
      else  if(key.equals("Tìm kiếm theo khuyến mại")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( String.valueOf(dssp.get(i).getKhuyenmai()).indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||String.valueOf(dssp.get(i).getKhuyenmai()).equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getKhuyenmai());
                  listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
                  else
                {
                      modeltb.setRowCount(0);
                }
            }
        }
      else  if(key.equals("Tìm kiếm theo giá")&& tf_timkiem.getText()!="")
        {
            for(int i=0;i<dssp.size();i++)
            {
                if( String.valueOf(dssp.get(i).getGia()).indexOf(tf_timkiem.getText())>=0 && !tf_timkiem.getText().equals("") ||String.valueOf(dssp.get(i).getGia()).equals(tf_timkiem.getText()) )
                {
                   listtk.setVisible(true);
                   jScrollPane4.setViewportView(listtk);
                    model.clear();
                   model.addElement(dssp.get(i).getGia());
                  listtk.setModel(model);
                  modeltb.setRowCount(0);
                  modeltb.addRow(new Object[]
                  {
          dssp.get(i).getMa(),dssp.get(i).getTen(),dssp.get(i).getLoaisp(),dssp.get(i).getHangsx(),dssp.get(i).getSoluong(),dssp.get(i).getKhuyenmai(),converttien(dssp.get(i).getGia())+" VNĐ",dssp.get(i).getNgayhangve(),false

                  });
                }
               
            }
            
        }
    }
    private void tf_timkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_timkiemKeyReleased
    
    xulytimkiem();
    }//GEN-LAST:event_tf_timkiemKeyReleased

    private void cbb_timkiemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_timkiemItemStateChanged
       
          modeltb.setRowCount(0);
        adddefaultable();
        tf_timkiem.setText("");
        listtk.setVisible(false);
        xulyscoll4();
        model.clear();
    }//GEN-LAST:event_cbb_timkiemItemStateChanged

    private void listtkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listtkMouseClicked
        
             System.out.println(listtk.getSelectedIndex());
            tf_timkiem.setText(model.getElementAt(listtk.getSelectedIndex()).toString());
            xulytimkiem();
    }//GEN-LAST:event_listtkMouseClicked

    public void resetformsp() {
        tf_tsp.setText("");
        tf_gia.setText("");
        tf_km.setText("");
        tf_msp.setText("");
        tf_sl.setText("");
        Tar_mt.setText("");
        cbb_lsp.setSelectedIndex(0);
        cbbhss.setSelectedIndex(0);
        jd_ngaynhap.setDate(new Date());

}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Tar_mt;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton btnanh1;
    private javax.swing.JButton btnanh2;
    private javax.swing.JButton btnanh3;
    private javax.swing.JButton btnanh4;
    private javax.swing.JButton btncthsx;
    private javax.swing.JButton btncumtomvbb;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbb_lsp;
    private javax.swing.JComboBox<String> cbb_timkiem;
    private javax.swing.JComboBox<String> cbbhss;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JDateChooser jd_ngaynhap;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JList<String> listtk;
    private javax.swing.JTable tbl_qlsp;
    private javax.swing.JTextField tf_gia;
    private javax.swing.JTextField tf_km;
    private javax.swing.JTextField tf_msp;
    private javax.swing.JTextField tf_sl;
    private javax.swing.JTextField tf_timkiem;
    private javax.swing.JTextField tf_tsp;
    // End of variables declaration//GEN-END:variables
}
