package com.azure.test.springbootazuredemo.service.impl;

import com.azure.test.springbootazuredemo.model.Attendee;
import com.azure.test.springbootazuredemo.repo.AttendeeRepo;
import com.azure.test.springbootazuredemo.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendeeServiceImpl implements AttendeeService {
    private final AttendeeRepo attendeeRepo;

    @Autowired
    public AttendeeServiceImpl(AttendeeRepo attendeeRepo) {
        this.attendeeRepo = attendeeRepo;
    }


    @Override
    public List<Attendee> getAllAttendee() {
        return attendeeRepo.findAll();
    }

    @Override
    public Optional<Attendee> getAttendee(Long id) {
        return attendeeRepo.findById(id);
    }

    @Override
    public Attendee createAttendee(Attendee attendee) {
        return attendeeRepo.save(attendee);
    }

    @Override
    public void deleteAttendee(Long id) {
        attendeeRepo.deleteById(id);
    }

    @Override
    public Attendee updateAttendee(Attendee attendee) {
        Attendee updateAttendee = attendeeRepo.findById(attendee.getId()).get();
        updateAttendee.setFirstName(attendee.getFirstName());
        updateAttendee.setLastName(attendee.getLastName());
        updateAttendee.setCompany(attendee.getCompany());
        updateAttendee.setEmail(attendee.getEmail());
        updateAttendee.setRegistrationOther(attendee.getRegistrationOther());
        updateAttendee.setRegistrationType(attendee.getRegistrationType());
        updateAttendee.setPayment(attendee.getPayment());
        updateAttendee.setReferral(attendee.getReferral());
        return attendeeRepo.save(updateAttendee);
    }
}
