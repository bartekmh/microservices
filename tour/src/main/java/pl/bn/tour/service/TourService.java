package pl.bn.tour.service;

import pl.bn.tour.model.TourDTO;

import java.math.BigInteger;
import java.util.List;

public interface TourService {
    TourDTO get(BigInteger tourId);
    TourDTO insert(TourDTO tourDTO);
    TourDTO update(TourDTO tourDTO);
    List<TourDTO> getAll();
}
