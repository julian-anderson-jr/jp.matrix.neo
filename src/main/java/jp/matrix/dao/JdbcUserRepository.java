package jp.matrix.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import jp.matrix.service.UserRepository;
import lombok.extern.slf4j.Slf4j;
import oracle.sql.converter.CharacterConverters;

@Slf4j
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
		User res = user;
		String sid = user.getName();
		String pwd = user.getPassword();
		boolean rs = false;
		Connection con = null;
		PreparedStatement st = null;
		try
		{
			con = dataSource.getConnection();
			st = con.prepareStatement("INSERT INTO USERINFO(SID,PWD,GPID,LVL,LOCKING,UPDT,CRDT)VALUES(?,?,?,?,?,SYSDATE,SYSDATE)");
			st.setString(1, sid);
			st.setString(2, pwd);
			st.setObject(3, 0, java.sql.Types.INTEGER);
			st.setObject(4, 0, java.sql.Types.INTEGER);
			st.setObject(5, 0, java.sql.Types.INTEGER);
			rs = st.execute();
			con.commit();
		}
		catch(SQLException ex)
		{
			log.error(ex.getMessage());
			res = null;
		}
		finally
		{
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
			st.setObject(1, username);
			rs = st.executeQuery();
			rs.next();
			res = rs.getInt(1);
		}
		catch(SQLException ex)
		{
			log.error(ex.getMessage());
			res = -1;
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
