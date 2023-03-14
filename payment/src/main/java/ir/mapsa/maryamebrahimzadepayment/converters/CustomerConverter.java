package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter implements BaseConverter<CustomerDto,Customer> {
   @Autowired
   private TransactionConverter transactionConverter;
    @Override
    public Customer convertDto(CustomerDto d) {
        Customer e = new Customer();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setFirstName(d.getFirstName());
        e.setLastName(d.getLastName());
        e.setAge(d.getAge());
        e.setBalance(d.getBalance());
        e.setCardNumber(d.getCardNumber());
        e.setEmail(d.getEmail());
        e.setCustomerId(d.getCustomerId());
        e.setTransactions(transactionConverter.convertDto(d.getTransactions()));
        return e;
    }

    @Override
    public CustomerDto convertEntity(Customer e) {
        CustomerDto d = new CustomerDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setFirstName(e.getFirstName());
        d.setLastName(e.getLastName());
        d.setAge(e.getAge());
        d.setBalance(e.getBalance());
        d.setCardNumber(e.getCardNumber());
        d.setEmail(e.getEmail());
        d.setCustomerId(e.getCustomerId());
        d.setTransactions(transactionConverter.convertEntity(e.getTransactions()));
        return d;
    }
}
