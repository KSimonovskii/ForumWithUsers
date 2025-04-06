package telran.java57.forum.accounting.dto;

import lombok.*;
import telran.java57.forum.accounting.model.Role;

import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRolesDto {
    String login;
    @Singular
    Set<Role> roles;
}
