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
     * Enregistre un utilisateur
     *
     * @param user L'user qui va être créé
     * @return L'utilisateur crée
     * @since 19
     */
    @Override
    public User saveUser(User user)
    {
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
        User user = userRepo.findByEmail(email);
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
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
        return userRepo.findByEmail(email);
    }

    /**
     * Récupère tous les utilisateurs
     *
     * @return Des users
     * @since 19
     */
    @Override
    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
}
