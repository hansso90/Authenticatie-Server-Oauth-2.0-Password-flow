package nl.lemkes.example.oauth.server.config;

import nl.lemkes.example.oauth.server.model.Gebruiker;
import nl.lemkes.example.oauth.server.repository.GebruikerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author hans
 */
@Service
public class UserDatailsServiceImpl implements UserDetailsService
{
	@Autowired
	private GebruikerRepository gebruikerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Gebruiker gebruiker = gebruikerRepository.findByUsername(username);
		if (gebruiker == null)
		{
			throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
		}
		return gebruiker;
	}
}
