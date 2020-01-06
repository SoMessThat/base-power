package com.SoMessThat.sys.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoMessThat.sys.domain.Role;
import com.SoMessThat.sys.mapper.RoleMapper;
import com.SoMessThat.sys.util.UUIDUtil;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.RoleVo;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public List<RoleVo> queryRole(RoleVo vo){
		vo.setStatus("ENABLED");
		return roleMapper.queryRole(vo);
	}

	@Override
	public int addRole(RoleVo vo){
		Role po = BeanUtil.copy(vo, Role.class);
		po.setStatus("ENABLED");
		po.setUpdateTime(new Date());
		po.setCode(UUIDUtil.getNoLineSortUUID());
		return roleMapper.insertSelective(po);
	}
	
	@Override
	public RoleVo findRoleById(Long id){
		Role po = roleMapper.selectByPrimaryKey(id);
		return BeanUtil.copy(po, RoleVo.class);
	}
	
	@Override
	public int updateRoleById(RoleVo vo){
		Role po = BeanUtil.copy(vo, Role.class);
		po.setUpdateTime(new Date());
		return roleMapper.updateByPrimaryKeySelective(po);
	}
	
	@Override
	public int delRoleById(Long id){
		Role po = new Role();
		po.setId(id);
		po.setStatus("DISABLED");
		po.setUpdateTime(new Date());
		return roleMapper.updateByPrimaryKeySelective(po);
	}

	@Override
	public List<RoleVo> getRightRoleList(RoleVo role) {
		return null;
//		return roleMapper.getRightRoleList(role);
	}

	@Override
	public int delRightRole(Map<String, String> map) {
//		CommonSysRelRoleRightTb ref = new CommonSysRelRoleRightTb();
//		ref.setRightId(Long.parseLong(map.get("rightId")));
//		String[] id = map.get("roleIds").split(",");
//		int num = 0;
//		for (int i = 0; i < id.length; i++) {
//			ref.setRoleId(Long.parseLong(id[i]));
//			num += commonSysRelRoleRightTbMapper.delRightRole(ref);
//		}
//		return num;
		return 0;
	}

	@Override
	public int addRightRole(Map<String, String> map) {
//		CommonSysRelRoleRightTb ref = new CommonSysRelRoleRightTb();
//		ref.setRightId(Long.parseLong(map.get("rightId")));
//		String[] id = map.get("roleIds").split(",");
//		int num = 0;
//		for (int i = 0; i < id.length; i++) {
//			ref.setRoleId(Long.parseLong(id[i]));
//			num += commonSysRelRoleRightTbMapper.insertSelective(ref);
//		}
//		return num;
		return 0;
	}

	@Override
	public List<String> queryRoleByUserId(long userId) {
		return null;
//		return roleMapper.queryRoleByUserId(userId);
		
	}
	
}
