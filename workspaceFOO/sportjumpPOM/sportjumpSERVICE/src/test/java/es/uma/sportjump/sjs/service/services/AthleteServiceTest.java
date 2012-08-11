package es.uma.sportjump.sjs.service.services;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.uma.sportjump.sjs.model.entities.Athlete;

public class AthleteServiceTest {
	private static ApplicationContext applicationContext = null;	
	
	String athleteName1 = "Sebastian";
	String athleteSurname1 = "Coe";
	
	String athleteName2 = "Fermin";
	String athleteSurname2 = "Cacho";
	
	String athleteName3 = "El";
	String athleteSurname3 = "Guerrouj";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		String[] SPRING_CONFIGURATION_FILES = {"test-service-application-service.xml", "test-service-application-dao.xml"};
		applicationContext = new ClassPathXmlApplicationContext(SPRING_CONFIGURATION_FILES);
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		applicationContext = null;
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testSetNewAthlete() {
		//Get AthleteService
		AthleteService athleteService = applicationContext.getBean(AthleteService.class);
		
		//Create athlete 1
		Integer idAthlete1 = athleteService.setNewAthlete(athleteName1, athleteSurname1);
		
		//Create athlete 2
		Integer idAthlete2 = athleteService.setNewAthlete(athleteName2, athleteSurname2);
		
		assertEquals(new Integer(0), idAthlete1);
		assertEquals(new Integer(1), idAthlete2);		
	}
	
	@Test
	public void testFindAthlete() {
		//Get AthleteService
		AthleteService athleteService = applicationContext.getBean(AthleteService.class);
		
		//Get athlete1
		Athlete athlete1 = athleteService.findAthlete(new Integer(0));
		
		//Get athlete2
		Athlete athlete2 = athleteService.findAthlete(new Integer(1));
		
		assertEquals(athleteName1,athlete1.getName());
		assertEquals(athleteSurname1, athlete1.getSurname());
		
		assertEquals(athleteName2, athlete2.getName());
		assertEquals(athleteSurname2, athlete2.getSurname());
	}
	
	@Test
	public void testExistsAthleteByNameSurname() {
		//Get AthleteService
		AthleteService athleteService = applicationContext.getBean(AthleteService.class);
		
		//check athlete1
		boolean check1 = athleteService.existsAthlete(athleteName1, athleteSurname1);
		
		//check athlete2
		boolean check2 = athleteService.existsAthlete(athleteName2, athleteSurname2);
		
		//check athlete3
		boolean check3 = athleteService.existsAthlete(athleteName3, athleteSurname3);
		
		assertTrue(check1);
		assertTrue(check2);
		assertFalse(check3);

		
		
	}
	
	
	@Test
	public void testRemoveAthlete() {
		
		//Get AthleteService
		AthleteService athleteService = applicationContext.getBean(AthleteService.class);
				
		//Remove athlete1
		athleteService.removeAthlete(new Integer(0));
		
		//Get athlete1
		Athlete athlete1 = athleteService.findAthlete(new Integer(0));
		//Get athlete2
		Athlete athlete2 = athleteService.findAthlete(new Integer(1));
		
		assertNull(athlete1);
		assertNotNull(athlete2);
		
		//Remove athlete2
		athleteService.removeAthlete(new Integer(1));	
		
		//Get athlete1
		athlete1 = athleteService.findAthlete(new Integer(0));
		//Get athlete2
		athlete2 = athleteService.findAthlete(new Integer(1));
		
		assertNull(athlete1);
		assertNull(athlete2);
				
	}
	
	
}
		
	