package com.ssm.mapper;

import com.ssm.pojo.SmallType;
import com.ssm.pojo.SmallTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmallTypeMapper {
    long countByExample(SmallTypeExample example);

    int deleteByExample(SmallTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmallType smallType);

    int insertSelective(SmallType record);

    List<SmallType> selectByBid(int bid);

    SmallType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SmallType record, @Param("example") SmallTypeExample example);

    int updateByExample(@Param("record") SmallType record, @Param("example") SmallTypeExample example);

    int updateByPrimaryKeySelective(SmallType record);

    int updateByPrimaryKey(SmallType record);

	List<SmallType> selectAll();
}