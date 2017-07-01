package DAO;

import Entity.Phong;
import Entity.nhansu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class nhansuDAO extends DataAccessHelper {

    private final String GET_BY_ID = "select * from nhansu where manv =? and maphong =?";
    private final String GET_ALL = "select * from nhansu";
    private final String UPDATE_DATA = "Update "
            + "nhansu set chucvu =? where manv =? and maphong =?";
    private final String ADD_DATA = "insert into "
            + "nhansu(manv, maphong, chucvu)"
            + "values (?,?,?)";
    private final String REMOVE_DATA = "Delete nhansu where manv=? and maphong =?";

    public ArrayList<nhansu> getByID(String ids, String id) {
        ArrayList<nhansu> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, ids);
            ps.setString(2, id);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                nhansu item = new nhansu();
                item.setManv(rs.getString("manv"));
                item.setMaphong(rs.getString("maphong"));
                item.setChucvu(rs.getString("chucvu"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<nhansu> getAll() {
        ArrayList<nhansu> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    nhansu item = new nhansu();
                    item.setManv(rs.getString("manv"));
                    item.setMaphong(rs.getString("maphong"));
                    item.setChucvu(rs.getString("chucvu"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public boolean AddData(nhansu nsm) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, nsm.getManv());
            ps.setString(2, nsm.getMaphong());
            ps.setString(3, nsm.getChucvu());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean Update(nhansu nsm) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, nsm.getChucvu());
            ps.setString(2, nsm.getManv());
            ps.setString(3, nsm.getMaphong());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public boolean Delete(String u, String v) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            ps.setString(2, v);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
