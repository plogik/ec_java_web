package se.ecutbildning.utb.ecutbildningar.domain.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"UTBILDNING_ID" , "STUDENT_PERSONNR"}))
public class Inskrivning {
    private Long id;
    private Utbildning utbildning;
    private Student student;

    @Enumerated(EnumType.STRING)
    private Betyg betyg;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public Inskrivning setId(Long id) {
        this.id = id;
        return this;
    }

    public Betyg getBetyg() {
        return betyg;
    }

    public Inskrivning setBetyg(Betyg betyg) {
        this.betyg = betyg;
        return this;
    }

    @ManyToOne
    public Utbildning getUtbildning() {
        return utbildning;
    }

    public Inskrivning setUtbildning(Utbildning utbildning) {
        this.utbildning = utbildning;
        return this;
    }

    @ManyToOne
    public Student getStudent() {
        return student;
    }

    public Inskrivning setStudent(Student student) {
        this.student = student;
        return this;
    }
}
