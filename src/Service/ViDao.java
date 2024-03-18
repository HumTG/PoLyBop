/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Vi;
import Repository.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class ViDao implements InterfaceVi {

    String selectAll = "select *  from Vi";
    String select_Trangthai2 = "SELECT * FROM Vi WHERE Trangthai = 0";
    String selectID1 = "select * from Vi where IDVi= ?";
    String selectID = "select * from Vi where Ma_Vi= ?";
    String insert = "INSERT INTO Vi (Ma_Vi,TenVi,KieuDang,ID_ThuongHieu, Url_Anh, TrangThai) VALUES (?,?,?,?,?,?)";
    String update = "Update Vi set TenVi=?, KieuDang =?, ID_ThuongHieu=?, Url_Anh =?, TrangThai=? where Ma_Vi =?";
    String delete = "delete from SanPham where ID_Sanpham = ?";
    String selectById = "select * from Vi where IDVi =?";
String select_Trangthai1 = "SELECT * FROM Vi WHERE Trangthai = 1";
    @Override
    public void insert(Vi sp) {
        JDBCHeper.update(insert, sp.getMa_Vi(), sp.getTenVi(), sp.getKieuDang(), sp.getID_ThuongHieu(), sp.getUrl_Anh(), sp.isTrangThai());
    }

    @Override
    public void update(Vi sp) {
        JDBCHeper.update(update, sp.getTenVi(), sp.getKieuDang(), sp.getID_ThuongHieu(), sp.getUrl_Anh(), sp.isTrangThai(), sp.getMa_Vi());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Vi> selectAll() {
        return selectBySQL(select_Trangthai1);
    }

    @Override
    public Vi selectID(Integer id) {
        List<Vi> list = selectBySQL(selectID1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Vi> selectByKeyword(String keyword) {
        String sql = "SELECT * FROM dbo.Vi WHERE TenVi LIKE ? AND IdVi = ? AND Trangthai = 1 ";
        return selectBySQL(sql, "%" + keyword + "%");
    }

    @Override
    public List<Vi> selectBySQL(String sql, Object... args) {
        List<Vi> list_vi = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                Vi sp = new Vi();
                sp.setIDVi(rs.getInt("IdVi"));
                sp.setID_ThuongHieu(rs.getInt("ID_ThuongHieu"));
                sp.setMa_Vi(rs.getString("Ma_Vi"));
                sp.setTenVi(rs.getString("tenVi"));
                sp.setKieuDang(rs.getString("kieuDang"));
                sp.setTrangThai(rs.getBoolean("trangThai"));
                sp.setUrl_Anh(rs.getString("Url_anh"));
                list_vi.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_vi;
    }

    public List<Vi> selectAlll() {
        return selectBySQL(selectAll);
    }

    public List<Vi> select_TrangThai() {
        return selectBySQL(select_Trangthai2);
    }

    @Override
    public Vi selectID1(String id) {
        List<Vi> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<Vi> Select_ByName(String name) {  // tìm theo tên sản phẩm
        String Select_ByName = "select  *  from Vi where TenVi like ?";
        return selectBySQL(Select_ByName, "%" + name + "%");
    }

    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_Vi,3,LEN(IDVi))as int)) from  Vi ";
            ResultSet rs = JDBCHeper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    

    @Override
    public List<Vi> getViByPage(int page, int recordInPage) {
        List<Vi> list = new ArrayList<>();
        String sql = "SELECT IDVi,ID_ThuongHieu, Ma_Vi, KieuDang, TenVi, TrangThai " +
                 "FROM Vi WHERE TRANGTHAI = 1 " +
                 "ORDER BY IDVi " +
                 "OFFSET ? ROWS " +
                 "FETCH NEXT ? ROWS ONLY";

        int startRecord = (page - 1) * recordInPage;

        try {
            ResultSet rs = JDBCHeper.Query(sql, startRecord, recordInPage);
            while(rs.next()){
                Vi sp = new Vi();
                list.add(sp);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotal() {
         String sql = "SELECT COUNT(*) FROM Vi WHERE TRANGTHAI = 1";
      
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while(rs.next()){
               return rs.getInt(1);
            }
      
        } catch (SQLException ex) {
            ex.printStackTrace();
  
        }
         return 0;
    }

    public String selectNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTenVi();
    }

    public int selectIdByName(String name) {
        String sql = "select * from Vi where TenVi =?";
        return selectBySQL(sql, name).get(0).getIDVi();
    }
        // lấy ra giá bán của ví thông qua mã ví 
    public double getGiaBan(String maSP) {
        double gia = 0;
        String sql = "Select ChiTietVi.GiaBan from ChiTietVi\n"
                + "join Vi on vi.IDVi = ChiTietVi.IDChiTietVi where Ma_Vi like '" + maSP + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
           ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                gia = rs.getDouble(1); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
    }
}
