package rs.ac.ftn.uns.sep.pcc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.dto.BankLookupResponse;
import rs.ac.ftn.uns.sep.pcc.service.TransactionRequestService;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRequestService transactionRequestService;

    @PostMapping("/bankLookup")
    public ResponseEntity<BankLookupResponse> postBankLookup(@RequestBody AcquirerRequest acquirerRequest) {
        final String url = transactionRequestService.findBankUrl(acquirerRequest);
        BankLookupResponse response = new BankLookupResponse(url);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
