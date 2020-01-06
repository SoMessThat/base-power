package com.SoMessThat.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.SoMessThat.sys.domain.Department;
import com.SoMessThat.sys.vo.TreeVo;
import com.SoMessThat.sys.vo.DepartmentVo;

public interface DepartmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    int insert(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    int insertSelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    Department selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_department
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Department record);

	List<DepartmentVo> queryDepartment(DepartmentVo vo);

	List<TreeVo> getDepartmentTree();

	List<TreeVo> getDepartmentSonTree(String id);

	DepartmentVo findDepartmentByCode(String code);

	int mulDelDepartmentByCode(@Param("codes") String codes);
}