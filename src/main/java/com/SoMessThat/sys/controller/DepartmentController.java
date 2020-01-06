package com.SoMessThat.sys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoMessThat.sys.api.DepartmentApi;
import com.SoMessThat.sys.service.DepartmentService;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.TreeVo;
import com.SoMessThat.sys.vo.DepartmentVo;
import com.SoMessThat.sys.vo.PageVo;

@RestController
public class DepartmentController implements DepartmentApi {
	
	@Autowired
	DepartmentService departmentService;
	
	@Override
	public PageVo<DepartmentVo> queryDepartment(DepartmentVo vo){
		List<DepartmentVo> list = departmentService.queryDepartment(vo);
		return BeanUtil.page(list);	
	}

	@Override
	public String addDepartment(@RequestBody DepartmentVo vo){
		return departmentService.addDepartment(vo);
	}
	
	@Override
	public DepartmentVo findDepartmentById(@RequestParam("id") Long id){
		return departmentService.findDepartmentById(id);
	}
	
	@Override
	public DepartmentVo findDepartmentByCode(@RequestParam("code") String code) {
		return departmentService.findDepartmentByCode(code);
	}
	
	@Override
	public int updateDepartmentById(@RequestBody DepartmentVo vo){
		return departmentService.updateDepartmentById(vo);
	}
	
	@Override
	public int delDepartmentById(@RequestParam("id") Long id){
		return departmentService.delDepartmentById(id);
	}

	@Override
	public List<TreeVo> getDepartmentTree() {
		return departmentService.getDepartmentTree();
	}
	
	@Override
	public List<TreeVo> getDepartmentSonTree(@RequestParam String id) {
		return departmentService.getDepartmentSonTree(id);
	}

	@Override
	public int mulDelDepartmentByCode(@RequestParam String codes) {
		return departmentService.mulDelDepartmentByCode(codes);
	}

}
