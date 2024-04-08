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
        cbHinhThuc.setSelectedItem(tblKhuyenMai.getValueAt(index, 2).toString());
        txtGiaTri.setText(tblKhuyenMai.getValueAt(index, 3).toString());
        txtBatDau.setDate((Date) tblKhuyenMai.getValueAt(index, 4));
        txtKetThuc.setDate((Date) tblKhuyenMai.getValueAt(index, 5));
        if ((tblKhuyenMai.getValueAt(index, 6).toString()).equalsIgnoreCase("Còn hoạt động")) {
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
        String kieuGiamGia;

        ma = txtMa.getText().trim();
        kieuGiamGia = cbHinhThuc.getSelectedItem().toString();
        ngayBD = new java.sql.Date(txtBatDau.getDate().getTime());
        ngayKT = new java.sql.Date(txtKetThuc.getDate().getTime());
        giaTri = Integer.parseInt(txtGiaTri.getText().trim());
        if (rdCon.isSelected()) {
            trangThai = true;
        } else {
            trangThai = true;
        }
        return new KhuyenMai(ma, kieuGiamGia, giaTri, ngayBD, ngayKT, trangThai);
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
        if (txtBatDau.getDate() == null || txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu hoặc ngày kết thúc");
            return false;
        }

        if (txtKetThuc.getDate().before(txtBatDau.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
        }
        if (cbHinhThuc.getSelectedItem().toString().isEmpty()) {
        // Nếu không có hình thức nào được chọn, hiển thị thông báo lỗi
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hình thức giảm giá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false; // Trả về null để biểu thị rằng dữ liệu không hợp lệ
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

        } catch (NumberFormatException ex) {
            JOptionPane.showConfirmDialog(this, "Giá phải là số");
            return false;
        }
        if (!rdCon.isSelected() && !rdHet.isSelected()) {
        // Nếu không có ô nào được chọn, hiển thị thông báo lỗi
        JOptionPane.showMessageDialog(null, "Vui lòng chọn trạng thái khuyến mãi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false; // Trả về null để biểu thị rằng dữ liệu không hợp lệ
    }

        return true;

    }
    
    boolean check1(){
        if (txtMa.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã khuyến mại");
            return false;
        }
                if (txtBatDau.getDate() == null || txtKetThuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày bắt đầu hoặc ngày kết thúc");
            return false;
        }

        if (txtKetThuc.getDate().before(txtBatDau.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải sau ngày bắt đầu");
        }
        if (cbHinhThuc.getSelectedItem().toString().isEmpty()) {
        // Nếu không có hình thức nào được chọn, hiển thị thông báo lỗi
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hình thức giảm giá.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return false; // Trả về null để biểu thị rằng dữ liệu không hợp lệ
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

        } catch (NumberFormatException ex) {
            JOptionPane.showConfirmDialog(this, "Giá phải là số");
            return false;
        }
        if (!rdCon.isSelected() || !rdHet.isSelected()) {
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
    public static boolean validateDates(String startDateStr, String endDateStr) {
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
    }

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
        jLabel9 = new javax.swing.JLabel();
        cbHinhThuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rdCon = new javax.swing.JRadioButton();
        rdKhongHoatDong = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();

        rdHet.setText("Hết hạn");
        rdHet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHetActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách hóa đơn"));
        jPanel1.setToolTipText("");

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID ", "Mã", "Hình thức giảm giá", "Mức giảm giá", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhuyenMai);

        jButton1.setText("|<");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(">|");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText(">>");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("<<");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Lọc khuyến mại");

        cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "0" }));
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

        btnTimKiem1.setText("Tìm khuyến mại");
        btnTimKiem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem1ActionPerformed(evt);
            }
        });

        txtTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(416, 416, 416))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKiem1)
                .addGap(18, 18, 18)
                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1047, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addContainerGap())
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Tạo khuyến mại");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa khuyến mại");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("Xóa khuyến mại");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

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
        txtBatDau.setDateFormatString("YYYY-MM-dd");

        jLabel6.setText("Ngày kết thúc");

        txtKetThuc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtKetThuc.setDateFormatString("YYYY-MM-dd");

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

        jPanel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel9.setText("Hình thức giảm giá");

        cbHinhThuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm giá theo %", "Giảm giá theo VNĐ", " " }));

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
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdCon)
                                .addGap(27, 27, 27)
                                .addComponent(rdKhongHoatDong))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 198, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(227, 227, 227))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbHinhThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdCon)
                    .addComponent(rdKhongHoatDong))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Làm mới");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
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
        if(index <0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa");
        }else{// đã chọn
            // lấy mã sv từ table dòng index cột 1
            int chon;
            chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa không");
            if (chon != JOptionPane.YES_OPTION) {
                return;
        } else {
            if(check1()){
            ma = tblKhuyenMai.getValueAt(index, 1).toString();
            if(kms.updateKM(ma, this.readForm())>0){
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                this.fillTable(kms.getAll());
            }  
            }else{ // không xóa được
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
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
        chon = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm không");
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
        int selectedTt =  cbox.getSelectedIndex(); 
         
        List<KhuyenMai> listKhuyenMai = kms.locTT(selectedTt);
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
        if(index <0){
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
        }else{// đã chọn
            // lấy mã sv từ table dòng index cột 1
            ma = tblKhuyenMai.getValueAt(index, 1).toString();
            if(kms.deleteKM(ma)>0){
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                this.fillTable(kms.getAll());
                
            }else{ // không xóa được
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem1;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbHinhThuc;
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
    private javax.swing.JLabel jLabel9;
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
}
