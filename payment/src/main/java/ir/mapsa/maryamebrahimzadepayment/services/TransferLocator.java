package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TransferLocator {
    @Autowired
    private List<BaseTransaction> transfers;
    @Autowired
    private CardTransactionService service;
    public void transfer(TransactionDto tDto) throws ServiceException {
        boolean support = true;
        for (BaseTransaction transfer : transfers) {
            if (transfer.resolve(tDto)) {
                service.transfer(tDto);
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
}
