package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import ir.mapsa.maryamebrahimzadepayment.repositories.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransferLocator {
    @Autowired
    private List<BaseTransfer> transfers;
//    private Map<TransactionType, BaseTransfer> map=new HashMap<>();
//    @PostConstruct
//    public void init() {
////        Map<String, BaseTransfer> map = transfers.stream()
////                .collect(Collectors.toMap(BaseTransfer::getType, transfers::));
//        transfers.forEach(l->map.put(l.getType(),l));
//    }

    public void transfer(TransactionDto tDto) throws ServiceException {
        boolean support = true;
        for (BaseTransfer transfer : transfers) {
            if (transfer.resolve(tDto)) {
                transfer.transfer(tDto);
                support=true;
                break;
            } else {
                support = false;
            }
        }
        if (!support) {
            throw new ServiceException("transfer_not_supported");
        }
    }

//    public BaseTransfer getTransactionType(TransactionType method) {
//        return map.get(method);
//    }
}
