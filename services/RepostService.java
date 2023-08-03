package com.dea.codingdojo.blogplatform.services;

import com.dea.codingdojo.blogplatform.models.Post;
import com.dea.codingdojo.blogplatform.repositories.PostRepo;

import java.util.Optional;

public class RepostService {

    private PostRepo postRepo;

    public RepostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public void repost(Long postId) {
        Optional<Post> post = postRepo.findById(postId);
        if (post.isPresent()) {
            post.get().setReposted(true);
            postRepo.updateReposted(post.get());
        }
    }

}
