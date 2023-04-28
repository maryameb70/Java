package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sample {
    @Autowired
    private Parent parent;

    @Autowired
    private Interface child3;
}
