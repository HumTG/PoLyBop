/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import Model.TaiKhoan; 

/**
 *
 * @author Admin
 */
public interface InterfaceTaiKhoan {
    List<TaiKhoan> getTaiKhoanNV(); 
    List<TaiKhoan> getChucVu(String email); 
    String updateTaiKhoan(String email,String mk); 
    String getNameNV(String email) ; 
}
