package rs.ac.ftn.uns.sep.pcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.ftn.uns.sep.pcc.bom.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByAcquirerName(String acquirerName);
}
