package com.weng.contractmanagementbackend.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ContractUpdateRequest(

        @NotNull
        @Min(value = 1, message = "id不能小于1")
        Long id,

        @NotBlank(message = "合同名称不能为空")
        String name,

        @NotBlank(message = "签署方不能为空")
        String signatory,

        @NotNull
        //这里要使用@JsonFormat注解，不能用@DateTimeFormat
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate signatureTime,

        @NotNull
        @Min(value = 0, message = "状态不能小于0")
        @Max(value = 1, message = "状态不能大于1")
        Integer status
) {
}
