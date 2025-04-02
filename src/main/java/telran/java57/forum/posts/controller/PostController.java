package telran.java57.forum.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java57.forum.dto.NewPostDto;
import telran.java57.forum.dto.PostDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {

    @PostMapping("/post/{author}")
    public PostDto addNewPost(@PathVariable String author, @RequestBody NewPostDto newPostDto){
        return null;
    }



}
