package pl.bn.tour.service;

import pl.bn.tour.model.TourDTO;

import java.math.BigInteger;

public interface TourService {
    TourDTO get(BigInteger tourId);
    TourDTO insert(TourDTO tourDTO);
    TourDTO update(TourDTO tourDTO);
}
