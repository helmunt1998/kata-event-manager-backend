package com.bancodebogota.eventmanager.repository;

import org.springframework.stereotype.Repository;

import com.bancodebogota.eventmanager.entity.Event;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
