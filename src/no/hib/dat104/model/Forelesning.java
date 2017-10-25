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
@Table(name = "forelesning", schema = "ratemate", catalog = "h181394")
public class Forelesning {
	private int id;
	private String dato;
	private String klStart;
	private String klSlutt;
	private String fag;
	private String foreleser;
	private Integer bra;
	private Integer middels;
	private Integer daarlig;
	private Fag fagByFag;
	private Foreleser foreleserByForeleser;

	@Id
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "dato")
	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	@Basic
	@Column(name = "kl_start")
	public String getKlStart() {
		return klStart;
	}

	public void setKlStart(String klStart) {
		this.klStart = klStart;
	}

	@Basic
	@Column(name = "kl_slutt")
	public String getKlSlutt() {
		return klSlutt;
	}

	public void setKlSlutt(String klSlutt) {
		this.klSlutt = klSlutt;
	}

	@Basic
	@Column(name = "fag")
	public String getFag() {
		return fag;
	}

	public void setFag(String fag) {
		this.fag = fag;
	}

	@Basic
	@Column(name = "foreleser")
	public String getForeleser() {
		return foreleser;
	}

	public void setForeleser(String foreleser) {
		this.foreleser = foreleser;
	}

	@Basic
	@Column(name = "bra")
	public Integer getBra() {
		return bra;
	}

	public void setBra(Integer bra) {
		this.bra = bra;
	}

	@Basic
	@Column(name = "middels")
	public Integer getMiddels() {
		return middels;
	}

	public void setMiddels(Integer middels) {
		this.middels = middels;
	}

	@Basic
	@Column(name = "daarlig")
	public Integer getDaarlig() {
		return daarlig;
	}

	public void setDaarlig(Integer daarlig) {
		this.daarlig = daarlig;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Forelesning that = (Forelesning) o;

		if (id != that.id)
			return false;
		if (dato != null ? !dato.equals(that.dato) : that.dato != null)
			return false;
		if (klStart != null ? !klStart.equals(that.klStart) : that.klStart != null)
			return false;
		if (klSlutt != null ? !klSlutt.equals(that.klSlutt) : that.klSlutt != null)
			return false;
		if (fag != null ? !fag.equals(that.fag) : that.fag != null)
			return false;
		if (foreleser != null ? !foreleser.equals(that.foreleser) : that.foreleser != null)
			return false;
		if (bra != null ? !bra.equals(that.bra) : that.bra != null)
			return false;
		if (middels != null ? !middels.equals(that.middels) : that.middels != null)
			return false;
		if (daarlig != null ? !daarlig.equals(that.daarlig) : that.daarlig != null)
			return false;

		return true;
	}

	@ManyToOne
	@JoinColumn(name = "fag", referencedColumnName = "emnekode")
	public Fag getFagByFag() {
		return fagByFag;
	}

	public void setFagByFag(Fag fagByFag) {
		this.fagByFag = fagByFag;
	}

	@ManyToOne
	@JoinColumn(name = "foreleser", referencedColumnName = "ansattnr")
	public Foreleser getForeleserByForeleser() {
		return foreleserByForeleser;
	}

	public void setForeleserByForeleser(Foreleser foreleserByForeleser) {
		this.foreleserByForeleser = foreleserByForeleser;
	}

	public void updateStemmer(Integer gammel, Integer ny) {
		if (gammel != null) {
			switch (gammel) {
			case 0:
				bra--;
				break;
			case 1:
				middels--;
				break;
			case 2:
				daarlig--;
				break;
			}
		}

		switch (ny) {
		case 0:
			bra++;
			break;
		case 1:
			middels++;
			break;
		case 2:
			daarlig++;
			break;
		}
	}
}