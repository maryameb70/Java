package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransferDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferLocator extends AbstractService<TransactionRepository, Transaction> {
    @Autowired
    private List<BaseTransfer> transfers;

    public void transfer(TransferDto tDto) throws ServiceException {
        boolean support = true;
        for (BaseTransfer transfer : transfers) {
            if (transfer.resolve(tDto)) {
                transfer.transfer(tDto);
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
