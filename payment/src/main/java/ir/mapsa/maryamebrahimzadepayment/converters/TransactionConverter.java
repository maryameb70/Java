package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionConverter extends BaseConverter<TransactionDto, Transaction> {
    @Mapping(source = "d.source", target = "sender.cardNumber")
    @Mapping(source = "d.destination", target = "receiver.cardNumber")
    Transaction convertDto(TransactionDto d) throws ServiceException;

    @Mapping(source = "sender.cardNumber", target = "source")
    @Mapping(source = "receiver.cardNumber", target = "destination")
    TransactionDto convertEntity(Transaction e);
    //    @Autowired
//    private BankInfoRepository bankInfo;


}
