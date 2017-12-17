package com.cdnuit.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cdnuit.model.Utilisateur;
import com.cdnuit.repository.UtilisateurRepository;


public final class UtilisateurDetailService implements UserDetailsService {

	@Autowired
	private UtilisateurRepository uRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur u = uRepo.touverUParemail(email);
		if (u == null)
			throw new UsernameNotFoundException(String.format("User with the username %s doesn't exist", email));
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(u.isAdmin()) {
			authorities = AuthorityUtils.createAuthorityList("ROLE_ADMIN");
			}
		return new org.springframework.security.core.userdetails.
				User(u.getEmail(), u.getMotDepasse(), authorities);
	}

}
