/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.TKSanPham_View;
import java.util.List;

/**
 *
 * @author vicon
 */
public interface ITKSanPham_Service {
    List<TKSanPham_View> getTKSanPham();
    List<TKSanPham_View> getTKSanPham (String batDau, String ketThuc);
    int DonHang(); 
    int SanPham();
    double DoanhThu();
}
