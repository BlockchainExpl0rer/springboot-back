package com.projet.api.service;

import com.projet.api.domain.AddressTransaction;

import java.util.List;

/**
 * Déclaration des actions CRUD sur le model AddressTransaction
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
public interface AddressTransactionService
{
    /**
     * Enregistre une transaction
     *
     * @param addressTransaction La transaction qui va être sauvegardé
     * @return La transaction sauvegardée
     * @since 19
     */
    AddressTransaction saveTransaction(AddressTransaction addressTransaction);

    /**
     * Récupère un nom d'une transaction
     *
     * @param stringId Le nom de la transaction
     * @return La transaction récupère
     * @since 19
     */
    AddressTransaction getTransaction(String stringId);

    /**
     * Récupère toutes les transactions
     *
     * @return Une liste des transactions
     * @since 19
     */
    List<AddressTransaction>getTransactions();
}
