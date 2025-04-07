package com.medconnect.controller;

import com.medconnect.entity.Doctor;
import com.medconnect.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepo;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Doctor doctor) {
        Doctor existing = doctorRepo.findByEmail(doctor.getEmail());
        if (existing != null && existing.getPassword().equals(doctor.getPassword())) {
            return new ResponseEntity<>("Login successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}
