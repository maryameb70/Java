package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.AccountTypeDto;
import ir.mapsa.maryamebrahimzadepayment.models.AccountType;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeConverter implements BaseConverter<AccountTypeDto, AccountType> {
    @Override
    public AccountType convertDto(AccountTypeDto d) {
        AccountType e = new AccountType();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setInsertTimeStamp(d.getInsertTimeStamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setName(d.getName());
        e.setAccountTypeId(d.getAccountTypeId());
        return e;
    }

    @Override
    public AccountTypeDto convertEntity(AccountType e) {
        AccountTypeDto d = new AccountTypeDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setInsertTimeStamp(e.getInsertTimeStamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setName(e.getName());
        d.setAccountTypeId(e.getAccountTypeId());
        return d;
    }
}
