package com.liw.mybatis.demo.po;

import java.util.List;

/**
 * 包装类型
 *
 */
public class UserQueryVo {
	private List<Integer> ids;
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
}
