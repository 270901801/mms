package com.ssm.mapper;

import com.ssm.pojo.Admin;
import com.ssm.pojo.Input;
import com.ssm.pojo.InputExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InputMapper {
    long countByExample(InputExample example);

    int deleteByExample(InputExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Input record);

    int insertSelective(Input record);

    List<Input> selectByExample(InputExample example);

    Input selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Input record, @Param("example") InputExample example);

    int updateByExample(@Param("record") Input record, @Param("example") InputExample example);

    int updateByPrimaryKeySelective(Input record);

    int updateByPrimaryKey(Input record);

	List<Input> selectAll();

	<T> List<Input> selectByKeyword(Map<String, T> map);

	List<Input> selectByGroupName();

}