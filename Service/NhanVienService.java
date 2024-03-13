package Service;

import Model.NhanVien;
import Repository.DBconnect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class NhanVienService {
    
    List<NhanVien> listNV;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;
      public List<NhanVien> getAll() {
        listNV = new ArrayList<>();
        sql = "select Ma_NhanVien, HoTen,ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, MatKhau,TrangThai from NhanVien";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDate(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10));
                listNV.add(nv);
            }
            return listNV;
        } catch (Exception e) {
            e.printStackTrace();
            return listNV;
        }
    }
      public int insertNV(NhanVien nv) {
        sql = "insert into NhanVien(Ma_NhanVien, HoTen, ChucVu, NgaySinh, SDT, Email, GioiTinh, DiaChi, MatKhau, TrangThai) values (?,?,?,?,?,?,?,?,?,?)";

        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNhanVien());
            ps.setString(2, nv.getHoTen());
            ps.setString(3, nv.getChucVu());
            ps.setDate(4, (Date) nv.getNgaySinh());
            ps.setString(5,  nv.getSdt());
            ps.setString(6,  nv.getEmail());
            ps.setInt(7,  nv.getGioiTinh());
            ps.setString(8,  nv.getDiaChi());
            ps.setString(9,  nv.getMatKhau());
            ps.setInt(10,  nv.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int deletteNV(String ma) {
        sql = "delete from NhanVien where Ma_NhanVien like ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateNV(String ma, NhanVien nv) {
        sql = "update NhanVien set HoTen=?, ChucVu=?, NgaySinh=?, SDT=?, Email=?, GioiTinh=?, DiaChi=?, MatKhau=?, TrangThai=?\\n\"\n" +
"                +\"where Ma_NhanVien like ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nv.getHoTen());
            ps.setString(2, nv.getChucVu());
            ps.setDate(3, (Date) nv.getNgaySinh());
            ps.setString(4,  nv.getSdt());
            ps.setString(5,  nv.getEmail());
            ps.setInt(6,  nv.getGioiTinh());
            ps.setString(7,  nv.getDiaChi());
            ps.setString(8,  nv.getMatKhau());
            ps.setInt(9,  nv.getTrangThai());
            ps.setString(10, ma);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
