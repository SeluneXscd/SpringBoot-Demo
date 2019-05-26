package com.selune.luckymoney.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Null;
import java.math.BigDecimal;

/**
 * @Author: Selune
 * @Date: 2019/5/23 23:45
 */

@Entity
@Data
public class Luckymoney {

    @Id
    @GeneratedValue
    private Integer id;

    @Null(message = "金额必填")
    @Min(value = 0, message = "金额不正确")
    @Max(value = 200, message = "金额超出最大值")
    private BigDecimal money;

    /** 发送方 */
    private String producer;

    /** 接收方 */
    private String consumer;

    public Luckymoney() {
    }

}
