package com.example.gallery.service;

import com.example.gallery.model.Painting;
import com.example.gallery.repository.PaintingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaintingService {

    private final PaintingRepository repository;

    @Autowired
    public PaintingService(PaintingRepository repository) {
        this.repository = repository;
    }

    public List<Painting> findAll() {
        return repository.findAll();
    }

    public Painting save(Painting painting) {
        return repository.save(painting);
    }
}

