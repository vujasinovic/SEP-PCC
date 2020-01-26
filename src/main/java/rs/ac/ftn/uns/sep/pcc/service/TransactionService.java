package rs.ac.ftn.uns.sep.pcc.service;

import rs.ac.ftn.uns.sep.pcc.bom.Transaction;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.dto.IssuerRequest;

import java.util.Collection;

public interface TransactionService {
    Transaction save(Transaction transaction);

    Collection<Transaction> findAll();

    Transaction getOne(Long id);

    String findBankUrl(AcquirerRequest acquirerRequest);

    void sendTransactionResults(IssuerRequest issuerRequest);
}
