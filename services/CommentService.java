package com.dea.codingdojo.blogplatform.services;

import com.dea.codingdojo.blogplatform.models.Comment;
import com.dea.codingdojo.blogplatform.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepo;



    public List<Comment> allPosts(){
        return commentRepo.findAll();
    }

    public List<Comment> postComment(Long postId){
        return commentRepo.findByPostIdIs(postId);
    }

    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public void deleteComment(Comment comment) {
        commentRepo.delete(comment);
    }


}
