package com.jm.marketplace.controller;

import com.jm.marketplace.dto.goods.AdvertisementViewDto;
import com.jm.marketplace.service.advertisement.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/goods")
public class GoodsController {

    private final AdvertisementService advertisementService;

    @Autowired
    public GoodsController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<AdvertisementViewDto> getAll() {
        return advertisementService.findAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public AdvertisementViewDto getById(@PathVariable(name = "id") Long id) {
        return advertisementService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid AdvertisementViewDto advertisementViewDto) {
        advertisementService.saveOrUpdate(advertisementViewDto);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@RequestBody @Valid AdvertisementViewDto advertisementViewDto) {
        advertisementService.saveOrUpdate(advertisementViewDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable(name = "id") Long id) {
        advertisementService.deleteById(id);
    }
}
