/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChatLieu;
import Model.MauSac;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Repository.JDBCHeper;

/**
 *
 * @author Windows
 */
public class ChatLieuDao implements InterfaceChatLieu {

    String selectAll = "select *from ChatLieu";
    String update = "update ChatLieu set TenChatLieu =? , TrangThai = ? where Ma_ChatLieu =?";
    String selectById = "select * from ChatLieu where IDChatLieu = ?";
    String selectById1 = "select * from ChatLieu where Ma_ChatLieu=?";
    String insert = "insert into ChatLieu(Ma_ChatLieu, TenChatLieu, TrangThai) values (?,?,?)";

    @Override
    public void insert(ChatLieu sp) {
        JDBCHeper.update(insert, sp.getMa_ChatLieu(), sp.getTenChatLieu(), sp.isTrangThai());
    }

    @Override
    public void update(ChatLieu sp) {
        JDBCHeper.update(update, sp.getTenChatLieu(), sp.isTrangThai(), sp.getMa_ChatLieu());
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChatLieu selectID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChatLieu> selectAll() {
        return selectBySQL(selectAll);
    }

    @Override
    public List<ChatLieu> selectBySQL(String sql, Object... args) {
        List<ChatLieu> lisst = new ArrayList<>();
        try {
            ResultSet rs = JDBCHeper.query(sql, args);
            while (rs.next()) {
                ChatLieu ms = new ChatLieu();
                ms.setIdChatLieu(rs.getInt("IDChatLieu"));
                ms.setMa_ChatLieu(rs.getString("Ma_ChatLieu"));
                ms.setTenChatLieu(rs.getString("TenChatLieu"));
                ms.setTrangThai(rs.getBoolean("TrangThai"));
                lisst.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return lisst;
    }

    public ChatLieu selectID1(String id) {
        List<ChatLieu> list = selectBySQL(selectById1, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public int selectMaLOAISP() {
        try {
            String sql = "select max(cast(substring(Ma_ChatLieu,4,LEN(IDChatLieu))as int)) from  ChatLieu ";
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
        return selectBySQL(selectById, id).get(0).getTenChatLieu();
    }

    public int selectIdByName(String name) {
        String sql = "select * from ChatLieu where TenChatLieu =?";
        return selectBySQL(sql, name).get(0).getIdChatLieu();
    }
}
