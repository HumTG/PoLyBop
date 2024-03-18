/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ThuongHieu;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceThuongHieu {
    abstract public void insert(ThuongHieu sp);
    
    abstract public void update(ThuongHieu sp);
    
    abstract public void delete(Integer id);
    
    abstract public List<ThuongHieu> selectAll();
    
    abstract public ThuongHieu selectID(Integer id);
    
    abstract public List<ThuongHieu> selectBySQL(String sql, Object...args);
}
