package nl.lemkes.example.oauth.server.controller;

import java.util.Random;

import nl.lemkes.example.oauth.server.model.Gebruiker;
import nl.lemkes.example.oauth.server.repository.GebruikerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hans
 */
@RestController
@RequestMapping("/gebruiker")
public class GebruikerController
{
	@Autowired
	private GebruikerRepository gebruikerRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/maak", method = RequestMethod.GET)
	private ResponseEntity<String> maakGebruiker()
	{
		String naam = "User-" + gen();
		String wachtwoord = "example";

		Gebruiker gebruiker = new Gebruiker();
		gebruiker.setUsername(naam);
		gebruiker.setPassword(passwordEncoder.encode(wachtwoord));
		gebruiker.setActief(Boolean.TRUE);
		gebruikerRepository.save(gebruiker);

		return new ResponseEntity<String>(naam + ":" + wachtwoord, HttpStatus.OK);
	}

	/**
	 * Ik wil 5 random cijfers;
	 * 
	 * @return
	 */
	public int gen()
	{
		Random r = new Random(System.currentTimeMillis());
		return 10000 + r.nextInt(20000);
	}
}
