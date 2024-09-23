package pl.bn.tour.model;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;

public class TourDTO {
    private BigInteger tourId;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String description;

    public TourDTO(BigInteger tourId, String name, LocalDate date, LocalTime time, String description) {
        this.tourId = tourId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public TourDTO() {


    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigInteger getTourId() {
        return tourId;
    }

    public void setTourId(BigInteger tourId) {
        this.tourId = tourId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
