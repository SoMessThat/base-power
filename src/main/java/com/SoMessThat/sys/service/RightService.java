package com.SoMessThat.sys.service;

import java.util.List;
import java.util.Map;

import com.SoMessThat.sys.vo.RightVo;
import com.SoMessThat.sys.vo.TreeVo;

public interface RightService {
	
	/**
	 * 查找所有XXXXX
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	List<RightVo> queryRight(RightVo vo);

	/**
	 * 新增XXXXX
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	int addRight(RightVo vo);
	
	/**
	 * 通过id查看XXXXX信息
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	RightVo findRightById(Long id);
	
	/**
	 * 通过code查看XXXXX信息
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	RightVo findRightByCode(String code);
	
	/**
	 * 通过id修改XXXXX
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	int updateRightById(RightVo vo);
	
	/**
	 * 通过id软删除XXXXX信息
	 * @createTime: 2019/10/11 16:51:32
	 * @author: wu.kaibin
	 */
	int delRightById(Long id);

	/**
	 * 给角色分配权限的权限树。
	 * @createTime: 2019年10月12日 下午3:11:20
	 * @author: wu.kaibin
	 */
	List<RightVo> findRightTreeByRole(Map<String, Long> map);

	/**
	 * 修改某个角色的权限。
	 * @createTime: 2019年10月12日 下午3:11:32
	 * @author: wu.kaibin
	 */
	int updateRoleRight(Map<String, String> map);
	
	/**
     * 查找权限树
     * @createTime: 2019年10月16日 下午4:27:13
     * @author: wu.kaibin
     */
	List<TreeVo> queryRightTree();

}
