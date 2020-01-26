package rs.ac.ftn.uns.sep.pcc.service;

import rs.ac.ftn.uns.sep.pcc.bom.Bank;

import java.util.Collection;

public interface BankService {
    Bank getOne(Long id);

    Collection<Bank> findAll();

    Bank findByName(String name);

    Bank findByCode(String code);
}
