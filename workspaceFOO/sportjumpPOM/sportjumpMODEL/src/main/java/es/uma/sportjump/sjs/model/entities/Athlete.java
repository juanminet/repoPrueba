package es.uma.sportjump.sjs.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ATHLETE database table.
 * 
 */
@Entity
@Table(name="ATHLETE")
public class Athlete implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAthlete;
	private String name;
	private String surname;

    public Athlete() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ATHLETE")
	public int getIdAthlete() {
		return this.idAthlete;
	}

	public void setIdAthlete(int idAthlete) {
		this.idAthlete = idAthlete;
	}


	@Column(name="NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="SURNAME")
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}