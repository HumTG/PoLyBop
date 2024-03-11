/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import Model.KhachHang1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Repository.JDBCHeper;

/**
 *
 * @author ADMIN
 */
public class KhachHangRepository implements KhachHangRepositoryImpl {
    String selectById = "select * from KhachHang where IDKhangHang = ?";
    String INSERT_SQL = "INSERT KHACHHANG VALUES(?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE KhachHang set TenKhachHang = ?,SDT = ?,Ngaysinh = ?, Email = ?, Diachi = ?, TRANGTHAI=? where IDKHANGHANG = ?";
    String DELETE_SQL = "UPDATE KhachHang set TRANGTHAI = 0 WHERE IDKhangHang = ?";
    String SELECT_ALL_SQL = "select * from NhanVien ";
    String SELECT_BY_ID_SQL = "select * from NhanVien where ID_Nhanvien = ?";
    String SELECT_BY_ACCOUNT_SQL = "select * from NhanVien where Username = ?";
    String SELECT_TrangThai1 = "select * from NhanVien where Trangthai = 0";
    String SELECT_TrangThai2 = "select * from NhanVien where Trangthai = 1";
    String update_pass = "update NhanVien set Pass=? where Email=?";
    
    @Override
    public List<KhachHang> getAllKhachHang() {
       List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT IDKhangHang, TENKHACHHANG, SDT, NGAYSINH, EMAIL, DIACHI, TRANGTHAI FROM KHACHHANG\n";        
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getBoolean(7));
                list.add(kh);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public KhachHang getById(String Id) {
        KhachHang kh = null;
        String sql = "SELECT IDKhangHang, TENKHACHHANG, SDT, NGAYSINH, EMAIL, DIACHI, TRANGTHAI FROM KHACHHANG\n" +
        "WHERE IDKhangHang = ?";
        
        ResultSet rs = JDBCHeper.Query(sql,Id);
        try {
            while(rs.next()){
                kh =  new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getBoolean(7));
            }
            return kh;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<KhachHang> FindKhachHang(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(KhachHang Entity){
         JDBCHeper.update(INSERT_SQL, Entity.getTenKhachHang(), Entity.getSdt(), Entity.getNgaySinh(),
                Entity.getEmail(),  Entity.getDiaChi(), Entity.isTrangThai());
    }

    @Override
    public void delKH(String id) {
       JDBCHeper.update(DELETE_SQL, id);
    }

    @Override
    public void updateKH(KhachHang Entity) {
       JDBCHeper.update(UPDATE_SQL, Entity.getTenKhachHang(), Entity.getSdt(), Entity.getNgaySinh(), Entity.getEmail(), Entity.getDiaChi(),
                Entity.isTrangThai(), Entity.getIdKhachHang());
    }

    @Override
    public List<KhachHang> searchKH(String key) {
        List<KhachHang> lst = new ArrayList<>();
         String sql = "SELECT IDKhangHang, TENKHACHHANG, SDT, NGAYSINH, EMAIL, DIACHI, TRANGTHAI FROM KHACHHANG WHERE TRANGTHAI = 1 AND (TENKHACHHANG like concat('%',?,'%') OR SDT like concat('%',?,'%') OR EMAIL like concat('%',?,'%'))";
         ResultSet rs = JDBCHeper.Query(sql, key, key, key);
         try {
            while(rs.next()){
                KhachHang nv = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getBoolean(7));
                lst.add(nv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<KhachHang> getKHByPage(int page, int recordsPerPage) {
        List<KhachHang> list = new ArrayList<>();
        String sql = "SELECT IDKhangHang, TENKHACHHANG, SDT, NGAYSINH, EMAIL, DIACHI, TRANGTHAI " +
                 "FROM KHACHHANG WHERE TRANGTHAI = 1 " +
                 "ORDER BY IDKhangHang " +
                 "OFFSET ? ROWS " +
                 "FETCH NEXT ? ROWS ONLY";

        int startRecord = (page - 1) * recordsPerPage;

        try {
            ResultSet rs = JDBCHeper.Query(sql, startRecord, recordsPerPage);
            while(rs.next()){
                KhachHang nv = new KhachHang(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getBoolean(7));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int getTotalKH() {
        String sql = "SELECT COUNT(*) FROM KHACHHANG WHERE TRANGTHAI = 1";
      
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
    
    public List<KhachHang1> selectBySQL(String sql, Object... args) {
        List<KhachHang1> list_th = new ArrayList<>();
        
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {                
                KhachHang1 th = new KhachHang1();
                th.setIdKhangHang(rs.getInt("IdKhangHang"));
                th.setMa_KhachHang(rs.getString("Ma_KhachHang"));
                th.setTenKhachHang(rs.getString("TenKhachHang"));

                list_th.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_th;
    }
      public String selectNameByID(int id) {
        return selectBySQL(selectById, id).get(0).getTenKhachHang();
    }
    
}
