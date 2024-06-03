package com.example.demo.controller;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;


    @PostMapping("/article/list")
    public ResponseEntity<?> articleList(@RequestBody PageRequestDTO pageRequestDTO){
        return articleService.articleList(pageRequestDTO);
    }

    @PostMapping("/article/view")
    public ResponseEntity<?> articleView(@RequestBody Map<String, Integer> request){
        int articleNo = request.get("articleNo");
        return articleService.articleView(articleNo);
    }

    @PostMapping("/article/write")
    public ResponseEntity<?> articleWrite(@RequestBody ArticleDTO articleDTO){
        return articleService.articleWrite(articleDTO);
    }

    @PostMapping("/article/delete")
    public ResponseEntity<?> articleDelete(@RequestBody Map<String, Integer> request){
        int articleNO = request.get("articleNo");
        return articleService.articleDelete(articleNO);
    }
}
