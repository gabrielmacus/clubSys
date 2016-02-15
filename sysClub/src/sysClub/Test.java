package sysClub;


import java.util.Date;

import sysClub.DAOs.PersonaDAO;
import sysClub.DAOs.SocioDAO;
import sysClub.entidades.Persona;
import sysClub.entidades.Socio;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
	
	
	PersonaDAO personaDAO =new PersonaDAO();

Persona persona=new Persona("Alberto", "Rodriguez", "Cochabamba 123", "4333244,4323422", 20303033l);
	personaDAO.addPersona(persona);
	persona.setApellido("Ramirez");
	personaDAO.updatePersona(persona);
	
	SocioDAO socioDAO = new SocioDAO();
    Socio socio = new Socio("Juan", "Ibañez", "Albania 234", "433434", 32323233l, 1011);
    socioDAO.addSocio(socio);
   socio.setFechaBaja(new Date());
	socioDAO.updateSocio(socio);
	
	
	}

}
