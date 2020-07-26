package jp.matrix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jp.matrix.service.UserRepository;

public class JdbcUserRepository implements UserRepository {
	private javax.sql.DataSource dataSource = null;
	
	public JdbcUserRepository(javax.sql.DataSource dataSource)
	{
		this.dataSource = dataSource;
			//BCryptPasswordEncoder cry = new BCryptPasswordEncoder();
			//Connection con = dataSource.getConnection();
			//PreparedStatement st = con.prepareStatement("INSERT INTO USERINFO(SID,PWD) VALUES ('poko','" + cry.encode("poko") + "')");
			//st.execute();
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByUsername(String username) {
		int res = 0;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try
		{
			con = dataSource.getConnection();
			st = con.prepareStatement("SELECT COUNT(1) AS CNT FROM USERINFO WHERE SID = ?");
			st.setObject(0, username);
			rs = st.executeQuery();
			res = rs.getInt(0);
		}
		catch(SQLException ex)
		{
			res = 0;
		}
		finally
		{
			if (rs != null)
			{
				try
				{
					rs.close();
				}
				catch(Exception ex)
				{
				}
			}
			if (st != null)
			{
				try
				{
					st.close();
				}
				catch(Exception ex)
				{
				}
			}
			if (con != null)
			{
				try
				{
					con.close();
				}
				catch(Exception ex)
				{
				}
			}
		}
		return res;
	}
}
