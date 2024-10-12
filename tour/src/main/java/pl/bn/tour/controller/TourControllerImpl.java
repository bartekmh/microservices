package pl.bn.tour.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.service.TourService;

import java.math.BigInteger;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/tours")
public class TourControllerImpl implements TourController {

    @Autowired
    TourService tourService;

    @GetMapping(path = "/getAll")
    public List<TourDTO> getAll() {
        return tourService.getAll();
    }

    @GetMapping(path = "/get/{id}")
    public TourDTO getOne(@PathVariable BigInteger id) {
        return tourService.get(id);
    }

    @PostMapping(path = "/insert")
    public TourDTO insert(@RequestBody TourDTO tour) {
        return tourService.insert(tour);
    }

    @PostMapping(path = "/update")
    public TourDTO update(@RequestBody TourDTO tour) {
        return tourService.update(tour);
    }

    @PostMapping(path = "/delete/{tourId}")
    public String delete(@PathVariable BigInteger tourId) {
        return tourService.delete(tourId);
    }

//	GET /tours – pobranie wszystkich ofert.
//	GET /tours/{id} – pobranie szczegółów wycieczki.
//	POST /tours – dodanie nowej wycieczki.
//	PUT /tours/{id} – aktualizacja wycieczki.
//	DELETE /tours/{id} – usunięcie wycieczki.

}
