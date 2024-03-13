/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhuyenMai;
import Repository.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Windows
 */
public class KhuyenMaiDAO implements InterfaceKhuyenMai{
     @Override
    public List<KhuyenMai> getKhuyenMai() {
        String sql = "SELECT [IDKhuyenMai]\n"
                + "      ,[Ma_KhuyenMai]\n"
                + "      ,[GiaTri]\n"
                + "      ,[NgayBatDau]\n"
                + "      ,[NgayKetThuc]\n"
                + "      ,[KieuGiamGia]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [dbo].[KhuyenMai]";
        List<KhuyenMai> listKM = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getBoolean(7));
                listKM.add(km);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKM;
    }

    @Override
    public int getGiaTriKM(String maKM) {
        String sql = "Select GiaTri from KhuyenMai where Ma_KhuyenMai like N'"+maKM+"'";
        int giaTri = 0;
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                giaTri = rs.getInt(1); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return giaTri; 
    }
}
