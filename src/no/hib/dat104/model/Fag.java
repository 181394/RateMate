/**
 * 
 */
package no.hib.dat104.model;

/**
 * @author prebe
 *
 */
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fag", schema = "ratemate", catalog = "h181394")
public class Fag {
    private String emnekode;
    private String navn;
    private List<Foreleser> forelesersByEmnekode;
    private List<Forelesning> forelesningsByEmnekode;
    private List<Student> studentsByEmnekode;

    @Id
    @Column(name = "emnekode")
    public String getEmnekode() {
        return emnekode;
    }

    public void setEmnekode(String emnekode) {
        this.emnekode = emnekode;
    }

    @Basic
    @Column(name = "navn")
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fag fagEntity = (Fag) o;

        if (emnekode != null ? !emnekode.equals(fagEntity.emnekode) : fagEntity.emnekode != null) return false;
        if (navn != null ? !navn.equals(fagEntity.navn) : fagEntity.navn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = emnekode != null ? emnekode.hashCode() : 0;
        result = 31 * result + (navn != null ? navn.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "fagByFagliste")
    public List<Foreleser> getForelesersByEmnekode() {
        return forelesersByEmnekode;
    }

    public void setForelesersByEmnekode(List<Foreleser> forelesersByEmnekode) {
        this.forelesersByEmnekode = forelesersByEmnekode;
    }

    @OneToMany(mappedBy = "fagByFag")
    public List<Forelesning> getForelesningsByEmnekode() {
        return forelesningsByEmnekode;
    }

    public void setForelesningsByEmnekode(List<Forelesning> forelesningsByEmnekode) {
        this.forelesningsByEmnekode = forelesningsByEmnekode;
    }

    @OneToMany(mappedBy = "fagByFagliste")
    public List<Student> getStudentsByEmnekode() {
        return studentsByEmnekode;
    }

    public void setStudentsByEmnekode(List<Student> studentsByEmnekode) {
        this.studentsByEmnekode = studentsByEmnekode;
    }
}
