/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKDoanhThu_Model;
import Model.TKDoanhThu_View;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows
 */
public class TKDoanhThu_Service implements ITKDoanhThu_service{
        ITKDoanhThu_repos TK_repos = new TKDoanhThu_repos();
    List<TKDoanhThu_Model> list;

    @Override
    public List<TKDoanhThu_View> getTKDoanhThu(Integer nam) {
        List<TKDoanhThu_View> list_view = new ArrayList<>();
        list = TK_repos.getTKDoanhThu(nam);
        for (TKDoanhThu_Model tK : list) {
            list_view.add(new TKDoanhThu_View(tK.getThang(), tK.getSlSanPham(), tK.getTongGiaBan(), tK.getTongGiaGia(), tK.getTongDoanhThu()));
        }
        return list_view;
        
    }
}
