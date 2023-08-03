package com.dea.codingdojo.blogplatform.repositories;

import com.dea.codingdojo.blogplatform.models.Comment;
import com.dea.codingdojo.blogplatform.models.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like, Long> {
    List<Like> findAll();
    List<Like> findByPostIdIs(Long id);
}