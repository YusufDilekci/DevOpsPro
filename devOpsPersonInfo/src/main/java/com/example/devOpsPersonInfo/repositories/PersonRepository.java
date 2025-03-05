package com.example.devOpsPersonInfo.repositories;

import com.example.devOpsPersonInfo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
