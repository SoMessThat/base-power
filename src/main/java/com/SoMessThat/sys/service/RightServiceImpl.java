package com.SoMessThat.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.SoMessThat.sys.domain.Right;
import com.SoMessThat.sys.mapper.RightMapper;
import com.SoMessThat.sys.util.UUIDUtil;
import com.SoMessThat.sys.vo.BeanUtil;
import com.SoMessThat.sys.vo.RightVo;
import com.SoMessThat.sys.vo.TreeVo;

@Service
public class RightServiceImpl implements RightService {
	
	@Autowired
	RightMapper rightMapper;
	
	@Override
	public List<RightVo> queryRight(RightVo vo){
		vo.setStatus("ENABLED");
		return rightMapper.queryRight(vo);
	}

	@Override
	public int addRight(RightVo vo){
		Right po = BeanUtil.copy(vo, Right.class);
		po.setStatus("ENABLED");
		po.setUpdateTime(new Date());
		po.setCode(UUIDUtil.getNoLineSortUUID());
		return rightMapper.insertSelective(po);
	}
	
	@Override
	public RightVo findRightById(Long id){
		Right po = rightMapper.selectByPrimaryKey(id);
		return BeanUtil.copy(po, RightVo.class);
	}
	
	@Override
	public RightVo findRightByCode(String code){
		return rightMapper.findRightByCode(code);
	}
	
	@Override
	public int updateRightById(RightVo vo){
		Right po = BeanUtil.copy(vo, Right.class);
		po.setUpdateTime(new Date());
		return rightMapper.updateByPrimaryKeySelective(po);
	}
	
	@Override
	public int delRightById(Long id){
		Right po = new Right();
		po.setId(id);
		po.setStatus("DISABLED");
		po.setUpdateTime(new Date());
		return rightMapper.updateByPrimaryKeySelective(po);
	}

	@Override
    public List<RightVo> findRightTreeByRole(Map<String, Long> map) {
        List<RightVo> rightTreeByRole = rightMapper.findRightTreeByRole(map);
        return rightTreeByRole;
    }

    @Override
    public int updateRoleRight(Map<String, String> map) {
    	int num = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("roleId", map.get("roleId"));
		if (!ObjectUtils.isEmpty(map.get("delRightIds"))) {		
			param.put("rightIds", "(" + map.get("delRightIds") + ")");
			num += rightMapper.delRightIds(param);
		}
		if (!ObjectUtils.isEmpty(map.get("addRightIds"))) {
			param.put("rightIds", map.get("addRightIds").split(","));
			num += rightMapper.addRightIds(param);
		}
		return num;
    }

	@Override
	public List<TreeVo> queryRightTree() {
		return rightMapper.queryRightTree();
	}
	
}
