package com.turing.api.article;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

}
