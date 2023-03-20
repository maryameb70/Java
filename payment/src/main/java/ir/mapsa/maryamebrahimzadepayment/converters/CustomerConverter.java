package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter implements BaseConverter<CustomerDto,Customer> {
    @Override
    public Customer convertDto(CustomerDto d) {
        Customer e = new Customer();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setInsertTimeStamp(d.getInsertTimeStamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setFirstName(d.getFirstName());
        e.setLastName(d.getLastName());
        e.setAge(d.getAge());
        e.setBalance(d.getBalance());
        e.setCardNumber(d.getCardNumber());
        e.setEmail(d.getEmail());
        e.setCustomerId(d.getCustomerId());
        return e;
    }

    @Override
    public CustomerDto convertEntity(Customer e) {
        CustomerDto d = new CustomerDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setInsertTimeStamp(e.getInsertTimeStamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setFirstName(e.getFirstName());
        d.setLastName(e.getLastName());
        d.setAge(e.getAge());
        d.setBalance(e.getBalance());
        d.setCardNumber(e.getCardNumber());
        d.setEmail(e.getEmail());
        d.setCustomerId(e.getCustomerId());
        return d;
    }
}
