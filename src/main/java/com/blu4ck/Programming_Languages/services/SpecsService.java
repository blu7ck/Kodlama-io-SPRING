package com.blu4ck.Programming_Languages.services;

import com.blu4ck.Programming_Languages.models.Specs;
import com.blu4ck.Programming_Languages.repositories.SpecsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpecsService {
    @Autowired
    private SpecsRepository specsRepository;

    public Specs saveSpecs(Specs specs) {
        return specsRepository.save(specs);
    }

    public void deleteSpecs(Long id) {
        specsRepository.deleteById(id);
    }

    public Optional<Specs> updateSpecs(Long id, Specs specsDetails) {
        Optional<Specs> optionalSpecs = specsRepository.findById(id);
        if (optionalSpecs.isPresent()) {
            Specs specs = optionalSpecs.get();
            specs.setTech(specsDetails.getTech());
            return Optional.of(specsRepository.save(specs));
        }
        return Optional.empty();
    }
}
