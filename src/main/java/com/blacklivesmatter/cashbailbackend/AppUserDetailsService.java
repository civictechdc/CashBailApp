package com.blacklivesmatter.cashbailbackend;


import com.blacklivesmatter.cashbailbackend.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blacklivesmatter.cashbailbackend.model.AppUser;
import com.blacklivesmatter.cashbailbackend.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Transactional
@Service
@Slf4j
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<AppUser> appUserOptional = this.userRepo.findByUsername(username);
		
		if(!appUserOptional.isPresent()) {
			log.info("User not found: {}", username);
			throw new UsernameNotFoundException("User not found");
		}

		AppUser appUser = appUserOptional.get();
		
		return User
				.withUsername(username)
				.password(appUser.getPassword())
				.roles(appUser.getRole().toString())
				.build();
	}
	private Set<GrantedAuthority> getAuthorities(AppUser user){
		Set<GrantedAuthority> authorities = new HashSet<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());
		authorities.add(grantedAuthority);
		return authorities;
	}

}
