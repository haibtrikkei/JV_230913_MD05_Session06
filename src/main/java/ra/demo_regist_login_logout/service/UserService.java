package ra.demo_regist_login_logout.service;

import ra.demo_regist_login_logout.dto.UserDto;
import ra.demo_regist_login_logout.entity.Users;

public interface UserService {
     Users findUsersByUserName(String userName);
     void saveUser(UserDto userDto);
     void saveAdmin(UserDto userDto);
}
