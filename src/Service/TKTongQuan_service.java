/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKTongQuan_Model;
import Model.TKTongQuan_View;
import Repository.ITKTongQuan_Repos;
import Repository.TKTongQuan_Repos;

/**
 *
 * @author Windows
 */
public class TKTongQuan_service implements ITKTongQuan_Service{
     ITKTongQuan_Repos repo = new TKTongQuan_Repos();

 @Override
    public TKTongQuan_View tkHomNay() {
        TKTongQuan_View tk = new TKTongQuan_View();
        tk.setDoanhthu(repo.tkHomNay().getDoanhThu());
        tk.setDonHang(repo.tkHomNay().getDonHang());
        tk.setSanPham(repo.tkHomNay().getSanPham());
        return tk;
    }

    @Override
    public TKTongQuan_View tkTheoNgay(String batDau, String ketThuc) {
        TKTongQuan_View tk = new TKTongQuan_View();
        tk.setDoanhthu(repo.tkTheoNgay(batDau, ketThuc).getDoanhThu());
        tk.setDonHang(repo.tkTheoNgay(batDau, ketThuc).getDonHang());
        tk.setSanPham(repo.tkTheoNgay(batDau, ketThuc).getSanPham());
        return tk;
    }

}
