package com.dea.codingdojo.blogplatform.services;

import com.dea.codingdojo.blogplatform.models.Post;
import com.dea.codingdojo.blogplatform.repositories.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService {

@Autowired
private PostRepo postRepo;

    public List<Post> findAll() {
        return postRepo.findAll();
    }

    public List<Post> findLatest5() {
        return postRepo.findFirst5ByOrderByDateDesc();
    }
    public Post findById(Long id) {
        return postRepo.findById(id)
                .orElse(null);
    }

    public Post create(Post post) {
        return postRepo.save(post);
    }

    public Post edit(Post post) {
        if (postRepo.existsById(post.getId())) {
            return postRepo.save(post);
        }
        throw new RuntimeException("Post not found: " + post.getId());
    }

    public void deleteById(Long id) {
        if (postRepo.existsById(id)) {
            postRepo.deleteById(id);
        } else {
            throw new RuntimeException("Post not found: " + id);
        }
    }
}
