package com.driver.models;

public class ImageResponseDto {

    int id;

    String description;

    String dimensions;

    public ImageResponseDto(int id, String description, String dimensions) {
        this.id = id;
        this.description = description;
        this.dimensions = dimensions;
    }

    public ImageResponseDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
