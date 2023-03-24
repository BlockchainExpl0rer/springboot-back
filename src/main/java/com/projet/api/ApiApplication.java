package com.projet.api;

import com.projet.api.domain.Role;
import com.projet.api.domain.User;
import com.projet.api.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * Permet de lancer le Framework Spring Boot
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@SpringBootApplication
public class ApiApplication {

	/**
	 * Initialise l'app
	 *
	 * @param args Mets des args
	 * @since 19
	 */
	public static void main(String[] args)
	{
		SpringApplication.run(ApiApplication.class, args);
	}

	/**
	 * Ajoute 4 rôles, 4 users et assignes des rôles aux users
	 *
	 * @param userService Ajoute les données
	 * @return Des données crée
	 * @since 19
	 */
	@Bean
	CommandLineRunner run(UserService userService)
	{
		return args -> {

			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Quaranta", "Arthur", "qarthur@youpi.fr", "toto", new ArrayList<>()));
			userService.saveUser(new User(null, "Vinght", "Erosse", "verosse@youpi.fr", "toto", new ArrayList<>()));
			userService.saveUser(new User(null, "Sauvage", "Michel", "smichel@youpi.fr", "toto", new ArrayList<>()));
			userService.saveUser(new User(null, "Bat", "Chris", "bchris@youpi.fr", "toto", new ArrayList<>()));

			userService.addRoleToUser("qarthur@youpi.fr", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("qarthur@youpi.fr", "ROLE_ADMIN");
			userService.addRoleToUser("qarthur@youpi.fr", "ROLE_USER");
			userService.addRoleToUser("verosse@youpi.fr", "ROLE_USER");
			userService.addRoleToUser("verosse@youpi.fr", "ROLE_MANAGER");
			userService.addRoleToUser("smichel@youpi.fr", "ROLE_USER");
			userService.addRoleToUser("bchris@youpi.fr", "ROLE_USER");

		};
	}

}
