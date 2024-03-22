/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import Model.SanPhamCT;
import Model.Vi;
import java.util.List;
import Repository.ViRepository;

/**
 *
 * @author Xuan Dat
 */
public class SanPhamService {
    ViRepository viRepository;
    SanPhamDAO sanPhamDAO = new SanPhamDAO();
    public List<SanPham> getAll(){
        return viRepository.getAll();
    }
    public String delete(Vi id) {
        if (sanPhamDAO.delCTV(id)==true) {
            return "dax xoa";
        } else {
            return "That bajt";
        }
    }
}
