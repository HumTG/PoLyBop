/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class MauSacDao implements InterfaceMauSac {

    String selectAll = "select * from MauSac";
    String selectID = "select * from MauSac where Ma_MauSac= ?";
    String selectById = "select * from MauSac where IDMauSac =?";
    String update = "update MauSac set  TenMauSac =?, TrangThai=? where Ma_MauSac=?";
    String insert = "INSERT INTO MauSac (Ma_MauSac, TenMauSac, TrangThai) VALUES (?, ?, ?)";
    @Override
    public void insert(MauSac sp) {
        JDBCHeper.update(insert, sp.getMa_MauSac(),sp.getTenMauSac(),sp.isTrangThai());
    }

    @Override
    public void update(MauSac sp) {
        JDBCHeper.update(update, sp.getTenMauSac(),sp.isTrangThai(),sp.getMa_MauSac());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MauSac selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MauSac> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<MauSac> selectBySQL(String sql, Object... args) {
        List<MauSac> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setIdMauSac(rs.getInt("idMauSac"));
                ms.setMa_MauSac(rs.getString("Ma_MauSac"));
                ms.setTenMauSac(rs.getString("tenMauSac"));
                ms.setTrangThai(rs.getBoolean("trangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public String selecNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTenMauSac();
    }
        public int selectIdByName(String name){
        String sql = "select * from MauSac where TenMauSac =?";
        return selectBySQL(sql, name).get(0).getIdMauSac();
    }
    public MauSac selectID1(String id) {
        List<MauSac> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_MauSac,4,LEN(IDMauSac))as int)) from MauSac ";
            ResultSet rs = JDBCHeper.query(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
