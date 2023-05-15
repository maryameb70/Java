package com.example.telepardaz.repositories;

import com.example.telepardaz.models.QrCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QRCodeRepository extends JpaRepository<QrCode, Long> {
    QrCode findByTerminalId(String terminalId);
}
