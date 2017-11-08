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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String dato;
	private String kl_start;
	private String kl_slutt;
	@ManyToOne
	@JoinColumn(name = "fag", referencedColumnName = "emnekode")
	@Column(name = "fag")
	private Fag fag;
	@Column(name = "bra")
	private Integer bra;
	@Column(name = "middels")
	private Integer middels;
	@Column(name = "daarlig")
	private Integer daarlig;

	public Forelesning() {
	}

	public Forelesning(String dato, String kl_start, String kl_slutt, Fag fag) {
		this.dato = dato;
		this.kl_start = kl_start;
		this.kl_slutt = kl_slutt;
		this.fag = fag;
		this.bra = null;
		this.middels = null;
		this.daarlig = null;
	}

	public Integer getId() {
		return id;
	}

	public String getDato() {
		return dato;
	}

	public void setDato(String dato) {
		this.dato = dato;
	}

	public String getKl_start() {
		return kl_start;
	}

	public void setKl_start(String klStart) {
		this.kl_start = klStart;
	}

	public String getKl_slutt() {
		return kl_slutt;
	}

	public void setKl_slutt(String klSlutt) {
		this.kl_slutt = klSlutt;
	}

	public Fag getFag() {
		return fag;
	}

	public void setFag(Fag fl1) {
		this.fag = fl1;
	}

	public Integer getBra() {
		return bra;
	}

	public void setBra(Integer bra) {
		this.bra = bra;
	}

	public Integer getMiddels() {
		return middels;
	}

	public void setMiddels(Integer middels) {
		this.middels = middels;
	}

	public Integer getDaarlig() {
		return daarlig;
	}

	public void setDaarlig(Integer daarlig) {
		this.daarlig = daarlig;
	}

	private int datoToInt(Forelesning f) {
		String[] datoArr = { f.dato.substring(0, 2), f.dato.substring(3, 5), f.dato.substring(6, 10) };
		String revDato = datoArr[2] + datoArr[1] + datoArr[0];
		return Integer.parseInt(revDato);
	}

	private int datoToInt(String dato) {
		String[] datoArr = { dato.substring(0, 2), dato.substring(3, 5), dato.substring(6, 10) };
		String revDato = datoArr[2] + datoArr[1] + datoArr[0];
		return Integer.parseInt(revDato);
	}

	private int klokkeToInt(Forelesning f) {
		String[] klokkeArr = f.kl_start.split(":");
		String klokken = klokkeArr[0] + klokkeArr[1];
		return Integer.parseInt(klokken);
	}

	public int compareTo(Forelesning f) {
		if (datoToInt(this) == datoToInt(f))
			return klokkeToInt(this) < klokkeToInt(f) ? -1 : 1;

		else if (datoToInt(this) < datoToInt(f))
			return -1;
		else
			return 1;
	}

	public int compareTo(String dato, String klokke) {
		if (datoToInt(this) == datoToInt(dato))
			return klokkeToInt(this) < klokkeToInt(klokke) ? -1 : 1;

		else if (datoToInt(this) < datoToInt(dato))
			return -1;
		else
			return 1;
	}

	private int klokkeToInt(String klokke) {
		String klokken = klokke.replace(":", "");
		return Integer.parseInt(klokken);
	}

	private void testStemmer() {
		if (bra == null)
			bra = 0;
		if (middels == null)
			middels = 0;
		if (daarlig == null)
			daarlig = 0;

	}

	public void nullstill() {
		bra = 0;
		middels = 0;
		daarlig = 0;
	}

	public void updateStemmer(Integer gammel, Integer ny) {
		testStemmer();
		if (gammel != null) {
			switch (gammel) {
			case 0:
				if (!(bra == 0))
					bra--;
				break;
			case 1:
				if (!(middels == 0))
					middels--;
				break;
			case 2:
				if (!(daarlig == 0))
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
