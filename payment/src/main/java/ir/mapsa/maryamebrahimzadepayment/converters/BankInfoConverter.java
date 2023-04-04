package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BankInfoDto;
import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankInfoConverter extends BaseConverter<BankInfoDto, BankInfo> {
    @Mapping(source = "d.branchCode",target = "branch.branchCode")
    @Mapping(source = "d.accountTypeName",target = "accountType.name")
    @Mapping(source = "d.customerId",target = "customer.customerId")
    BankInfo convertDto(BankInfoDto d) throws ServiceException;
    @Mapping(source = "branch.branchCode",target = "branchCode")
    @Mapping(source = "accountType.name",target = "accountTypeName")
    @Mapping(source = "customer.customerId",target = "customerId")
    BankInfoDto convertEntity(BankInfo e);
//    @Autowired
//    private BranchService branchService;
//    @Autowired
//    private AccountTypeService accountTypeService;
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private BankInfoService bankInfoService;
}
