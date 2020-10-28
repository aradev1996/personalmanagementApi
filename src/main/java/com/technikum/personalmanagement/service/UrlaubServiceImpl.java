package com.technikum.personalmanagement.service;

import com.technikum.personalmanagement.entity.UrlaubEntity;
import com.technikum.personalmanagement.repository.UrlaubRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UrlaubServiceImpl implements UrlaubService {

    private final UrlaubRepository urlaubRepository;

    public UrlaubServiceImpl(UrlaubRepository urlaubRepository) {this.urlaubRepository = urlaubRepository;}

    @Override
    public UrlaubEntity save(UrlaubEntity urlaubEntity) {
        return urlaubRepository.save(urlaubEntity);
    }

    @Override
    public List<UrlaubEntity> getAll() {
        return urlaubRepository.findAll();
    }
}
