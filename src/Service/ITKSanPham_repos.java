/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.TKSanPham_Model;
import java.util.List;

/**
 *
 * @author vicon
 */
public interface ITKSanPham_repos {
    List<TKSanPham_Model> getTKSanPham();
    List<TKSanPham_Model> getTKSanPhamTheoNgay(String batDau, String ketThuc);
}
