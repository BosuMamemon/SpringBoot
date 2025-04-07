package com.example.jpa01.repository;

import com.example.jpa01.domain.Board;
import com.example.jpa01.domain.Item;
import com.example.jpa01.domain.ItemSellStatus;
import com.example.jpa01.domain.Member;
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
public class TestRepository {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testFindByName() {
        Member member = memberRepository.findByName("admin");
        log.info(member);
    }

    @Test
    public void testFindByEmail() {
        Member member = memberRepository.findByEmail("zxczxc");
        log.info(member);
    }

    @Test
    public void testQueryExample() {
        Member member = memberRepository.queryExample("zxczxc");
        log.info(member);
    }

    @Test
    public void testDatasource() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info(connection);
    }

    @Test
    public void testMemberInsert() throws SQLException {
        Member member = new Member();
        member.setAddress("admin");
        member.setName("admin");
        member.setPassword("admin");
        member.setEmail("admin");
        memberRepository.save(member);
    }

    @Test
    public void testMemberFindAll() throws SQLException {
        List<Member> members = memberRepository.findAll();
        for(int i = 0; i < members.size(); i++) {
            log.info(members.get(i));
        }
    }

    @Test
    public void testMemberFindById() throws SQLException {
        Member member = memberRepository.findById(1L).get();    // id의 자료형이 Long이라서 1L라고 써줘야함
        log.info(member);
    }

    @Test
    public void testMemberUpdate() throws SQLException {
        Member member = memberRepository.findById(1L).get();
        member.setName("test");
        member.setEmail("test@test");
        member.setAddress("test");
        member.setPassword("test");
        memberRepository.save(member);
    }

    @Test
    public void testMemberDelete() throws SQLException {
        memberRepository.deleteById(2L);
    }

    @Test
    public void testItemInsert() throws SQLException {
        Item item = Item.builder()
                .itemName("바보11")
                .itemDetail("우하하")
                .itemSellStatus(ItemSellStatus.입고대기)
                .build();
        itemRepository.save(item);
    }

    @Test
    public void testItemFindAll() throws SQLException {
        List<Item> items = itemRepository.findAll();
        for(int i = 0; i < items.size(); i++) {
            log.info(items.get(i));
        }
    }

    @Test
    public void testItemFindById() throws SQLException {
        Item item = itemRepository.findById(1L).get();
        log.info(item);
    }

    @Test
    public void testItemUpdate() throws SQLException {
        Item item = itemRepository.findById(1L).get();
        item.setItemName("사과사과");
        itemRepository.save(item);
    }

    @Test
    public void TestBoardInsert() {
        Board board = new Board();
        board.setTitle("test");
        board.setContent("test");
        board.setAuthor("test");
        boardRepository.save(board);
    }
}
