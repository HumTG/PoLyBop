/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repository.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThuocTinhSanPhamDAO implements InterfaceThuocTinh{

    @Override
    public int getIDSPbyName(String name) {
        int ID = 0;
        String sql = "Select IDVi from Vi where TenVi like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDMauSacbyName(String name) {
        int ID = 0;
        String sql = "Select IDMauSac from MauSac where TenMauSac like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDChatLieubyName(String name) {
        int ID = 0;
        String sql = "Select IDChatLieu from ChatLieu where TenChatLieu like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDXuatXubyName(String name) {
        int ID = 0;
        String sql = "Select IDXuatXu from XuatXu where TenXuatXu like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    @Override
    public int getIDLoaiVibyName(String name) {
        int ID = 0;
        String sql = "Select IDLoaiVi from LoaiVi where TenLoaiVi like N'" + name + "'";
        try (Connection con = DBconnect.getConnection(); PreparedStatement ps = con.prepareCall(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ID = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ID;
    }

    public static void main(String[] args) {
        ThuocTinhSanPhamDAO th = new ThuocTinhSanPhamDAO();
        System.out.println(th.getIDMauSacbyName("do"));
    }

}
