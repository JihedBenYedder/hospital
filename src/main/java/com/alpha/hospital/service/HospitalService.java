package com.alpha.hospital.service;

import org.springframework.stereotype.Service;

@Service
public class HospitalService {



    public int getBedsTotalNumber() {
        return 10;
    }

    public int getOccupiedBedsNumber() {
        return 0;
    }
}
