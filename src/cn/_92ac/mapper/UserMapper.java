package cn._92ac.mapper;

import cn._92ac.pojo.User;

public interface UserMapper {

	
	public  User  selectUserByUsername(String username);
	public boolean addUser(User user);
	
	
	
}
