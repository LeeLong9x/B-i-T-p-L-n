/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ltm.control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Admin
 */
public class cutomstableheader extends JLabel implements TableCellRenderer{

    public cutomstableheader(Color foreground,Color backgound)
    {
        setFont(new Font("Consolas", Font.BOLD, 14));
        setOpaque(true);
        setForeground(foreground);
        setBackground(backgound);
        setBorder(BorderFactory.createEtchedBorder());
        setSize(100,80);
        
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText("   "+value.toString().trim());
        return this;
    }
    
    
}
