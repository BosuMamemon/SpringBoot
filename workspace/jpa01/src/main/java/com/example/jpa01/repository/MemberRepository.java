package com.example.jpa01.repository;

import com.example.jpa01.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);

    Member findByEmail(String email);

    Member findByAddress(String address);
    
//    이때 FROM절에는 테이블이 아니라 엔티티를 적어줘야함
//    :뒤부분은 패러미터임
    @Query("SELECT m FROM Member as m WHERE m.name = :name")
    Member queryExample(@RequestParam("name") String name);
}
