package com.technikum.personalmanagement.repository;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UrlaubRepository extends JpaRepository<UrlaubEntity, UUID> {

}
