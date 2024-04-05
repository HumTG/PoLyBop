/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKDoanhThu_Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class TKDoanhThu_repos implements ITKDoanhThu_repos{
      @Override
    public List<TKDoanhThu_Model> getTKDoanhThu(int nam) {
        List<TKDoanhThu_Model> list = new ArrayList<>();
        String sql = "SELECT  ? AS Tháng, SUM(HoaDonChiTiet.SoLuong), Sum(HoaDon.ThanhTien),Sum(HoaDon.ThanhTien) - Sum(HoaDonChiTiet.DonGia) AS GiamGia,\n" +
"               HoaDon.ThanhTien  AS GiaSauGiam\n" +
"               FROM HoaDon \n" +
"               join HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon\n" +
"               WHERE  Month(HoaDon.NgayThanhToan) = ? AND YEAR(HoaDon.NgayThanhToan) = ? and HoaDon.TrangThai = 1\n" +
"               GROUP BY HoaDon.ThanhTien,HoaDonChiTiet.SoLuong";
        for (int i = 1; i <= 12; i++) {
            try {
                ResultSet rs = JDBCHeper.Query(sql, i, i,nam);
//                int thang = 1;
                float SL = 0, doanhThu = 0, giamGia = 0, giaSauGiam = 0;
                while (rs.next()) {
                    i = rs.getInt(1);
                    SL += rs.getInt(2);
                    doanhThu += rs.getFloat(3);
                    giamGia += rs.getFloat(4);
                    giaSauGiam += rs.getFloat(5);
                }
                list.add(new TKDoanhThu_Model(i, (int) SL, doanhThu, giamGia, giaSauGiam));
            } catch (SQLException ex) {
                Logger.getLogger(TKDoanhThu_repos.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        return list;
    }
}


