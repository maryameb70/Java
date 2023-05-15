package com.example.telepardaz.services;

import com.example.telepardaz.dto.MerchantResponse;
import com.example.telepardaz.exceptions.ServiceException;
import com.example.telepardaz.models.Merchant;
import com.example.telepardaz.models.PersonMerchant;

public interface BaseMerchant {
    <T extends Merchant> MerchantResponse createMerchant(T merchant) throws ServiceException;

    <T extends Merchant> MerchantResponse getMerchantResponse(T merchant);

//    Merchant savePersonMerchant(T personMerchant) throws ServiceException;
}
