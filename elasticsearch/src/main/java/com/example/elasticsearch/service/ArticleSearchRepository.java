package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {

    List<Article> findByTitle(String title);

    List<Article> findByTitleAndClickCount(String title, Long clickCount);

    List<Article> findByTitleOrClickCount(String title, Long clickCount);

    Page<Article> findByContent(String content, Pageable page);

    Page<Article> findByContentNot(String content, Pageable page);

    Page<Article> findByContentLike(String content, Pageable page);

    void deleteByClickCount(Long clickCount);

    void deleteByClickCountBetween(Long number1,Long number2);

    void deleteById(Long id);
}
