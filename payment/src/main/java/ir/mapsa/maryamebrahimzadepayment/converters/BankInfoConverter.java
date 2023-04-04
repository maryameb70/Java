package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankInfoConverter extends BaseConverter<BankInfoDto, BankInfo> {
//    @Autowired
//    private BranchService branchService;
//    @Autowired
//    private AccountTypeService accountTypeService;
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private BankInfoService bankInfoService;
}
