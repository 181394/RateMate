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

    public void UpdateStudent(Student s){em.persist(s);}
    public void UpdateLive(Integer gammel, Integer ny){
    	Date dato = new Date();
    	Forelesning f1 = getForelesning(dato);
    	f1.updateStemmer(gammel, ny);
    	em.persist(f1);
    	}

public Forelesning getForelesning(Date dato) {return em.find(Forelesning.class, dato);}

    public List<Forelesning> fliste (){
        Query query = em.createQuery("SELECT f FROM Forelesning f ORDER BY f.dato DESC", Forelesning.class);
        return query.getResultList();
    }

    public Student finnStudent(String studnr){return em.find(Student.class, studnr);}
    public Foreleser finnForeleser(String ansattnr){return em.find(Foreleser.class, ansattnr);}

    public void nullstillStemmer(){
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
    	System.out.println(f1.getKlStart());
    	System.out.println(f1.getKlSlutt());
    	System.out.println(f1.getFag());
    	em.persist(f1);}
    
//    public Fag hentFag(String ek) {
//    	return em.find(Fag.class, ek);
//    }

    public boolean finnesStudent(String studnr){
        return (em.find(Student.class, studnr) != null);
    }
    public boolean finnesForeleser(String ansattnr, String passord){
    	Foreleser f1 = em.find(Foreleser.class, ansattnr);
    	return (f1 != null && f1.getPassord().equals(passord));
    }
}
