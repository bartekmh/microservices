package pl.bn.tour.controller;

import pl.bn.tour.model.TourDTO;

import java.math.BigInteger;
import java.util.List;

public interface TourController {
    List<TourDTO> getTours();

    TourDTO getTour(BigInteger id);

    TourDTO insertTour(TourDTO tour);

    TourDTO updateTour(TourDTO tour);

    String deleteTour(BigInteger tourId);
}
