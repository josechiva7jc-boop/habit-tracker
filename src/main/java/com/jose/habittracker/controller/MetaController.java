package com.jose.habittracker.controller;

import com.jose.habittracker.model.Meta;
import com.jose.habittracker.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meta")

public class MetaController {
    @Autowired
    private MetaService metaService;

    @GetMapping
    public List<Meta> getAllMetas() {
        return metaService.getAll();
    }
    @PostMapping
    public Meta create (@RequestBody Meta meta) {
        return metaService.create(meta);
    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
         metaService.deleteMeta(id);
    }
    @PutMapping("/{id}")
    public Meta update(@PathVariable Long id, @RequestBody Meta meta) {
        return metaService.updateMeta(id, meta);
    }

}
