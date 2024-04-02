package com.turing.api.article;

import com.turing.api.common.AbstractService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService{
    private final ArticleRepository repository;

    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Article build) {
        repository.save(build);
    }
}
