/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author Windows
 */
public class ChatLieu {
    private int idChatLieu;
    private String Ma_ChatLieu;
    private String tenChatLieu;
    private boolean trangThai;

    public ChatLieu() {
    }

    public ChatLieu(int idChatLieu, String Ma_ChatLieu, String tenChatLieu, boolean trangThai) {
        this.idChatLieu = idChatLieu;
        this.Ma_ChatLieu = Ma_ChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.trangThai = trangThai;
    }

    public String getMa_ChatLieu() {
        return Ma_ChatLieu;
    }

    public void setMa_ChatLieu(String Ma_ChatLieu) {
        this.Ma_ChatLieu = Ma_ChatLieu;
    }

 

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }


    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

   

    
    
}
