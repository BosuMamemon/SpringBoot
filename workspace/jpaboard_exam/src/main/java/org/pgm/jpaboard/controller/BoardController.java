package org.pgm.jpaboard.controller;

import groovy.util.logging.Log4j2;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.pgm.jpaboard.dto.BoardDTO;
import org.pgm.jpaboard.dto.PageRequestDTO;
import org.pgm.jpaboard.dto.PageResponseDTO;
import org.pgm.jpaboard.service.BoardService;
import org.pgm.jpaboard.upload.UploadFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Slf4j
@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Value("${org.pgm.jpaboard.upload.path}")
    private String uploadPath;

    @GetMapping("/list")
    public void listBoard(PageRequestDTO pageRequestDTO,Model model) {
        PageResponseDTO<BoardDTO> responseDTO = boardService.list(pageRequestDTO);
        model.addAttribute("responseDTO", responseDTO);
        model.addAttribute("pageRequest", pageRequestDTO);
    }

    @GetMapping("/register")
    public void register(){
    }

    @PostMapping("/register")
    public String register(BoardDTO boardDTO, UploadFileDTO uploadFileDTO) {
        List<String> strFileNames = null;
        if(uploadFileDTO.getFiles() != null && !uploadFileDTO.getFiles().get(0).getOriginalFilename().isEmpty()) {
            strFileNames = fileUpload(uploadFileDTO);
        }
        boardDTO.setFileNames(strFileNames);
        boardService.registerBoard(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read","/modify"})
    public void read_modify(PageRequestDTO pageRequestDTO, Long bno, Model model) {
        BoardDTO boardDTO = boardService.readBoard(bno);
        model.addAttribute("board", boardDTO);
    }

    @PostMapping("/modify")
    public String modify(UploadFileDTO uploadFileDTO, BoardDTO boardDTO, Model model) {
        List<String> strFileNames = null;
        if(uploadFileDTO.getFiles() != null && !uploadFileDTO.getFiles().get(0).getOriginalFilename().isEmpty()) {
            BoardDTO realBoardDTO = boardService.readBoard(boardDTO.getBno());
            List<String> fileNames = realBoardDTO.getFileNames();
            if(fileNames != null && fileNames.size() > 0) {
                removeFile(fileNames);
            }
            strFileNames = fileUpload(uploadFileDTO);
            boardDTO.setFileNames(strFileNames);
        }
        boardService.updateBoard(boardDTO);
        return "redirect:/board/read?bno="+boardDTO.getBno();
    }

    @GetMapping("/remove")
    public String remove(Long bno) {
        BoardDTO boardDTO = boardService.readBoard(bno);
        List<String> fileNames = boardDTO.getFileNames();
        if(fileNames != null && fileNames.size() > 0) {
            removeFile(fileNames);
        }
        boardService.deleteBoard(bno);
        return "redirect:/board/list";
    }

    @GetMapping("/view/{filename}")
    public ResponseEntity<Resource> viewFileGet(@PathVariable("filename") String filename) {
        Resource resource = new FileSystemResource(uploadPath + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));
        } catch(Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    private void removeFile(List<String> fileNames) {
        for (String filename : fileNames) {
            Resource resource = new FileSystemResource(uploadPath + File.separator + filename);
            log.info("resource: " + String.valueOf(resource));
            boolean removedFlag = false;
            try {
                String contentType = Files.probeContentType(resource.getFile().toPath());
                removedFlag = resource.getFile().delete();
                if (contentType.startsWith("image")) {
                    File oFile = new File(uploadPath + File.separator + "s_" + filename);
                    log.info(String.valueOf(oFile));
                    removedFlag = oFile.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> fileUpload(UploadFileDTO uploadFileDTO) {
        List<String> list = new ArrayList<>();
        if(uploadFileDTO.getFiles() != null) {
            uploadFileDTO.getFiles().forEach(multipartFile -> {
                String originalFileName = multipartFile.getOriginalFilename();
                String uuid = UUID.randomUUID().toString();
                Path savePath = Paths.get(uploadPath, uuid + "_" + originalFileName);
                boolean imageFlag = false;

                try {
                    multipartFile.transferTo(savePath);
                    if(Files.probeContentType(savePath).startsWith("image")) {
                        imageFlag = true;
                        File thumbnail = new File(uploadPath, "s_" + uuid + "_" + originalFileName);
                        Thumbnailator.createThumbnail(savePath.toFile(), thumbnail, 200, 200);
                    }
                } catch(Exception e) {
                    e.printStackTrace();
                }

                list.add(uuid + "_" + originalFileName);
            });
        }
        return list;
    }
}
