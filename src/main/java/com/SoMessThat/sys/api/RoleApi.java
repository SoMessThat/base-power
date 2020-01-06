package com.SoMessThat.sys.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.RoleVo;

@RequestMapping("/role")
public interface RoleApi {
	
	/**
	 * 查找所有角色
	 * @createTime: 2019/10/11 16:52:49
	 * @author: wu.kaibin
	 */
	@RequestMapping("/queryRole")
	PageVo<RoleVo> queryRole(@RequestBody RoleVo vo);

	/**
	 * 新增角色
	 * @createTime: 2019/10/11 16:52:49
	 * @author: wu.kaibin
	 */
	@RequestMapping("/addRole")
	int addRole(@RequestBody RoleVo vo);
	
	/**
	 * 通过id查看角色信息
	 * @createTime: 2019/10/11 16:52:49
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findRoleById")
	RoleVo findRoleById(@RequestParam("id") Long id);
	
	/**
	 * 通过id修改角色
	 * @createTime: 2019/10/11 16:52:49
	 * @author: wu.kaibin
	 */
	@RequestMapping("/updateRoleById")
	int updateRoleById(@RequestBody RoleVo vo);
	
	/**
	 * 通过id软删除角色信息
	 * @createTime: 2019/10/11 16:52:49
	 * @author: wu.kaibin
	 */
	@RequestMapping("/delRoleById")
	int delRoleById(@RequestParam("id") Long id);
	
	/**
	 * 给权限分配角色的角色列表（包括选择框及搜索）。
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	@RequestMapping("/getRightRoleList")
	PageVo<RoleVo> getRightRoleList(@RequestBody RoleVo role);
	
	/**
	 * 删除拥有这个权限的角色
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	@RequestMapping("/delRightRole")
	int delRightRole(@RequestParam Map<String, String> map);
	
	/**
	 * 添加拥有这个权限的角色
	 * @createTime: 2019年6月11日 下午5:42:07
	 * @author: wu.kaibin
	 */
	@RequestMapping("/addRightRole")
	int addRightRole(@RequestParam Map<String, String> map);
	
	/**
	* @date 2019/6/17 13:59
	* @description 查询用户的角色
	*/
	@RequestMapping("/queryRoleByUserId")
	List<String> queryRoleByUserId(@RequestParam("userId") long userId);
}
