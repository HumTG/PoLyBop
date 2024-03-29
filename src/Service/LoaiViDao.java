/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.LoaiVi;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Repository.JDBCHeper;

/**
 *
 * @author Xuan Dat
 */
public class LoaiViDao implements InterfaceLoaiVi {

    String selectAll = "select * from LoaiVi";
    String selectID = "select * from LoaiVi where Ma_LoaiVi= ?";
    String selectById = "select * from LoaiVi where IDLoaiVi =?";
    String update = "update LoaiVi set  TenLoaiVi =?, TrangThai=? where Ma_LoaiVi=?";
    String insert = "INSERT INTO LoaiVi (Ma_LoaiVi, TenLoaiVi, TrangThai) VALUES (?, ?, ?)";
    @Override
    public void insert(LoaiVi sp) {
        JDBCHeper.update(insert, sp.getMa_LoaiVi(),sp.getTenLoaiVi(),sp.isTrangThai());
    }

    @Override
    public void update(LoaiVi sp) {
        JDBCHeper.update(update, sp.getTenLoaiVi(),sp.isTrangThai(),sp.getMa_LoaiVi());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public LoaiVi selectID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoaiVi> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<LoaiVi> selectBySQL(String sql, Object... args) {
        List<LoaiVi> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                LoaiVi ms = new LoaiVi();
                ms.setIdLoaiVi(rs.getInt("IDLoaiVi"));
                ms.setMa_LoaiVi(rs.getString("Ma_LoaiVi"));
                ms.setTenLoaiVi(rs.getString("TenLoaiVi"));
                ms.setTrangThai(rs.getBoolean("TrangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public String selecNameById(int id) {
        return selectBySQL(selectById, id).get(0).getTenLoaiVi();
    }
        public int selectIdByName(String name){
        String sql = "select * from LoaiVi where TenLoaiVi =?";
        return selectBySQL(sql, name).get(0).getIdLoaiVi();
    }
    public LoaiVi selectID1(String id) {
        List<LoaiVi> list = selectBySQL(selectID, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    public int select_Max_id_java() {
        try {
            String sql = "select max(cast(substring(Ma_LoaiVi,4,LEN(IDLoaiVi))as int)) from LoaiVi ";
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
