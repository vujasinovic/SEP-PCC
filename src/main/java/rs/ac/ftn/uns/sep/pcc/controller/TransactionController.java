package rs.ac.ftn.uns.sep.pcc.controller;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.ftn.uns.sep.pcc.dto.AcquirerRequest;
import rs.ac.ftn.uns.sep.pcc.service.TransactionRequestService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionRequestService transactionRequestService;

    @SneakyThrows
    @PostMapping("/bankLookup")
    public void postBankLookup(@RequestBody AcquirerRequest acquirerRequest, HttpServletResponse response) {
        final String url = transactionRequestService.findBankUrl(acquirerRequest);

        response.sendRedirect(url);
    }
}
