package pl.bn.tour.util;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.model.TourEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mapper {
    private static ModelMapper modelMapper = new ModelMapper();

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    static {
        Converter<String, LocalDate> stringToLocalDate = new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                return LocalDate.parse(context.getSource(), dateFormatter);
            }
        };

        Converter<LocalDate, String> localDateToString = new Converter<LocalDate, String>() {
            @Override
            public String convert(MappingContext<LocalDate, String> context) {
                return context.getSource().format(dateFormatter);
            }
        };

        modelMapper.createTypeMap(TourEntity.class, TourDTO.class)
                .addMappings(mapper -> mapper.using(stringToLocalDate).map(TourEntity::getDate, TourDTO::setDate
                ));

        modelMapper.createTypeMap(TourDTO.class, TourEntity.class)
                .addMappings(mapper -> mapper.using(localDateToString).map(TourDTO::getDate, TourEntity::setDate));
    }

    public static TourDTO toDTO(TourEntity user) {
        return modelMapper.map(user, TourDTO.class);
    }

    // Method to map from UserDTO to User entity
    public static TourEntity toEntity(TourDTO userDTO) {
        return modelMapper.map(userDTO, TourEntity.class);
    }
}