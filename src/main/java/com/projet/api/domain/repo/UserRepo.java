package com.projet.api.domain.repo;

import com.projet.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Récupère toutes les requêtes de la table User
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
public interface UserRepo extends JpaRepository<User, Long>
{
    /**
     * Trouve un email dans la base de donnée
     *
     * @since 19
     * @param email Le nom de l'email
     * @return L'email recherché
     */
    User findByEmail(String email);
}