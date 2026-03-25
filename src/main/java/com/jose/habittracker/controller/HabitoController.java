package com.jose.habittracker.controller;

import com.jose.habittracker.model.Habito;
import com.jose.habittracker.service.HabitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habitos")

public class HabitoController {

    @Autowired
    private HabitoService habitoservice;

    @GetMapping
    public List<Habito> getAll() {
        return habitoservice.getAll();
    }
    @PostMapping
    public Habito create(@RequestBody Habito habito) {
        return habitoservice.create(habito);
    }
}
