package com.bbp.board.controller;

import com.bbp.board.dto.BoardDTO;
import com.bbp.board.repostitory.BoardRepository;
import com.bbp.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        System.out.println("boardDTO = " + boardDTO);
        boardService.save(boardDTO);
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardDTOList", boardDTOList);
        return "list";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "detail";
    }

}
