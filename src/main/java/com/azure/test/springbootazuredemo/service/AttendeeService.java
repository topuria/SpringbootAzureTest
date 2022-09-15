package com.azure.test.springbootazuredemo.service;

import com.azure.test.springbootazuredemo.model.Attendee;

import java.util.List;
import java.util.Optional;


public interface AttendeeService {
    List<Attendee> getAllAttendee();

    Optional<Attendee> getAttendee(Long id);

    Attendee createAttendee(Attendee attendee);

    void deleteAttendee(Long id);

    Attendee updateAttendee(Attendee attendee);

}
