package com.bbp.board.service;

import com.bbp.board.dto.BoardDTO;
import com.bbp.board.entity.BoardEntity;
import com.bbp.board.repostitory.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public void save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);
    }
}
