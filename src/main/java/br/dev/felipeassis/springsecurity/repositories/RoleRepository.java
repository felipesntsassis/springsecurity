package br.dev.felipeassis.springsecurity.repositories;

import br.dev.felipeassis.springsecurity.entities.Role;
import br.dev.felipeassis.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>  {
}
