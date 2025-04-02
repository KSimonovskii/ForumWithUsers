package telran.java57.forum.posts.dao.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@NoArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post not found by Id")
public class PostNotFoundException extends RuntimeException{
}
