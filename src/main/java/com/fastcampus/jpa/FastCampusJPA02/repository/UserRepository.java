package com.fastcampus.jpa.FastCampusJPA02.repository;

import com.fastcampus.jpa.FastCampusJPA02.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
//Spring JPA 라이브러리가 지원해 주는 영역
//JpaRepository 를상속받는 것만으로 많은 메소드를 사용할수가 있다.
//<엔티티 타입, PK> 값을 넣어 주면 된다.
public interface UserRepository extends JpaRepository<User,Long> {
    
}
