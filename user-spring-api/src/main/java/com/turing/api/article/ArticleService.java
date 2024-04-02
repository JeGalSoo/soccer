package com.turing.api.article;

import java.util.List;

public interface ArticleService {

    List<Article> findAll();

    void save(Article build);
}
