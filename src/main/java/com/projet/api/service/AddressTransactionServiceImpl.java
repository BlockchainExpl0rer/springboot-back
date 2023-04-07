package com.projet.api.service;

import com.projet.api.domain.AddressTransaction;
import com.projet.api.domain.repo.AddressTransactionRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * Enregistre une transaction
     *
     * @param addressTransaction La transaction qui va être sauvegardé
     * @return La transaction sauvegardée
     * @since 19
     */
    @Override
    public AddressTransaction saveTransaction(AddressTransaction addressTransaction)
    {
        log.info("Enregistrement d'une transaction {}!", addressTransaction.getStringId());
        return addressTransactionRepo.save(addressTransaction);
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
}
