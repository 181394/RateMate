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
@Table(name = "foreleser", schema = "ratemate", catalog = "h181394")
public class Foreleser {
    private String ansattnr;
    private String navn;
    private String passord;
    private String fagliste;
    private Fag fagByFagliste;
    private List<Forelesning> forelesningsByAnsattnr;

    @Id
    @Column(name = "ansattnr")
    public String getAnsattnr() {
        return ansattnr;
    }

    public void setAnsattnr(String ansattnr) {
        this.ansattnr = ansattnr;
    }

    @Basic
    @Column(name = "navn")
    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    @Basic
    @Column(name = "passord")
    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    @Basic
    @Column(name = "fagliste")
    public String getFagliste() {
        return fagliste;
    }

    public void setFagliste(String fagliste) {
        this.fagliste = fagliste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Foreleser that = (Foreleser) o;

        if (ansattnr != null ? !ansattnr.equals(that.ansattnr) : that.ansattnr != null) return false;
        if (navn != null ? !navn.equals(that.navn) : that.navn != null) return false;
        if (passord != null ? !passord.equals(that.passord) : that.passord != null) return false;
        if (fagliste != null ? !fagliste.equals(that.fagliste) : that.fagliste != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ansattnr != null ? ansattnr.hashCode() : 0;
        result = 31 * result + (navn != null ? navn.hashCode() : 0);
        result = 31 * result + (passord != null ? passord.hashCode() : 0);
        result = 31 * result + (fagliste != null ? fagliste.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "fagliste", referencedColumnName = "emnekode")
    public Fag getFagByFagliste() {
        return fagByFagliste;
    }

    public void setFagByFagliste(Fag fagByFagliste) {
        this.fagByFagliste = fagByFagliste;
    }

    @OneToMany(mappedBy = "foreleserByForeleser")
    public List<Forelesning> getForelesningsByAnsattnr() {
        return forelesningsByAnsattnr;
    }

    public void setForelesningsByAnsattnr(List<Forelesning> forelesningsByAnsattnr) {
        this.forelesningsByAnsattnr = forelesningsByAnsattnr;
    }
}
