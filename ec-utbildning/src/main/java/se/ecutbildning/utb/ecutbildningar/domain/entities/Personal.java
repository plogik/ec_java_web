package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Personal {
    public enum Roll { LARARE, UTBILDNINGSLEDARE };

    @Id
    private String personnr;

    private String fnamn;
    private String enamn;

    @Enumerated(EnumType.STRING)
    private Roll roll;

    @ManyToMany(mappedBy = "personal")
    private List<Kurs> kurser;
}
