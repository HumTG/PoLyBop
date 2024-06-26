/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;
import Model.SanPham; 
import Model.SanPhamCT;
import java.util.Date;
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
    // lấy ra thông tin sản phẩm chi tiết qua quã sản phẩm 
    List<SanPhamCT> getDaTaSPCT(String maSP);
    // 
    int getSoLuongSPCT(String maVi);
    
    // Thêm chi tiết sản phẩm 
    void addCTSP(int idSP , int idMauSac , int idChatLieu , int idXuatXu , int idLoaiVi , String maCTSP , String khoaVi , String soNganDungThe , int soLuong , double giaNhap , double giaBan , String ngayNhap); 
    // update chi tiết sản phẩm 
    void updateCTSP(int idSP , int idMauSac , int idChatLieu , int idXuatXu , int idLoaiVi , String maCTSP , String khoaVi , String soNganDungThe , int soLuong , double giaNhap , double giaBan , String ngayNhap); 

}
