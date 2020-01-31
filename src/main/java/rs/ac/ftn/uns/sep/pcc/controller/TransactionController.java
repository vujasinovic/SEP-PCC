package rs.ac.ftn.uns.sep.pcc.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.dto.IssuerRequest;
import rs.ac.ftn.uns.sep.pcc.service.TransactionService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @SneakyThrows
    @PostMapping("/bankLookup")
    public void postBankLookup(@RequestBody AcquirerRequest acquirerRequest, HttpServletResponse response) {
        final String url = transactionService.findBankUrl(acquirerRequest);

        //TODO: hit issuer (check HomeController in PCC project)
        response.sendRedirect(url);
    }

    @PostMapping("/handleTransactionResult")
    public void getHandleTransactionResult(@RequestBody IssuerRequest issuerRequest) {
        transactionService.sendTransactionResults(issuerRequest);
    }

    //TODO open another endpoint that will handle data sent from PCC
}
