package ir.mapsa.telepayer.services;

import ir.mapsa.telepayer.dto.QRCodeDto;
import ir.mapsa.telepayer.exceptions.ServiceException;
import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.models.QRCode;
import ir.mapsa.telepayer.repositories.QRCodeRepository;
import org.springframework.stereotype.Service;

@Service
public class QrCodeService extends AbstractService<QRCodeRepository, QRCode> {
    public void createQRCode(QRCodeDto dto) throws ServiceException {
        Merchant merchant = repository.findByMerchantPaymentId(dto.getMerchantPaymentId());
        if (merchant == null) {
            throw new ServiceException("This_merchandise_is_not_registered_in_the_system");
        }
        QRCode qrCode = new QRCode();
        qrCode.setMerchantPaymentId(dto.getMerchantPaymentId());
        qrCode.setAmount(dto.getAmount());
        qrCode.setOrderDescription(dto.getOrderDescription());
        qrCode.setOrderItems(dto.getOrderItems());
        qrCode.setMetadata(dto.getMetadata());
        qrCode.setCodeType(dto.getCodeType());
        qrCode.setStoreInfo(dto.getStoreInfo());
        qrCode.setStoreId(dto.getStoreId());
        qrCode.setTerminalId(dto.getTerminalId());
        qrCode.setRequestedAt(dto.getRequestedAt());
        qrCode.setIsAuthorization(dto.getIsAuthorization());
        qrCode.setAuthorizationExpiry(dto.getAuthorizationExpiry());
        qrCode.setRedirectUrl(dto.getRedirectUrl());
        repository.save(qrCode);
    }
}
