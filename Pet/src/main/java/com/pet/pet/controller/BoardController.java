package com.pet.pet.controller;

import com.pet.pet.model.Board;
import com.pet.pet.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/board")
    public String board(Model model){
        List<Board> board = boardRepository.findAll();
        model.addAttribute("board",board);
        return "board";
    }
    @GetMapping("/board/{id}")
    public String boardDetail(@PathVariable int id, Model model){
        model.addAttribute("board", boardRepository.findById(id));
        return "boardDetail";
    }

}
