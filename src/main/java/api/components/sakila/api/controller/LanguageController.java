package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Language;
import api.components.sakila.api.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/language")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping("/all")
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
}
