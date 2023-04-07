package com.projet.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

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
