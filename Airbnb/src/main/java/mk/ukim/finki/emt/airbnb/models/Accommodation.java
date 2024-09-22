package mk.ukim.finki.emt.airbnb.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.airbnb.models.enumerations.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@NoArgsConstructor

@Document("accomodation")
public class Accommodation {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private Category category;
    private Host host;
    private Integer numRooms;


    public Accommodation(String name, Category category, Host host, Integer numRooms){
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }


}
