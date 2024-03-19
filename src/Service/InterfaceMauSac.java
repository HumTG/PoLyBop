/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface InterfaceMauSac {

    abstract public void insert(MauSac sp);

    abstract public void update(MauSac sp);

    abstract public void delete(Integer id);

    abstract public MauSac selectID(Integer id);

    abstract public List<MauSac> selectAll();

    abstract public List<MauSac> selectBySQL(String sql, Object... args);
}
