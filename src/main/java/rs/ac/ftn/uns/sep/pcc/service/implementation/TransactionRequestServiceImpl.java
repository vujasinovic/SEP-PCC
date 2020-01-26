package rs.ac.ftn.uns.sep.pcc.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.ftn.uns.sep.pcc.bom.Bank;
import rs.ac.ftn.uns.sep.pcc.bom.TransactionRequest;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.repository.TransactionRequestRepository;
import rs.ac.ftn.uns.sep.pcc.service.BankService;
import rs.ac.ftn.uns.sep.pcc.service.TransactionRequestService;
import rs.ac.ftn.uns.sep.pcc.utils.MapperUtils;

import java.util.Collection;

import static rs.ac.ftn.uns.sep.pcc.globals.TransactionConstants.*;

@Service
@RequiredArgsConstructor
public class TransactionRequestServiceImpl implements TransactionRequestService {
    private final BankService bankService;

    private final TransactionRequestRepository transactionRequestRepository;

    @Override
    public TransactionRequest save(TransactionRequest transactionRequest) {
        return transactionRequestRepository.save(transactionRequest);
    }

    @Override
    public Collection<TransactionRequest> findAll() {
        return transactionRequestRepository.findAll();
    }

    @Override
    public TransactionRequest getOne(Long id) {
        return transactionRequestRepository.getOne(id);
    }

    @Override
    public String findBankUrl(AcquirerRequest acquirerRequest) {
        final String issuerIdNumber = acquirerRequest.getPan()
                .replace(PAN_NUMBER_DELIMITER, PAN_NUMBER_DELIMITER_REPLACEMENT)
                .substring(IIN_NUMBER_START_INDEX, IIN_NUMBER_END_INDEX);

        TransactionRequest transactionRequest = MapperUtils.map(acquirerRequest, TransactionRequest.class);
        transactionRequestRepository.save(transactionRequest);

        Bank bank = bankService.findByCode(issuerIdNumber);

        return bank.getUrl();
    }
}
