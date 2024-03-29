/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.TKTongQuan_Model;

/**
 *
 * @author Windows
 */
public interface ITKTongQuan_Repos {
     TKTongQuan_Model tkHomNay();
    TKTongQuan_Model tkTheoNgay(String batDau, String ketThuc);
}
