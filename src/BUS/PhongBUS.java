
package BUS;

import DAO.PhongDAO;
import Entity.Phong;
import java.util.ArrayList;

public class PhongBUS {
    PhongDAO dal = new PhongDAO();
    public ArrayList<Phong> getByID(String id){
        return dal.getByID(id);
    }
    
    public ArrayList<Phong> getALl(){
        return dal.getAll();
    }
    
    
  
}
