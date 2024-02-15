package api.components.sakila.api.dto;

import api.components.sakila.api.domain.Language;

public class LanguageDTO {
    private int id;
    private String name;

    public LanguageDTO() {}

    public LanguageDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public LanguageDTO convertToDTO(Language language) {
        return new LanguageDTO(language.getLanguageId(), language.getName());
    }
}