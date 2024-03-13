/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.HoaDon;
import Model.HoaDonCT;
import Model.HoaDonCT1;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceHoaDon {

    List<HoaDonCT> getAll();

    List<HoaDonCT> getAllByPage(int page, int recordsPerPage);

    int getTotalHoaDon();
    
    int getTotalFilteredHoaDon(String startDate, String endDate, String keySearch, Integer payMethod);

    List<HoaDonCT> filterHoaDon(String startDate, String endDate, String keySearch, Integer payMethod, int page, int recordsPerPage);

    List<HoaDonCT> getAllHDChuaHT();

    List<HoaDonCT1> getAllCTHD(String ma);

    List<HoaDon> SelectAll();

    // Tìm kiếm hóa đơn 
    public ArrayList<HoaDon> getListHoaDon();

    List<HoaDonCT> timKiem(String seach);

    abstract public void insert(HoaDon Entity);

    abstract public List<HoaDon> selectBySql(String sql, Object... args);

    // lấy ra ID nhân viên  thông qua email 
    int getIDNhanVien(String emailNV);

    // get ID khách hàng qua sdt 
    int getIDKhachHang(String sdt);

    // get id hóa đơn thông qua mã hóa đơn 
    int getIDHD(String maHD);

    // Lấy ID hóa đơn chi tiết thông qua mã hóa đơn chi tiết 
    int getID_CTSP(String maHDCT);

    // Tạo hóa đơn chờ 
    void addHoaDon(int IDKH, int IDNhanVien, int IDKhuyenMai, String maHD, double tongTien, int PTTT);

    // Hủy hóa đơn 
    void removeHoaDon(int IDHoaDon);

    // Tạo ra hóa đơn chi tiết
    void addSPHDCT(int IDHD, int IDCTSP, String maHDCT, int soLuong, double donGia);

    // sửa số lượng sản phẩm hóa đơn chi tiết ( tăng )
    void updateSLSPHDCT(String maHD, int soLuong);

    // set số lượng trong hóa đơn chờ 
    void setSLHDCT(String maHDCT, int soLuong);

    // Xóa sản phẩm trong hóa đơn chờ 
    void deleteSPHDCT(String maHDCT);

    // Thanh toán hóa đơn 
    void thanhToanHD(String maHD, int IDKH, double tongTien, int PTTT);
    
    // Lấy ra số lượng trong hóa dơn chi tiết 
    int getSLSP(int IDCTSP , int IDHD);
    // lấy ra giá bán 
    double getGiaBan(int IDCTSP); 
    
    // update lại giá tiền trong bảng hóa đơn chi tiết 
    void updateGiaSPHDCT(double giaUpdate , int IDCTSP , int IDHD); 
    void updateGiaSPHDCT_btnSua(double giaUpdate ,String maHDCT);
}
