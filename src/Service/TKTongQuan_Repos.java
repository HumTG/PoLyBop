/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKTongQuan_Model;
import java.sql.*;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class TKTongQuan_Repos implements ITKTongQuan_Repos {

    @Override
    public TKTongQuan_Model tkHomNay() {
        TKTongQuan_Model tk = null;
        String sql = "	SELECT (\n"
                + "	SELECT count(HoaDon.Ma_HoaDon) \n"
                + "	FROM HoaDon\n"
                + "	WHERE CONVERT(DATE, HoaDon.NgayThanhToan)  = getdate() AND HoaDon.TrangThai =1) AS 'Đơn hàng', \n"
                + "    sum(HoaDonChiTiet.SoLuong) as 'Sản phẩm' ,\n"
                + "	SUM(HoaDon.ThanhTien) as 'Doanh thu' \n"
                + "	FROM HoaDon\n"
                + "    left JOIN HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.ID_HoaDon\n"
                + "    WHERE CONVERT(DATE, HoaDon.NgayThanhToan) = CONVERT(DATE, GETDATE()) AND HoaDon.TrangThai =1";
        ResultSet rs = JDBCHeper.Query(sql);
        try {
            while (rs.next()) {
                tk = new TKTongQuan_Model(rs.getInt(1), rs.getInt(2), rs.getFloat(3));
            }
            return tk;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public TKTongQuan_Model tkTheoNgay(String batDau, String ketThuc) {
        TKTongQuan_Model tk = null;
        String sql = "	SELECT (\n"
                + "	SELECT count(HoaDon.Ma_HoaDon) FROM HoaDon \n"
                + "	WHERE CONVERT(DATE, HoaDon.NgayThanhToan) BETWEEN ? and ?   AND HoaDon.TrangThai != 2)  AS DONHANG, \n"
                + "                 sum(HoaDonChiTiet.SoLuong), \n"
                + "				 SUM(HoaDon.ThanhTien) FROM HoaDon\n"
                + "                left JOIN HoaDonChiTiet on HoaDon.IDHoaDon = HoaDonChiTiet.IDHoaDonChiTiet\n"
                + "                WHERE CONVERT(DATE, HoaDon.NgayThanhToan) BETWEEN ? and ?  \n"
                + "                AND HoaDon.TrangThai != 2";
        ResultSet rs = JDBCHeper.Query(sql, batDau, ketThuc, batDau, ketThuc);
        try {
            while (rs.next()) {
                tk = new TKTongQuan_Model(rs.getInt(1), rs.getInt(2), rs.getFloat(3));
            }
            return tk;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void main(String[] args) {
        ITKTongQuan_Repos repo = new TKTongQuan_Repos();
        System.out.println(repo.tkHomNay().toString());
    }

}
