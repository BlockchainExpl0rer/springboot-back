package com.projet.api.domain.repo;

import com.projet.api.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Récupère toutes les requêtes de la table rôle
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
public interface RoleRepo extends JpaRepository<Role, Long>
{
    /**
     * Trouve un nom de rôle
     *
     * @since 19
     * @param name Le nom du rôle
     * @return Le rôle recherché
     */
    Role findByName(String name);
}
