package com.fastcampus.jpa.FastCampusJPA02.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity//엔티티에는 PK값이 반드시 필요하다
public class User {
    @Id//primary키
    @GeneratedValue(strategy = GenerationType.IDENTITY)//순차적 증가
    private Long id;

    @NonNull
    private String name;
    @NonNull//이메일과 이름은 필수값이 된다.
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    //@OneToMany(fetch = FetchType.EAGER)//일 대 다
    //private List<Address> address;
}
