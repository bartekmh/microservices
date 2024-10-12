package pl.bn.tour.controller;

import pl.bn.tour.model.TourDTO;

import java.math.BigInteger;
import java.util.List;

public interface TourController {
    List<TourDTO> getAll();

    TourDTO getOne(BigInteger id);

    TourDTO insert(TourDTO tour);

    TourDTO update(TourDTO tour);

    String delete(BigInteger tourId);
}
