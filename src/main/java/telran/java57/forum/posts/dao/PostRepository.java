package telran.java57.forum.posts.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import telran.java57.forum.posts.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;


public interface PostRepository extends MongoRepository<Post, String> {
    public Stream<Post> streamByAuthorIgnoreCase(String author);

    @Query("{tags: {$elemMatch: {$in: ?0}}}")
    public Stream<Post> findPostsByTagsInIgnoreCase(List<String> tags);

    public Stream<Post> streamByDateCreatedBetween(LocalDateTime dateFrom, LocalDateTime dateTo);
}
