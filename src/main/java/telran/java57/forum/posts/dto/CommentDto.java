package telran.java57.forum.posts.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {
    @Setter
    String user;
    String message;
    LocalDateTime dateCreated;
    Integer likes;
}
