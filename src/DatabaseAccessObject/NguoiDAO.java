package DatabaseAccessObject;

import ql_hodan.Nguoi;
import ConnectionDB.*;
import java.util.*;
import java.sql.*;

public class NguoiDAO {
	 public static List<Nguoi> selectAll() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement prst = connection.createStatement();
	            ResultSet rs = prst.executeQuery("select * from nguoi ");
	            List<Nguoi> ngList = new ArrayList<>();
	            while (rs.next()) {
	                Nguoi ng = new Nguoi(rs.getString("maNguoi"),rs.getString("hoVaTen"), rs.getInt("tuoi"),rs.getInt("namSinh"),
	                		rs.getString("ngheNghiep"), rs.getString("maHoDan"));
	                ng.setIdNguoi(rs.getString("maNguoi"));
	                ng.setName(rs.getString("hoVaTen"));
	                ng.setAge(rs.getInt("tuoi"));
	                ng.setYear(rs.getInt("namSinh"));               
	                ng.setJob(rs.getString("ngheNghiep"));
	                ng.setIdHoDan(rs.getString("maHoDan"));
	                ngList.add(ng);
	            }
	            return ngList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }
	 public static List<Nguoi> selectKP(String IDKP) {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	        	PreparedStatement prst = connection.prepareStatement("select * from nguoi ,hodan hd where nguoi.maHoDan = hd.maHoDan and hd.maKhuPho = (?)");
	        	prst.setString(1,IDKP );
	        	ResultSet rs = prst.executeQuery();
	            List<Nguoi> ngList = new ArrayList<>();
	            while (rs.next()) {
	                Nguoi ng = new Nguoi();
	                ng.setIdNguoi(rs.getString("maNguoi"));
	                ng.setName(rs.getString("hoVaTen"));
	                ng.setAge(rs.getInt("tuoi"));
	                ng.setYear(rs.getInt("namSinh"));               
	                ng.setJob(rs.getString("ngheNghiep"));
	                ng.setIdHoDan(rs.getString("maHoDan"));
	                ngList.add(ng);
	            }
	            return ngList;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	 }

	    public List<String> getListIDNguoi() {
	        Connection connection = null;
	        try {
	        	connection = ConnectionDatabase.getConnection();
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("Select maNguoi From nguoi");
	            List<String> listIDNguoi = new ArrayList<>();
	            while (rs.next()) {
	                listIDNguoi.add(rs.getString("maNguoi"));
	            }
	            return listIDNguoi;
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	    public static boolean insert(Nguoi ng) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("INSERT INTO nguoi VALUES (?,?,?,?,?,?)");
	            prst.setString(1, ng.getIdNguoi());
	            prst.setString(2, ng.getName());
	            prst.setInt(3, ng.getAge());
	            prst.setInt(4, ng.getYear());
	            prst.setString(5, ng.getJob());
	            prst.setString(6, ng.getIdHoDan());
	            return prst.execute();

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static boolean update(Nguoi ng) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("UPDATE nguoi SET hoVaTen = ?, tuoi = ?, "
	                    +" namSinh = ?,ngheNghiep = ?, maHoDan = ? WHERE maNguoi = ?");  
	            prst.setString(1, ng.getName());
	            prst.setInt(2, ng.getAge());
	            prst.setInt(3, ng.getYear());
	            prst.setString(4, ng.getJob());
	            prst.setString(5, ng.getIdHoDan());
	            prst.setString(6, ng.getIdNguoi());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        } 
	        return false;
	    }

	    public static boolean delete(Nguoi ng) {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            PreparedStatement prst = connection.prepareStatement("DELETE FROM nguoi WHERE maNguoi = ?");
	            prst.setString(1, ng.getIdNguoi());
	            return prst.execute();
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return false;
	    }

	    public static List<String> getListIDHoDan() {
	        Connection connection = null;
	        try {
	            connection = ConnectionDatabase.getConnection();
	            Statement st = connection.createStatement();
	            ResultSet rs = st.executeQuery("Select maHoDan From nguoi");
	            List<String> listMHD = new ArrayList<>();
	            while (rs.next()) {
	                listMHD.add(rs.getString("maHoDan"));
	            }
	            return listMHD;
	        } catch (ClassNotFoundException | SQLException ex) {
	            ex.getMessage();
	        }
	        return null;
	    }
}
