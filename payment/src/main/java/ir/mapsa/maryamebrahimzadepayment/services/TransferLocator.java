package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class TransferLocator {
    @Autowired
    private List<BaseTransaction> transfers;
    public void transfer(TransactionDto tDto) throws ServiceException {
        boolean support = true;
        for (BaseTransaction transfer : transfers) {
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
}
