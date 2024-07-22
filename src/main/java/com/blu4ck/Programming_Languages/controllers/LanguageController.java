package com.blu4ck.Programming_Languages.controllers;

import com.blu4ck.Programming_Languages.models.Language;
import com.blu4ck.Programming_Languages.services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/languages")
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping
    public List<Language> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageById(@PathVariable Long id) {
        return languageService.getLanguageById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Language createLanguage(@RequestBody Language language) {
        return languageService.saveLanguage(language);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id) {
        languageService.deleteLanguage(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language languageDetails) {
        Language updatedLanguage = languageService.updateLanguage(id, languageDetails);
        return ResponseEntity.ok(updatedLanguage);
    }
}
