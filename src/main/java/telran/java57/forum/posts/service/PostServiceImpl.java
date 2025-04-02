package telran.java57.forum.posts.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import telran.java57.forum.posts.dao.PostRepository;
import telran.java57.forum.posts.dao.exceptions.PostNotFoundException;
import telran.java57.forum.posts.dto.CommentDto;
import telran.java57.forum.posts.dto.NewPostDto;
import telran.java57.forum.posts.dto.PeriodDto;
import telran.java57.forum.posts.dto.PostDto;
import telran.java57.forum.posts.model.Comment;
import telran.java57.forum.posts.model.Post;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    final PostRepository postRepository;
    final ModelMapper modelMapper;

    @Override
    public PostDto addNewPost(String author, NewPostDto newPostDto) {
        Post post = new Post(newPostDto.getTitle(), newPostDto.getContent(), author, newPostDto.getTags());
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto findPostById(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto updatePost(String postId, NewPostDto updateData) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);

        post.setContent(updateData.getContent());
        post.setTitle(updateData.getTitle());
        post.setTags(updateData.getTags());

        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public PostDto deletePost(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        postRepository.delete(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findPostsByAuthor(String author) {
        return postRepository.streamByAuthor(author)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public PostDto addNewComment(String postId, CommentDto newComment) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        post.getComments().add(new Comment(newComment.getUser(), newComment.getMessage()));
        postRepository.save(post);
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> findPostsWithTags(List<String> tags) {
        return postRepository.streamByTagsIn(tags)
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> findPostsByPeriod(PeriodDto period) {
        return postRepository.streamByDateCreatedBetween(period.getDateFrom().atStartOfDay(), period.getDateTo().atStartOfDay())
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public Integer addLike(String postId) {
        Post post = postRepository.findById(postId).orElseThrow(PostNotFoundException::new);
        post.addLike();
        postRepository.save(post);
        return post.getLikes();
    }


}
