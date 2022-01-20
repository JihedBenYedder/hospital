package com.alpha.hospital.model.dto;

public class HospitalData {

    private int totalBedsNumber;
    private int occupiedBedsNumber;

    public int getTotalBedsNumber() {
        return totalBedsNumber;
    }

    public void setTotalBedsNumber(int totalBedsNumber) {
        this.totalBedsNumber = totalBedsNumber;
    }

    public int getOccupiedBedsNumber() {
        return occupiedBedsNumber;
    }

    public void setOccupiedBedsNumber(int occupiedBedsNumber) {
        this.occupiedBedsNumber = occupiedBedsNumber;
    }
}
