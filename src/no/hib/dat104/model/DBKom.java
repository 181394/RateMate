package no.hib.dat104.model;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class DBKom {

	@PersistenceContext(name = "RateMatePersistenceUnit")
	private EntityManager em;

	public void UpdateStudent(Student s, Integer ny) {
		Student stud = em.find(Student.class, s.getStudentnr());
		stud.setRating(ny);
		em.persist(stud);
	}

	public Forelesning getForelesning() {
		Date date = new Date();
		String enNull = "";
		String ekstraNull = "";
		String endaEnNull = "";
		String sisteNull = "";
		String[] dato = new String[3];
		String[] klokken = new String[2];
		if (date.getMinutes() < 10)
			ekstraNull = "0";
		if (date.getHours()< 10)
			sisteNull = "0";
		if (date.getDate() < 10)
			endaEnNull = "0";
		if (date.getMonth()< 10)
			enNull = "0";
		dato[0]= endaEnNull + date.getDate();
		dato[1]= enNull + (date.getMonth()+1);
		dato[2]= "" + (date.getYear() + 1900);
		klokken[0] = sisteNull + date.getHours();
		klokken[1] =  ekstraNull + date.getMinutes();		
		return getForelesning1(dato, klokken);
	}
	

	private Forelesning getForelesning1(String[] dato, String[] klokken) {
		List<Forelesning> forelesning = fliste();
		for (Forelesning f : forelesning) {
			if (f.getDato().equals(dato[0] + "." + dato[1] + "." + dato[2])){
				if (f.getKl_start().compareTo(klokken[0] + ":" + klokken[1])<=0 && f.getKl_slutt().compareTo(klokken[0] + ":" + klokken[1]) > 0 ) {
					return f;
				}
			}
		}
		return null;
	}

	public void UpdateLive(Integer gammel, Integer ny) {
		Forelesning f1 = em.find(Forelesning.class, getForelesning().getId());
		if (f1 != null) {
			f1.updateStemmer(gammel, ny);
			em.persist(f1);
		}
	}
	public List<Forelesning> fliste() {
		Query query = em.createQuery("SELECT f FROM Forelesning f ORDER BY f.dato DESC", Forelesning.class);
		return query.getResultList();
	}

	public Student finnStudent(String studnr) {
		return em.find(Student.class, studnr);
	}

	public Foreleser finnForeleser(String ansattnr) {
		return em.find(Foreleser.class, ansattnr);
	}

	public void nullstillStemmer() {
		Query forelesningsQuery = em.createQuery("SELECT f FROM Forelesning f", Forelesning.class);
		Query studentQuery = em.createQuery("SELECT s FROM Student s", Student.class);
		List<Forelesning> flist = forelesningsQuery.getResultList();
		List<Student> slist = studentQuery.getResultList();

		for (Forelesning f : flist) {
			f.setBra(0);
			f.setMiddels(0);
			f.setDaarlig(0);
			em.persist(f);
		}
		for (Student s : slist) {
			s.setRating(null);
			em.persist(s);
		}
	}

	public void lastOppForelesning(Forelesning f1) {
		System.out.println(f1.getDato());
		System.out.println(f1.getKl_start());
		System.out.println(f1.getKl_slutt());
		System.out.println(f1.getFag());
		em.persist(f1);
	}

	// public Fag hentFag(String ek) {
	// return em.find(Fag.class, ek);
	// }

	public boolean finnesStudent(String studnr) {
		return (em.find(Student.class, studnr) != null);
	}

	public boolean finnesForeleser(String ansattnr, String passord) {
		Foreleser f1 = em.find(Foreleser.class, ansattnr);
		return (f1 != null && f1.getPassord().equals(passord));
	}
}
