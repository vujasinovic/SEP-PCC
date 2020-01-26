package rs.ac.ftn.uns.sep.pcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.ftn.uns.sep.pcc.bom.TransactionRequest;

@Repository
public interface TransactionRequestRepository extends JpaRepository<TransactionRequest, Long> {
}
