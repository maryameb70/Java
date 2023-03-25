package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerConverter implements BaseConverter<CustomerDto,Customer> {
    @Autowired
    private BankInfoConverter bankInfoConverter;
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
        e.setEmail(d.getEmail());
        e.setCustomerId(d.getCustomerId());
        e.setBankInfos(bankInfoConverter.convertDto(d.getBankInfos()));
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
        d.setEmail(e.getEmail());
        d.setCustomerId(e.getCustomerId());
        d.setBankInfos(bankInfoConverter.convertEntity(e.getBankInfos()));
        return d;
    }
}
