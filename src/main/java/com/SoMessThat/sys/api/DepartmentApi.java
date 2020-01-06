package com.SoMessThat.sys.api;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoMessThat.sys.vo.TreeVo;
import com.SoMessThat.sys.vo.DepartmentVo;
import com.SoMessThat.sys.vo.PageVo;

@RequestMapping("/department")
public interface DepartmentApi {
	
	/**
	 * 查找所有组织
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/queryDepartment")
	PageVo<DepartmentVo> queryDepartment(DepartmentVo vo);

	/**
	 * 新增组织
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/addDepartment")
	String addDepartment(@RequestBody DepartmentVo vo);
	
	/**
	 * 通过id查看组织信息
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findDepartmentById")
	DepartmentVo findDepartmentById(@RequestParam("id") Long id);
	
	/**
	 * 通过code查看组织信息
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findDepartmentByCode")
	DepartmentVo findDepartmentByCode(@RequestParam("code") String code);
	
	/**
	 * 通过id修改组织
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/updateDepartmentById")
	int updateDepartmentById(@RequestBody DepartmentVo vo);
	
	/**
	 * 通过id软删除组织信息
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/delDepartmentById")
	int delDepartmentById(@RequestParam("id") Long id);
	
	/**
	 * 获取部门列表（树）
	 * @param 
	 * @return DepartmentVo
	 */
	@RequestMapping("/getDepartmentTree")
	List<TreeVo> getDepartmentTree();
	
	/**
	 * 获取子部门列表（树）
	 * @param id 部门code
	 * @return DepartmentVo
	 */
	@RequestMapping("/getDepartmentSonTree")
	List<TreeVo> getDepartmentSonTree(@RequestParam("id") String id);
	
	/**
	 * 通过code软删除组织信息
	 * @createTime: 2019/10/11 16:47:26
	 * @author: wu.kaibin
	 */
	@RequestMapping("/mulDelDepartmentByCode")
	int mulDelDepartmentByCode(@RequestParam("codes") String codes);
}
