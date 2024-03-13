/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import Model.SanPham;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Xuan Dat
 */
public class ViRepository {
    DBconnect dBconnect;
    public ArrayList<SanPham> getAll(){
        String sql = " SELECT Ma_Vi,\n"
                + "		TenVi,\n"
                + "		KieuDang,\n"
                + "		ThuongHieu.TenThuongHieu,\n"
                + "		MauSac.TenMauSac,\n"
                + " FROM Vi \n"
                + " JOIN (ChiTietVi JOIN MauSac ON ChiTietVi.ID_MauSac = MauSac.IDMauSac) ON Vi.IDVi = ChiTietVi.ID_Vi \n"
                + " JOIN ThuongHieu ON Vi.ID_ThuongHieu = ThuongHieu.IDThuongHieu ";
        ArrayList<SanPham> list = new ArrayList<>();
        try (Connection con = dBconnect.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)){
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {  
                SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(sp);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
