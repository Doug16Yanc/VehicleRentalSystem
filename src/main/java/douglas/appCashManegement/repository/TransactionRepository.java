package douglas.appCashManegement.repository;

import douglas.appCashManegement.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
