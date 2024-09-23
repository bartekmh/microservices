package pl.bn.tour.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.service.TourService;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/tours")
public class TourControllerImpl implements TourController {

    @Autowired
    TourService tourService;

    @GetMapping(path = "/getall")
    public List<TourDTO> getTours() {
        String result = "Hello";

        TourDTO tour = new TourDTO(BigInteger.ONE, "Tour 1",
                LocalDate.now(),
                LocalTime.now(),
                "Tour description");

        return List.of(tour);
    }

    @GetMapping(path = "/get/{id}")
    public TourDTO getTour(@PathVariable BigInteger id) {

        TourDTO tour = tourService.get(id);

        return tour;
    }

    @PostMapping(path = "insert")
    public TourDTO insertTour(@RequestBody TourDTO tour) {

        return tourService.insert(tour);
    }

    @PostMapping(path = "update")
    public TourDTO updateTour(@RequestBody TourDTO tour) {

        return tourService.update(tour);
    }

    @PostMapping(path = "delete/{id}")
    public String deleteTour(@PathVariable BigInteger tourId) {

        //TODO DB save

        return "deleted";
    }


//	GET /tours – pobranie wszystkich ofert.
//	GET /tours/{id} – pobranie szczegółów wycieczki.
//	POST /tours – dodanie nowej wycieczki.
//	PUT /tours/{id} – aktualizacja wycieczki.
//	DELETE /tours/{id} – usunięcie wycieczki.

}
