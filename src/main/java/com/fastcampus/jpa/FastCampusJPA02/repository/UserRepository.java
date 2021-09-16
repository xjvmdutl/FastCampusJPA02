package com.fastcampus.jpa.FastCampusJPA02.repository;

import com.fastcampus.jpa.FastCampusJPA02.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

//Spring JPA 라이브러리가 지원해 주는 영역
//JpaRepository 를상속받는 것만으로 많은 메소드를 사용할수가 있다.
//<엔티티 타입, PK> 값을 넣어 주면 된다.
public interface UserRepository extends JpaRepository<User,Long> {
    Set<User> findByName(String name);//이름을 통해 가지고 온다.

    //모두 위의 코드와 동일하게 동작한다.
    Set<User> findUserByNameIs(String name);
    Set<User> findUserByName(String name);
    Set<User> findUserByNameEquals(String name);

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

    List<User> findByIdIsNotNull();

    //List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> names);//매개변수로 Iterator 타입이 들어가야된다.

    List<User> findByNameStartingWith(String name);
    List<User> findByNameEndingWith(String name);
    List<User> findByNameContains(String name);

    List<User> findByNameLike(String name);


    List<User> findTop1ByName(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);

    //ID는 역순 Email은 정순으로 정렬하여 출력
    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    Page<User> findByName(String name, Pageable pageable);


    @Query(value = "select * from user limit 1",nativeQuery = true)
    Map<String,Object> findRowRecord();
}
