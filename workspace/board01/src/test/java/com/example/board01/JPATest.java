package com.example.board01;

import com.example.board01.dto.MemberDTO;
import com.example.board01.repository.MemberRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class JPATest {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info(connection);
    }

    @Test
    public void testMemberInsert() throws SQLException {
        MemberDTO member = new MemberDTO();
        member.setAddress("a");
        member.setName("a");
        member.setEmail("a@a");
        member.setPassword("a");
        memberRepository.save(member);
    }

    @Test
    public void testMemberFindAll() throws SQLException {
         List<MemberDTO> list = memberRepository.findAll();
         for(MemberDTO member : list) {
             log.info(member);
         }
    }

    @Test
    public void testMemberFindById() throws SQLException {
        MemberDTO member = memberRepository.findById(1L).get();
        log.info(member);
    }

    @Test
    public void testMemberUpdate() throws SQLException {
        MemberDTO member = memberRepository.findById(1L).get();
        member.setName("1");
        member.setPassword("1");
        member.setAddress("1");
        member.setEmail("1@1");
        memberRepository.save(member);
    }

    @Test
    public void testMemberDelete() throws SQLException {
        memberRepository.deleteById(2L);
    }
}
