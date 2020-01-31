package rs.ac.ftn.uns.sep.pcc.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rs.ac.ftn.uns.sep.pcc.bom.Bank;
import rs.ac.ftn.uns.sep.pcc.bom.Transaction;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.dto.IssuerRequest;
import rs.ac.ftn.uns.sep.pcc.repository.TransactionRepository;
import rs.ac.ftn.uns.sep.pcc.service.BankService;
import rs.ac.ftn.uns.sep.pcc.service.TransactionService;
import rs.ac.ftn.uns.sep.pcc.utils.MapperUtils;

import java.net.URL;
import java.util.Collection;

import static rs.ac.ftn.uns.sep.pcc.globals.TransactionConstants.*;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final BankService bankService;

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Collection<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getOne(Long id) {
        return transactionRepository.getOne(id);
    }

    @Override
    public String findBankUrl(AcquirerRequest acquirerRequest) {
        final String issuerIdNumber = acquirerRequest.getPan()
                .replace(PAN_NUMBER_DELIMITER, PAN_NUMBER_DELIMITER_REPLACEMENT)
                .substring(IIN_NUMBER_START_INDEX, IIN_NUMBER_END_INDEX);

        Transaction transaction = MapperUtils.map(acquirerRequest, Transaction.class);
        transactionRepository.save(transaction);

        Bank bank = bankService.findByCode(issuerIdNumber);

        return bank.getUrl();
    }

    @SneakyThrows
    @Override
    public void sendTransactionResults(IssuerRequest issuerRequest) {
        Transaction transaction = transactionRepository.findByAcquirerName(issuerRequest.getAcquirerName());

        Bank acquirer = bankService.findByName(transaction.getAcquirerName());

        RestTemplate restTemplate = new RestTemplate();

        //TODO: create endpoint in Acquirer that will handle following request (add payment amount to merchant if successful)
        restTemplate.postForEntity(new URL(acquirer.getUrl()).toString(), issuerRequest, IssuerRequest.class);
    }
}
