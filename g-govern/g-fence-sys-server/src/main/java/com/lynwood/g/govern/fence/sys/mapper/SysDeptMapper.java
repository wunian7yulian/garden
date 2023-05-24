package com.lynwood.g.govern.fence.sys.mapper;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysDeptExtDTO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.lynwood.g.govern.fence.sys.pojo.entity.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wunian7yulian
* @description 针对表【sys_dept(部门表)】的数据库操作Mapper
* @createDate 2023-05-24 10:41:39
* @Entity com.lynwood.g.govern.fence.sys.pojo.entity.SysDept
*/
public interface SysDeptMapper extends BaseMapper<SysDept> {


    List<SysDeptExtDTO> selectByFId(@Param("fId") Long fId);

}




