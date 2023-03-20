package ir.mapsa.maryamebrahimzadepayment.controllers;

import ir.mapsa.maryamebrahimzadepayment.dto.TransactionDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.Transaction;
import ir.mapsa.maryamebrahimzadepayment.services.CardTransactionService;
import ir.mapsa.maryamebrahimzadepayment.services.TransferLocator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransactionController extends AbstractController<Transaction, TransactionDto, CardTransactionService> {
    @Autowired
    private TransferLocator transferLocator;

    @PostMapping
    public void add(@RequestBody TransactionDto dto) throws ServiceException {
        transferLocator.transfer(dto);
    }
}
