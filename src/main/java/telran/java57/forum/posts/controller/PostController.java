package telran.java57.forum.posts.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import telran.java57.forum.posts.dto.*;
import telran.java57.forum.posts.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/forum")
public class PostController {

    final PostService postService;

    @PostMapping("/post/{author}")
    public PostDto addNewPost(@PathVariable String author, @RequestBody NewPostDto newPostDto){
        return postService.addNewPost(author, newPostDto);
    }

    @GetMapping("/post/{postId}")
    public PostDto findPostById(@PathVariable String postId){
        return postService.findPostById(postId);
    }

    @PutMapping("post/{postId}")
    public PostDto updatePost(@PathVariable String postId, @RequestBody NewPostDto updateData){
        return postService.updatePost(postId, updateData);
    }

    @DeleteMapping("post/{postId}")
    public PostDto deletePost(@PathVariable String postId){
        return postService.deletePost(postId);
    }

    @GetMapping("posts/author/{author}")
    public Iterable<PostDto> findPostsByAuthor(@PathVariable String author){
        return postService.findPostsByAuthor(author);
    }

    @PutMapping("post/{postId}/comment/{author}")
    public PostDto addComment(@PathVariable String postId, @PathVariable String author, @RequestBody NewCommentDto newComment){
        return postService.addNewComment(postId, author, newComment);
    }

    @PostMapping("posts/tags")
    public List<PostDto> findPostsWithTags(@RequestBody List<String> tags){
        return postService.findPostsWithTags(tags);
    }

    @PostMapping("posts/period")
    public List<PostDto> findPostsByPeriod(@RequestBody PeriodDto period){
        return postService.findPostsByPeriod(period);
    }

    @PutMapping("post/{postId}/like")
    public void addLike(@PathVariable String postId){
        postService.addLike(postId);

    }






}
