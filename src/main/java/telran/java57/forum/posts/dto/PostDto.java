package telran.java57.forum.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    String id;
    String title;
    String content;
    String author;
    LocalDateTime dateCreated;
    @Singular
    Set<String> tags;
    Integer likes;
    @Singular
    List<CommentDto> comments;

}
