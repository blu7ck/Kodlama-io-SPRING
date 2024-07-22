package com.blu4ck.Programming_Languages.controllers;

import com.blu4ck.Programming_Languages.models.Specs;
import com.blu4ck.Programming_Languages.services.SpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/specs")
public class SpecsController {
    @Autowired
    private SpecsService specsService;

    @PostMapping
    public Specs createSpecs(@RequestBody Specs specs) {
        return specsService.saveSpecs(specs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecs(@PathVariable Long id) {
        specsService.deleteSpecs(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Specs> updateSpecs(@PathVariable Long id, @RequestBody Specs specsDetails) {
        return specsService.updateSpecs(id, specsDetails)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
