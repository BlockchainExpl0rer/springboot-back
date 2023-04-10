package com.projet.api.service;

import com.projet.api.domain.AddressTransaction;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
     * Récupère toutes les transactions
     *
     * @return Une liste des transactions
     * @since 19
     */
    List<AddressTransaction>getTransactions();

    /**
     * Récupère une transaction en fonction de son id
     *
     * @param transactionId L'id de la transaction
     */
    void getTransaction(Long transactionId);

    /**
     * Récupère une transaction en fonction du nom de sa transaction
     *
     * @param stringId Le nom de la transaction
     * @return La transaction récupère
     * @since 19
     */
    AddressTransaction getTransaction(String stringId);

    /**
     * Enregistre une transaction
     *
     * @param addressTransaction La transaction qui va être sauvegardé
     * @return La transaction sauvegardée
     * @since 19
     */
    AddressTransaction saveTransaction(AddressTransaction addressTransaction);

    /**
     * Mets à jour une transaction
     *
     * @param transactionId L'id de la transaction
     * @param stringId Le nom de la nouvelle transaction
     */
    void updateTransaction(Long transactionId, String stringId);

    /**
     * Supprime une transaction
     *
     * @param transactionId L'id de la transaction
     */
    void deleteTransaction(Long transactionId);

}
