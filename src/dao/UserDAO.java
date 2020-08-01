package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface{
	public int signUp(User user) {
		try {
			Connection con = ConnectionManager.getConnection();
			String sql="insert into USERS(email,password)values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,user.getEmail());
			st.setString(2, user.getPassword());
			int i=st.executeUpdate();
			con.close();
			return i;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	public boolean loginUser(User user) {
		try {
			Connection con = ConnectionManager.getConnection();
			String sql="select * from USERS";
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				if(user.getEmail().equals(rs.getString(1))&&user.getPassword().equals(rs.getString(2))){
					return true;
				}
			}
			con.close();
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
}