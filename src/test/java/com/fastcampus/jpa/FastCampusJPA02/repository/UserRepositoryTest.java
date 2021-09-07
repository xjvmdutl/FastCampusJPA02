package com.fastcampus.jpa.FastCampusJPA02.repository;

import com.fastcampus.jpa.FastCampusJPA02.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Test
    @Transactional// 세션을 유지 시켜 준다
    void crud(){//create,read,update,delete
        /*
        userRepository.save(new User());//c(테이블에 저장)
        userRepository.findAll().forEach(System.out::println);
        */
        //System.out.println();//userTable 에 모든 데이터를 list 형식으로 가지고 온다
        /*
        for(User user : userRepository.findAll()){
            System.out.println(user);
        }
        */
        //List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        //이름을 기준으로 역순으로 정렬 된다.
        //List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));
        //ID List 로 가지고 온다
        //users.forEach(System.out::println);

        /*
        User user1 = new User("jack","jack@fastcampus.com");
        User user2 = new User("steve","steve@fastcampus.com");
        //userRepository.saveAll(Lists.newArrayList(user1,user2));
        //여러 데이터를 한번에 저장
        userRepository.save(user1);
        //한개만 저장
        List<User> users=userRepository.findAll();
        users.forEach(System.out::println);
        */
        /*
        User user = userRepository.getOne(1L);
        //오류 발생
        //세션이 존재해서 proxy 를 생성할수 없다->@transactional 를 선언해야 된다.
        System.out.println(user);
        */
        //Optional<User> user = userRepository.findById(1L);
        User user = userRepository.findById(1L).orElse(null);
        //orElse를 붙혀야지 객체 형식으로 받을수가 있다.
        System.out.println(user);
    }
}