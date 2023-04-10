package com.projet.api.service;

import com.projet.api.domain.AddressTransaction;
import com.projet.api.domain.repo.AddressTransactionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Pour effectuer les actions du CRUD de la table addressTransaction
 *
 * @author QArthur13
 * @version 1.0
 * @since 19
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AddressTransactionServiceImpl implements AddressTransactionService
{
    private final AddressTransactionRepo addressTransactionRepo;

    /**
     * Récupère toutes les transactions
     *
     * @return Une liste des transactions
     * @since 19
     */
    @Override
    public List<AddressTransaction> getTransactions()
    {
        log.info("Fetching des transactions!");
        return addressTransactionRepo.findAll();
    }

    /**
     * Récupère une transaction en fonction de son id
     *
     * @param transactionId L'id de la transaction
     */
    @Override
    public void getTransaction(Long transactionId)
    {
        log.info("Fetching d'une transaction {}!", transactionId);
        addressTransactionRepo.findById(transactionId);
    }

    /**
     * Récupère un nom d'une transaction
     *
     * @param stringId Le nom de la transaction
     * @return La transaction récupère
     * @since 19
     */
    @Override
    public AddressTransaction getTransaction(String stringId)
    {
        log.info("Fetching d'une transaction {}!", stringId);
        return addressTransactionRepo.findByStringId(stringId);
    }

    /**
     * Enregistre une transaction
     *
     * @param addressTransaction La transaction qui va être sauvegardé
     * @return La transaction sauvegardée
     * @since 19
     */
    @Override
    public AddressTransaction saveTransaction(AddressTransaction addressTransaction)
    {
        if (addressTransaction.getStringId().length() == 50) {

            log.info("Enregistrement d'une transaction {}", addressTransaction.getStringId());
            return addressTransactionRepo.save(addressTransaction);

        } else {

            throw new IllegalStateException("La taille doit être égal à 50! Pas inférieur ou supérieur!");

        }
    }

    /**
     * Mets à jour une transaction
     *
     * @param transactionId L'id de la transaction
     * @param stringId Le nom de la nouvelle transaction
     */
    @Override
    public void updateTransaction(Long transactionId, String stringId)
    {
        AddressTransaction addressTransaction = addressTransactionRepo.findById(transactionId).orElseThrow(() -> new IllegalStateException("L'id N°" + transactionId + " n'existe pas!"));

        if (stringId != null && stringId.length() > 0 && !Objects.equals(addressTransaction.getStringId(), stringId)) {

            log.info("Mise à jour d'une transaction {}!", stringId);
            addressTransaction.setStringId(stringId);

        }
    }

    /**
     * Supprime une transaction
     *
     * @param transactionId L'id de la transaction
     */
    @Override
    public void deleteTransaction(Long transactionId)
    {
        boolean exist = addressTransactionRepo.existsById(transactionId);

        if (!exist) {

            throw new IllegalStateException("L'id N°" + transactionId + " n'existe pas!");

        }

        log.info("Suppression d'un id d'une transaction {}!", transactionId);
        addressTransactionRepo.deleteById(transactionId);
    }
}
