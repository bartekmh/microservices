package pl.bn.tour;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.model.TourEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class TourApp {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static void main(String[] args) {
        SpringApplication.run(TourApp.class);
    }

    @Bean
    ModelMapper mapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<TourEntity, TourDTO> typeMap = mapper.createTypeMap(TourEntity.class, TourDTO.class);
        Converter<String, LocalDate> converterStringToDate = new Converter<>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> context) {
                return LocalDate.parse(context.getSource(), DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
        };
        typeMap.addMappings(m -> m.using(converterStringToDate).map(TourEntity::getDate, TourDTO::setDate));

        TypeMap<TourDTO, TourEntity> typeMap2 = mapper.createTypeMap(TourDTO.class, TourEntity.class);
        Converter<LocalDate, String> converterDateToString = new Converter<>() {
            @Override
            public String convert(MappingContext<LocalDate, String> context) {
                return context.getSource().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            }
        };
        typeMap2.addMappings(m -> m.using(converterDateToString).map(TourDTO::getDate, TourEntity::setDate));


        return mapper;
    }
}
