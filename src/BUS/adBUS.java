package BUS;

import DAO.adDAO;

public class adBUS {
    adDAO dao = new adDAO();
    public boolean  getLogin(String u,String p){
       return  dao.getLogin(u, p);
    }
}