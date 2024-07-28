package com.example.nestjs.dto;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateOrderBody {
    @NotNull(message = "产品ID不能为空")
    @NotBlank(message = "产品ID不能为空")
    private String productId;
    @NotNull(message = "用户ID不能为空")
    @NotBlank(message = "用户ID不能为空")
    private String userId;
    @NotNull(message = "购买量不能为空")
    private Integer quantity;

}
