package DatabaseAccessObject;

import ql_hodan.KhuPho;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class KhuPhoDAO {
	public static KhuPho getKhuPho() {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery("select * from KhuPho ");
            while (rs.next()) {
            	KhuPho kp = new KhuPho();
            	kp.setIdKhuPho(rs.getString("maKhuPho"));
                kp.setNameKhuPho(rs.getString("tenKhuPho"));
                return kp;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
	 public static List<KhuPho> selectAll() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery("select * from khupho ");
	            List<KhuPho> kpList = new ArrayList<>();
	            while (rs.next()) {
	                KhuPho kp = new KhuPho(rs.getString("maKhuPho"),rs.getString("tenKhuPho"));
	                kp.setIdKhuPho(rs.getString("maKhuPho"));
	                kp.setNameKhuPho(rs.getString("tenKhuPho"));
	                kpList.add(kp);
	            }
	            return kpList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }

	    public List<String> getListIDKhuPho() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("Select maKhuPho From khupho");
	            List<String> listIDKhuPho = new ArrayList<>();
	            while (rs.next()) {
	                listIDKhuPho.add(rs.getString("maKhuPho"));
	            }
	            return listIDKhuPho;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	    public static boolean insert(KhuPho kp) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("INSERT INTO KhuPho VALUES (?,?)");
	            prst.setString(1, kp.getIdKhuPho());
	            prst.setString(2, kp.getNameKhuPho());	            
	            return prst.execute();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static boolean update(KhuPho kp) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("UPDATE KhuPho SET tenKhuPho = ? WHERE maKhuPho = ?");  
	            prst.setString(1, kp.getNameKhuPho());
	            prst.setString(2, kp.getIdKhuPho());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static boolean delete(KhuPho kp) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("DELETE FROM KhuPho WHERE maKhuPho = ?");
	            prst.setString(1, kp.getIdKhuPho());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }
}
