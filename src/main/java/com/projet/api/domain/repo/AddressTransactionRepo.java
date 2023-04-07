package com.projet.api.domain.repo;

import com.projet.api.domain.AddressTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Pour faire des requêtes à la table AddressTransaction
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
public interface AddressTransactionRepo extends JpaRepository<AddressTransaction, Long>
{
    /**
     * Trouve une chaine de caractère dans la table AddressTransaction
     *
     * @param stringId La chaine recherché
     * @return La transaction
     * @since 19
     */
    AddressTransaction findByStringId(String stringId);
}
