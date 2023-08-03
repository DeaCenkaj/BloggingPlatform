package com.dea.codingdojo.blogplatform.controllers;

import com.dea.codingdojo.blogplatform.models.Post;
import com.dea.codingdojo.blogplatform.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    @Autowired
    private PostService postService;
    @RequestMapping("/")
    public String index(Model model) {
        List<Post> latest5Posts = postService.findLatest5();
        model.addAttribute("latest5posts", latest5Posts);

        if (latest5Posts != null) {
            List<Post> latest3Posts = latest5Posts.stream()
                    .limit(3).collect(Collectors.toList());
            model.addAttribute("latest3posts", latest3Posts);
        }

        return "index.jsp";
    }
    @RequestMapping("/createPost")
    public String createPost(Model model) {
        // Get the current authentication
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Check if the user is authenticated
        if (authentication != null && authentication.isAuthenticated()) {
            // User is logged in, allow them to create a post
            return "createPost.jsp";
        } else {
            // User is not logged in, redirect to a login page or show an error message
            return "login.jsp"; // Replace with your desired login page or error page
        }
    }


}