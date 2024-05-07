package com.weng.contractmanagementbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weng.contractmanagementbackend.model.domain.Contract;
import org.apache.ibatis.annotations.Mapper;

/**
* @author weng
* @description 针对表【contract(合同表)】的数据库操作Mapper
* @createDate 2024-05-07 18:57:50
* @Entity generator.domain.Contract
*/
@Mapper
public interface ContractMapper extends BaseMapper<Contract> {

}




