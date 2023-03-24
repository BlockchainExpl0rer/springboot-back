package com.projet.api.api;

import com.projet.api.domain.Role;
import com.projet.api.domain.User;
import com.projet.api.service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Permet de faire les requêtes de l'API
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userService;

    /**
     * Récupère une liste users
     *
     * @return Une liste users récupérer
     * @since 19
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers()
    {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    /**
     * Ajoute un utilisateur
     *
     * @param user Le futur user
     * @return L'user, créer
     * @since 19
     */
    @GetMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }

    /**
     * Ajoute un rôle
     *
     * @param role Le futur rôle
     * @return Le rôle crée
     * @since 19
     */
    @PostMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());

        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }

    /**
     * Ajoute un rôle à un user
     *
     * @param form Les infos du form
     * @return Un rôle à un user
     * @since 19
     */
    @PostMapping("/role/addToUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody RoleToUserForm form)
    {
        userService.addRoleToUser(form.getEmail(), form.getRoleName());
        return ResponseEntity.ok().build();
    }
}

/**
 * Pour ajouter un rôle à l'user
 *
 * @author QArthur13
 * @version 1.O
 * @since 19
 */
@Data
class RoleToUserForm
{
    private String email;
    private String roleName;
}
