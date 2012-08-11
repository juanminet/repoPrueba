package es.uma.sportjump.sjs.dao.daos;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uma.sportjump.sjs.model.entities.Athlete;

public class AthleteDaoTest {
	private static ApplicationContext applicationContext = null;
	private static ApplicationContext applicationContextJpa = null;
	private static ApplicationContext applicationContextMock = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContextJpa = new ClassPathXmlApplicationContext("test-jpa-application-dao.xml");
		applicationContextMock = new ClassPathXmlApplicationContext("test-mock-application-dao.xml");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext = null;
		applicationContextJpa = null;
		applicationContextMock = null;
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testAthleteJpaCRUD() {
		
		//select application context for JPA
		applicationContext = applicationContextJpa;
		
		//call testAthleteCRUD
		testAthleteCRUD();
		
		//remove application context
		applicationContext = null;
	
	}
	
	@Test
	public void testAthleteMockCRUD() {
		
		//select application context for JPA
		applicationContext = applicationContextMock;
		
		//call testAthleteCRUD
		testAthleteCRUD();
		
		//remove application context
		applicationContext = null;
	
	}
	
	

	private void testAthleteCRUD() {
		
		
		//Initialize variables
		String name = "Sebastian";
		String surname ="Coe";
		
		//Create athlete
		Integer idAthlete = createAthlete(name,surname);
		
		//Make assert
		assertNotNull(idAthlete);
		
		//Read athlete
		Athlete athlete = readAthlete(idAthlete);
		
		//Make assert
		makeAssertAthlete(name,surname,athlete);
		
		
		//Delete athlete
		deleteAthlete(athlete);
		
		//Read athlete
		athlete = readAthlete(idAthlete);
		
		//Make assert
		assertNull(athlete);
		

		
	}
	
	
	
	@Test
	public void testGetAthleteByNameSurnameJpa() {
		
		//select application context for JPA
		applicationContext = applicationContextJpa;
		
		//call testAthleteCRUD
		testGetAthleteByNameSurname();
		
		//remove application context
		applicationContext = null;
	
	}
	
	@Test
	public void testGetAthleteByNameSurnameMock() {
		
		//select application context for JPA
		applicationContext = applicationContextMock;
		
		//call testAthleteCRUD
		testGetAthleteByNameSurname();
		
		//remove application context
		applicationContext = null;
	
	}

	private void testGetAthleteByNameSurname() {
		
		//Initialize variables
		String name = "Sebastian";
		String surname ="Coe";
		
		//Create athlete
		Integer idAthlete = createAthlete(name,surname);
		
		//Make assert
		assertNotNull(idAthlete);
		
		//Read athlete by name and surname
		Athlete athlete = readAthleteByNameSurname(name,surname);
		
		//Make assert
		makeAssertAthlete(name,surname,athlete);
				
				
		//Delete athlete
		deleteAthlete(athlete);
		
		//Read athlete by name and surname
		athlete = readAthleteByNameSurname(name,surname);				
		
		//Make assert
		assertNull(athlete);
		
	}

	
	private Integer createAthlete(String name, String surname) {
		//Get bean 
		AthleteDao athleteDao = applicationContext.getBean(AthleteDao.class);
		
		//Create athlete
		Athlete athlete = new Athlete();
		athlete.setName(name);
		athlete.setSurname(surname);
		
		//Persist athlete		
		athleteDao.persistAthlete(athlete);
		

		//return idAthlete
		return Integer.valueOf(athlete.getIdAthlete());	
	}

	private Athlete readAthlete(Integer idAthlete) {
		//Get bean
		AthleteDao athleteDao = applicationContext.getBean(AthleteDao.class);
		
		//Read athlete
		Athlete athlete = athleteDao.getAthleteById(idAthlete);
		
		//return
		return athlete;
	}
	
	private Athlete readAthleteByNameSurname(String name, String surname) {
		//Get bean
		AthleteDao athleteDao = applicationContext.getBean(AthleteDao.class);
		
		//Read athlete
		Athlete athlete = athleteDao.getAthleteByNameSurname(name, surname);
		
		//return
		return athlete;
	}


	private void deleteAthlete(Athlete athlete) {
		//Get bean
		AthleteDao athleteDao = applicationContext.getBean(AthleteDao.class);
		
		//Remove athlete
		athleteDao.deleteAthlete(Integer.valueOf(athlete.getIdAthlete()));		
	}

	private void makeAssertAthlete(String name, String surname, Athlete athlete) {
		assertEquals(athlete.getName(),name);
		assertEquals(athlete.getSurname(),surname);		
	}

	
}
