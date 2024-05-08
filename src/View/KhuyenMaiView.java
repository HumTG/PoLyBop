/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Model.KhuyenMai;
import Service.KhuyenMaiDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import Repository.DBconnect;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author Admin
 */
public class KhuyenMaiView extends javax.swing.JPanel {

    private DefaultTableModel model = new DefaultTableModel();
    private KhuyenMaiDAO kms = new KhuyenMaiDAO();
    private int index = -1;

    public KhuyenMaiView() {
        initComponents();
        this.fillTable(kms.getAll());
        //  txtBatDau.setEnabled(false);

    }

    void fillTable(List<KhuyenMai> list) {
        model = (DefaultTableModel) tblKhuyenMai.getModel();
        model.setRowCount(0);
        for (KhuyenMai x : list) {
            model.addRow(x.toDataRow());
        }
    }

    public void showData(int index) {
        index = tblKhuyenMai.getSelectedRow();
        txtMa.setText(tblKhuyenMai.getValueAt(index, 1).toString());
        txtGiaTri.setText(tblKhuyenMai.getValueAt(index, 2).toString());
        txtBatDau.setDate((Date) tblKhuyenMai.getValueAt(index, 3));
        txtKetThuc.setDate((Date) tblKhuyenMai.getValueAt(index, 4));
        if ((tblKhuyenMai.getValueAt(index, 5).toString()).equalsIgnoreCase("Còn hoạt động")) {
            rdCon.setSelected(true);
        } else {
            rdKhongHoatDong.setSelected(true);
        }
    }

    KhuyenMai readForm() {
        String ma;
        Date ngayBD, ngayKT;
        int giaTri;
        boolean trangThai;

        ma = txtMa.getText().trim();

        ngayBD = txtBatDau.getDate();
        java.util.Date startDate = ngayBD;
        java.sql.Date sqlDate = new java.sql.Date(startDate.getTime());
        ngayKT = txtKetThuc.getDate();
        java.util.Date endDate = ngayKT;
        java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
        /*ngayBD = new java.sql.Date(txtBatDau.getDate().getTime());
        ngayKT = new java.sql.Date(txtKetThuc.getDate().getTime());*/
        giaTri = Integer.parseInt(txtGiaTri.getText().trim());
        if (rdCon.isSelected()) {
            trangThai = true;
        } else {
            trangThai = false;
        }
        return new KhuyenMai(ma, giaTri, ngayBD, ngayKT, trangThai);
    }

    public boolean check() {
        if (txtMa.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã khuyến mại");
            return false;
        }
        if (isMaStringDuplicate(txtMa.getText())) {
            JOptionPane.showMessageDialog(this, "Mã khuyến mại đã tồn tại");
            return false;
        }
        // Kiểm tra ngày bắt đầu và ngày kết thúc
        if (txtBatDau.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu");
            return false;
        }
        if (txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc");
            return false;
        }

        /*if (txtKetThuc.getDate().before(txtBatDau.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
        }*/
        java.util.Date ngayBD = txtBatDau.getDate();

        // Lấy ngày kết thúc từ txtKetThuc
        java.util.Date ngayKT = txtKetThuc.getDate();

        // Kiểm tra xem cả hai ngày không null
        if (ngayBD != null && ngayKT != null) {
            // Chuyển đổi thành java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(ngayBD.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(ngayKT.getTime());

            // Kiểm tra ngày bắt đầu phải sau ngày kết thúc
            if (sqlStartDate.after(sqlEndDate)) {
                // Xử lý khi ngày bắt đầu sau ngày kết thúc
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc.");
                return false;
            } else {
                // Ngày bắt đầu hợp lệ, tiếp tục kiểm tra định dạng
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false); // Tắt chế độ tự động chấp nhận các giá trị không hợp lệ

                try {
                    // Kiểm tra định dạng của ngày bắt đầu
                    sdf.parse(ngayBD.toString());
                    // Kiểm tra định dạng của ngày kết thúc
                    sdf.parse(ngayKT.toString());
                    // Nếu cả hai đều hợp lệ, tiến hành xử lý tiếp theo
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu và ngày kết thúc hợp lệ.");
                } catch (ParseException e) {
                    // Xử lý khi ngày có định dạng không hợp lệ
                    //JOptionPane.showMessageDialog(this,"Ngày có định dạng không hợp lệ.");
                }
            }
        }

