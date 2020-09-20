package com.technikum.personalmanagement.repository;

import com.technikum.personalmanagement.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {

    @Query("select p from PersonEntity p where p.status=true")
    List<PersonEntity> getAllActive();

    @Query("select p from PersonEntity p where p.status=false")
    List<PersonEntity> getAllInActive();
}
