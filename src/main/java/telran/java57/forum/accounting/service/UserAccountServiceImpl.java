package telran.java57.forum.accounting.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import telran.java57.forum.accounting.dao.UserRepository;
import telran.java57.forum.accounting.dao.exceptions.UserNotFoundException;
import telran.java57.forum.accounting.dto.*;
import telran.java57.forum.accounting.model.UserAccount;

@Service
@RequiredArgsConstructor
public class UserAccountServiceImpl implements UserAccountService{

    final UserRepository userRepository;
    final ModelMapper modelMapper;

    @Override
    public UserDto register(UserRegisterDto userRegisterDto) {
        UserAccount newUser = new UserAccount(userRegisterDto.getLogin(), userRegisterDto.getPassword(), userRegisterDto.getFirstName(), userRegisterDto.getLastName());
        userRepository.save(newUser);
        return modelMapper.map(newUser, UserDto.class);
    }

    @Override
    public UserDto getUser(String name) {
        UserAccount user = userRepository.findById(name).orElseThrow(UserNotFoundException::new);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void changePassword(String name, String newPassword) {
        UserAccount user = userRepository.findById(name).orElseThrow(UserNotFoundException::new);
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public UserDto removeUser(String login) {
        UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userRepository.delete(user);
        return userDto;
    }

    @Override
    public UserDto updateUser(String login, UpdateUserDto newUserData) {
        UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
        boolean userModified = false;
        if (!newUserData.getFirstName().isEmpty()){
            user.setFirstName(newUserData.getFirstName());
            userModified = true;
        }
        if (!newUserData.getLastName().isEmpty()){
            user.setLastName(newUserData.getLastName());
            userModified = true;
        }
        if (userModified){
            userRepository.save(user);
        }
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserRolesDto changeRolesList(String login, String role, boolean isAddRole) {
        UserAccount user = userRepository.findById(login).orElseThrow(UserNotFoundException::new);
        if (isAddRole){
            user.addRole(role);
        } else {
            user.removeRole(role);
        }
        userRepository.save(user);
        return UserRolesDto.builder()
                .login(login)
                .roles(user.getRoles())
                .build();
    }
}
