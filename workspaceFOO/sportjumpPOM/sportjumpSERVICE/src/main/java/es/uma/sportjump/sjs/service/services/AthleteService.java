package es.uma.sportjump.sjs.service.services;

import es.uma.sportjump.sjs.model.entities.Athlete;

public interface AthleteService {
	
	/**
	 * 
	 * @param name
	 * @param surname
	 * @return
	 */
	public Integer setNewAthlete(String name, String surname);
	
	/**
	 * 
	 * @param idAthlete
	 * @return
	 */	
	public Athlete findAthlete(Integer idAthlete);
	
	/**
	 * 
	 * @param athlete
	 */
	public void removeAthlete(Integer idAthlete);

	/**
	 * 
	 * @param name
	 * @param surname
	 */
	public boolean existsAthlete(String name, String surname);

}
