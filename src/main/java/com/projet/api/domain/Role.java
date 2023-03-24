package com.projet.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

/**
 * Classe qui permet de créer un Role pour un utilisateur
 *
 * @author QArthur13
 * @version 1.O
 * @since 19
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;
}
