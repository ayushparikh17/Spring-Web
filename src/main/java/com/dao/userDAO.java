package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.bean.userBean;

public class userDAO {
	
	@Autowired
	JdbcTemplate stmt;
	
	public boolean Insert(userBean user) {
		
	int i=stmt.update("Insert into SpringUser(First_Name,Last_Name,Gender,Hobby,City,File_Path) values(?,?,?,?,?,?)",user.getFirstName(),user.getLastName(),user.getGender(),user.getHobby(),user.getCity(),user.getFilePath());
		if(i==0) {
			return false;
		}else {
			return true;
		}
	}
	
	public List<userBean> listUser(){
		List<userBean> users=stmt.query("Select * from SpringUser", new UserMapper() );
		return users;
	}
	
	class UserMapper implements RowMapper<userBean>{

		public userBean mapRow(ResultSet rs, int rowNum) throws SQLException {
			userBean bean=new userBean();
			bean.setUserId(rs.getInt("Id"));
			bean.setFirstName(rs.getString("First_Name"));
			bean.setLastName(rs.getString("Last_Name"));
			bean.setGender(rs.getString("Gender"));
			bean.setHobby(rs.getString("Hobby"));
			bean.setCity(rs.getString("City"));
			bean.setFilePath(rs.getString("File_Path"));
			return bean;
		}
	
	}
	
	public List<userBean> editUser(int id){
		List<userBean> user=stmt.query("Select * from SpringUser where Id='"+id+"'", new UserMapper());
		return user;
	}
	
	public boolean Update(userBean user) {
		
		int i=stmt.update("Update SpringUser Set First_Name=?,Last_Name=?,Gender=?,Hobby=?,City=?,File_Path=? where Id='"+user.getUserId()+"'",user.getFirstName(),user.getLastName(),user.getGender(),user.getHobby(),user.getCity(),user.getFilePath());
			if(i==0) {
				return false;
			}else {
				return true;
			}
		}
	
	public boolean Delete(int id) {
		int i=stmt.update("Delete from SpringUser where Id=?",id);
		if (i==0) {
			return false;
		} else {
			return true;
		}
	}
}
