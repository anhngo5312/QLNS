/*
 * To change this license header, choose License Headers in nhansu Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAO.nhansuDAO;
import Entity.nhansu;
import java.util.ArrayList;

/**
 *
 * @author nambh
 */
public class nhansuBUS {
    nhansuDAO dao = new nhansuDAO();
    public ArrayList<nhansu> getByID(String ids, String id){
        return dao.getByID(ids, id);
    }
 
    public ArrayList<nhansu> getAll(){
        return dao.getAll();
    }
    
    public boolean update(nhansu nsm) {
        return dao.Update(nsm);
    }
    
    public boolean delete(String manv, String maphong) {
        return dao.Delete(manv, maphong);
    }
    
    public boolean AddData(nhansu nsm) {
        return dao.AddData(nsm);
    }
}
