package com.example.elasticsearch.test;

import com.example.elasticsearch.ElasticsearchApplication;
import com.example.elasticsearch.entity.Article;
import com.example.elasticsearch.service.ArticleSearchRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleSearchRepositoryTest {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;

//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void testSave(){
        Article article=new Article(3L,"srpignMVC教程","srpignMVC","srpignMVC入门到放弃",System.currentTimeMillis()+"",22L);
        Article article1=new Article(4L,"srpig教程","spring","spring入门到放弃",System.currentTimeMillis()+"",20L);
        Article article2=new Article(5L,"srpigCloud教程","springCloud","springCloud入门到放弃",System.currentTimeMillis()+"",20L);
        Article article3=new Article(6L,"java教程","java","java入门到放弃",System.currentTimeMillis()+"",120L);
        Article article4=new Article(7L,"php教程","php","php入门到放弃",System.currentTimeMillis()+"",160L);

        articleSearchRepository.save(article);
        articleSearchRepository.save(article1);
        articleSearchRepository.save(article2);
        articleSearchRepository.save(article3);
        articleSearchRepository.save(article4);

        Article article8=new Article(8L,"mysql教程","mysql","mysql入门到放弃",System.currentTimeMillis()+"",460L);
        Article article9=new Article(9L,"redis教程","redis","redis入门到放弃",System.currentTimeMillis()+"",60L);
        Article article10=new Article(10L,"c教程","c","c教程入门到放弃",System.currentTimeMillis()+"",600L);
        //bulk index 批量方式插入
//        List<Article> sampleEntities = Arrays.asList( article10);
//        articleSearchRepository.save

    }

}
