package com.SoMessThat.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoMessThat.sys.api.UserApi;
import com.SoMessThat.sys.service.UserService;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.PowerDTO;
import com.SoMessThat.sys.vo.UserVo;

@RestController
public class UserController implements UserApi {
	
	@Autowired
	UserService userService;
	
	@Override
	public PageVo<UserVo> queryUser(@RequestBody UserVo vo){
		List<UserVo> list = userService.queryUser(vo);
		return BeanUtil.page(list);	
	}

	@Override
	public int addUser(@RequestBody UserVo vo){
		return userService.addUser(vo);
	}
	
	@Override
	public UserVo findUserById(@RequestParam("id") Long id){
		return userService.findUserById(id);
	}
	
	@Override
	public int updateUserById(@RequestBody UserVo vo){
		return userService.updateUserById(vo);
	}
	
	@Override
	public int delUserById(@RequestParam("id") Long id){
		return userService.delUserById(id);
	}

	@Override
	public PageVo<UserVo> findRoleList(@RequestBody UserVo user) {
		List<UserVo> list = userService.findRoleList(user);
		return BeanUtil.page(list);
	}

	@Override
	public int updateUserRole(@RequestParam Map<String, String> map) {
		if (ObjectUtils.isEmpty(map.get("userId"))) {			
			return 0;
		}
		if (!(ObjectUtils.isEmpty(map.get("delRoleIds")) || ObjectUtils.isEmpty(map.get("addRoleIds")))) {
			return 0;
		}
		return userService.updateUserRole(map);
	}
//
//	@Override
//	public PageVo<UserVo> queryRolesUsers(UserVo user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int delRolesUser(Map<String, String> map) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int addRolesUser(Map<String, String> map) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public List<PowerDTO> queryMenu(@RequestParam("id") Long id) {
		return userService.queryMenu(id);
	}
	
}
