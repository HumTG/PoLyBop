/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKDoanhThu_View;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface ITKDoanhThu_service {
    List<TKDoanhThu_View> getTKDoanhThu(Integer nam);
}
