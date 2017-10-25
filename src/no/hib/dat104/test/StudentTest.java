package no.hib.dat104.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import no.hib.dat104.model.Student;

	public class StudentTest {

		Student s1 = new Student();
		Student s2 = new Student();
		Student s3 = new Student();
		
		@Before
		public void setup() {
			s1.setStudentnr("123456");
			s2.setStudentnr("123456");
			s3.setStudentnr("000000");
			s1.setNavn("Ulrikke");
			s2.setNavn("Ulrikke");
			s3.setNavn("Fjomsleif");
			s1.setFagliste("Mat102");
			s2.setFagliste("Mat102");
			s3.setFagliste("Fot666");
			s1.setRating(1);
			s2.setRating(1);
			s3.setRating(0);
		}
		
		@Test
		public void erStudentLikStudent() {
			assertTrue(s1.equals(s2));
		}
		@Test
		public void erStudentULikStudent() {
			assertFalse(s1.equals(s3));
		}
		@Test
		public void erStudenterUlikPåStudentnr() {
			s2.setStudentnr("123450");
			assertFalse(s1.equals(s2));
		}
		@Test
		public void erStudenterUlikPåNavn() {
			s2.setNavn("Ulrikkus");
			assertFalse(s1.equals(s2));
		}
		@Test
		public void erStudenterUlikPåFagliste() {
			s2.setFagliste("Mat009");
			assertFalse(s1.equals(s2));
		}
		@Test
		public void erStudenterUlikPåRating() {
			s2.setRating(-1);
			assertFalse(s1.equals(s2));
		}

}
