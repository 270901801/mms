package com.ssm.mapper;

import com.ssm.pojo.Input;
import com.ssm.pojo.Output;
import com.ssm.pojo.OutputExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface OutputMapper {
    long countByExample(OutputExample example);

    int deleteByExample(OutputExample example);

    int deleteByPrimaryKey(Integer oid);

    int insert(Output record);

    int insertSelective(Output record);

    List<Output> selectByExample(OutputExample example);

    Output selectByPrimaryKey(Integer oid);

    int updateByExampleSelective(@Param("record") Output record, @Param("example") OutputExample example);

    int updateByExample(@Param("record") Output record, @Param("example") OutputExample example);

    int updateByPrimaryKeySelective(Output record);

    int updateByPrimaryKey(Output record);

	List<Output> selectAll();

	<T> List<Output> selectByKeyword(Map<String, T> map);

	List<Output> selectByGroupName();
}