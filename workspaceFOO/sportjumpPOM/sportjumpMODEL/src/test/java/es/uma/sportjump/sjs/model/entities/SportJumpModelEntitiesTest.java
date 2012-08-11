package es.uma.sportjump.sjs.model.entities;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SportJumpModelEntitiesTest {

	private static EntityManagerFactory entityManagerFactory = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		entityManagerFactory = Persistence.createEntityManagerFactory("sportjumpJpaPU");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		entityManagerFactory = null;
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testCRUD() {

		// Definition Athlete
		String name = "Sebastian";
		String surname = "Coe";

		// Create athlete
		Integer idAthlete = createAthlete(name, surname);

		// Make assert
		assertNotNull(idAthlete);

		// Read athlete
		Athlete athlete = readAthlete(idAthlete);

		// Make assert
		makeAssertAthlete(name, surname, athlete);

		// Update Athlete
		String newName = "Fermin";

		updateAthlete(idAthlete, newName);

		// Read Athlete
		athlete = readAthlete(idAthlete);

		// Make assert
		makeAssertAthlete(newName, surname, athlete);

		// Delete athlete
		deleteAthlete(idAthlete);

		// Read Client
		athlete = readAthlete(idAthlete);

		// Make assert
		assertNull(athlete);

	}

	private Integer createAthlete(String name, String surname) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Create athlete
		Athlete athlete = new Athlete();
		athlete.setName(name);
		athlete.setSurname(surname);
		
		//Persist entity
		entityManager.getTransaction().begin();
		entityManager.persist(athlete);
		entityManager.getTransaction().commit();
		
		//return idAthlete
		return Integer.valueOf(athlete.getIdAthlete());
	}

	private Athlete readAthlete(Integer idAthlete) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//read Athlete
		Athlete athlete = entityManager.find(Athlete.class, idAthlete);
		return athlete;
	}

	private void updateAthlete(Integer idAthlete, String newName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
	
		//read Athlete
		Athlete athlete = entityManager.find(Athlete.class, idAthlete);
		
		//updete athlete
		athlete.setName(newName);
		
		entityManager.getTransaction().begin();
		entityManager.persist(athlete);
		entityManager.getTransaction().commit();		
	}

	private void deleteAthlete(Integer idAthlete) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//remove athlete
		Athlete athlete = entityManager.find(Athlete.class, idAthlete);
		
		entityManager.getTransaction().begin();
		entityManager.remove(athlete);
		entityManager.getTransaction().commit();
		
	}

	private void makeAssertAthlete(String name, String surname, Athlete athlete) {
		assertEquals(name, athlete.getName());
		assertEquals(surname, athlete.getSurname());
		
	}

}
