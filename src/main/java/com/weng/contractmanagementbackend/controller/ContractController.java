package com.weng.contractmanagementbackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.weng.contractmanagementbackend.common.Result;
import com.weng.contractmanagementbackend.model.domain.Contract;
import com.weng.contractmanagementbackend.model.dto.ContractAddRequest;
import com.weng.contractmanagementbackend.model.dto.ContractPageRequest;
import com.weng.contractmanagementbackend.model.dto.ContractUpdateRequest;
import com.weng.contractmanagementbackend.model.vo.ContractVO;
import com.weng.contractmanagementbackend.service.ContractService;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contract")
@Slf4j
@Validated
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/page")
    public Result<Page<ContractVO>> listContractByPage(@RequestBody @Validated ContractPageRequest contractPageRequest){
        Page<ContractVO> contractVOPage = contractService.listContractByPage(contractPageRequest);
        return Result.success(contractVOPage);
    }

    @PostMapping
    public Result<Boolean> addContract(@RequestBody @Validated ContractAddRequest contractAddRequest){
        contractService.addContract(contractAddRequest);
        return Result.success(true);
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteContract(@Min (value = 1,message = "id必须大于1")@PathVariable Long id){
        contractService.removeById(id);
        return Result.success(true);
    }

    @GetMapping("/{id}")
    public Result<ContractVO> getContractById(@Min(value = 1,message = "id必须大于1") @PathVariable Long id){
        Contract contract = contractService.getById(id);
        ContractVO contractVO = ContractVO.builder()
                .id(contract.getId())
                .name(contract.getName())
                .signatory(contract.getSignatory())
                .signatureTime(contract.getSignatureTime())
                .status(contract.getStatus())
                .build();
        return Result.success(contractVO);
    }

    @PutMapping
    public Result<Boolean> updateContract(@RequestBody @Validated ContractUpdateRequest contractUpdateRequest){
        contractService.updateContractById(contractUpdateRequest);
        return Result.success(true);
    }


}
