package org.pgm.jpaboard.service;

import lombok.extern.log4j.Log4j2;
import org.pgm.jpaboard.domain.BoardEntity;
import org.pgm.jpaboard.dto.BoardDTO;
import org.pgm.jpaboard.dto.PageRequestDTO;
import org.pgm.jpaboard.dto.PageResponseDTO;
import org.pgm.jpaboard.repository.BoardRepository;
import org.pgm.jpaboard.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public void registerBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = dtoToEntity(boardDTO);
        log.info(boardEntity.getImageSet().size());
        boardRepository.save(boardEntity);
    }

    @Override
    public BoardDTO readBoard(Long bno) {
        BoardEntity boardEntity=boardRepository.findByIdWithImages(bno)
                .orElse(null);
        boardEntity.updateReadcount();
        boardRepository.save(boardEntity);
        return entityToDto(boardEntity);
    }

    @Override
    public void updateBoard(BoardDTO boardDTO) {
        BoardEntity boardEntity = boardRepository.findById(boardDTO.getBno()).get();
        boardEntity.change(boardDTO.getTitle(), boardDTO.getContent());
        boardEntity.removeImage();
        if(boardDTO.getFileNames() != null) {
            for(String filename : boardDTO.getFileNames()) {
                String[] arr = filename.split("_");
                boardEntity.addImage(arr[0], arr[1]);
            }
        }
        boardRepository.save(boardEntity);
    }

    @Transactional
    @Override
    public void deleteBoard(Long bno) {
        replyRepository.deleteByBoardEntity_Bno(bno);
        boardRepository.deleteById(bno);
    }

    @Override
    public PageResponseDTO<BoardDTO> list(PageRequestDTO pageRequestDTO) {
        Pageable pageable = pageRequestDTO.getPageable("bno");
        Page<BoardEntity> result = boardRepository.searchAll(
                pageRequestDTO.getTypes(),
                pageRequestDTO.getKeyword(),
                pageable);
        List<BoardDTO> dtoList = result.stream()
                .map(boardEntity -> entityToDto(boardEntity))
                .collect(Collectors.toList());
//        위는 아래와 같음
//        List<BoardDTO> dtos = new ArrayList<>();
//        result.getContent().forEach(boardEntity -> dtos.add(entityToDto(boardEntity)));

        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total((int) result.getTotalElements())
                .build();
    }
}
