package com.SoMessThat.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.SoMessThat.sys.domain.User;
import com.SoMessThat.sys.mapper.UserMapper;
import com.SoMessThat.sys.util.UUIDUtil;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.PowerDTO;
import com.SoMessThat.sys.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public List<UserVo> queryUser(UserVo vo){
		vo.setStatus("ENABLED");
		return userMapper.queryUser(vo);
	}

	@Override
	public int addUser(UserVo vo){
		User po = BeanUtil.copy(vo, User.class);
		po.setStatus("ENABLED");
		po.setUpdateTime(new Date());
		po.setCreateTime(new Date());
		po.setCode(UUIDUtil.getUUID());
		return userMapper.insertSelective(po);
	}
	
	@Override
	public UserVo findUserById(Long id){
		User po = userMapper.selectByPrimaryKey(id);
		return BeanUtil.copy(po, UserVo.class);
	}
	
	@Override
	public int updateUserById(UserVo vo){
		User po = BeanUtil.copy(vo, User.class);
		po.setUpdateTime(new Date());
		return userMapper.updateByPrimaryKeySelective(po);
	}
	
	@Override
	public int delUserById(Long id){
		User po = new User();
		po.setId(id);
		po.setStatus("DISABLED");
		po.setUpdateTime(new Date());
		return userMapper.updateByPrimaryKeySelective(po);
	}

	@Override
	public List<UserVo> findRoleList(UserVo user) {
		return userMapper.findRoleList(user);
	}

	@Override
	public int updateUserRole(Map<String, String> map) {
		int num = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("userId", map.get("userId"));
		if (!ObjectUtils.isEmpty(map.get("delRoleIds"))) {		
			param.put("roleIds", "(" + map.get("delRoleIds") + ")");
			num += userMapper.delRoleIds(param);
		}
		if (!ObjectUtils.isEmpty(map.get("addRoleIds"))) {
			param.put("roleIds", map.get("addRoleIds").split(","));
			num += userMapper.addRoleIds(param);
		}
		return num;
	}

	@Override
	public List<PowerDTO> queryMenu(Long id) {
		return userMapper.selectPowerRootByUserID(id);
	}
	
}
