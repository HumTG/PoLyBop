/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.Vi;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceVi {
            abstract public void insert(Vi sp);
    
    abstract public void update(Vi sp);
    
    abstract public void delete(Integer id);
    
    abstract public List<Vi> selectAll();
    
    abstract public Vi selectID(Integer id);
    int getTotal();
    abstract public Vi selectID1(String id);
    abstract public List<Vi> getViByPage(int page,int recordInPage);
    abstract public List<Vi> selectBySQL(String sql, Object...args);
}
