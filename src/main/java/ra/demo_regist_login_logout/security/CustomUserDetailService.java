package ra.demo_regist_login_logout.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ra.demo_regist_login_logout.entity.Roles;
import ra.demo_regist_login_logout.entity.Users;
import ra.demo_regist_login_logout.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userService.findUsersByUserName(username);
        if(user!=null){
            CustomUserDetail customUserDetail = CustomUserDetail.builder()
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .fullName(user.getFullName())
                    .password(user.getPassword())
                    .authorities(mapToUserAuthrities(user.getRoles()))
                    .build();
            return customUserDetail;
        }else{
            throw new UsernameNotFoundException("Username not exist");
        }
    }

    private List<GrantedAuthority> mapToUserAuthrities(List<Roles> roles) {
        return roles.stream().map(role->new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }
}
