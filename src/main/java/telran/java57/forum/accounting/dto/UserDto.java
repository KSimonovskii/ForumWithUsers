package telran.java57.forum.accounting.dto;

import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserDto {
    String login;
    String firstName;
    String lastName;
    @Singular
    Set<String> roles;
}
