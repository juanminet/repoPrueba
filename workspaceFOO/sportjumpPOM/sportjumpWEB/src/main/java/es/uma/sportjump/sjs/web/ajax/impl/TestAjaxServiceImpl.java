package es.uma.sportjump.sjs.web.ajax.impl;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;

import es.uma.sportjump.sjs.service.services.AthleteService;
import es.uma.sportjump.sjs.web.ajax.TestAjaxService;


@RemoteProxy(name = "TestAjaxService")
public class TestAjaxServiceImpl implements TestAjaxService {

	@Autowired
	private AthleteService athleteService;
	
	@RemoteMethod
	public void addUser(String userName) {

		athleteService.setNewAthlete(userName, userName);

	}
	
	@RemoteMethod
	public boolean existsUser(String userName){
		
		System.out.println("el usuario a buscar es: " + userName);
		
		return athleteService.existsAthlete(userName,userName);
		
	}

}
