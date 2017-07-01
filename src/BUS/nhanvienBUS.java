package BUS;

import DAO.nhanvienDAO;
import Entity.nhanvien;
import java.util.ArrayList;

public class nhanvienBUS {
    nhanvienDAO dao = new nhanvienDAO();

    public ArrayList<nhanvien> getALL(){
        return dao.getALL();
    }
    public boolean AddData(nhanvien nvm){
        return dao.AddData(nvm);
    }
   
   public boolean  delete(String u){
       return dao.DeleteData(u);
    }
   public boolean  update(nhanvien nvm)
   {
       return dao.Update(nvm);
   }
   
   public int tong() {
       return dao.tong();
   }
}
