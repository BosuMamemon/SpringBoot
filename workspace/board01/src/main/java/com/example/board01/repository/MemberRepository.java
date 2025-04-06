package com.example.board01.repository;

import com.example.board01.dto.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberDTO, Long> {

}
