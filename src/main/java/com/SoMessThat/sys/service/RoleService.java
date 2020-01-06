package com.SoMessThat.sys.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoMessThat.sys.vo.RoleVo;

public interface RoleService {
	
	/**
	 * 查找所有XXXXX
	 * @createTime: 2019/10/11 16:53:08
	 * @author: wu.kaibin
	 */
	List<RoleVo> queryRole(RoleVo vo);

	/**
	 * 新增XXXXX
	 * @createTime: 2019/10/11 16:53:08
	 * @author: wu.kaibin
	 */
	int addRole(RoleVo vo);
	
	/**
	 * 通过id查看XXXXX信息
	 * @createTime: 2019/10/11 16:53:08
	 * @author: wu.kaibin
	 */
	RoleVo findRoleById(Long id);
	
	/**
	 * 通过id修改XXXXX
	 * @createTime: 2019/10/11 16:53:08
	 * @author: wu.kaibin
	 */
	int updateRoleById(RoleVo vo);
	
	/**
	 * 通过id软删除XXXXX信息
	 * @createTime: 2019/10/11 16:53:08
	 * @author: wu.kaibin
	 */
	int delRoleById(Long id);
	
	/**
	 * 给权限分配角色的角色列表（包括选择框及搜索）。
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	List<RoleVo> getRightRoleList(@RequestBody RoleVo role);
	
	/**
	 * 删除拥有这个权限的角色
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	int delRightRole(@RequestParam Map<String, String> map);
	
	/**
	 * 添加拥有这个权限的角色
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	int addRightRole(@RequestParam Map<String, String> map);

	/**
	* @date 2019/6/17 13:59
	* @description 查询用户的角色
	*/
	List<String> queryRoleByUserId(long userId);
}
