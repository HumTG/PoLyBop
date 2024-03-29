/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import Model.ChatLieu;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface InterfaceChatLieu {
          abstract public void insert(ChatLieu sp);
    
    abstract public void update(ChatLieu sp);
    
    abstract public void delete(Integer id);
    
    
    abstract public ChatLieu selectID(String id);
    
    abstract public List<ChatLieu> selectAll();
    
    abstract public List<ChatLieu> selectBySQL(String sql, Object...args);
}
