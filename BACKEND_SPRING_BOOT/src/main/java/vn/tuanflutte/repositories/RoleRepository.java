package vn.tuanflutte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.tuanflutte.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
