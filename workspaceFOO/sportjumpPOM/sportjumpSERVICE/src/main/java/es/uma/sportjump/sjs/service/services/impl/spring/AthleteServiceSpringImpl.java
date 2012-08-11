package es.uma.sportjump.sjs.service.services.impl.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uma.sportjump.sjs.dao.daos.AthleteDao;
import es.uma.sportjump.sjs.model.entities.Athlete;
import es.uma.sportjump.sjs.service.services.AthleteService;


@Service("athleteService")
public class AthleteServiceSpringImpl  implements AthleteService{
	
	@Autowired
	AthleteDao athleteDao;

	
	public Integer setNewAthlete(String name, String surname) {
		
		//Crate object athlete
		Athlete athlete = new Athlete();
		athlete.setName(name);
		athlete.setSurname(surname);
		
		//Persist athlete
		athleteDao.persistAthlete(athlete);
		
		
		return athlete.getIdAthlete();
	}


	public Athlete findAthlete(Integer idAthlete) {	
		
		return athleteDao.getAthleteById(idAthlete);
	}

	
	public void removeAthlete(Integer idAthlete) {
		
			athleteDao.deleteAthlete(idAthlete);			
	}


	public boolean existsAthlete(String name, String surname) {
		
		boolean res = false;
		
		Athlete athlete = athleteDao.getAthleteByNameSurname(name,surname);
		
		if (athlete != null) {
			res = true;
		}
		
		return res;		
	}

}
