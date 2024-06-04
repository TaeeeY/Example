package com.example.demo.controller;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;


    @GetMapping("/list")
    public String articleList(PageRequestDTO pageRequestDTO, Model model){
        log.info("카테고리" + pageRequestDTO.getArticleCate());
        PageResponseDTO pageResponseDTO = articleService.articleList(pageRequestDTO);
        model.addAttribute("pageResponseDTO", pageResponseDTO);
        return "/list";
    }

    @GetMapping("/article/view")
    public ResponseEntity<?> articleView(@RequestParam int articleNo){
        return articleService.articleView(articleNo);
    }

    @PostMapping("/article/write")
    public ResponseEntity<?> articleWrite(@RequestBody ArticleDTO articleDTO){
        return articleService.articleWrite(articleDTO);
    }

    @GetMapping("/article/delete")
    public ResponseEntity<?> articleDelete(@RequestParam int articleNo){
        return articleService.articleDelete(articleNo);
    }
}
