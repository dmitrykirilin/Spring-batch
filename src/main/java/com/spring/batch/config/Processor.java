package com.spring.batch.config;

import com.spring.batch.model.Department;
import com.spring.batch.model.User;
import org.springframework.stereotype.Component;

import org.springframework.batch.item.ItemProcessor;

import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<User, User> {

    private final static Map<String, String> depsNames= new HashMap<String, String>(){{
        put("001", Department.values()[0].name());
        put("002", Department.values()[1].name());
        put("003", Department.values()[2].name());
    }};

    @Override
    public User process(User user) throws Exception {

        user.setDept(depsNames.get(user.getDept()));
        System.out.println(String.format("Convert to [%s]", user.getDept()));
        return user;
    }
}
