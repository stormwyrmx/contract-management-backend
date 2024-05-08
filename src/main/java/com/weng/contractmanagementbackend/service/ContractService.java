package com.weng.contractmanagementbackend.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weng.contractmanagementbackend.model.domain.Contract;
import com.weng.contractmanagementbackend.model.dto.ContractAddRequest;
import com.weng.contractmanagementbackend.model.dto.ContractPageRequest;
import com.weng.contractmanagementbackend.model.dto.ContractUpdateRequest;
import com.weng.contractmanagementbackend.model.vo.ContractVO;

/**
* @author weng
* @description 针对表【contract(合同表)】的数据库操作Service
* @createDate 2024-05-07 18:57:50
*/
public interface ContractService extends IService<Contract> {

    Page<ContractVO> listContractByPage(ContractPageRequest contractPageRequest);

    void addContract(ContractAddRequest contractAddRequest);

    void updateContractById(ContractUpdateRequest contractUpdateRequest);

    void finishContract(Long id);
}
