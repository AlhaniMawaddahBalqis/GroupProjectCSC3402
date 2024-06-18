package com.csc3402.project.pharmacy.service;

import com.csc3402.project.pharmacy.model.Pharmacist;
import com.csc3402.project.pharmacy.repository.PharmacistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        return new org.springframework.security.core.userdetails.User(pharmacist.getEmail(), pharmacist.getPassword(), new ArrayList<>());
    }
}
