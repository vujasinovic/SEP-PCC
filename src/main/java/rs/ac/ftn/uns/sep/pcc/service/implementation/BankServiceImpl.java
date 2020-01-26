package rs.ac.ftn.uns.sep.pcc.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.ftn.uns.sep.pcc.bom.Bank;
import rs.ac.ftn.uns.sep.pcc.repository.BankRepository;
import rs.ac.ftn.uns.sep.pcc.service.BankService;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {
    private final BankRepository bankRepository;

    @Override
    public Bank getOne(Long id) {
        return bankRepository.getOne(id);
    }

    @Override
    public Collection<Bank> findAll() {
        return bankRepository.findAll();
    }

    @Override
    public Bank findByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public Bank findByCode(String code) {
        return bankRepository.findByCode(code);
    }
}
