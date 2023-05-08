package ir.mapsa.telepardaz.repositories;

import ir.mapsa.telepardaz.models.QRCode;
import ir.mapsa.telepardaz.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    Merchant findByMerchantPaymentId(String merchantId);
}
