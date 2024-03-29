/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.LoaiVi;
import java.util.List;

/**
 *
 * @author Xuan Dat
 */
public interface InterfaceLoaiVi {
    abstract public void insert(LoaiVi sp);

    abstract public void update(LoaiVi sp);

    abstract public void delete(Integer id);

    abstract public LoaiVi selectID(Integer id);

    abstract public List<LoaiVi> selectAll();

    abstract public List<LoaiVi> selectBySQL(String sql, Object... args);
}
