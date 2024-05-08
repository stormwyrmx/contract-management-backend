package com.weng.contractmanagementbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weng.contractmanagementbackend.mapper.ContractMapper;
import com.weng.contractmanagementbackend.model.domain.Contract;
import com.weng.contractmanagementbackend.model.dto.ContractAddRequest;
import com.weng.contractmanagementbackend.model.dto.ContractPageRequest;
import com.weng.contractmanagementbackend.model.dto.ContractUpdateRequest;
import com.weng.contractmanagementbackend.model.vo.ContractVO;
import com.weng.contractmanagementbackend.service.ContractService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author weng
* @description 针对表【contract(合同表)】的数据库操作Service实现
* @createDate 2024-05-07 18:57:50
*/
@Service
@RequiredArgsConstructor
public class ContractServiceImpl extends ServiceImpl<ContractMapper, Contract>
    implements ContractService {

    private final ContractMapper contractMapper;

    @Override
    public Page<ContractVO> listContractByPage(ContractPageRequest contractPageRequest) {
        Integer status = contractPageRequest.status();
        Page<Contract>contractPage=new Page<>(contractPageRequest.current(),contractPageRequest.size());
        //根据状态是未完成还是已完成来查询，并按时间排序
        LambdaQueryWrapper<Contract>contractLambdaQueryWrapper=new LambdaQueryWrapper<>();
        contractLambdaQueryWrapper.eq(status!=null,Contract::getStatus,status);
        contractLambdaQueryWrapper.orderByDesc(Contract::getCreateTime);
        contractMapper.selectPage(contractPage,contractLambdaQueryWrapper);
        List<ContractVO> contractVOList = contractPage.getRecords().stream().map(contract -> ContractVO.builder()
                .id(contract.getId())
                .name(contract.getName())
                .signatory(contract.getSignatory())
                .signatureTime(contract.getSignatureTime())
                .status(contract.getStatus())
                .build()).toList();
        Page<ContractVO>contractVOPage=new Page<>(contractPage.getCurrent(),contractPage.getSize(),contractPage.getTotal());
        contractVOPage.setRecords(contractVOList);
        return contractVOPage;
    }

    @Override
    public void addContract(ContractAddRequest contractAddRequest) {
        Contract contract = Contract.builder()
                .name(contractAddRequest.name())
                .signatory(contractAddRequest.signatory())
                .signatureTime(contractAddRequest.signatureTime())
                .build();
        contractMapper.insert(contract);
    }

    @Override
    public void updateContractById(ContractUpdateRequest contractUpdateRequest) {
        Contract contract = Contract.builder()
                .id(contractUpdateRequest.id())
                .name(contractUpdateRequest.name())
                .signatory(contractUpdateRequest.signatory())
                .signatureTime(contractUpdateRequest.signatureTime())
                .status(contractUpdateRequest.status())
                .build();
        contractMapper.updateById(contract);
    }

    @Override
    public void finishContract(Long id) {
        Contract contract = contractMapper.selectById(id);
        contract.setStatus(1);
        contractMapper.updateById(contract);
    }

}




