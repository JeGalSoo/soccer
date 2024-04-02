package com.turing.api.user;

import com.turing.api.article.Article;
import com.turing.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    private final UserService service;
    @Qualifier("userRepository")
    private final UserRepository repository;

    @PostMapping("/api/userLogin")
    public Map<String, Messenger> login (@RequestBody Map<?,?> paramap){
        Map<String,Messenger> map = new HashMap<>();
        User user = service.findByUsername((String) paramap.get("username"));
        map.put("mess1age",(user==null) ?Messenger.FAIL
                :(user.getPassword().equals(paramap.get("password"))) ?Messenger.SUCCESS :Messenger.WRONG_PASSWORD);
        return map;
    }

    @GetMapping("/api/all-users")
    public Map<?,?> findall(){
        Map<String, Object> map = new HashMap<>();
        map.put("message", Messenger.SUCCESS);
        List<User> list = new ArrayList<>();
        list = repository.findAll();
        map.put("result", list);
        return map;
    }

    @PostMapping( path = "/api/userSave")
    public Map<String, Messenger> join (@RequestBody Map<?,?> paramap){
        Map<String, Messenger> map = new HashMap<>();
        User newUser = (User.builder()
                .username((String) paramap.get("username"))
                .password((String) paramap.get("password"))
                .name((String) paramap.get("name"))
                .phone((String) paramap.get("phone"))
                .recommender((String) paramap.get("recommender"))
                .build());
        if (repository.findByUsername(newUser.getUsername()).isEmpty()) {
            service.save(newUser);
            map.put("message",Messenger.SUCCESS);
        } else {
            map.put("message",Messenger.FAIL);
        }
        return map;
    }

    @PostMapping("/api/userChange")
    public Map<String,?> updatePassword(@RequestBody Map<?,?> paramap) {
        Map<String,Messenger> map = new HashMap<>();
        User newUser = (User.builder()
                //세션유지로 아이디를 받는 값이 필요하고, 그 값과 같은 것을 findByUsername으로 찾아서 save로 findByUsername이나 쿼리로 해야됨
                .username((String) paramap.get("username"))
                .password((String) paramap.get("password"))
                .name((String) paramap.get("name"))
                .phone((String) paramap.get("phone"))
                .addressId((Long) paramap.get("addressId"))
                .build());
        //save는 기존 자료에 병합(덮어씌우기)기능도 있다.
        //그리고 JPA에는 update기능이 없기 때문에 update 대신 save를 사용한다.
        service.save(newUser);
        User chUser=service.findByUsername((String) paramap.get("username"));
        map.put("message",chUser.equals(newUser)?Messenger.SUCCESS:Messenger.FAIL);
        return map;
    }

    @PostMapping("/api/userDelete")
    public Map<String, Messenger> deleteUser(@RequestBody Map<?,?> paramap) {
        Map<String, Messenger> map = new HashMap<>();
        if(service.findByUsername((String) paramap.get("username"))!=null)
            repository.deleteByUsername((String) paramap.get("username"));
        map.put("message", service.findByUsername((String) paramap.get("username")) == null ?Messenger.SUCCESS:Messenger.FAIL);
//            map.put("message", Messenger.SUCCESS);
//        } else {
//            map.put("message", Messenger.FAIL);
//        }
        return map;
    }
}
