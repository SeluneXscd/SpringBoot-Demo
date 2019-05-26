package com.selune.luckymoney.controller;

import com.selune.luckymoney.domain.Luckymoney;
import com.selune.luckymoney.domain.Result;
import com.selune.luckymoney.repository.LuckymoneyRepository;
import com.selune.luckymoney.service.LuckymoneyService;
import com.selune.luckymoney.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @Author: Selune
 * @Date: 2019/5/23 23:52
 */

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /**
     * 获取红包列表
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * 创建红包
     * @Valid 表单验证
     */
    @PostMapping("/luckymoneys")
    public Result<Luckymoney> create(@Valid Luckymoney luckymoney, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.fail(1, bindingResult.getFieldError().getDefaultMessage());
        }
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());

        return ResultUtils.success(repository.save(luckymoney));
    }

    /**
     * 通过id查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        // 查询内容
        Optional<Luckymoney> optionalLuckymoney = repository.findById(id);
        // 如果有内容, 就设置consumer
        if (optionalLuckymoney.isPresent()) {
            Luckymoney luckymoney = optionalLuckymoney.get();
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
        // 否则返回空
        return null;
    }

    @PostMapping("/luckymoneys/two")
    public void createTwo() {
        service.createTwo();
    }

}
