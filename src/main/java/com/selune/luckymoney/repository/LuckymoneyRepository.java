package com.selune.luckymoney.repository;

import com.selune.luckymoney.pojo.Luckymoney;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Selune
 * @Date: 2019/5/23 23:54
 */

public interface LuckymoneyRepository extends JpaRepository<Luckymoney, Integer> {

}
