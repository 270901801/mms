package com.ssm.mapper;

import com.ssm.pojo.BigType;
import com.ssm.pojo.BigTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BigTypeMapper {
    long countByExample(BigTypeExample example);

    int deleteByExample(BigTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BigType record);

    int insertSelective(BigType record);

    List<BigType> selectByExample(BigTypeExample example);

    BigType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BigType record, @Param("example") BigTypeExample example);

    int updateByExample(@Param("record") BigType record, @Param("example") BigTypeExample example);

    int updateByPrimaryKeySelective(BigType record);

    int updateByPrimaryKey(BigType record);
}