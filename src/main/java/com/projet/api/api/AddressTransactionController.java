package com.projet.api.api;

import com.projet.api.domain.AddressTransaction;
import com.projet.api.service.AddressTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AddressTransactionController
{
    private final AddressTransactionService addressTransactionService;

    /**
     * Récupère une liste d'un ensemble de transactions
     *
     * @return Une liste de transactions
     */
    @GetMapping("/transactions")
    public ResponseEntity<List<AddressTransaction>>getAddressTransactions()
    {
        return ResponseEntity.ok().body(addressTransactionService.getTransactions());
    }

    /**
     * Récupère une transaction en fonction de son id.
     *
     * @param transactionId L'id de la transaction
     */
    @GetMapping("/transactions/{transactionId}")
    public void getTransaction(@PathVariable("transactionId") Long transactionId)
    {
        addressTransactionService.getTransaction(transactionId);
    }

    /**
     * Ajoute une transaction
     *
     * @param addressTransaction La transaction
     * @return La transaction enregistrée
     */
    @PostMapping("/transactions")
    public ResponseEntity<AddressTransaction> saveTransaction(@RequestBody AddressTransaction addressTransaction)
    {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/v1/transactions").toUriString());

        return ResponseEntity.created(uri).body(addressTransactionService.saveTransaction(addressTransaction));
    }

    /**
     * Mets à jour une transaction
     *
     * @param transactionId L'id de la transaction
     * @param stringId Le nom de la transaction
     */
    @PutMapping("/transactions/{transactionId}")
    public void updateTransaction(@PathVariable("transactionId") Long transactionId, @RequestParam String stringId)
    {
        addressTransactionService.updateTransaction(transactionId, stringId);
    }

    /**
     * Supprime une transaction
     *
     * @param transactionId L'id de la transaction
     */
    @DeleteMapping("/transactions/{transactionId}")
    public void deleteTransaction(@PathVariable("transactionId") Long transactionId)
    {
        addressTransactionService.deleteTransaction(transactionId);
    }
}
