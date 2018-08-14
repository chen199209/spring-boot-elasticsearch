package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Article;
import com.example.elasticsearch.service.ArticleSearchRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private ArticleSearchRepository articleSearchRepository;


    @RequestMapping("save")
    public void save(){
        Article article=new Article(3L,"srpignMVC教程","srpignMVC","srpignMVC入门到放弃",System.currentTimeMillis()+"",22L);
        Article article1=new Article(4L,"srpig教程","spring","spring入门到放弃",System.currentTimeMillis()+"",20L);
        Article article2=new Article(5L,"srpigCloud教程","springCloud","springCloud入门到放弃",System.currentTimeMillis()+"",20L);
        Article article3=new Article(6L,"java教程","java","java入门到放弃",System.currentTimeMillis()+"",120L);
        Article article4=new Article(7L,"php教程","php","php入门到放弃",System.currentTimeMillis()+"",160L);

        Article article5=new Article(11L,"srpignMVC教程","srpignMVC","srpignMVC入门到放弃",System.currentTimeMillis()+"",22L);
        Article article6=new Article(23L,"srpig教程","spring","spring入门到放弃",System.currentTimeMillis()+"",20L);
        Article article7=new Article(78L,"srpigCloud教程","springCloud","springCloud入门到放弃",System.currentTimeMillis()+"",20L);
        Article article8=new Article(66L,"java教程","java","java入门到放弃",System.currentTimeMillis()+"",120L);
        Article article9=new Article(71L,"php教程","php","php入门到放弃",System.currentTimeMillis()+"",160L);


        articleSearchRepository.save(article);
        articleSearchRepository.save(article1);
        articleSearchRepository.save(article2);
        articleSearchRepository.save(article3);
        articleSearchRepository.save(article4);
        articleSearchRepository.save(article5);
        articleSearchRepository.save(article6);
        articleSearchRepository.save(article7);
        articleSearchRepository.save(article8);
        articleSearchRepository.save(article9);
    }

    @RequestMapping("/findByTitle/{title}")
    public String findByTitle(@PathVariable String title){
        List<Article> list= articleSearchRepository.findByTitle(title);
        Gson gson = new Gson();
        String result = gson.toJson(list);
        return result;
    }

    @RequestMapping("/findByContentLike/{content}")
    public String findByContentLike(@PathVariable String content){
        Pageable pageable = new PageRequest(0,10);
        Page<Article> list= articleSearchRepository.findByContentLike(content, pageable);
        Gson gson = new Gson();
        String result = gson.toJson(list.getContent());
        return result;
    }

    @RequestMapping("/deleteByClickCount/{clickCount}")
    public void deleteByClickCount(@PathVariable Long clickCount){
       articleSearchRepository.deleteByClickCount(clickCount);
    }

    @RequestMapping("/deleteByClickCountBetween")
    public void deleteByClickCountBetween(@RequestParam(value = "number1",defaultValue = "0") Long number1 ,
                                          @RequestParam(value = "number2",defaultValue = "0") Long number2){
        articleSearchRepository.deleteByClickCountBetween(number1,number2);
    }

    @RequestMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        articleSearchRepository.deleteById(id);
    }

}
