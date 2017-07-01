package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class adDAO extends DataAccessHelper {
    
    private final String GET_LOGIN = "select * from idlogin where username=? and passwd=?";

    public boolean getLogin(String u, String p) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }    
    
}