package com.weng.contractmanagementbackend.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record ContractVO(

        Long id,

        String name,

        String signatory,

        //这里要使用@JsonFormat注解，不能用@DateTimeFormat
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate signatureTime,

        Integer status
) {
}
