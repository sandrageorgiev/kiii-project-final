package mk.ukim.finki.emt.airbnb.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@NoArgsConstructor
@Document("host")
public class Host {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String surname;
    private Country country;

    public Host(String name, String surname, Country country){
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
