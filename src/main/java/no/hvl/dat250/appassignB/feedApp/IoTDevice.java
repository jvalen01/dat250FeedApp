package no.hvl.dat250.appassignB.feedApp;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IoTDevice {
    @Id
    private Long id;

    private String name;

    private Integer identifier;

    private Boolean status;
}
