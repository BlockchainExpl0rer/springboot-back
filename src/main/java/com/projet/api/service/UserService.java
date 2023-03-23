package com.projet.api.service;

import com.projet.api.domain.Role;
import com.projet.api.domain.User;

import java.util.List;

/**
 * Définie les actions du CRUD sur le model User et Role
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
public interface UserService
{
    /**
     * Enregistre un utilisateur
     *
     * @since 19
     * @param user L'user qui va être créé
     * @return L'utilisateur crée
     */
    User saveUser(User user);

    /**
     * Enregistre un rôle
     *
     * @since 19
     * @param role Le rôle qui va être créé
     * @return Le role crée
     */
    Role saveRole(Role role);

    /**
     * Ajoute un rôle à l'utilisateur
     *
     * @since 19
     * @param email L'email de l'user
     * @param roleName Le rôle qui va être adressé à l'user
     */
    void addRoleToUser(String email, String roleName);

    /**
     * Récupère un utilisateur en fonction de son email
     *
     * @since 19
     * @param email L'email de l'user
     * @return Un user
     */
    User getUser(String email);

    /**
     * Récupère tous les utilisateurs
     *
     * @since 19
     * @return Des users
     */
    List<User>getUsers();
}
