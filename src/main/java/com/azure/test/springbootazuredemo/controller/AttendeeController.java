package com.azure.test.springbootazuredemo.controller;

import com.azure.test.springbootazuredemo.helper.ResponseHandler;
import com.azure.test.springbootazuredemo.model.Attendee;
import com.azure.test.springbootazuredemo.service.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AttendeeController {

    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    //TODO: სტატუსები 0,1,2 დასამატებელია, დანარჩენი მუშაობს

    @GetMapping("/message")
    public ResponseEntity<Object> message() {
        return ResponseHandler.generateResponse("Deployed and Running Successfully!!!", HttpStatus.OK);
    }

    @GetMapping("/get/Attendee/{id}")
    public ResponseEntity<Object> getAttendee(@PathVariable Long id) {
        try {
            Attendee attendee = attendeeService.getAttendee(id).get();
            return ResponseHandler.generateResponse("0", HttpStatus.OK, attendee);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

    @GetMapping("/get/AllAttendee")
    public ResponseEntity<Object> getAttendee() {
        try {
            List<Attendee> attendeeList = attendeeService.getAllAttendee();
            return ResponseHandler.generateResponse("0", HttpStatus.OK, attendeeList);

        } catch (Exception ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

    @PostMapping("/post/createAttendee")
    public ResponseEntity<Object> createAttendee(@RequestBody Attendee attendee) {
        try {
            Attendee attendee1 = attendeeService.createAttendee(attendee);
            return ResponseHandler.generateResponse("Created", HttpStatus.CREATED, attendee1);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

    @PutMapping("/put/updateAttendee")
    public ResponseEntity<Object> updateAttendee(@RequestBody Attendee attendee) {
        try {
            Attendee attendee1 = attendeeService.updateAttendee(attendee);
            return ResponseHandler.generateResponse("Updated", HttpStatus.OK, attendee1);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> deleteAttendee(@PathVariable Long id) {
        try {
            attendeeService.deleteAttendee(id);
            String message = "Deleted!";
            return ResponseHandler.generateResponse(message, HttpStatus.OK, null);
        } catch (Exception ex) {
            return ResponseHandler.generateResponse(ex.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }


}
