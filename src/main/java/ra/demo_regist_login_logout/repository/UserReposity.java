package ra.demo_regist_login_logout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.demo_regist_login_logout.entity.Users;

@Repository
public interface UserReposity extends JpaRepository<Users,Integer> {
    Users findUsersByUserName(String userName);
}
