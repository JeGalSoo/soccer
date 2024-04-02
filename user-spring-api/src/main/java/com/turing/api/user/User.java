package com.turing.api.user;

import com.turing.api.article.Article;
import jakarta.persistence.*;
import lombok.*;
import com.turing.api.order.Order;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity(name="users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String recommender;

    @OneToMany(mappedBy = "writer")
    private List<Article> articles;
    @OneToMany(mappedBy = "owner")
    private List<Order> orders;


    @Builder(builderMethodName = "builder")
    public User(String username, String password, String name, String phone,long addressId, String recommender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.addressId = addressId;
        this.recommender = recommender;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phone +
                ", address='" + addressId + '\'' +
                ", recommender='" + recommender + '\'' +
                '}' + '\n';
    }
}