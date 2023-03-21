package ir.mapsa.maryamebrahimzadepayment.services;

import ir.mapsa.maryamebrahimzadepayment.exceptions.ServiceException;
import ir.mapsa.maryamebrahimzadepayment.models.BankInfo;
import ir.mapsa.maryamebrahimzadepayment.models.Branch;
import ir.mapsa.maryamebrahimzadepayment.repositories.BankInfoRepository;
import ir.mapsa.maryamebrahimzadepayment.repositories.BranchRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BranchService extends AbstractService<BranchRepository, Branch> {


}
