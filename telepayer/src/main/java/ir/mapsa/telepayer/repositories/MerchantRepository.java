package ir.mapsa.telepayer.repositories;

import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.models.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByUsername(String username);
}
