package com.csc3402.project.pharmacysm.service;

import com.csc3402.project.pharmacysm.model.Pharmacist;
import com.csc3402.project.pharmacysm.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomPharmacistDetailsService implements UserDetailsService {

    @Autowired
    private PharmacistRepository pharmacistRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pharmacist pharmacist = pharmacistRepository.findByEmail(email);

        if (pharmacist == null) {
            throw new UsernameNotFoundException("No user found with email: " + email);
        }

        return new User(pharmacist.getEmail(), pharmacist.getPassword(), new ArrayList<>());
    }
}
