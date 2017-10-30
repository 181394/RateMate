/**
 * 
 */
package no.hib.dat104.model;

/**
 * @author prebe
 *
 */
import javax.persistence.*;

@Entity
@Table(name = "student", schema = "ratemate", catalog = "h181394")
public class Student {
    @Id
    @Column(name = "studentnr")
    private String studentnr;
    @Column(name = "navn")
    private String navn;
//    private String fagliste;
    @Column(name = "rating")
    private Integer rating;

    public Student (){

    }

    public Student(String studentnr, String navn) {
        this.studentnr = studentnr;
        this.navn = navn;
        this.rating = null;
    }

    public String getStudentnr() {
        return studentnr;
    }

    public void setStudentnr(String studentnr) {
        this.studentnr = studentnr;
    }


    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

//    @Basic
//    @Column(name = "fagliste")
//    public String getFagliste() {
//        return fagliste;
//    }

//    public void setFagliste(String fagliste) {
//        this.fagliste = fagliste;
//    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Student that = (Student) o;
//
//        if (studentnr != null ? !studentnr.equals(that.studentnr) : that.studentnr != null) return false;
//        if (navn != null ? !navn.equals(that.navn) : that.navn != null) return false;
//        if (fagliste != null ? !fagliste.equals(that.fagliste) : that.fagliste != null) return false;
//        if (rating != null ? !rating.equals(that.rating) : that.rating != null) return false;
//
//        return true;
//    }

//    @Override
//    public int hashCode() {
//        int result = studentnr != null ? studentnr.hashCode() : 0;
//        result = 31 * result + (navn != null ? navn.hashCode() : 0);
//        result = 31 * result + (fagliste != null ? fagliste.hashCode() : 0);
//        result = 31 * result + (rating != null ? rating.hashCode() : 0);
//        return result;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "fagliste", referencedColumnName = "emnekode")
//    public Fag getFagByFagliste() {
//        return fagByFagliste;
//    }
//
//    public void setFagByFagliste(Fag fagByFagliste) {
//        this.fagByFagliste = fagByFagliste;
//    }
}
