/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SanPham;
import java.util.List;
import Repository.ViRepository;

/**
 *
 * @author Xuan Dat
 */
public class SanPhamService {
    ViRepository viRepository;
    public List<SanPham> getAll(){
        return viRepository.getAll();
    }
}
