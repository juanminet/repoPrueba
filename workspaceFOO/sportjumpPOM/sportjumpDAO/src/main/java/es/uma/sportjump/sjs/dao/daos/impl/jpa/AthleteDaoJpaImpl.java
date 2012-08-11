package es.uma.sportjump.sjs.dao.daos.impl.jpa;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uma.sportjump.sjs.dao.daos.AthleteDao;
import es.uma.sportjump.sjs.model.entities.Athlete;

@Repository("athleteDao")
public class AthleteDaoJpaImpl  implements AthleteDao{

 
	@PersistenceContext
 	protected EntityManager em;

	
	
	@Transactional
	public void persistAthlete(Athlete athlete) {		
		em.persist(athlete);	
	
		System.out.println(athlete.getIdAthlete());
	}

	
	@Transactional
	public Athlete getAthleteById(Integer id) {
		return em.find(Athlete.class, Integer.valueOf(id));
	}

	
	@Transactional
	public void deleteAthlete(Integer id) {
		em.remove(getAthleteById(id));		
	}


	@Transactional
	public Athlete getAthleteByNameSurname(String name, String surname) {
		
		Athlete resAthlete = null;
								
		Query query = em.createNamedQuery("findAthleteByNameSurname")
				.setParameter("name", name)
				.setParameter("surname", surname);
		
		List<Athlete> listAthletes = query.getResultList();
		
		if(listAthletes != null && listAthletes.size() > 0){
			resAthlete = listAthletes.get(0);
		}
		
		return resAthlete;
	}

}