        // kiểm tra giá trị
        if (txtGiaTri.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Giá trị của khuyến mại");
            return false;
        }
        try {
            int giaTri = Integer.valueOf(txtGiaTri.getText());
            if (giaTri < 0) {
                JOptionPane.showMessageDialog(this, "Giá trị phải lớn hơn 0");
                return false;
            }
            if (giaTri > 100) {
                JOptionPane.showMessageDialog(this, "Giá trị phải <= 100 ");
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showConfirmDialog(this, "Giá phải là số");
            return false;
        }
        if (!rdCon.isSelected() && !rdKhongHoatDong.isSelected()) {
            // Nếu không có ô nào được chọn, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái khuyến mãi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false; // Trả về null để biểu thị rằng dữ liệu không hợp lệ
        }

        return true;

    }

    boolean check1() {
        if (txtMa.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã khuyến mại");
            return false;
        }
        if (txtBatDau.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu ");
            return false;
        }
        if (txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày kết thúc");
            return false;
        }

        java.util.Date ngayBD = txtBatDau.getDate();

        // Lấy ngày kết thúc từ txtKetThuc
        java.util.Date ngayKT = txtKetThuc.getDate();

        // Kiểm tra xem cả hai ngày không null
        if (ngayBD != null && ngayKT != null) {
            // Chuyển đổi thành java.sql.Date
            java.sql.Date sqlStartDate = new java.sql.Date(ngayBD.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(ngayKT.getTime());

            // Kiểm tra ngày bắt đầu phải sau ngày kết thúc
            if (sqlStartDate.after(sqlEndDate)) {
                // Xử lý khi ngày bắt đầu sau ngày kết thúc
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải trước ngày kết thúc.");
                return false;
            } else {
                // Ngày bắt đầu hợp lệ, tiếp tục kiểm tra định dạng
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false); // Tắt chế độ tự động chấp nhận các giá trị không hợp lệ
                try {
                    // Kiểm tra định dạng của ngày bắt đầu
                    sdf.parse(ngayBD.toString());
                    // Kiểm tra định dạng của ngày kết thúc
                    sdf.parse(ngayKT.toString());
                    // Nếu cả hai đều hợp lệ, tiến hành xử lý tiếp theo
                    JOptionPane.showMessageDialog(this, "Ngày bắt đầu và ngày kết thúc hợp lệ.");
                } catch (ParseException e) {
                    // Xử lý khi ngày có định dạng không hợp lệ
                    //JOptionPane.showMessageDialog(this,"Ngày có định dạng không hợp lệ.");
                }
            }
        }
        /*if (txtKetThuc.getDate().before(txtBatDau.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
        }*/

        // kiểm tra giá trị
        if (txtGiaTri.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Giá trị của khuyến mại");
            return false;
        }
        try {
            int giaTri = Integer.valueOf(txtGiaTri.getText());
            if (giaTri < 0) {
                JOptionPane.showMessageDialog(this, "Giá trị phải lớn hơn 0");
                return false;
            }
            else if (giaTri > 100) {
                JOptionPane.showMessageDialog(this, "Giá trị phải <= 100");
                return false;
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showConfirmDialog(this, "Giá phải là số");
            return false;
        }
        if (!rdCon.isSelected() && !rdKhongHoatDong.isSelected()) {
            // Nếu không có ô nào được chọn, hiển thị thông báo lỗi
            JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái khuyến mãi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false; // Trả về null để biểu thị rằng dữ liệu không hợp lệ
        }

        return true;
    }

    private boolean isMaStringDuplicate(String maKhuyenMai) {
        // Query your database to check if the provided code already exists
        String sql = "SELECT COUNT(*) FROM KHUYENMAI WHERE Ma_KhuyenMai = ?";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, maKhuyenMai);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // If count is greater than 0, the code already exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Default to false if an exception occurs or code doesn't exist
    }

