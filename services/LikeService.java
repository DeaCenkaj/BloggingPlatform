package com.dea.codingdojo.blogplatform.services;

import com.dea.codingdojo.blogplatform.models.Comment;
import com.dea.codingdojo.blogplatform.models.Like;
import com.dea.codingdojo.blogplatform.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LikeService {
    @Autowired
    public LikeRepository likeRepo;
    public List<Like> allPosts(){
        return likeRepo.findAll();
    }

    public List<Like> postLike(Long postId){
        return likeRepo.findByPostIdIs(postId);
    }

    public Like addLike(Like like) {
        return likeRepo.save(like);
    }

    public void deleteLike(Like like) {
        likeRepo.delete(like);
    }

}
