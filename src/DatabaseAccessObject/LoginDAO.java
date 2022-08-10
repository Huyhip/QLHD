package DatabaseAccessObject;

import ql_hodan.Login;
import ConnectionDB.*;
import java.sql.*;

public class LoginDAO {
	public static Login getLogin() {
        Connection connection = null;
        try {
            connection = ConnectionDatabase.getConnection();
            Statement prst = connection.createStatement();
            ResultSet rs = prst.executeQuery("select * from useritem ");
            while (rs.next()) {
                Login dn = new Login(rs.getString("tenTaiKhoan"),rs.getString("matKhau"),rs.getString("vaiTro"));
                dn.setUser(rs.getString("tenTaiKhoan"));
                dn.setPass(rs.getString("matKhau"));
                dn.setVaiTro(rs.getString("vaiTro"));
                return dn;
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.getMessage();
        }
        return null;
    }
}
