package nl.lemkes.example.oauth.server.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author hans
 */
@Entity
@Table(name = "gebruiker")
public class Gebruiker implements Serializable, UserDetails
{
	@Id
	@Access(AccessType.PROPERTY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Boolean actief = Boolean.TRUE;

	private String password;

	private String username;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Arrays.asList(Recht.values());
	}

	@Override
	public String getPassword()
	{
		return password;
	}

	@Override
	public String getUsername()
	{
		return username;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return actief;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return actief;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return actief;
	}

	@Override
	public boolean isEnabled()
	{
		return actief;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getActief() {
		return actief;
	}

	public void setActief(Boolean actief) {
		this.actief = actief;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
