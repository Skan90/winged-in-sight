package dbserver.wingedinsight.model;


import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.UUID;
@Entity(name = "Bird")
@Table(
       name = "bird",
        uniqueConstraints = {
                @UniqueConstraint(name = "bird_name_unique",
                columnNames="name")
        }
)
public class Bird {

    @Id
    private final UUID id;
    @NotBlank
    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private final String name;

    public Bird(@JsonProperty("id") UUID id,
                @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }



    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
