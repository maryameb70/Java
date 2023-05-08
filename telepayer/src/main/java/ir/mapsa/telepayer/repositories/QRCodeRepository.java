package ir.mapsa.telepayer.repositories;

import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.models.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    Merchant findByMerchantPaymentId(String merchantId);
}
