package ir.mapsa.telepardaz.repositories;

import ir.mapsa.telepardaz.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {
    Merchant findByUsername(String username);
}
