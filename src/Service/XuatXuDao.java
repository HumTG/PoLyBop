/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.XuatXu;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class XuatXuDao implements InterfaceXuatXu {

    String selectAll = "select *from XuatXu";
    String update = "update XuatXu set TenXuatXu =? , TrangThai = ? where Ma_XuatXu =?";
    String selectById = "select * from XuatXu where IDXuatXu =?";
    String selectById1 = "select * from XuatXu where Ma_XuatXu=?";
    String insert = "insert into XuatXu (Ma_XuatXu , TenXuatXu, TrangThai) values (?,?,?)";

    @Override
    public void insert(XuatXu sp) {
        JDBCHeper.update(insert, sp.getMa_XuatXu(), sp.getTenXuatXu(), sp.isTrangThai());
    }

    @Override
    public void update(XuatXu sp) {
        JDBCHeper.update(update, sp.getTenXuatXu(), sp.isTrangThai(), sp.getMa_XuatXu());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<XuatXu> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public XuatXu selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<XuatXu> selectBySQL(String sql, Object... args) {
        List<XuatXu> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                XuatXu xx = new XuatXu();
                xx.setIdXuatXu(rs.getInt("idXuatXu"));
                xx.setMa_XuatXu(rs.getString("Ma_XuatXu"));
                xx.setTenXuatXu(rs.getString("tenXuatXu"));
                xx.setTrangThai(rs.getBoolean("trangThai"));
                list.add(xx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String selectNameByID(int id) {
        return selectBySQL(selectById, id).get(0).getTenXuatXu();
    }
//

    public int selectIdByName(String name) {
        String sql = "select * from XuatXu where TenXuatXu =?";
        return selectBySQL(sql, name).get(0).getIdXuatXu();
    }

    public XuatXu selectID1(String id) {
        List<XuatXu> list = selectBySQL(selectById1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int selectMaLOAISP() {
        try {
            String sql = "select max(cast(substring(Ma_XuatXu,4,LEN(IDXuatXu))as int)) from  XuatXu ";
            ResultSet rs = JDBCHeper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String selectNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTenXuatXu();
    }
}
