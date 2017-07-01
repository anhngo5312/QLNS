/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entity.nhanvien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nambh
 */
public class nhanvienDAO extends DataAccessHelper {

    private final String GET_ALL = "select * from nhanvien";
    private final String ADD_DATA = "insert into "
            + "nhanvien(manv,tennv,ngaysinh,gioitinh,diachi,sdt,dangvien,maphong)"
            + "values (?,?,?,?,?,?,?,?)";
    private final String GET_TOTAL = "select count(manv) from nhanvien";
    private final String UPDATE_DATA = "Update "
            + "nhanvien set tennv =?, ngaysinh=?,gioitinh=?,diachi=?,sdt=?,dangvien=?,maphong=? where manv=?";
    private final String REMOVE_DATA = "Delete nhanvien where manv=?";

    public ArrayList<nhanvien> getALL() {
        ArrayList<nhanvien> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    nhanvien item = new nhanvien();
                    item.setManv(rs.getString("manv"));
                    item.setTennv(rs.getString("tennv"));
                    item.setNgaysinh(rs.getString("ngaysinh"));
                    item.setGioitinh(rs.getString("gioitinh"));
                    item.setDiachi(rs.getString("diachi"));
                    item.setSdt(rs.getString("sdt"));
                    item.setDangvien(rs.getString("dangvien"));
                    item.setMaphong(rs.getString("maphong"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(nhanvien nvm){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, nvm.getManv());
            ps.setString(2, nvm.getTennv());
            ps.setString(3, nvm.getNgaysinh());
            ps.setString(4, nvm.getGioitinh());
            ps.setString(5, nvm.getDiachi());
            ps.setString(6, nvm.getSdt());
            ps.setString(7, nvm.getDangvien());
            ps.setString(8, nvm.getMaphong());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

   public boolean DeleteData(String u){
       boolean check = false;
       try {
           getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
           getClose();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return check;
   }
   
    public boolean Update(nhanvien nvm){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, nvm.getTennv());
            ps.setString(2, nvm.getNgaysinh());
            ps.setString(3, nvm.getGioitinh());
            ps.setString(4, nvm.getDiachi());
            ps.setString(5, nvm.getSdt());
            ps.setString(6, nvm.getDangvien());
            ps.setString(7, nvm.getMaphong());
            ps.setString(8, nvm.getManv());
            int rs = ps.executeUpdate();
            if(rs > 0){
                check = true;
            }
            
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public int tong() {
        int t = 0;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_TOTAL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    t = rs.getInt(1);
                }
                
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
