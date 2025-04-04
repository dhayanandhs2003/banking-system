package entity;

public class Artist {
    private int artist_id;
    private String name;
    private String biography;
    private String birth_date;
    private String nationality;
    private String website;
    private String contact_info;

    public Artist() {}

    public Artist(int artist_id, String name, String biography, String birth_date, 
                  String nationality, String website, String contact_info) {
        this.artist_id = artist_id;
        this.name = name;
        this.biography = biography;
        this.birth_date = birth_date;
        this.nationality = nationality;
        this.website = website;
        this.contact_info = contact_info;
    }

    // Getters and Setters
}


