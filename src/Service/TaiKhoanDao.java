/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DBconnect;
import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TaiKhoanDao implements InterfaceTaiKhoan {

    @Override
    public List<TaiKhoan> getTaiKhoanNV() {
        List<TaiKhoan> listTKNV = new ArrayList<>();
        String sql = "SELECT [Email]\n"
                + "      ,[MatKhau]\n"
                + "	  ,[ChucVu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien]";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listTKNV.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listTKNV;
    }

    @Override
    public List<TaiKhoan> getChucVu(String email) {
        List<TaiKhoan> listChucVu = new ArrayList<>();
        String sql = "SELECT [Email]\n"
                + "      ,[MatKhau]\n"
                + "	  ,[ChucVu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[NhanVien] where Email = ?";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                listChucVu.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }

    @Override
    public String updateTaiKhoan(String email, String mk) {
        String sql = "UPDATE NhanVien \n"
                + "SET MatKhau = ? \n"
                + "WHERE Email = ? ";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ps.setString(1, mk);
            ps.setString(2, email);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Đổi mật khẩu thành công ";
    }

    @Override
    public String getNameNV(String email) {
        String sql = "SELECT [HoTen]\n"
                + "  FROM [PoLyBop].[dbo].[NhanVien] \n"
                + "  WHERE Email = '"+email+"'";
        String nameNV = ""; 
        try(Connection con = DBconnect.getConnection() ; PreparedStatement ps= con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) {                
                nameNV = rs.getString(1); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nameNV; 
    }

}
