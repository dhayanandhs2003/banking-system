package main;

import dao.VirtualArtGalleryImpl;
import entity.Artwork;
import exception.ArtworkNotFoundException;

import java.io.IOException;
import java.sql.SQLException;

public class TestArtworkRetrieval {
    public static void main(String[] args) {
        try {
            VirtualArtGalleryImpl gallery = new VirtualArtGalleryImpl();

            int testArtworkId = 1; // an actual artwork_id from DB
            Artwork artwork = gallery.getArtworkById(testArtworkId);

            System.out.println("Artwork Retrieved:");
            System.out.println("ID: " + artwork.getArtworkId());
            System.out.println("Title: " + artwork.getTitle());
            System.out.println("Description: " + artwork.getDescription());
            System.out.println("Creation Date: " + artwork.getCreationDate());
            System.out.println("Medium: " + artwork.getMedium());
            System.out.println("Image URL: " + artwork.getImageUrl());
            System.out.println("Artist ID: " + artwork.getArtistId());

        } catch (ArtworkNotFoundException e) {
            System.out.println("❌ " + e.getMessage());
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}

