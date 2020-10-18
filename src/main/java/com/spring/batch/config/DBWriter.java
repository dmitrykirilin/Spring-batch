package com.spring.batch.config;

import com.spring.batch.model.User;
import com.spring.batch.repo.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void write(List<? extends User> list) throws Exception {

        System.out.println("Data saved into users: " + list);
        userRepository.saveAll(list);
    }
}
