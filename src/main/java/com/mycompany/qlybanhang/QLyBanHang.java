/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.qlybanhang;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author shypo
 */
public class QLyBanHang {

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                  SanPhamJFrame sanphamJFrame = new SanPhamJFrame();
//                  sanphamJFrame.setTitle("DashBoard");       
//                  sanphamJFrame.setVisible(true);
//                SanPhamJFrame frame = new SanPhamJFrame();
//                frame.setTitle("Quản Lý Bán Hàng");
//                frame.setSize(800, 600);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
                  new DashBoardJFrame().setVisible(true);
                  new DashBoardJFrame().setTitle("DashBoard");
                  
                  
            }
        });     
    }
}
