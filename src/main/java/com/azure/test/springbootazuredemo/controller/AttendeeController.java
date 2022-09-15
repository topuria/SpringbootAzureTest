package com.azure.test.springbootazuredemo.controller;

import com.azure.test.springbootazuredemo.model.Attendee;
import com.azure.test.springbootazuredemo.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendeeController {

    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService){
        this.attendeeService = attendeeService;
    }


    @GetMapping("/message")
    public String message() {
        return "Deployed and Works Fine!!";
    }

    @GetMapping("/get/Attendee/{id}")
    public Attendee getAttendee(@PathVariable Long id){
        return attendeeService.getAttendee(id).get();
    }

    @GetMapping("/get/AllAttendee")
    public List<Attendee> getAttendee(){
        return attendeeService.getAllAttendee();
    }

    @PostMapping("/post/createAttendee")
    public Attendee createAttendee(@RequestBody Attendee attendee){
        return attendeeService.createAttendee(attendee);
    }

    @PutMapping("/put/updateAttendee")
    public Attendee updateAttendee(@RequestBody Attendee attendee){
        return attendeeService.updateAttendee(attendee);
    }

    @DeleteMapping("/del/{id}")
    public String deleteAttendee(@PathVariable Long id){
        attendeeService.deleteAttendee(id);
        return "Deleted!";
    }


}
