package com.blu4ck.Programming_Languages.services;

import com.blu4ck.Programming_Languages.exceptions.ResourceNotFoundException;
import com.blu4ck.Programming_Languages.models.Language;
import com.blu4ck.Programming_Languages.repositories.LanguageRepository;
import com.blu4ck.Programming_Languages.repositories.SpecsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private SpecsRepository specsRepository;

    private static final Logger logger = LoggerFactory.getLogger(LanguageService.class);



    public List<Language> getAllLanguages() {
        logger.info("Fetching all languages");
        return languageRepository.findAll();
        }

    public Optional<Language> getLanguageById(Long id) {
        return languageRepository.findById(id);
    }

    public Language updateLanguage(Long id, Language languageDetails) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);

        if (optionalLanguage.isPresent()) {
            Language existingLanguage = optionalLanguage.get();
            existingLanguage.setName(languageDetails.getName());
            existingLanguage.setSpecs(languageDetails.getSpecs());
            return languageRepository.save(existingLanguage);
        } else {
            throw new ResourceNotFoundException("Language id bulunamadı " + id);
        }
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

}
