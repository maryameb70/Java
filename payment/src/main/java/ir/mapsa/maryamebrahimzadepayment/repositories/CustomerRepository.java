package ir.mapsa.maryamebrahimzadepayment.repositories;

import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByCardNumber(String cardNumber);
    Customer findByAccountNumber(String accountNumber);
}

