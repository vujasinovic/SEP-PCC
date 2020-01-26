package rs.ac.ftn.uns.sep.pcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.ftn.uns.sep.pcc.bom.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
    Bank findByCode(String code);

    Bank findByName(String name);
}
