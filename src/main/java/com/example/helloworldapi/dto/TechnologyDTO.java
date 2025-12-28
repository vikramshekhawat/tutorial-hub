package com.example.helloworldapi.dto;

public class TechnologyDTO {
    private Long id;
    private String name;
    private String description;
    private String iconUrl;
    private Long tutorialCount;

    public TechnologyDTO() {
    }

    public TechnologyDTO(Long id, String name, String description, String iconUrl, Long tutorialCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.iconUrl = iconUrl;
        this.tutorialCount = tutorialCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public Long getTutorialCount() {
        return tutorialCount;
    }

    public void setTutorialCount(Long tutorialCount) {
        this.tutorialCount = tutorialCount;
    }
}

