package com.technikum.personalmanagement.service;

import com.technikum.personalmanagement.entity.PersonEntity;
import com.technikum.personalmanagement.entity.UrlaubEntity;
import com.technikum.personalmanagement.repository.UrlaubRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface UrlaubService {

    UrlaubEntity save(UrlaubEntity personEntity);

    List<UrlaubEntity> getAll();
}
