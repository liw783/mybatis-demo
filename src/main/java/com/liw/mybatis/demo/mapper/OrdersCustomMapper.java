package com.liw.mybatis.demo.mapper;

import java.util.List;

import com.liw.mybatis.demo.po.Orders;
import com.liw.mybatis.demo.po.OrdersCustom;
import com.liw.mybatis.demo.po.User;

public interface OrdersCustomMapper {
	public List<OrdersCustom> findOrdersList() throws Exception;
	public List<Orders> findOrdersListResultMap() throws Exception;
	public List<Orders> findOrdersDetailListResultMap() throws Exception;
	public List<User> findUserItemsResultMap() throws Exception;
	
	
}
