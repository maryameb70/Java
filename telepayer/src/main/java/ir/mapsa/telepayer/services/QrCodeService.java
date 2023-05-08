package ir.mapsa.telepayer.services;

import ir.mapsa.telepayer.dto.QRCodeDto;
import ir.mapsa.telepayer.exceptions.ServiceException;
import ir.mapsa.telepayer.models.Merchant;
import ir.mapsa.telepayer.models.QRCode;
import ir.mapsa.telepayer.repositories.QRCodeRepository;
import org.springframework.stereotype.Service;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

@Service
public class QrCodeService extends AbstractService<QRCodeRepository, QRCode> {
    public void createQRCode(QRCodeDto dto) throws ServiceException, IOException, WriterException {
        Merchant merchant = repository.findByMerchantPaymentId(dto.getMerchantPaymentId());
        if (merchant == null) {
            throw new ServiceException("This_merchandise_is_not_registered_in_the_system");
        }
       // String qrCodeText = "https://www.journaldev.com";
        String qrCodeText = String.valueOf(saveQrCode(dto));
        String filePath = "JD.png";
        int size = 125;
        String fileType = "png";
        File qrFile = new File(filePath);
        createQRImage(qrFile, qrCodeText, size, fileType);
    }

    private QRCode saveQrCode(QRCodeDto dto) {
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
        return qrCode;
    }

    private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
            throws WriterException, IOException {

        Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);

        int matrixWidth = byteMatrix.getWidth();
        BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
        image.createGraphics();

        Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, matrixWidth, matrixWidth);
        graphics.setColor(Color.BLACK);

        for (int i = 0; i < matrixWidth; i++) {
            for (int j = 0; j < matrixWidth; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }
        ImageIO.write(image, fileType, qrFile);
    }

}
