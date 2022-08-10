package DatabaseAccessObject;

import ql_hodan.HoDan;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class HoDanDAO {
	 public static List<HoDan> selectAll() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery("select * from hodan ");
	            List<HoDan> hdList = new ArrayList<>();
	            while (rs.next()) {
	                HoDan hd = new HoDan(rs.getString("maHoDan"),rs.getInt("soThanhVien"),rs.getString("soNha"),rs.getString("maKhuPho"));
	                hd.setIdHoDan(rs.getString("maHoDan"));
	                hd.setSoThanhVien(rs.getInt("soThanhVien"));
	                hd.setSoNha(rs.getString("soNha"));
	                hd.setIdKhuPho(rs.getString("maKhuPho"));
	                hdList.add(hd);
	            }
	            return hdList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }

	    public List<String> getListIDHoDan() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("Select maHoDan From hodan");
	            List<String> listIDHoDan = new ArrayList<>();
	            while (rs.next()) {
	                listIDHoDan.add(rs.getString("maHoDan"));
	            }
	            return listIDHoDan;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	    public static boolean insert(HoDan hd) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("INSERT INTO HoDan VALUES (?,?,?,?)");
	            prst.setString(1, hd.getIdHoDan());
	            prst.setInt(2, hd.getSoThanhVien());
	            prst.setString(3, hd.getSoNha());
	            prst.setString(4, hd.getIdKhuPho());
	            return prst.execute();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static boolean update(HoDan hd) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("UPDATE HoDan SET soThanhVien = ?, soNha = ?, maKhuPho = ? WHERE maHoDan = ?");  
	            prst.setInt(1, hd.getSoThanhVien());
	            prst.setString(2, hd.getSoNha());
	            prst.setString(3, hd.getIdKhuPho());
	            prst.setString(4, hd.getIdHoDan());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static boolean delete(HoDan hd) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("DELETE FROM HoDan WHERE maHoDan = ?");
	            prst.setString(1, hd.getIdHoDan());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }
	    public static List<String> getListIDKhuPho() {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("Select maKhuPho From hodan");
	            List<String> listMKP = new ArrayList<>();
	            while (rs.next()) {
	                listMKP.add(rs.getString("maKhuKho"));
	            }
	            return listMKP;
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.getMessage();
	        }
	        return null;
	    }
}
