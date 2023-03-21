package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.repositories.AccountTypeRepository;
import ir.mapsa.maryamebrahimzadepayment.repositories.BranchRepository;
import ir.mapsa.maryamebrahimzadepayment.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankInfoConverter implements BaseConverter<BankInfoDto, BankInfo> {
    @Autowired
    private BranchRepository branchRepository;
    @Autowired
    private AccountTypeRepository accountTypeRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public BankInfo convertDto(BankInfoDto d) {
        BankInfo e = new BankInfo();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setInsertTimeStamp(d.getInsertTimeStamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setBankName(d.getBankName());
        e.setCardNumber(d.getCardNumber());
        e.setAccountNumber(d.getAccountNumber());
        e.setShabaNumber(d.getShabaNumber());
        e.setBalance(d.getBalance());
        e.setCcv(d.getCcv());
        e.setExpirationDate(d.getExpirationDate());
        e.setBranch(branchRepository.findByBranchCode(d.getBranchCode()));
        e.setAccountType(accountTypeRepository.findByName(d.getAccountTypeName()));
        e.setCustomer(customerRepository.findByCustomerId(d.getCustomerId()));
        e.setBankInfoId(d.getBankInfoId());
        return e;
    }

    @Override
    public BankInfoDto convertEntity(BankInfo e) {
        BankInfoDto d = new BankInfoDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setInsertTimeStamp(e.getInsertTimeStamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setBankName(e.getBankName());
        d.setCardNumber(e.getCardNumber());
        d.setAccountNumber(e.getAccountNumber());
        d.setShabaNumber(e.getShabaNumber());
        d.setBalance(e.getBalance());
        d.setCcv(e.getCcv());
        d.setExpirationDate(e.getExpirationDate());
        d.setBranchCode(e.getBranch().getBranchCode());
        d.setAccountTypeName(e.getAccountType().getAccountTypeId());
        d.setCustomerId(e.getCustomer().getCustomerId());
        d.setBankInfoId(e.getBankInfoId());
        return d;
    }
}
