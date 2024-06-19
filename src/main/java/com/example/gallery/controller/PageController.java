package com.example.gallery.controller;

import com.example.gallery.model.Painting;
import com.example.gallery.service.PaintingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final PaintingService paintingService;

    @Autowired
    public PageController(PaintingService paintingService) {
        this.paintingService = paintingService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("paintings", paintingService.findAll());
        return "index";
    }

    @GetMapping("/addPainting")
    public String showAddPaintingForm(Model model) {
        model.addAttribute("painting", new Painting());
        return "add-painting";
    }

    @PostMapping("/addPainting")
    public String addPainting(@ModelAttribute Painting painting) {
        paintingService.save(painting);
        return "redirect:/";
    }
}
