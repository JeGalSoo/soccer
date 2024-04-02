package com.turing.api.article;

import com.turing.api.enums.Messenger;
import com.turing.api.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ArticleController {
    private final ArticleService service;


    @GetMapping("/api/all-articles")
    public Map<?,?> findall(){
        Map<String, Object> map = new HashMap<>();
        map.put("message", Messenger.SUCCESS);
        List<Article> list = new ArrayList<>();
//        for(int i=0; i<10;i++) {
//            list.add(Article.builder()
//                    .id(123L)
//                    .title("샤샤샤")
//                    .content("잠온다")
//                    .writer("제갈")
//                    .registerDate("오늘")
//                    .build());
//        }
        list = service.findAll();
        map.put("result", list);
        return map;
    }

    @PostMapping("api/articleSave")
    public Map<?,?> save(@RequestBody Map<?,?> paramap){
        Map<String, Messenger> map = new HashMap<>();
        service.save(Article.builder()
                .title((String) paramap.get("title"))
                .content((String) paramap.get("content"))
                .writer((User) paramap.get("writer"))
                .registerDate((String) paramap.get("registerDate"))
                .build());
        map.put("message",Messenger.SUCCESS); //나중에 save의 결과값으로 id를 받아서 조회해서 있으면 true로 전환하는거 구현해야 됨
        return map;
    }


}
