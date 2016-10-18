package nl.lemkes.example.oauth.server.config;

import nl.lemkes.example.oauth.server.model.Gebruiker;
import nl.lemkes.example.oauth.server.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author hans
 */
@Component
public class PasswordFlowProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private GebruikerRepository gebruikerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        Gebruiker huisarts = (Gebruiker) userDetails;
        String encodedPassword = userDetails.getPassword();
        String rawPassword = String.valueOf(usernamePasswordAuthenticationToken.getCredentials());
        if(!passwordEncoder.matches(rawPassword, encodedPassword))
        {
            throw new BadCredentialsException("Wachtwoord komt niet overeen.");
        }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        Gebruiker gebruiker = gebruikerRepository.findByUsername(username);
        if(gebruiker == null)
        {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }
        return gebruiker;
    }
}
