package pl.bn.tour.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity(name = "TOUR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TourEntity {
    @Id
    @Column(name="TOUR_ID")
    @SequenceGenerator(name = "tour_id_sequence", sequenceName = "tour_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tour_id_sequence")
    private BigInteger tourId;
    private String name;
    private String date;
    private String time;
    private String description;
}