    private void loadBanGhi() {
        tblKhuyenMai.setRowSelectionInterval(index, index);
    }

// Phương thức để kiểm tra ngày bắt đầu và ngày kết thúc
    /*public static boolean validateDates(String startDateStr, String endDateStr) {
        String dateFormatRegex = "\\d{4}/\\d{2}/\\d{2}";
        
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date startDate = sdf.parse(startDateStr);
            Date endDate = sdf.parse(endDateStr);

           return true;
        } catch (ParseException e) {
           JOptionPane.showMessageDialog(null, "Định dạng ngày kh+ông hợp lệ. Vui lòng nhập theo định dạng dd/MM/yyyy.");
            return false;
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rdHet = new javax.swing.JRadioButton();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbox = new javax.swing.JComboBox<>();
        btnTimKiem1 = new javax.swing.JButton();
        txtTim = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtBatDau = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        txtKetThuc = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdCon = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();

        rdHet.setText("Hết hạn");
        rdHet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHetActionPerformed(evt);
            }
        });

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Mã", "Mức giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 990, 205));

        jButton1.setText("|<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 278, 54, -1));

        jButton2.setText(">|");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 278, 64, -1));

        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(531, 278, 59, -1));

        jButton5.setText("<<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(457, 278, 59, -1));

        jLabel8.setText("Lọc khuyến mại");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 27, 94, -1));

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn Hoạt Động", "Không Hoạt Động" }));
        cbox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxActionPerformed(evt);
            }
        });
        cbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cboxKeyReleased(evt);
            }
        });
        jPanel1.add(cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(754, 24, 198, -1));

        btnTimKiem1.setText("Tìm khuyến mại");
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimKiem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 24, -1, -1));

        txtTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });
        jPanel1.add(txtTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 26, 258, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 1080, 312));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Tạo khuyến mại");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 172, -1));

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa khuyến mại");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel2.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 172, -1));

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("Xóa khuyến mại");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel2.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 230, 172, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setText("Mã khuyến mại");

        txtMa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel5.setText("Ngày bắt đầu");

        txtBatDau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setText("Ngày kết thúc");

        txtKetThuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBatDau, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(txtMa)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtKetThuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 6, -1, -1));

        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel4.setText("Giá trị");

        txtGiaTri.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtGiaTri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaTriActionPerformed(evt);
            }
        });

        jLabel1.setText("Trạng thái");

        buttonGroup1.add(rdCon);
        rdCon.setText("Còn hoạt động");
        rdCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdConActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdKhongHoatDong);
        rdKhongHoatDong.setText("Không hoạt động");
        rdKhongHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdKhongHoatDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdCon)
                                .addGap(27, 27, 27)
                                .addComponent(rdKhongHoatDong))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)))
                .addGap(0, 260, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCon)
                    .addComponent(rdKhongHoatDong))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 12, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 172, 30));

        btnExportExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExportExcel.setText("Export");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });
        jPanel2.add(btnExportExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 90, 70));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, 1081, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        index = 0;
        loadBanGhi();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtMaActionPerformed

    private void rdConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdConActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdConActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:

        index = tblKhuyenMai.getSelectedRow();
        String ma;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa");
        } else {// đã chọn
            // lấy mã sv từ table dòng index cột 1
            int chon;
            chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không", "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (chon != JOptionPane.YES_OPTION) {
                return;
            } else {
                if (check1()) {
                    // Lấy mã từ bảng
                    ma = tblKhuyenMai.getValueAt(index, 1).toString();
                    // Đảm bảo rằng txtMa không thay đổi giá trị của nó
                    String maHienTai = txtMa.getText();
                    if (!ma.equals(maHienTai)) {
                        JOptionPane.showMessageDialog(this, "Không thể thay đổi mã.");
                        return;
                    }

                    // Thực hiện các thay đổi khác nếu cần
                    // Sau đó, thực hiện cập nhật dữ liệu
                    if (kms.updateKM(ma, this.readForm()) > 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công");
                        this.fillTable(kms.getAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại");

                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblKhuyenMaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMouseClicked
        // TODO add your handling code here:
        index = tblKhuyenMai.getSelectedRow();
        if (index > -1) {
            this.showData(index);
        }
    }//GEN-LAST:event_tblKhuyenMaiMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int chon;
        chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;
        } else {
            if (check()) {
                if (kms.addKhuenMai(this.readForm()) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    this.fillTable(kms.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void rdHetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdHetActionPerformed

    private void rdKhongHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdKhongHoatDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdKhongHoatDongActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (index == kms.getAll().size() - 1) {
            index = -1;
        }
        index++;
        loadBanGhi();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (index == 0) {
            index = kms.getAll().size();
        }
        index--;
        loadBanGhi();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxActionPerformed
        // TODO add your handling code here:
        String selectedTt = ((String) cbox.getSelectedItem());
        String hd;
        if (selectedTt.equals("Còn Hoạt Động")) {
            hd = "1";
        } else {
            hd = "0";
        }
        List<KhuyenMai> listKhuyenMai = kms.locTT(hd);
        this.fillTable(listKhuyenMai);
    }//GEN-LAST:event_cboxActionPerformed

    private void btnTimKiem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem1ActionPerformed
        // TODO add your handling code here:
        String ma = txtTim.getText();
        List<KhuyenMai> list1;

        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã cần tìm");
            list1 = kms.getAll();

        } else {
            model.setRowCount(0);
            list1 = kms.searchKM(ma);

        }
        for (KhuyenMai sv : list1) {
            model.addRow(sv.toDataRow());
        }

    }//GEN-LAST:event_btnTimKiem1ActionPerformed

    private void txtTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimActionPerformed

    private void txtGiaTriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaTriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaTriActionPerformed

    private void cboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboxKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_cboxKeyReleased

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        index = tblKhuyenMai.getSelectedRow();
        String ma;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
        }
        int chon;
        chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (chon != JOptionPane.YES_OPTION) {
            return;

        } else {// đã chọn
            // lấy mã sv từ table dòng index cột 1
            ma = tblKhuyenMai.getValueAt(index, 1).toString();
            if (kms.deleteKM(ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                this.fillTable(kms.getAll());

            } else { // không xóa được
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        index = kms.getAll().size() - 1;
        loadBanGhi();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMa.setText(null);
        txtBatDau.setDate(null);
        txtKetThuc.setDate(null);

        txtGiaTri.setText(null);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        showSaveDialogAndExport();
    }//GEN-LAST:event_btnExportExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbox;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdCon;
    private javax.swing.JRadioButton rdHet;
    private javax.swing.JRadioButton rdKhongHoatDong;
    private javax.swing.JTable tblKhuyenMai;
    private com.toedter.calendar.JDateChooser txtBatDau;
    private javax.swing.JTextField txtGiaTri;
    private com.toedter.calendar.JDateChooser txtKetThuc;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTim;
    // End of variables declaration//GEN-END:variables

    private void showSaveDialogAndExport() {
        JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home") + "/Downloads");
        fileChooser.setDialogTitle("Save Excel File");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".xls") || f.isDirectory();
            }

            public String getDescription() {
                return "Excel Files (*.xls)";
            }
        });

        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            // Add .xls extension if not present
            if (!fileToSave.getAbsolutePath().endsWith(".xls")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xls");
            }
            exportToExcel(fileToSave);
        }
    }

    private void exportToExcel(File fileToSave) {
        DefaultTableModel model = (DefaultTableModel) tblKhuyenMai.getModel();
        Workbook workbook = new HSSFWorkbook(); // Sử dụng HSSFWorkbook cho định dạng .xls
        Sheet sheet = workbook.createSheet("KhachHangData");

        // Tạo header từ tên cột
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < model.getColumnCount(); col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(model.getColumnName(col));
        }

        // Thêm dữ liệu từ JTable vào Excel
        for (int row = 0; row < model.getRowCount(); row++) {
            Row excelRow = sheet.createRow(row + 1);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = excelRow.createCell(col);
                cell.setCellValue(model.getValueAt(row, col).toString());
            }
        }

        // Định dạng lại các cột (ví dụ: làm to rộng cột A)
        for (int col = 0; col < 10; col++) {
            sheet.setColumnWidth(col, 5000); // 3000 đơn vị là width, tùy thuộc vào đơn vị của bạn
        }

        // Lưu Workbook vào file Excel
        try (FileOutputStream outputStream = new FileOutputStream(fileToSave)) {
            workbook.write(outputStream);
            JOptionPane.showMessageDialog(this, "Export Excel successful!\nFile saved at: " + fileToSave.getAbsolutePath());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Export Excel failed!");
        }
    }
}
