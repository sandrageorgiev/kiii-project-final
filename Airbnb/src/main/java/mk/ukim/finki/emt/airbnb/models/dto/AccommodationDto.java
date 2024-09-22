package mk.ukim.finki.emt.airbnb.models.dto;

import lombok.Data;
import mk.ukim.finki.emt.airbnb.models.enumerations.Category;

@Data
public class AccommodationDto {

    private String name;
    private Category category;
    private String hostId;
    private Integer numRooms;
}
