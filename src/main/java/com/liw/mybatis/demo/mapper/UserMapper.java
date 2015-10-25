package com.liw.mybatis.demo.mapper;

import java.util.List;

import com.liw.mybatis.demo.po.User;
import com.liw.mybatis.demo.po.UserCustom;
import com.liw.mybatis.demo.po.UserQueryVo;
/**
 * mapper接口
 * 
 */
public interface UserMapper {
	List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	List<UserCustom> findUserListResultMap(UserQueryVo userQueryVo) throws Exception;
	int findUserCount(UserQueryVo userQueryVo) throws Exception;
	User findUserById(int id) throws Exception;
	void insertUser(User user) throws Exception;
	void deleteUser(int id) throws Exception;
	
}
