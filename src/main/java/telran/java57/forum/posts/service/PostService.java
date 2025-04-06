package telran.java57.forum.posts.service;

import telran.java57.forum.posts.dto.*;

import java.util.List;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);


    PostDto findPostById(String id);

    PostDto updatePost(String postId, NewPostDto updateData);

    PostDto deletePost(String postId);

    Iterable<PostDto> findPostsByAuthor(String author);

    PostDto addNewComment(String postId, String author, NewCommentDto newComment);

    List<PostDto> findPostsWithTags(List<String> tags);

    List<PostDto> findPostsByPeriod(PeriodDto period);

    void addLike(String postId);
}
