package com.fastcampus.jpa.FastCampusJPA02.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity//엔티티에는 PK값이 반드시 필요하다
public class User {
    @Id//primary키
    @GeneratedValue//순차적 증가
    private Long id;

    @NonNull
    private String name;
    @NonNull//이메일과 이름은 필수값이 된다.
    private String email;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
