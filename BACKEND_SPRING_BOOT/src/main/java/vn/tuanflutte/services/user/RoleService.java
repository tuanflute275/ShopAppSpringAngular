package vn.tuanflutte.services.user;

import vn.tuanflutte.repositories.RoleRepository;
import vn.tuanflutte.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public Role createNewRole(Role role) {
        return roleRepo.save(role);
    }
}
