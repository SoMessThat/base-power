package com.SoMessThat.sys.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SoMessThat.sys.domain.Department;
import com.SoMessThat.sys.mapper.DepartmentMapper;
import com.SoMessThat.sys.util.UUIDUtil;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.TreeVo;
import com.SoMessThat.sys.vo.DepartmentVo;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentVo> queryDepartment(DepartmentVo vo){
		vo.setStatus("ENABLED");
		return departmentMapper.queryDepartment(vo);
	}

	@Override
	public String addDepartment(DepartmentVo vo){
		Department po = BeanUtil.copy(vo, Department.class);
		po.setStatus("ENABLED");
		po.setCode(UUIDUtil.getNoLineSortUUID());
		po.setCreateTime(new Date());
		po.setUpdateTime(new Date());
		int i = departmentMapper.insertSelective(po);
		if (i>0) {
			return po.getCode();
		} 
		return "Fail";
	}
	
	@Override
	public DepartmentVo findDepartmentById(Long id){
		Department po = departmentMapper.selectByPrimaryKey(id);
		return BeanUtil.copy(po, DepartmentVo.class);
	}
	
	@Override
	public DepartmentVo findDepartmentByCode(String code) {
		return departmentMapper.findDepartmentByCode(code);
	}
	
	@Override
	public int updateDepartmentById(DepartmentVo vo){
		Department po = BeanUtil.copy(vo, Department.class);
		po.setUpdateTime(new Date());
		return departmentMapper.updateByPrimaryKeySelective(po);
	}
	
	@Override
	public int delDepartmentById(Long id){
		Department po = new Department();
		po.setId(id);
		po.setStatus("DELETED");
		po.setUpdateTime(new Date());
		return departmentMapper.updateByPrimaryKeySelective(po);
	}
	
	@Override
	public List<TreeVo> getDepartmentTree() {
		return departmentMapper.getDepartmentTree();
	}
	
	@Override
	public List<TreeVo> getDepartmentSonTree(String id) {
		return departmentMapper.getDepartmentSonTree(id);
	}

	@Override
	public int mulDelDepartmentByCode(String codes) {
		return departmentMapper.mulDelDepartmentByCode(codes);
	}
	
}
