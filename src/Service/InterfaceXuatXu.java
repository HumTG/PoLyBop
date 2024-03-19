/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.XuatXu;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceXuatXu {
                abstract public void insert(XuatXu sp);
    
    abstract public void update(XuatXu sp);
    
    abstract public void delete(Integer id);
    
    abstract public List<XuatXu> selectAll();
    
    abstract public XuatXu selectID(Integer id);
    
    abstract public List<XuatXu> selectBySQL(String sql, Object...args);
}
