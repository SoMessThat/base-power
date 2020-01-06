package com.SoMessThat.sys.api;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.RightVo;
import com.SoMessThat.sys.vo.TreeVo;

@RequestMapping("/right")
public interface RightApi {
	
	/**
	 * 查找所有权限
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/queryRight")
	PageVo<RightVo> queryRight(RightVo vo);

	/**
	 * 新增权限
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/addRight")
	int addRight(@RequestBody RightVo vo);
	
	/**
	 * 通过id查看权限信息
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findRightById")
	RightVo findRightById(@RequestParam("id") Long id);
	
	/**
	 * 通过code查看权限信息
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/findRightByCode")
	RightVo findRightByCode(@RequestParam("code") String code);
	
	/**
	 * 通过id修改权限
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/updateRightById")
	int updateRightById(@RequestBody RightVo vo);
	
	/**
	 * 通过id软删除权限信息
	 * @createTime: 2019/10/11 16:51:12
	 * @author: wu.kaibin
	 */
	@RequestMapping("/delRightById")
	int delRightById(@RequestParam("id") Long id);
	
	/**
     * 给角色分配权限的权限树。
     */
    @RequestMapping("/findRightTreeByRole")
    List<RightVo> findRightTreeByRole(@RequestParam Map<String, Long> map);
    
    /**
     * 修改某个角色的权限。
     */
    @RequestMapping("/updateRoleRight")
    int updateRoleRight(@RequestParam Map<String, String> map);
    
    /**
     * 查找权限树
     * @createTime: 2019年10月16日 下午4:27:13
     * @author: wu.kaibin
     */
	@RequestMapping("/queryRightTree")
	List<TreeVo> queryRightTree();
}
