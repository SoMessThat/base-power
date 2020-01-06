package com.SoMessThat.sys.service;

import java.util.List;

import com.SoMessThat.sys.vo.TreeVo;
import com.SoMessThat.sys.vo.DepartmentVo;

public interface DepartmentService {
	
	/**
	 * 查找所有XXXXX
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	List<DepartmentVo> queryDepartment(DepartmentVo vo);

	/**
	 * 新增XXXXX
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	String addDepartment(DepartmentVo vo);
	
	/**
	 * 通过id查看XXXXX信息
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	DepartmentVo findDepartmentById(Long id);
	
	/**
	 * 通过code查看组织信息
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	DepartmentVo findDepartmentByCode(String code);
	
	/**
	 * 通过id修改XXXXX
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	int updateDepartmentById(DepartmentVo vo);
	
	/**
	 * 通过id软删除XXXXX信息
	 * @createTime: 2019/10/11 16:48:00
	 * @author: wu.kaibin
	 */
	int delDepartmentById(Long id);

	List<TreeVo> getDepartmentTree();

	List<TreeVo> getDepartmentSonTree(String id);
	
	/**
	 * 通过code软删除组织信息
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	int mulDelDepartmentByCode(String codes);

	
}
