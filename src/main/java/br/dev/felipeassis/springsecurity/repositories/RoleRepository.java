package br.dev.felipeassis.springsecurity.repositories;

import br.dev.felipeassis.springsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID>  {

    /**
     * Obtem uma role a partir do seu nome
     * @param name String
     * @return Role
     */
    Role findByName(String name);

}
