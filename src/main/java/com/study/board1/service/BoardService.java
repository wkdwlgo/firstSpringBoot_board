package com.study.board1.service;

import com.study.board1.entity.Board;
import com.study.board1.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;
import org.springframework.data.domain.Pageable;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    //글 작성 처리
    public void write(Board board, MultipartFile file) throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\file";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/file/" + fileName);

        boardRepository.save(board);
    }

    //게시글 리스트 처리
    public Page<Board> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }
    //특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    public Page<Board> boardSearchList(String searchKeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword,pageable);
    }

    //특정 게시글 삭제
    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}