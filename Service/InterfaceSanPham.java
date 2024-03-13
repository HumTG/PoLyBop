/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import Model.SanPham; 
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceSanPham {
    List<SanPham> getAll(); 
    List<SanPham> seachSP(String key); 
    // lấy ra id chi tiết sản phẩm 
    int getIDCTSP(String maSP);
    // trừ số lượng sản phảm trong sản phẩm chi tiết 
    void reduceSLSP(int idCTSP , int soLuong); 
    // Cộng số lượng sản phẩm trong sản phẩm chi tiết 
    void addSLSP(int idCTSP , int soLuong);
    // sửa số lượng của sản phẩm 
    void updateSLSP(int IDCTSP , int soLuong); 
    // Lấy ra tổng số lượng của sản phẩm 
    int sumSLSP(int IDCTSP, String maHDCT);
    
}
