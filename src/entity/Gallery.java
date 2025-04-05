package entity;

public class Gallery {
    private int gallery_id;  // Changed from galleryId
    private String name;
    private String description;
    private String location;
    private int curator_id;  // Changed from curatorId
    private String opening_hours;  // Changed from openingHours

    public Gallery() {}

    public Gallery(int gallery_id, String name, String description, String location, int curator_id, String opening_hours) {
        this.gallery_id = gallery_id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.curator_id = curator_id;
        this.opening_hours = opening_hours;
    }

    // Getters and Setters

    public int getGallery_id() {  // Updated method name
        return gallery_id;
    }

    public void setGallery_id(int gallery_id) {  // Updated method name
        this.gallery_id = gallery_id;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCurator_id() {  // Updated method name
        return curator_id;
    }

    public void setCurator_id(int curator_id) {  // Updated method name
        this.curator_id = curator_id;
    }

    public String getOpening_hours() {  // Updated method name
        return opening_hours;
    }

    public void setOpening_hours(String opening_hours) {  // Updated method name
        this.opening_hours = opening_hours;
    }
}
