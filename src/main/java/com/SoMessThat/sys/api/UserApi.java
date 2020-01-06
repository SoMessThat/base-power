package com.SoMessThat.sys.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.PowerDTO;
import com.SoMessThat.sys.vo.UserVo;

@RequestMapping("/user")
public interface UserApi {
	
	/**
	 * 查找所有用户
	 * @createTime: 2019/10/11 16:54:38
	 * @author: wu.kaibin
	 */
	@RequestMapping("/queryUser")
	PageVo<UserVo> queryUser(@RequestBody UserVo vo);

	/**
	 * 新增用户
	 * @createTime: 2019/10/11 16:54:38
	 * @author: wu.kaibin
	 */
	@RequestMapping("/addUser")
	int addUser(@RequestBody UserVo vo);
	
	/**
	 * 通过id查看用户信息
	 * @createTime: 2019/10/11 16:54:38
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findUserById")
	UserVo findUserById(@RequestParam("id") Long id);
	
	/**
	 * 通过id修改用户
	 * @createTime: 2019/10/11 16:54:38
	 * @author: wu.kaibin
	 */
	@RequestMapping("/updateUserById")
	int updateUserById(@RequestBody UserVo vo);
	
	/**
	 * 通过id软删除用户信息
	 * @createTime: 2019/10/11 16:54:38
	 * @author: wu.kaibin
	 */
	@RequestMapping("/delUserById")
	int delUserById(@RequestParam("id") Long id);
	
	/**
     * 给用户分配角色的角色列表（包括选择框）。
     */
    @RequestMapping("/findRoleList")
    PageVo<UserVo> findRoleList(@RequestBody UserVo user);
    
    /**
     * 修改某个用户的角色。
     */
    @RequestMapping("/updateUserRole")
    int updateUserRole(@RequestParam Map<String, String> map);
//
//	/**
//	 * 查找该角色的用户（包括选择框及搜索）。
//	 * @author: wu.kaibin
//	 */
//	@RequestMapping("/queryRolesUsers")
//	PageVo<UserVo> queryRolesUsers(@RequestBody UserVo user);
//
//	/**
//	 * 删除角色中的某个用户
//	 * @author: wu.kaibin
//	 */
//	@RequestMapping("/delRolesUser")
//	int delRolesUser(@RequestParam Map<String, String> map);
//
//	/**
//	 * 添加角色中的某个用户
//	 * @author: wu.kaibin
//	 */
//	@RequestMapping("/addRolesUser")
//	int addRolesUser(@RequestParam Map<String, String> map);
    
    /**
     * 根据角色id获取权限菜单
     * @createTime: 2019年11月18日 上午10:48:51
     * @author: wu.kaibin
     */
    @RequestMapping("/queryMenu")
    List<PowerDTO> queryMenu(@RequestParam("id") Long id);
	
}
