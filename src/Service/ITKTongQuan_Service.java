/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKTongQuan_Model;
import Model.TKTongQuan_View;

/**
 *
 * @author Windows
 */
public interface ITKTongQuan_Service {
        TKTongQuan_View tkHomNay();
    TKTongQuan_View tkTheoNgay(String batDau, String ketThuc);
}
