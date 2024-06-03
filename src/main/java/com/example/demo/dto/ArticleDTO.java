package com.example.demo.dto;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ArticleDTO {
    private int articleNo;
    private String articleTitle;
    private String articleContent;
    private String articleCate;
    private String articleWriter;
    private LocalDateTime articleData;
}
