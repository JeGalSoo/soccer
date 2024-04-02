package com.turing.api.article;
import com.turing.api.user.User;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
@AllArgsConstructor
@ToString
@Entity(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String content;
    private String registerDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;


    }