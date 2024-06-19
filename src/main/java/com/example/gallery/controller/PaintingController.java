package com.example.gallery.controller;

import com.example.gallery.model.Painting;
import com.example.gallery.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paintings")
public class PaintingController {

    private final PaintingService service;

    @Autowired
    public PaintingController(PaintingService service) {
        this.service = service;
    }

    @GetMapping
    public List<Painting> getAllPaintings() {
        return service.findAll();
    }

    @PostMapping
    public Painting addPainting(@RequestBody Painting painting) {
        return service.save(painting);
    }
}
