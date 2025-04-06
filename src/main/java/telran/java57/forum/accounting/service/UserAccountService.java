package telran.java57.forum.accounting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import telran.java57.forum.accounting.dto.UpdateUserDto;
import telran.java57.forum.accounting.dto.UserDto;
import telran.java57.forum.accounting.dto.UserRegisterDto;
import telran.java57.forum.accounting.dto.UserRolesDto;

public interface UserAccountService {

    UserDto register(UserRegisterDto userRegisterDto);

    UserDto getUser(String name);

    void changePassword(String name, String newPassword);

    UserDto removeUser(String login);

    UserDto updateUser(String login, UpdateUserDto newUserData);

    UserRolesDto changeRolesList(String login, String role, boolean isAddRole);
}
