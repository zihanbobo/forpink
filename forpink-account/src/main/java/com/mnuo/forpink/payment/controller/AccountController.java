package com.mnuo.forpink.payment.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mnuo.forpink.account.pojo.Balance;
import com.mnuo.forpink.payment.pojo.User;
import com.mnuo.forpink.payment.service.BalanceService;

@RestController
public class AccountController {
 
    @SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	final static Map<Integer, User> userMap = new HashMap() {{
            put(1, new User(1, "张三"));
            put(2, new User(2, "李四"));
            put(3, new User(3, "王五"));
        }
    };
 
    @Autowired
    BalanceService balanceService;
    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            return user;
        }
        return new User(0, "");
    }
    @RequestMapping("/acc/balance")
    public Balance balance(@RequestParam Integer id) {
    	return balanceService.getBalance(321123);
    }
}
