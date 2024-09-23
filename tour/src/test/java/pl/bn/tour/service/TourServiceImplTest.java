package pl.bn.tour.service;

import org.junit.Assert;
import org.junit.Test;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.MappingContext;
import pl.bn.tour.model.TourDTO;
import pl.bn.tour.model.TourEntity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TourServiceImplTest {

    @Test
    public void mapToDTOTest() {

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

        TourDTO dto = new TourDTO();
        dto.setDescription("desc");
        dto.setDate(LocalDate.of(2024, 06, 01));

        TourEntity entity = mapper.map(dto, TourEntity.class);

        Assert.assertEquals("desc", entity.getDescription());
        Assert.assertEquals("20240601", entity.getDate());

        entity = new TourEntity();
        entity.setDate("20200101");

        TourDTO tourDTO = mapper.map(entity, TourDTO.class);


        Assert.assertEquals(LocalDate.of(2020, 1, 1), tourDTO.getDate());


    }
}