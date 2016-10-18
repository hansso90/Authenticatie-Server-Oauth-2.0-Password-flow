package nl.lemkes.example.oauth.server.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * @author hans
 */
public enum Recht implements GrantedAuthority
{

	ROLE_AANVRAGEN("ROLE_INLOGGEN");

	private String authority;

	Recht(String authority)
	{
		this.authority = authority;
	}

	@Override
	public String getAuthority()
	{
		return authority;
	}

}
