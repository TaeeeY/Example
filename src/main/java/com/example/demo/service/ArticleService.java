package com.example.demo.service;

import com.example.demo.dto.ArticleDTO;
import com.example.demo.dto.PageRequestDTO;
import com.example.demo.dto.PageResponseDTO;
import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    public ResponseEntity<?> articleList(PageRequestDTO pageRequestDTO){
        Pageable pageable = pageRequestDTO.getPageable("articleNo");
        Page<Article> pageArticle = articleRepository.findByArticleCate(pageRequestDTO.getCate(), pageable);

        List<Article> articleList = pageArticle.getContent();
        int total = (int) pageArticle.getTotalElements();

        List<ArticleDTO> articleDTOS = new ArrayList<>();
        for (Article each : articleList) {
            articleDTOS.add(modelMapper.map(each, ArticleDTO.class));
        }

        PageResponseDTO pageResponseDTO = PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(articleDTOS)
                .total(total)
                .build();
        return ResponseEntity.ok(pageResponseDTO);
    }

    public ResponseEntity<?> articleView(int articleNo){

        Optional<Article> optArticle = articleRepository.findById(articleNo);
        ArticleDTO articleDTO = optArticle
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .orElse(null); // 위치로 변환?

        return ResponseEntity.ok(articleDTO);
    }

    public ResponseEntity<?> articleWrite(ArticleDTO articleDTO){
        Article article = modelMapper.map(articleDTO, Article.class);
        Article savedArticle = articleRepository.save(article);

        if(savedArticle.getArticleContent() != null){
            return ResponseEntity.ok(1);
        }else {
            return ResponseEntity.ok(0);
        }
    }

    public ResponseEntity<?> articleDelete(int articleNo){
        articleRepository.deleteById(articleNo);
        Optional<Article> optArticle = articleRepository.findById(articleNo);

        if(optArticle.isEmpty()){
            return ResponseEntity.ok(1);
        }else {
            return ResponseEntity.ok(0);
        }
    }
}
