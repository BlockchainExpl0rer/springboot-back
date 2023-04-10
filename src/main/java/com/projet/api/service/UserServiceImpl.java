package com.projet.api.service;

import com.projet.api.domain.Role;
import com.projet.api.domain.User;
import com.projet.api.domain.repo.RoleRepo;
import com.projet.api.domain.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Effectue les actions du CRUD pour les tables User et Role
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService
{
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    /**
     * Récupère tous les utilisateurs
     *
     * @return Des users
     * @since 19
     */
    @Override
    public List<User> getUsers()
    {
        log.info("Fetching des users!");
        return userRepo.findAll();
    }

    /**
     * Récupère un utilisateur en fonction de son id
     *
     * @param userId L'id de l'user
     */
    @Override
    public void getUser(Long userId)
    {
        log.info("Fetching d'un user {}!", userId);
        userRepo.findById(userId);
    }

    /**
     * Récupère un utilisateur en fonction de son email
     *
     * @param email L'email de l'user
     * @return Un user
     * @since 19
     */
    @Override
    public User getUser(String email)
    {
        log.info("Fetching d'un user {}!", email);
        return userRepo.findByEmail(email);
    }

    /**
     * Enregistre un utilisateur
     *
     * @param user L'user qui va être créé
     * @return L'utilisateur crée
     * @since 19
     */
    @Override
    public User saveUser(User user)
    {
        log.info("Enregistrement d'un nouvel user {} dans la BDD!", user.getFirstName());
        return userRepo.save(user);
    }

    /**
     * Enregistre un rôle
     *
     * @param role Le rôle qui va être créé
     * @return Le role crée
     * @since 19
     */
    @Override
    public Role saveRole(Role role)
    {
        log.info("Enregistrement d'un nouvel role {} dans la BDD!", role.getName());
        return roleRepo.save(role);
    }

    /**
     * Ajoute un rôle à l'utilisateur
     *
     * @param email    L'email de l'user
     * @param roleName Le rôle qui va être adressé à l'user
     * @since 19
     */
    @Override
    public void addRoleToUser(String email, String roleName)
    {
        log.info("Ajout d'un role {} à un user {}!", roleName, email);
        User user = userRepo.findByEmail(email);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }
}
