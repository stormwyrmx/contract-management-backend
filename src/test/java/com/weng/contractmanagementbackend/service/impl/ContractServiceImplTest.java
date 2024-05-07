package com.weng.contractmanagementbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weng.contractmanagementbackend.mapper.ContractMapper;
import com.weng.contractmanagementbackend.model.domain.Contract;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContractServiceImplTest {
    @Resource
    private ContractMapper contractMapper;

    @Test
    public void testSql(){
        LambdaQueryWrapper<Contract>contractLambdaQueryWrapper=new LambdaQueryWrapper<>();
        List<Contract> contractList = contractMapper.selectList(contractLambdaQueryWrapper);
        System.out.println(contractList);
    }

}