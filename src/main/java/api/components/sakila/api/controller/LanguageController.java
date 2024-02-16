package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Language;
import api.components.sakila.api.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/** A Rest Controller for managing languages.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@RestController
@RequestMapping("/home/language")
public class LanguageController {
    @Autowired
    private LanguageRepository languageRepository;

    /**
     * Retrieves a list of all languages.
     *
     * @return List of all languages available in the system.
     */
    @GetMapping("/all")
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }
}
