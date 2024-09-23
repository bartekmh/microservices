package pl.bn.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bn.tour.model.TourEntity;

import java.math.BigInteger;

public interface TourRepository extends JpaRepository<TourEntity, BigInteger> {
    TourEntity getByTourId(BigInteger id);
}
