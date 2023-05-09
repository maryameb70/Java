package com.example.telepardaz.repositories;

import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.QrRCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QrRCode, Long> {

}
