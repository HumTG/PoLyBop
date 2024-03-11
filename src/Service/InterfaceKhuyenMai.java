/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.KhuyenMai;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceKhuyenMai {
        List<KhuyenMai> getKhuyenMai(); 
    int getGiaTriKM(String maKM); 
}
