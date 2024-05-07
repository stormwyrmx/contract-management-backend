package com.weng.contractmanagementbackend.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

public record ContractPageRequest(
        @NotNull(message = "当前页不能为空")
        @Min(value = 1,message = "当前页不能小于1")
        Integer current,

        @NotNull(message = "每页条数不能为空")
        @Min(value = 1,message = "每页条数不能小于1")
        Integer size,

        @Min(value = 0, message = "状态不能小于0")
        @Max(value = 1, message = "状态不能大于1")
        Integer status
) {
}
