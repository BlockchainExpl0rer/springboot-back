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
     * Récupère tous les utilisateurs
     *
     * @return Des users
     * @since 19
     */
    List<User>getUsers();

    /**
     * Récupère un utilisateur en fonction de son id
     *
     * @param userId L'id de l'user
     */
    void getUser(Long userId);

    /**
     * Récupère un utilisateur en fonction de son email
     *
     * @param email L'email de l'user
     * @return Un user
     * @since 19
     */
    User getUser(String email);

    /**
     * Enregistre un utilisateur
     *
     * @param user L'user qui va être créé
     * @return L'utilisateur crée
     * @since 19
     */
    User saveUser(User user);

    /**
     * Enregistre un rôle
     *
     * @param role Le rôle qui va être créé
     * @return Le role crée
     * @since 19
     */
    Role saveRole(Role role);

    /**
     * Ajoute un rôle à l'utilisateur
     *
     * @param email L'email de l'user
     * @param roleName Le rôle qui va être adressé à l'user
     * @since 19
     */
    void addRoleToUser(String email, String roleName);
}
