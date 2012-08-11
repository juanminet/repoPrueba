package es.uma.sportjump.sjs.dao.daos;

import es.uma.sportjump.sjs.model.entities.Athlete;

public interface AthleteDao {
	
		/**
		 * Persist Athlete
		 * @param athlete
		 */
		public void persistAthlete(Athlete athlete);	
		
		/**
		 * Get athlete by id given by parameter
		 * @param id
		 * @return
		 */
		public Athlete getAthleteById(Integer id);
		
		/**
		 * Remove athlete
		 * @param id
		 */
		public void deleteAthlete(Integer id);

		/**
		 * 
		 * @param name
		 * @param surname
		 * @return
		 */
		public Athlete getAthleteByNameSurname(String name, String surname);

}
