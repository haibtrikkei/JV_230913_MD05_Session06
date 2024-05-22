package ra.demo_regist_login_logout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.demo_regist_login_logout.entity.Roles;

public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Roles findRolesByRoleName(String roleName);
}
