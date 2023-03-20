package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import ir.mapsa.maryamebrahimzadepayment.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerService extends AbstractService<CustomerRepository, Customer> {

    public void withdraw(Customer customer, Long amount) throws ServiceException {
        if (amount > customer.getBalance()) {
            throw new ServiceException("your_balance_is_not_enough");
        }
        customer.setBalance(customer.getBalance() - amount);
        repository.save(customer);
    }

    public void deposit(Customer customer, Long amount) {
        customer.setBalance(customer.getBalance() + amount);
        repository.save(customer);
    }

    public Long accountBalance(String cardNumber) throws ServiceException {
        Customer customer = repository.findByCardNumber(cardNumber);
        if (customer != null) {
            return customer.getBalance();
        } else {
            throw new ServiceException("user_not_found");
        }
    }

    public Customer findByCardNumber(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }
    public Customer findByAccountNumber(String acNum) {
        return repository.findByCardNumber(acNum);
    }
    public Customer getById(Long id) throws ServiceException {
        Optional<Customer> customer = repository.findById(id);
        try {
            return customer.orElseThrow();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), "user_not_Found");
        }
    }

    @Transactional
    public void update(CustomerDto customerDto) throws ServiceException {
        Customer customer = repository.findById(customerDto.getId())
                .orElseThrow(() -> new ServiceException("customer_not_found"));
        change(customer, customerDto);
        repository.save(customer);
    }

    private void change(Customer customer, CustomerDto customerDto) {
        if (customerDto.getCardNumber() != null) customer.setCardNumber(customerDto.getCardNumber());
        if (customerDto.getAge() != null) customer.setAge(customerDto.getAge());
        if (customerDto.getBalance() != null) customer.setBalance(customerDto.getBalance());
        if (customerDto.getFirstName() != null) customer.setFirstName(customerDto.getFirstName());
        if (customerDto.getLastName() != null) customer.setLastName(customerDto.getLastName());
    }
}
