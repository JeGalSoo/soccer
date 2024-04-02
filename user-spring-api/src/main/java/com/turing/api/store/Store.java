package com.turing.api.store;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Entity(name="stores")
public class Store {
    @Id
    @Column(name = "store_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String storename;
    private String ownername;
    private Long addressId;
    private String storephone;
    private Time opentime;

    @Builder(builderMethodName = "builder")
    public Store(Long id, String storename, String ownername, Long addressId, String storephone, Time opentime) {
        this.id = id;
        this.storename = storename;
        this.ownername = ownername;
        this.addressId = addressId;
        this.storephone = storephone;
        this.opentime = opentime;
    }
}
