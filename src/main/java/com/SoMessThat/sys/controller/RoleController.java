package com.SoMessThat.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoMessThat.sys.api.RoleApi;
import com.SoMessThat.sys.service.RoleService;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.RoleVo;

@RestController
public class RoleController implements RoleApi {
	
	@Autowired
	RoleService roleService;
	
	@Override
	public PageVo<RoleVo> queryRole(@RequestBody RoleVo vo){
		List<RoleVo> list = roleService.queryRole(vo);
		return BeanUtil.page(list);	
	}

	@Override
	public int addRole(@RequestBody RoleVo vo){
		return roleService.addRole(vo);
	}
	
	@Override
	public RoleVo findRoleById(@RequestParam("id") Long id){
		return roleService.findRoleById(id);
	}
	
	@Override
	public int updateRoleById(@RequestBody RoleVo vo){
		return roleService.updateRoleById(vo);
	}
	
	@Override
	public int delRoleById(@RequestParam("id") Long id){
		return roleService.delRoleById(id);
	}

	@Override
	public PageVo<RoleVo> getRightRoleList(@RequestBody RoleVo role) {
		List<RoleVo> list = roleService.getRightRoleList(role);
		return BeanUtil.page(list);
	}

	@Override
	public int delRightRole(@RequestParam Map<String, String> map) {
		return roleService.delRightRole(map);
	}

	@Override
	public int addRightRole(@RequestParam Map<String, String> map) {
		return roleService.addRightRole(map);
	}

	@Override
	public List<String> queryRoleByUserId(@RequestParam("userId") long userId) {
		return roleService.queryRoleByUserId(userId);
	}
	
}
