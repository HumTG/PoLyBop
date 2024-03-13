/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ThuongHieu;
import Repository.DBconnect;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Xuan Dat
 */
public class ThuongHieuDao implements InterfaceThuongHieu {

    @Override
    public List<ThuongHieu> getAllListThuongHieu() {
        String sql = "SELECT  [IDThuongHieu]\n"
                + "      ,[Ma_ThuongHieu]\n"
                + "      ,[TenThuongHieu]\n"
                + "      ,[TrangThai]\n"
                + "  FROM [PoLyBop].[dbo].[ThuongHieu]";
        List<ThuongHieu> lists = new ArrayList<>();
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)); 
                lists.add(th); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists; 
    }

}
