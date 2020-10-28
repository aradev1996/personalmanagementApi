package com.technikum.personalmanagement.api;


import com.technikum.personalmanagement.entity.UrlaubEntity;
import com.technikum.personalmanagement.mapper.UrlaubMapper;
import com.technikum.personalmanagement.model.UrlaubRequest;
import com.technikum.personalmanagement.model.UrlaubResponse;
import com.technikum.personalmanagement.service.UrlaubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/urlaub")
public class UrlaubController {

    private final UrlaubService urlaubService;

    private final UrlaubMapper mapper;

    public UrlaubController(UrlaubService urlaubService, UrlaubMapper mapper) {
        this.urlaubService = urlaubService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<UrlaubResponse> getAll() {
        List<UrlaubEntity> allUrlaub = urlaubService.getAll();

        return allUrlaub.stream().map(mapper::mapFromEntityToResponse).collect(Collectors.toList());
    }

    @PostMapping("/create")
    public void create(@RequestBody UrlaubRequest urlaubRequest) {
        urlaubService.save(mapper.mapFromRequestToEntity(urlaubRequest));
    }
}
