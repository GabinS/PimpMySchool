package fr.formation.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class Administrateur implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private RessourceHumaine ressource;
	
	public RessourceHumaine getRessourceHumaine()
	{
		return this.ressource;
	}
	
	public Administrateur(RessourceHumaine utilisateur)
	{
		if (utilisateur == null) {
			throw new UsernameNotFoundException("L'utilisateur n'existe pas.");
		}
		this.ressource = utilisateur;
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		myAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return myAuthorities;
	}
	
	public String getPassword() {
		return this.ressource.getPassword();

	}

	public String getUsername() {
		return this.ressource.getUsername();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}
