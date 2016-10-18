package nl.lemkes.example.oauth.server.repository;

import nl.lemkes.example.oauth.server.model.Gebruiker;
import org.springframework.data.repository.CrudRepository;

/**
 * @author hans
 */
public interface GebruikerRepository extends CrudRepository<Gebruiker, Long>
{
    Gebruiker findByUsername(String username);
}
