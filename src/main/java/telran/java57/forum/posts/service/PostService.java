package telran.java57.forum.posts.service;

import telran.java57.forum.posts.dto.CommentDto;
import telran.java57.forum.posts.dto.NewPostDto;
import telran.java57.forum.posts.dto.PeriodDto;
import telran.java57.forum.posts.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);


    PostDto findPostById(String id);

    PostDto updatePost(String postId, NewPostDto updateData);

    PostDto deletePost(String postId);

    List<PostDto> findPostsByAuthor(String author);

    PostDto addNewComment(String postId, CommentDto newComment);

    List<PostDto> findPostsWithTags(List<String> tags);

    List<PostDto> findPostsByPeriod(PeriodDto period);

    Integer addLike(String postId);
}
