package com.projet.api.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

/**
 * Classe pour les transactions de la crypto
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressTransaction
{
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String stringId;
}
