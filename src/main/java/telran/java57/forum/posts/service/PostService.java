package telran.java57.forum.service;

import telran.java57.forum.dto.NewPostDto;
import telran.java57.forum.dto.PostDto;

public interface PostService {

    PostDto addNewPost(String author, NewPostDto newPostDto);



}
