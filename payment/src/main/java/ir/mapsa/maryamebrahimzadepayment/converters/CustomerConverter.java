package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.models.Customer;
import ir.mapsa.maryamebrahimzadepayment.dto.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerConverter extends BaseConverter<CustomerDto,Customer> {
//    @Autowired
//    private BankInfoConverter bankInfoConverter;

}
