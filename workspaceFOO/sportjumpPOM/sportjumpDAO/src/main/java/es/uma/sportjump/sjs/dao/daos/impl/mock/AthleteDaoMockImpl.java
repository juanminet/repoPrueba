package es.uma.sportjump.sjs.dao.daos.impl.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.uma.sportjump.sjs.dao.daos.AthleteDao;
import es.uma.sportjump.sjs.model.entities.Athlete;

@Component("athleteDao")
public class AthleteDaoMockImpl implements AthleteDao{

	List<Athlete> listAthletes = new ArrayList<Athlete>();
	
	
	public void persistAthlete(Athlete athlete) {
		
		//add athlete to list
		listAthletes.add(athlete);
		
		//set id 
		athlete.setIdAthlete(listAthletes.indexOf(athlete));
	}
	

	
	public Athlete getAthleteById(Integer id) {
		Athlete resAthlete = null;
		
		//find athlete
		int index = -1;
		for(Athlete athlete : listAthletes){
			if(athlete.getIdAthlete() == id){
				index = listAthletes.indexOf(athlete);
				break;
			}
		}
		
		//remove athlete
		if (index != -1){
			resAthlete = listAthletes.get(index);
		}
		
		return resAthlete;
	}
	

	
	public void deleteAthlete(Integer id) {
		
		//find athlete
		int index = -1;
		for(Athlete athlete : listAthletes){
			if(athlete.getIdAthlete() == id){
				index = listAthletes.indexOf(athlete);
				break;
			}
		}
		
		//remove athlete
		if (index != -1){
			listAthletes.remove(index);
		}		
	}



	@Override
	public Athlete getAthleteByNameSurname(String name, String surname) {
		Athlete resAthlete = null;
		
		//find athlete
		int index = -1;
		for(Athlete athlete : listAthletes){
			if(athlete.getName().equals(name) && athlete.getSurname().equals(surname)){
				index = listAthletes.indexOf(athlete);
				break;
			}
		}
		
		//check if there are some athlete
		if(index != -1){
			resAthlete = listAthletes.get(index);
		}
		
		return resAthlete;		
	}

}
