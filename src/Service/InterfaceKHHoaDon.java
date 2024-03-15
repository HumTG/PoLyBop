/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import Model.HoaDonCT1;
import Model.KhachHangHoaDon; 

import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceKHHoaDon {
    List<KhachHangHoaDon> getAll(int idKH); 
    List<HoaDonCT1> getAllHDCT(String maHD); 
}
