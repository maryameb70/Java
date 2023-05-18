package com.example.telepardaz.repositories;

import com.example.telepardaz.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByTrackingId(String trackingId);
}
