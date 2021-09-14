package com.fastcampus.jpa.FastCampusJPA02.repository;

import com.fastcampus.jpa.FastCampusJPA02.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

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
        //User user = userRepository.findById(1L).orElse(null);
        //orElse를 붙혀야지 객체 형식으로 받을수가 있다.
        //System.out.println(user);
        /*
        userRepository.saveAndFlush(new User("new martin","newmartine@fastcampus.com"));
        userRepository.findAll().forEach(System.out::println);
        */
        /*
        long count = userRepository.count();
        System.out.println(count);
         */
        /*
        boolean flag = userRepository.existsById(1L);
        System.out.println(flag);
         */
        //userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
        //userRepository.deleteById(1L);
        //userRepository.deleteAll();
        //userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        //userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
        //userRepository.deleteAllInBatch();
        /*
        Page<User> users = userRepository.findAll(PageRequest.of(1,3));//0이 1페이지 이다.
        System.out.println("page : "+users);
        System.out.println("totalElements : " + users.getTotalElements());//몇개인지
        System.out.println("totalPages : "+users.getTotalPages());//전체 페이지 수
        System.out.println("numberOfElements : "+users.getNumberOfElements());
        System.out.println("sort : " + users.getSort());
        System.out.println("size : " + users.getSize());
        users.getContent().forEach(System.out::println);
         */
        /*
        ExampleMatcher matcher = ExampleMatcher.matching() //Matcher를 통해 제외, 포함 시킬 속성을 지정할수 있고
                .withIgnorePaths("name") //name은 제외
                .withMatcher("email",endsWith());//fastcampus로 끝나는 이메일로 조회
        Example<User> example = Example.of(new User("ma","fastcampus.com"),matcher);//Example로 실행 시킬수 있다.
        userRepository.findAll(example).forEach(System.out::println);
        */
        /*
        User user = new User();
        user.setEmail("slow");

        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("email",contains());
        Example<User> example = Example.of(user,matcher);
        userRepository.findAll(example).forEach(System.out::println);
         */
        userRepository.save(new User("david","david@fastcampus.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@fastcampus.com");

        userRepository.save(user);


    }

    @Test
    void select(){
        //System.out.println(userRepository.findByName("martin"));
        //martin 레코드가 2개가 나오기 때문에 List<User>타입으로 받아야 된다.
        System.out.println(userRepository.findByName("dennis"));

        System.out.println("findByEmail : " + userRepository.findByEmail("martin"));
        System.out.println("getByEmail : " + userRepository.getByEmail("martin"));
        System.out.println("readByEmail : " + userRepository.readByEmail("martin"));
        System.out.println("queryByEmail : " + userRepository.queryByEmail("martin"));
        System.out.println("searchByEmail : " + userRepository.searchByEmail("martin"));
        System.out.println("streamByEmail : " + userRepository.streamByEmail("martin"));
        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin"));

        //잘못된 표기
        //System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin"));
        //System.out.println("findByByEmail : " + userRepository.findByByEmail("martin"));

        System.out.println("findFirstByName : " + userRepository.findFirst2ByName("martin"));
        System.out.println("findTopByName : " + userRepository.findTop2ByName("martin"));

        System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
        //존재하지 않는 키워드가 있을경우에는 무시해서 find와 동일하게 동작된다.


        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@fastCampus.com","martin"));
        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@fastCampus.com","denis"));

        System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));

        System.out.println("findByCreatedAtGreaterThen : " + userRepository.findByCreatedAtGreaterThen(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThenEqual : " + userRepository.findByCreatedAtGreaterThenEqual(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L),LocalDateTime.now().plusDays(1L)));
        System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L,3L));

        System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L,3L));

    }

}