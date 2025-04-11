package main;

import dao.VirtualArtGalleryImpl;
import entity.Artwork;
import exception.ArtworkNotFoundException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainModule {
    public static void main(String[] args) {
        try {
            VirtualArtGalleryImpl galleryService = new VirtualArtGalleryImpl();

            // Test: Get artwork by ID
            int testArtworkId = 1;
            Artwork artwork = galleryService.getArtworkById(testArtworkId);
            System.out.println("Artwork Found: " + artwork.getTitle());

            // You can uncomment and test other methods after implementing them
            /*
            // Add artwork test
            Artwork newArt = new Artwork(2, "Sunset", "Beautiful sunset", LocalDate.of(2023, 10, 1), "Oil", "url", 1);
            galleryService.addArtwork(newArt);

            // Update artwork test
            newArt.setTitle("Updated Sunset");
            galleryService.updateArtwork(newArt);

            // Remove artwork test
            galleryService.removeArtwork(2);
            */

        } catch (ArtworkNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
