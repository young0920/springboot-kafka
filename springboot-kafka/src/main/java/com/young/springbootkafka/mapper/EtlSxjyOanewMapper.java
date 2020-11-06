package com.young.springbootkafka.mapper;

import com.young.springbootkafka.pojo.EtlSxjyOanew;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * EtlSxjyOanewMapper
 * @author  yangbing
 * @date  2020/11/4 10:27 上午
 */
@Mapper
public interface EtlSxjyOanewMapper {
    int deleteByPrimaryKey(String id);

    int insert(EtlSxjyOanew record);

    int insertSelective(EtlSxjyOanew record);

    EtlSxjyOanew selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EtlSxjyOanew record);

    int updateByPrimaryKey(EtlSxjyOanew record);

    int updateBatch(List<EtlSxjyOanew> list);

    int updateBatchSelective(List<EtlSxjyOanew> list);

    int batchInsert(@Param("list") List<EtlSxjyOanew> list);
}