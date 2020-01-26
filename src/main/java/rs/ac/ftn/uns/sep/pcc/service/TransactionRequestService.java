package rs.ac.ftn.uns.sep.pcc.service;

import rs.ac.ftn.uns.sep.pcc.bom.TransactionRequest;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;

import java.util.Collection;

public interface TransactionRequestService {
    TransactionRequest save(TransactionRequest transactionRequest);

    Collection<TransactionRequest> findAll();

    TransactionRequest getOne(Long id);

    String findBankUrl(AcquirerRequest acquirerRequest);
}
