package com.example.paymentta.service;

import com.example.paymentta.dto.CardDto;
import com.example.paymentta.exceptions.ServiceException;

public interface BaseTransaction<D> {
    void resolveTransaction(D d) throws ServiceException;}
