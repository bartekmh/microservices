package pl.bn.tour.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.model.TourEntity;
import pl.bn.tour.repository.TourRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    TourRepository tourRepository;

    @Autowired
    ModelMapper mapper;

    @Override
    public TourDTO get(BigInteger tourId) {
        TourEntity tourEntity = tourRepository.getByTourId(tourId);
        TourDTO tourDTO = null;
        if (tourEntity != null) {
            tourDTO = mapToDTO(tourEntity);
        }
        return tourDTO;
    }

    @Override
    public TourDTO insert(TourDTO tourDTO) {
        return save(tourDTO);
    }

    @Override
    public TourDTO update(TourDTO tourDTO) {
        return save(tourDTO);
    }

    @Override
    public List<TourDTO> getAll() {
        return tourRepository.findAll().stream().map(tourEntity -> mapToDTO(tourEntity)).collect(Collectors.toList());
    }

    @Override
    public String delete(BigInteger tourId) {
        String responseMsg = "OK - deleted.";
        if(tourRepository.existsById(tourId)) {
            tourRepository.deleteById(tourId);
        }else{
            responseMsg = "Entity does not exist.";
        }
        return responseMsg;
    }

    private TourDTO save(TourDTO tourDTO) {
        TourEntity entity = tourRepository.save(mapToEntity(tourDTO));
        return mapToDTO(entity);
    }

    private TourDTO mapToDTO(TourEntity tourEntity) {
        return mapper.map(tourEntity, TourDTO.class);
    }
    private TourEntity mapToEntity(TourDTO tourDTO) {
        return mapper.map(tourDTO, TourEntity.class);
    }
}
