package com.turing.api.store;

import com.turing.api.enums.Messenger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class StoreController {
    private final StoreRepository repository;

    public Map<String, Messenger> save(@RequestBody Map<?,?> paramap){
        Map<String,Messenger> map = new HashMap<>();
        if (repository.findByStorename((String) paramap.get("store_name")).isEmpty()) {
            repository.save(Store.builder()
                    .storename((String) paramap.get("store_name"))
                    .ownername((String) paramap.get("owner_name"))
                    .addressId((Long) paramap.get("addressId"))
                    .storephone((String) paramap.get("store_phone"))
                    .opentime((Time) paramap.get("open_time"))
                    .build());
        }
        return map;
    }
}
