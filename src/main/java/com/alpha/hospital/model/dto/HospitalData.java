package com.alpha.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HospitalData implements Serializable {

    private Integer totalBedsNumber;
    private Integer occupiedBedsNumber;
    private Integer occupancyRate;

    public HospitalData(HospitalData data) {
        this.totalBedsNumber = data.getTotalBedsNumber();
        this.occupiedBedsNumber = data.getOccupiedBedsNumber();
        this.occupancyRate = data.getOccupancyRate();
    }

    public Integer getTotalBedsNumber() {
        return totalBedsNumber;
    }

    public void setTotalBedsNumber(Integer totalBedsNumber) {
        this.totalBedsNumber = totalBedsNumber;
    }

    public Integer getOccupiedBedsNumber() {
        return occupiedBedsNumber;
    }

    public void setOccupiedBedsNumber(Integer occupiedBedsNumber) {
        this.occupiedBedsNumber = occupiedBedsNumber;
    }

    public Integer getOccupancyRate() {
        return occupancyRate;
    }

    public void setOccupancyRate(Integer occupancyRate) {
        this.occupancyRate = occupancyRate;
    }
}
