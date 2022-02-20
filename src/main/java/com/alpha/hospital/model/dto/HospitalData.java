package com.alpha.hospital.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HospitalData implements Serializable {

    private static final long serialVersionUID = 6529685098267757697L;

    private Integer totalBedsNumber;
    private Integer occupiedBedsNumber;
    private Integer occupancyRate;

    public HospitalData(Integer totalBedsNumber, Integer occupiedBedsNumber, Integer occupancyRate ) {
        this.totalBedsNumber = totalBedsNumber;
        this.occupiedBedsNumber = occupiedBedsNumber;
        this.occupancyRate = occupancyRate;
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
