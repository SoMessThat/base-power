package com.SoMessThat.sys.service;

import java.util.List;
import java.util.Map;

import com.SoMessThat.sys.vo.PowerDTO;
import com.SoMessThat.sys.vo.UserVo;

public interface UserService {
	
	/**
	 * 查找所有XXXXX
	 * @createTime: 2019/10/11 16:55:43
	 * @author: wu.kaibin
	 */
	List<UserVo> queryUser(UserVo vo);

	/**
	 * 新增XXXXX
	 * @createTime: 2019/10/11 16:55:43
	 * @author: wu.kaibin
	 */
	int addUser(UserVo vo);
	
	/**
	 * 通过id查看XXXXX信息
	 * @createTime: 2019/10/11 16:55:43
	 * @author: wu.kaibin
	 */
	UserVo findUserById(Long id);
	
	/**
	 * 通过id修改XXXXX
	 * @createTime: 2019/10/11 16:55:43
	 * @author: wu.kaibin
	 */
	int updateUserById(UserVo vo);
	
	/**
	 * 通过id软删除XXXXX信息
	 * @createTime: 2019/10/11 16:55:43
	 * @author: wu.kaibin
	 */
	int delUserById(Long id);
	/**
     * 给用户分配角色的角色列表（包括选择框）。
     */
	List<UserVo> findRoleList(UserVo user);

	/**
	 * 修改某个用户的角色。
	 * @createTime: 2019年10月24日 上午10:14:22
	 * @author: wu.kaibin
	 */
	int updateUserRole(Map<String, String> map);
	
	/**
     * 根据角色id获取权限菜单
     * @createTime: 2019年11月18日 上午10:48:51
     * @author: wu.kaibin
     */
	List<PowerDTO> queryMenu(Long id);
}
