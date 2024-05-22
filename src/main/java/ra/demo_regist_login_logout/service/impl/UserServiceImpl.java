package ra.demo_regist_login_logout.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.demo_regist_login_logout.dto.UserDto;
import ra.demo_regist_login_logout.entity.Roles;
import ra.demo_regist_login_logout.entity.Users;
import ra.demo_regist_login_logout.repository.RoleRepository;
import ra.demo_regist_login_logout.repository.UserReposity;
import ra.demo_regist_login_logout.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposity userReposity;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Users findUsersByUserName(String userName) {
        return userReposity.findUsersByUserName(userName);
    }

    @Override
    public void saveUser(UserDto userDto) {
        //Chuyen doi tu userDto ve doi tuong Users de save vao database
        Users user = Users.builder()
                .email(userDto.getEmail())
                .userName(userDto.getUserName())
                .address(userDto.getAddress())
                .fullName(userDto.getFullName())
                .build();
        //Gan quyen cho doi tuong users
        Roles roleUser = roleRepository.findRolesByRoleName("ROLE_USER");
        List<Roles> roles = new ArrayList<>();
        roles.add(roleUser);
        user.setRoles(roles);
        //Ma hoa mat khau cua users
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userReposity.save(user);
    }

    @Override
    public void saveAdmin(UserDto userDto) {
        //Chuyen doi tu userDto ve doi tuong Users de save vao database
        Users user = Users.builder()
                .email(userDto.getEmail())
                .userName(userDto.getUserName())
                .address(userDto.getAddress())
                .fullName(userDto.getFullName())
                .build();
        //Gan quyen cho doi tuong users
        Roles roleUser = roleRepository.findRolesByRoleName("ROLE_USER");
        Roles roleAdmin = roleRepository.findRolesByRoleName("ROLE_ADMIN");
        List<Roles> roles = new ArrayList<>();
        roles.add(roleUser);
        roles.add(roleAdmin);
        user.setRoles(roles);
        //Ma hoa mat khau cua users
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userReposity.save(user);
    }
}
