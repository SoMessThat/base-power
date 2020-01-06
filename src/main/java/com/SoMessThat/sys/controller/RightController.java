package com.SoMessThat.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SoMessThat.sys.api.RightApi;
import com.SoMessThat.sys.service.RightService;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.PageVo;
import com.SoMessThat.sys.vo.RightVo;
import com.SoMessThat.sys.vo.TreeVo;

@RestController
public class RightController implements RightApi {
	
	@Autowired
	RightService rightService;
	
	@Override
	public PageVo<RightVo> queryRight(RightVo vo){
		List<RightVo> list = rightService.queryRight(vo);
		return BeanUtil.page(list);	
	}

	@Override
	public int addRight(@RequestBody RightVo vo){
		return rightService.addRight(vo);
	}
	
	@Override
	public RightVo findRightById(@RequestParam Long id){
		return rightService.findRightById(id);
	}
	
	@Override
	public RightVo findRightByCode(@RequestParam String code){
		return rightService.findRightByCode(code);
	}
	
	@Override
	public int updateRightById(@RequestBody RightVo vo){
		return rightService.updateRightById(vo);
	}
	
	@Override
	public int delRightById(@RequestParam("id") Long id){
		return rightService.delRightById(id);
	}

	@Override
    public List<RightVo> findRightTreeByRole(@RequestParam Map<String, Long> map) {
        return rightService.findRightTreeByRole(map);
    }

    @Override
    public int updateRoleRight(@RequestParam Map<String, String> map) {
    	if (ObjectUtils.isEmpty(map.get("roleId"))) {			
			return 0;
		}
		if (!(ObjectUtils.isEmpty(map.get("delRightIds")) || ObjectUtils.isEmpty(map.get("addRightIds")))) {
			return 0;
		}
        return rightService.updateRoleRight(map);
    }

	@Override
	public List<TreeVo> queryRightTree() {
		return rightService.queryRightTree();
	}
	
}
