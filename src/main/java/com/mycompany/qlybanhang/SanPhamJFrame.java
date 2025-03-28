/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.qlybanhang;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
/**
 *
 * @author shypo
 */
public class SanPhamJFrame extends javax.swing.JFrame{
    private DefaultTableModel tableModel;
    /**

     */
    
    public SanPhamJFrame() {  
            
        try {          
            initComponents();
            tableModel = new DefaultTableModel();
            tableSanPham.setModel(tableModel);        
            loadData();
            }catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi kết nối cơ sở dữ liệu: " + e.getMessage());
        }
    } 
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/qlbh";
        String username = "root";
        String password = "";
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/qlbh", "root", "");
    }
    private void loadData() {
        tableModel.setColumnIdentifiers(new Object[] {"STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Mô Tả", "Giá", "Số Lượng","Loại Sản Phẩm"
        });
        tableModel.setRowCount(0);// Xoa du lieu truoc khi tai lai
        
        try {
            
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM SanPham");
            while (resultSet.next()) {
                Object[] row = {
                    resultSet.getInt("ProductID"),
                    resultSet.getString("MaSanPham"),
                    resultSet.getString("ProductName"),
                    resultSet.getString("Description"),
                    resultSet.getDouble("Price"),
                    resultSet.getInt("StockQuantity"),
                    resultSet.getString("LoaiSanPham")
                };
                tableModel.addRow(row);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void addProduct() {
        String maSanPham = textMaSanPham.getText();
        String tenSanPham = jTextField2.getText();
        String moTaSanPham = jTextField5.getText();
        double giaSanPham = Double.parseDouble(jTextField3.getText());
        int soLuongSanPham = Integer.parseInt(jTextField4.getText());
        String loaiSanPham = (String) cbbLoaiSanPham.getSelectedItem();
    
        try {
            Connection connection = getConnection();
            String sql = "INSERT INTO sanpham (MaSanPham, ProductName, Description, Price, StockQuantity,LoaiSanPham) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maSanPham);
            statement.setString(2, tenSanPham);
            statement.setString(3, moTaSanPham);
            statement.setDouble(4, giaSanPham);
            statement.setInt(5, soLuongSanPham);
            statement.setString(6, loaiSanPham);
            
        
            statement.executeUpdate();
            statement.close();
            connection.close();
            // Tải lại dữ liệu sau khi thêm mới
            loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    //----------------------//
    public void updateProduct() {
            String maSanPham = textMaSanPham.getText();
            String tenSanPham = jTextField2.getText();
            String moTaSanPham = jTextField5.getText();
            double giaSanPham = Double.parseDouble(jTextField3.getText());
            int soLuongSanPham = Integer.parseInt(jTextField4.getText());
            String loaiSanPham = (String) cbbLoaiSanPham.getSelectedItem();
    
            try {
                Connection connection = getConnection();
                String sql = "UPDATE sanpham SET ProductName = ? , Description = ?, Price = ?, StockQuantity = ?, LoaiSanPham = ? WHERE MaSanPham = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                 statement.setString(1, tenSanPham);
                statement.setString(2, moTaSanPham);
                statement.setDouble(3, giaSanPham);
                statement.setInt(4, soLuongSanPham);
                statement.setString(5, loaiSanPham);
                statement.setString(6, maSanPham); // Đặt giá trị cho tham số thứ 7

                statement.executeUpdate();
                statement.close();
                connection.close();            
                // Tải lại dữ liệu sau khi cập nhật
                loadData();
                } catch (SQLException e) {
                    e.printStackTrace();
                  }
                }
    //==================================//
    private void deleteProduct() {
        String maSanPham = textMaSanPham.getText();

        try {
            Connection connection = getConnection();
            String sql = "DELETE FROM sanpham WHERE MaSanPham = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, maSanPham);

            statement.executeUpdate();
            statement.close();
            connection.close();

            // Tải lại dữ liệu sau khi xóa
            loadData();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }
    //==============================//
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        textMaSanPham = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Mô Tả", "Giá", "Loại Sản Phẩm", "Số Lượng"
            }
        ));
        jScrollPane1.setViewportView(tableSanPham);

        jLabel1.setText("Mã Sản Phẩm");

        textMaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMaSanPhamActionPerformed(evt);
            }
        });

        jLabel2.setText("Tên Sản Phẩm");

        jButton2.setText("Quay Lại Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setText("Giá Sản Phẩm");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Mô Tả Sản Phẩm");

        jLabel6.setText("Loại Sản Phẩm");

        cbbLoaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSanPhamActionPerformed(evt);
            }
        });

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(textMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField2))
                                        .addGap(32, 32, 32)))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(1, 1, 1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addGap(155, 155, 155)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                            .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbLoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        deleteProduct();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void textMaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMaSanPhamActionPerformed
        // TODO add your handling code here:
        textMaSanPham = new JTextField();
        add(textMaSanPham);
    }//GEN-LAST:event_textMaSanPhamActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        addProduct();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        UpdateJFrame updateFrame = new UpdateJFrame();
        updateFrame.setTitle("Cập Nhật Sản Phẩm");
        updateFrame.setDefaultCloseOperation(UpdateJFrame.EXIT_ON_CLOSE);
        updateFrame.setVisible(true);
        //updateProduct();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:    
        new DashBoardJFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbLoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSanPhamActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPhamJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanPhamJFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbLoaiSanPham;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField textMaSanPham;
    // End of variables declaration//GEN-END:variables
}
