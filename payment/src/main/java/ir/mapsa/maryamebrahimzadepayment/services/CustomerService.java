package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.controllers.RestExceptionHandler;
import ir.mapsa.maryamebrahimzadepayment.converters.CustomerConverter;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import ir.mapsa.maryamebrahimzadepayment.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService extends AbstractService<CustomerRepository, Customer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    public Customer withdraw(Customer customer, Long amount) {
        try {
            customer = repository.findByCardNumber(customer.getCardNumber());
            if (customer != null && amount < customer.getBalance()) {
                customer.setBalance(customer.getBalance() - amount);
                repository.save(customer);
                return customer;
            }
        } catch (Exception e) {
            LOGGER.error("withdraw exception!",e);
//            throw new ServiceException("");
        }
        return null;
    }

    public Customer deposit(Customer customer, Long amount) {
        try {
            customer = repository.findByCardNumber(customer.getCardNumber());
            if (customer != null) {
                customer.setBalance(customer.getBalance() + amount);
                repository.save(customer);
                return customer;
            }
        } catch (Exception e) {
            LOGGER.error("deposit exception!",e);
//            throw new ServiceException("");
        }
        return null;
    }

    public Long accountBalance(String cardNumber) throws ServiceException {
        Customer customer = repository.findByCardNumber(cardNumber);
        if (customer != null) {
            return customer.getBalance();
        } else {
            throw new ServiceException("user_not_found");
        }
    }

    public Customer convertCard(String cardNumber) {
        return repository.findByCardNumber(cardNumber);
    }
    public Customer getById(Long id) throws ServiceException {
        Optional<Customer> customer = repository.findById(id);
        try {
            return customer.orElseThrow();
        } catch (Exception e) {
            throw new ServiceException(e.getMessage(), "user_not_Found");
        }
    }

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
