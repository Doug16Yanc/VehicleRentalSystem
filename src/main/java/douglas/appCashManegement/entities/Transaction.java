package douglas.appCashManegement.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "tb_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transaction;

    private Double value;
    @CreationTimestamp
    private Instant transactionDatetime;
    public Long getTransaction() {
        return transaction;
    }

    public void setTransaction(Long transaction) {
        this.transaction = transaction;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Instant getTransactionDatetime() {
        return transactionDatetime;
    }

    public void setTransactionDatetime(Instant transactionDatetime) {
        this.transactionDatetime = transactionDatetime;
    }

}
