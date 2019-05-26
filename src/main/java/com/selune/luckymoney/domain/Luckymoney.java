package com.selune.luckymoney.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 * @Author: Selune
 * @Date: 2019/5/23 23:45
 */

@Entity
public class Luckymoney {

    @Id
    @GeneratedValue
    private Integer id;

    @Min(value = 0, message = "金额不正确")
    @Max(value = 200, message = "金额超出最大值")
    private BigDecimal money;

    /** 发送方 */
    private String producer;

    /** 接收方 */
    private String consumer;

    public Luckymoney() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer;
    }
}
