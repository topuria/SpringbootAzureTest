package com.azure.test.springbootazuredemo.repo;

import com.azure.test.springbootazuredemo.model.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepo extends JpaRepository<Attendee,Long> {
}
