package com.example.telepardaz.services;

import com.example.telepardaz.dto.transfer.PaymentMessage;
import com.example.telepardaz.controllers.TransferClient;
import com.example.telepardaz.controllers.TransferToWalletClient;
import com.example.telepardaz.dto.TransferDto;
import com.example.telepardaz.dto.transfer.*;
import com.example.telepardaz.enums.TrackingStatus;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.Transaction;
import com.example.telepardaz.models.UserDetails;
import com.example.telepardaz.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransferService extends BaseService<TransactionRepository, Transaction> {
    @Autowired
    private MerchantService merchantService;

    @Autowired
    private TransferClient transferClient;

    @Autowired
    private TransferToWalletClient transferToWalletClient;


    public PaymentMessage transfer(TransferDto transferDto, UserDetails userDetails) throws ServiceException {
        Optional<Merchant> merchant = merchantService.findById(transferDto.getMerchantId());
        switch (transferDto.getTransferMethod()) {
            case TO_CARD -> {
                CardDto cardDto = CardDto.builder()
                        .sourceCardNumber("5859831048450950")
                        .destinationCardNumber(merchant.get().getCardNumber())
                        .cvv2(4502)
                        .expireTime("06-07")
                        .otp(123456)
                        .amount(transferDto.getAmount()).build();
                PaymentMessage paymentMessage = transferClient.doTransferCard(cardDto);
                return getPaymentMessage(paymentMessage);
            }
            case TO_ACCOUNT -> {
                AccountDto accountDto = AccountDto.builder()
                        .sourceAccountNumber("5859831093")
                        .destinationAccountNumber(merchant.get().getAccountNumber())
                        .amount(transferDto.getAmount()).build();
                PaymentMessage paymentMessage = transferClient.doTransferAccount(accountDto);
                return getPaymentMessage(paymentMessage);
            }
            case TO_PAYMENT -> {
                PaymentDto paymentDto = PaymentDto.builder()
                        .cardNumber(merchant.get().getCardNumber())
                        .cvv2(4502)
                        .expireTime("06-07")
                        .otp(123456)
                        .amount(transferDto.getAmount()).build();

                PaymentMessage paymentMessage = transferClient.doTransferPayment(paymentDto);
                return getPaymentMessage(paymentMessage);
            }
            case TO_WALLET -> {
                WalletDto walletDto = WalletDto.builder()
                        .trackingId(UUID.randomUUID().toString())
                        .amount(transferDto.getAmount()).build();
                saveTransaction(userDetails, walletDto);
                PaymentMessage paymentMessage = transferToWalletClient.doTransferWallet(walletDto);
                return getPaymentMessage(paymentMessage);
            }
            case WALLET_TO_WALLET -> {
                WalletToWalletDto walletToWalletDto = WalletToWalletDto.builder()
                        .userName("maryam")
                        .amount(transferDto.getAmount()).build();
                PaymentMessage paymentMessage = transferToWalletClient.doTransferWalletToWallet(walletToWalletDto);
                return getPaymentMessage(paymentMessage);
            }
            default -> throw new IllegalStateException("Unexpected value: " + transferDto.getTransferMethod());
        }
    }

    private void saveTransaction(UserDetails userDetails, WalletDto walletDto) {
        Transaction transfer = new Transaction();
        transfer.setAmount(walletDto.getAmount());
        transfer.setTrackingId(walletDto.getTrackingId());
        transfer.setUserName(userDetails.getSub());
        repository.save(transfer);
    }

    private static PaymentMessage getPaymentMessage(PaymentMessage paymentMessage) {
        PaymentMessage message = new PaymentMessage();
//        message.setMessage(paymentMessage.getMessage());
        return message;
    }

    public void retryDeposit(WalletDto walletDto) throws Exception {
        Transaction trans = repository.findByTrackingId(walletDto.getTrackingId());
        for (int i = 0; i < 3; i++) {
//            PaymentMessage paymentMessage1 = transferToWalletClient.doTransferTransaction(walletDto.getTrackingId());
//            if (paymentMessage1.getTrackingStatus() == TrackingStatus.FAIL) {
                try {
                    PaymentMessage paymentMessage = transferToWalletClient.doTransferWallet(walletDto);
                    if (paymentMessage.getTrackingStatus().equals(TrackingStatus.SUCCESS)) {
                        trans.setStatus(TrackingStatus.SUCCESS);
                        break;
                    }

                   // trans.setStatus(TrackingStatus.FAIL);

                } catch (HttpServerErrorException | HttpClientErrorException e) {
                    trans.setStatus(TrackingStatus.TIMEOUT);
                    throw new ServiceException("cannot-get-response-from-wallet", e, e.getStatusCode().toString());
                } finally {
                    super.update(trans);
                }
            }
        }

    }
//}
