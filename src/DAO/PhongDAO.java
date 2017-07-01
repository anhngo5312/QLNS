
package DAO;

import Entity.Phong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhongDAO extends DataAccessHelper{
    private final String GET_BY_ID = "select * from phong where maphong =?";
    private final String GET_ALL = "select * from phong";
    
    public ArrayList<Phong> getByID(String id){
        ArrayList<Phong> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs!= null && rs.next()){
                Phong item = new Phong();
                item.setmaphong(rs.getString("maphong"));
                item.settenphong(rs.getString("tenphong"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<Phong> getAll(){
        ArrayList<Phong> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while (rs.next()) {                    
                    Phong item = new Phong();
                    item.setmaphong(rs.getString("maphong"));
                    item.settenphong(rs.getString("tenphong"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
   
}
