package ir.mapsa.maryamebrahimzadepayment.converters;

import ir.mapsa.maryamebrahimzadepayment.dto.BranchDto;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import org.springframework.stereotype.Service;

@Service
public class BranchConverter implements BaseConverter<BranchDto, Branch> {
    @Override
    public Branch convertDto(BranchDto d) {
        Branch e = new Branch();
        e.setId(d.getId());
        e.setVersion(d.getVersion());
        e.setInsertTimeStamp(d.getInsertTimeStamp());
        e.setLastUpdateTimestamp(d.getLastUpdateTimestamp());
        e.setName(d.getName());
        e.setBranchCode(d.getBranchCode());
        e.setBranchId(d.getBranchId());
        return e;
    }

    @Override
    public BranchDto convertEntity(Branch e) {
        BranchDto d = new BranchDto();
        d.setId(e.getId());
        d.setVersion(e.getVersion());
        d.setInsertTimeStamp(e.getInsertTimeStamp());
        d.setLastUpdateTimestamp(e.getLastUpdateTimestamp());
        d.setName(e.getName());
        d.setBranchCode(e.getBranchCode());
        d.setBranchId(e.getBranchId());
        return d;
    }
}
