package telran.java57.forum.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import telran.java57.forum.model.Post;

public interface PostRepository extends MongoRepository<Post, String> {
}
