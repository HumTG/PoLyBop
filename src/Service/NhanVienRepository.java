/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;
import Model.NhanVien1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Repository.JDBCHeper;

/**
 *
 * @author ADMIN
 */
public class NhanVienRepository implements NhanVienRepositoryImpl{
String selectById = "select * from NhanVien where IDNhanVien = ?";
    String INSERT_SQL = "INSERT dbo.NhanVien VALUES(?,?,?,?,?,?,?,?,?)";
    String UPDATE_SQL = "UPDATE NhanVien set HOTEN = ?,SDT = ?,Ngaysinh = ?, Email = ?, Diachi = ?, MATKHAU = ?, CHUCVU = ?, GIOITINH = ?, TRANGTHAI=? where IDNHANVIEN = ?";
    String DELETE_SQL = "UPDATE NHANVIEN set TRANGTHAI = 0 WHERE IDNHANVIEN = ?";
    
    @Override
    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> list = new ArrayList<>();
//        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN\n"; 
        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN WHERE TRANGTHAI = 1";
      
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
     @Override
    public List<NhanVien> getAllNhanVienKhongHoatDong() {
       List<NhanVien> list = new ArrayList<>();
//        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN\n"; 
        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN WHERE TRANGTHAI = 0";
      
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public NhanVien getById(String id) {
        NhanVien nv = null;
        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN\n" +
        "WHERE IDNHANVIEN = ?";
        
        ResultSet rs = JDBCHeper.Query(sql,id);
        try {
            while(rs.next()){
                nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
            }
            return nv;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    @Override
    public NhanVien getByIdKhongHoatDong(String id) {
        NhanVien nv = null;
        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN\n" +
        "WHERE IDNHANVIEN = ? AND TRANGTHAI = 0";
        
        ResultSet rs = JDBCHeper.Query(sql,id);
        try {
            while(rs.next()){
                nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
            }
            return nv;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<NhanVien> findNhanVien(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(NhanVien Entity) {
        JDBCHeper.update(INSERT_SQL, Entity.getHoTen(),Entity.isChucVu(),Entity.getNgaySinh(), Entity.getSdt(),
                Entity.getEmail(),  Entity.isGioiTinh(),Entity.getDiaChi(),Entity.getMatKhau(), Entity.isTrangThai());
    }

    @Override
    public void delete(String id) {
        JDBCHeper.update(DELETE_SQL, id);
    }

    @Override
    public void updateKH(NhanVien Entity) {
        JDBCHeper.update(UPDATE_SQL, Entity.getHoTen(), Entity.getSdt(), Entity.getNgaySinh(),
                Entity.getEmail(),  Entity.getDiaChi(), Entity.getMatKhau(), Entity.isGioiTinh(), Entity.isChucVu(), Entity.isTrangThai(), Entity.getIdNhanVien());
    }

    @Override
    public List<NhanVien> searchNVHD(String key) {
         List<NhanVien> lst = new ArrayList<>();
         String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN WHERE TRANGTHAI = 1 AND (HOTEN like concat('%',?,'%') OR SDT like concat('%',?,'%') OR EMAIL like concat('%',?,'%'))";
         ResultSet rs = JDBCHeper.Query(sql, key, key, key);
         try {
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
                lst.add(nv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhanVien> searchNVKHD(String key) {
        List<NhanVien> lst = new ArrayList<>();
         String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI FROM NHANVIEN WHERE TRANGTHAI = 0 AND (HOTEN like concat('%',?,'%') OR SDT like concat('%',?,'%') OR EMAIL like concat('%',?,'%'))";
         ResultSet rs = JDBCHeper.Query(sql, key, key, key);
         try {
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
                lst.add(nv);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<NhanVien> getNhanVienByPage(int page, int recordsPerPage) {
        List<NhanVien> list = new ArrayList<>();
        String sql = "SELECT IDNHANVIEN, HOTEN, SDT, NGAYSINH, EMAIL, DIACHI, MATKHAU, GIOITINH, CHUCVU, TRANGTHAI " +
                 "FROM NHANVIEN WHERE TRANGTHAI = 1 " +
                 "ORDER BY IDNHANVIEN " +
                 "OFFSET ? ROWS " +
                 "FETCH NEXT ? ROWS ONLY";

        int startRecord = (page - 1) * recordsPerPage;

        try {
            ResultSet rs = JDBCHeper.Query(sql, startRecord, recordsPerPage);
            while(rs.next()){
                NhanVien nv = new NhanVien(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),rs.getString(5),rs.getString(6), rs.getString(7), rs.getBoolean(8),  rs.getBoolean(9),  rs.getBoolean(10));
                list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
}

    @Override
    public int getTotalNhanVien() {
        String sql = "SELECT COUNT(*) FROM NHANVIEN WHERE TRANGTHAI = 1";
      
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

      public List<NhanVien1> selectBySQL(String sql, Object... args) {
        List<NhanVien1> list_th = new ArrayList<>();
        
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {                
                NhanVien1 th = new NhanVien1();
                th.setIDNhanVien(rs.getInt("IDNhanVien"));
                th.setMa_NhanVien(rs.getString("Ma_NhanVien"));
                th.setHoTen(rs.getString("HoTen"));

                list_th.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list_th;
    }
      public String selectNameByID(int id) {
        return selectBySQL(selectById, id).get(0).getHoTen();
    }

    
  
}
