/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/Application.java to edit this template
 */
package View;

import ConnectDatabase.Connect;
import DAO.PhieuXuatDAO;
import DAO.SPXuatDAO;
import DAO.SanPhamDAO;
import DAO.UserDAO;
import Entity.PhieuXuat;
import Entity.SpXuat;
import Entity.Users;
import static ExportExcel.ExportExcel.exportExcel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author MRSTHAO
 */
public class Xuat_SanPham extends javax.swing.JFrame {

    /**
     * Creates new form Xuat_SanPham
     */
    public boolean CheckInput(){
        return !(NameSP_TextField.getText().equals("")||
                Quantity_In_TextField.getText().equals(""));
    }
    public void JTable_ConnectDb(){
        try {
            String query = "SELECT * FROM sp_xuat INNER JOIN sanpham ON sp_xuat.maSP = sanpham.id WHERE maPhieuXuat = "+idPhieuXuat;
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            DefaultTableModel model=(DefaultTableModel) XuatSP_Table.getModel();
            
            while (rs.next()){
                Object objList[] = {
                    rs.getInt("id"),
                    rs.getInt("sp_xuat.maSP"),
                    rs.getString("name"),
                    rs.getInt("quantity_in"),
                    rs.getInt("sanpham.price"),
                    rs.getInt("quantity_in") * rs.getInt("sanpham.price")
                };
                model.addRow(objList);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    public void Reload_View(){
        IdPhieuXuat_Label.setText(idPhieuXuat+"");
        try{
            String query = "SELECT * FROM phieuxuat INNER JOIN users ON phieuxuat.userId = users.id WHERE phieuxuat.id = "+idPhieuXuat;
            Connection cnt = Connect.getConnection();
            Statement stm = cnt.createStatement();
            ResultSet rs = stm.executeQuery(query);
            
            while(rs.next()){
                UserName_Label.setText(rs.getString("username"));
                DateOut_Label.setText(rs.getDate("dateOut").toString());
                SumPayment_Label.setText(String.valueOf(rs.getInt("sumPayment")));
            }
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        NameSP_TextField.setText("");
        Quantity_In_TextField.setText("");
        //Remove all row of jtable and connect again;
        DefaultTableModel dm = (DefaultTableModel) XuatSP_Table.getModel();
        int rowCount = dm.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
        JTable_ConnectDb();
    }
    
    public Xuat_SanPham() {
        initComponents();
    }
    int idPhieuXuat;
    Xuat_SanPham(int idPX){
        this.idPhieuXuat = idPX;
        initComponents();
        Reload_View();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IdPhieuXuat_Label = new javax.swing.JLabel();
        DateOut_Label = new javax.swing.JLabel();
        UserName_Label = new javax.swing.JLabel();
        SumPayment_Label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        XuatSP_Table = new javax.swing.JTable();
        Quantity_In_TextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        NameSP_TextField = new javax.swing.JTextField();
        Insert_Button = new javax.swing.JButton();
        Update_Button = new javax.swing.JButton();
        Delete_Button = new javax.swing.JButton();
        Excel_Button = new javax.swing.JButton();
        MesSoLuong_Label = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN PHIẾU XUẤT");

        jLabel2.setText("Mã phiếu xuất");

        jLabel3.setText("Ngày xuất");

        jLabel4.setText("Người xuất");

        jLabel5.setText("Tổng tiền bán");

        IdPhieuXuat_Label.setText("0000");

        DateOut_Label.setText("0000");

        UserName_Label.setText("0000");

        SumPayment_Label.setText("0000");

        XuatSP_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Thành tiền"
            }
        ));
        XuatSP_Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XuatSP_TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(XuatSP_Table);

        Quantity_In_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Quantity_In_TextFieldActionPerformed(evt);
            }
        });
        Quantity_In_TextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Quantity_In_TextFieldKeyPressed(evt);
            }
        });

        jLabel12.setText("Tên sản phẩm");

        jLabel14.setText("Số lượng");

        NameSP_TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameSP_TextFieldActionPerformed(evt);
            }
        });

        Insert_Button.setText("Thêm");
        Insert_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_ButtonActionPerformed(evt);
            }
        });

        Update_Button.setText("Sửa");
        Update_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Update_ButtonActionPerformed(evt);
            }
        });

        Delete_Button.setText("Xoá");
        Delete_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_ButtonActionPerformed(evt);
            }
        });

        Excel_Button.setText("Xuất");
        Excel_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Excel_ButtonActionPerformed(evt);
            }
        });

        MesSoLuong_Label.setText("     ");
        MesSoLuong_Label.setToolTipText("");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NameSP_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Quantity_In_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MesSoLuong_Label))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Delete_Button)
                            .addComponent(Insert_Button))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Update_Button)
                            .addComponent(Excel_Button))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))))
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(IdPhieuXuat_Label)
                            .addComponent(DateOut_Label)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(UserName_Label)
                                .addComponent(SumPayment_Label))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel1)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(IdPhieuXuat_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DateOut_Label)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(UserName_Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(SumPayment_Label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Delete_Button)
                                .addComponent(Excel_Button))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(NameSP_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Update_Button)
                                    .addComponent(Insert_Button))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(Quantity_In_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))
                        .addComponent(MesSoLuong_Label)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
       int yes_no = JOptionPane.showConfirmDialog(this, "Thoát chương trình ?","Thoát",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void Quantity_In_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Quantity_In_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Quantity_In_TextFieldActionPerformed

    private void NameSP_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameSP_TextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameSP_TextFieldActionPerformed

    private void Update_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Update_ButtonActionPerformed
        // TODO add your handling code here:
        if(CheckInput()){
            if(!XuatSP_Table.getSelectionModel().isSelectionEmpty()){ 
                boolean isOk = true;
                
                //ID sp_xuat
                int i = XuatSP_Table.getSelectedRow();
                TableModel model = XuatSP_Table.getModel();
                int id =(int) model.getValueAt(i, 0);
                //idSP
                String name = NameSP_TextField.getText();
                int idSP = SanPhamDAO.getIdByName(name);
                if(idSP == -1){
                    JOptionPane.showMessageDialog(null,"Không tồn tại sản phẩm này trong kho");
                    isOk = false;
                }
                //Id phieuxuat
                int maPhieuXuat = Integer.parseInt(IdPhieuXuat_Label.getText());
                //quartity_in_new
                int quantity_in_new = Integer.parseInt( Quantity_In_TextField.getText());
                /*
                quantity_in_old : SELECT quantity_in  from sp_xuat WHERE id = id;
                quantity_has    : SELECT quantity_has from sp      WHERE idSP = idSP;
                quantity_in_new vs (quantity has + quantity_in_old)
                */
                int quantity_in_old = SPXuatDAO.getQuantity_inById(id);
                int quantity_has = SanPhamDAO.getQuantity_hasById(idSP);
                if (quantity_has + quantity_in_old < quantity_in_new){
                    JOptionPane.showMessageDialog(null,"Nhà kho ko đủ để đáp ứng thay đổi");
                    isOk = false;
                }
                if(isOk){
                    int price = quantity_in_new * SanPhamDAO.getPriceById(idSP);  
                    SpXuat sp_px = SPXuatDAO.getById(id);
                    if(sp_px != null){
                        int rs = SPXuatDAO.update(id,quantity_in_new,price, idSP,maPhieuXuat);
                        if(rs == 1) JOptionPane.showMessageDialog(null,"Update thành công");
                        else JOptionPane.showMessageDialog(null,"Lõi");
                        Reload_View();
                    }else JOptionPane.showMessageDialog(null,"Ko tìm thấy sp_xuất mã id:"+id);
                }
            }else JOptionPane.showMessageDialog(null,"Vui lòng chọn ");
        }
        else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
    }//GEN-LAST:event_Update_ButtonActionPerformed

    private void Insert_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_ButtonActionPerformed
        // TODO add your handling code here:
        if(CheckInput()){
            boolean isOk=true;
            //maSP or id of SanPham
            String name = NameSP_TextField.getText();
            int idSP = SanPhamDAO.getIdByName(name);
            if(idSP == -1){
                JOptionPane.showMessageDialog(null,"Không tồn tại sản phẩm này trong kho");
                isOk = false;
            }
            //Id phieuxuat
            int maPhieuXuat = Integer.parseInt(IdPhieuXuat_Label.getText());
            //số lượng
            int quantity_in = Integer.parseInt( Quantity_In_TextField.getText());
            int quantity_has = SanPhamDAO.getQuantity_hasById(idSP);
            if (quantity_has < quantity_in){
                JOptionPane.showMessageDialog(null,"Hàng trong kho không đủ");
                isOk = false;
            }
            //id for SP_XUAT 
            int id = -1;
            String queryId = "SELECT MAX(id) FROM SP_Xuat";
            try {
                Connection cnt = Connect.getConnection();
                Statement stm = cnt.createStatement();
                ResultSet rs = stm.executeQuery(queryId);
                while(rs.next()){
                    id = rs.getInt("MAX(id)");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            id++;
            //price = solg * SanPham.price (giá của sp)
            float price = quantity_in * SanPhamDAO.getPriceById(idSP);        
            //insert (tồn tại tồn tại hàng và đủ số lượng mới cho nhập)
            if(isOk){
                int rs = SPXuatDAO.insert(id, quantity_in, price, idSP, maPhieuXuat);
                if (1 == rs){
                    JOptionPane.showMessageDialog(null,"Thêm thành công !");
                    int rsUpdate = PhieuXuatDAO.update(maPhieuXuat);
                    if (1 == rsUpdate)
                        JOptionPane.showMessageDialog(null,"Cập nhật phiếu thành công !");
                    else 
                        JOptionPane.showMessageDialog(null,"Cập nhật không thành công");
                }
                else 
                    JOptionPane.showMessageDialog(null,"Lỗi");
                Reload_View();
            }
        } else JOptionPane.showMessageDialog(null,"Vui lòng nhập đủ thông tin");
    }//GEN-LAST:event_Insert_ButtonActionPerformed

    private void Quantity_In_TextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Quantity_In_TextFieldKeyPressed
        // TODO add your handling code here:
        String value = Quantity_In_TextField.getText();
        MesSoLuong_Label.setForeground(Color.RED);
        int l = value.length();
        if (evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9' || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            Quantity_In_TextField.setEditable(true);
            MesSoLuong_Label.setText("");
        } else {
            Quantity_In_TextField.setEditable(false);
            MesSoLuong_Label.setText("Chỉ nhập số(0-9)");
        }
    }//GEN-LAST:event_Quantity_In_TextFieldKeyPressed

    private void Delete_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_ButtonActionPerformed
        // TODO add your handling code here:
        int yes_no = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn không ?","Xác nhận xóa",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(yes_no == JOptionPane.YES_OPTION){
            if(!XuatSP_Table.getSelectionModel().isSelectionEmpty()){ 
                int i = XuatSP_Table.getSelectedRow();
                TableModel model = XuatSP_Table.getModel();
                int id =(int) model.getValueAt(i, 0);
                SpXuat sp_px = SPXuatDAO.getById(id);
                if(sp_px != null){
                    int rs = SPXuatDAO.deleteById(id,Integer.parseInt(IdPhieuXuat_Label.getText()));
                    if (1 == rs)
                        JOptionPane.showMessageDialog(null,"Xóa thành công !");
                    else 
                        JOptionPane.showMessageDialog(null,"Lỗi");
                    Reload_View();
                }else JOptionPane.showMessageDialog(null,"Ko tìm thấy sp_xuất mã id:"+id);

            }else JOptionPane.showMessageDialog(null,"Vui lòng chọn ");
        }
    }//GEN-LAST:event_Delete_ButtonActionPerformed

    private void XuatSP_TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XuatSP_TableMouseClicked
        // TODO add your handling code here:
        int i = XuatSP_Table.getSelectedRow();
        TableModel model = XuatSP_Table.getModel();
        NameSP_TextField.setText(model.getValueAt(i,2).toString());
        Quantity_In_TextField.setText(model.getValueAt(i,3).toString());
    }//GEN-LAST:event_XuatSP_TableMouseClicked

    private void Excel_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Excel_ButtonActionPerformed
        // TODO add your handling code here:
        exportExcel(XuatSP_Table);
    }//GEN-LAST:event_Excel_ButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Xuat_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xuat_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xuat_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xuat_SanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Xuat_SanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateOut_Label;
    private javax.swing.JButton Delete_Button;
    private javax.swing.JButton Excel_Button;
    private javax.swing.JLabel IdPhieuXuat_Label;
    private javax.swing.JButton Insert_Button;
    private javax.swing.JLabel MesSoLuong_Label;
    private javax.swing.JTextField NameSP_TextField;
    private javax.swing.JTextField Quantity_In_TextField;
    private javax.swing.JLabel SumPayment_Label;
    private javax.swing.JButton Update_Button;
    private javax.swing.JLabel UserName_Label;
    private javax.swing.JTable XuatSP_Table;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
