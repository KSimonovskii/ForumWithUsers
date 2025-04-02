package telran.java57.forum.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.java57.forum.dao.PostRepository;
import telran.java57.forum.dto.NewPostDto;
import telran.java57.forum.dto.PostDto;
import telran.java57.forum.model.Post;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    final PostRepository postRepository;

    @Override
    public PostDto addNewPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), "", newPostDto.getTags());
        return null;
    }
}
