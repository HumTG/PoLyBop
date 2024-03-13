/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Xuan Dat
 */
public class ThuongHieu {
    private Integer id;
    private String Ma;
    private String Ten;
    private String tt;

    public ThuongHieu() {
    }

    public ThuongHieu(Integer id, String Ma, String Ten, String tt) {
        this.id = id;
        this.Ma = Ma;
        this.Ten = Ten;
        this.tt = tt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getTt() {
        return tt;
    }

    public void setTt(String tt) {
        this.tt = tt;
    }
    
    
}
