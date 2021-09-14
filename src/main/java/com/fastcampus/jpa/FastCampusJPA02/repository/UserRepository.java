package com.fastcampus.jpa.FastCampusJPA02.repository;

import com.fastcampus.jpa.FastCampusJPA02.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

//Spring JPA 라이브러리가 지원해 주는 영역
//JpaRepository 를상속받는 것만으로 많은 메소드를 사용할수가 있다.
//<엔티티 타입, PK> 값을 넣어 주면 된다.
public interface UserRepository extends JpaRepository<User,Long> {
    Set<User> findByName(String name);//이름을 통해 가지고 온다.

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    //User findSomethingByEmail(String email);
    //User findByByEmail(String email);

    List<User> findFirst2ByName(String name);
    List<User> findTop2ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findByEmailAndName(String email,String name);

    List<User> findByEmailOrName(String email,String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThen(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThenEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1,Long id2);

    List<User> findByIdGreaterThanEqualAndIdLessThanEqual(Long id1,Long id2);
}
