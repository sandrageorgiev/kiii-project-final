package mk.ukim.finki.emt.airbnb.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@NoArgsConstructor

@Document("country")
public class Country {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String continent;

    public Country (String name, String continent){
        this.name = name;
        this.continent = continent;
    }

}
