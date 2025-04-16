package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import entity.Gallery;
import dao.VirtualGalleryImpl;


public class GalleryServiceTest {
	private VirtualGalleryImpl service;


    @BeforeEach
    void setUp() {
        service = new VirtualGalleryImpl();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void testAddGallery() {
        Gallery gallery = new Gallery(7, "Test Gallery 1", "Description 1", "Test Location 1", 1, "10 AM - 5 PM");
        boolean result = service.addGallery(gallery);
        assertTrue(result, "Gallery should be added successfully.");
    }

    @Test
    void testUpdateGallery() {
        Gallery gallery = new Gallery(2, "Updated Gallery", "Updated Description", "Updated Location", 2, "9 AM - 6 PM");
        boolean result = service.updateGallery(gallery);
        assertTrue(result, "Gallery should be updated successfully.");
    }

    @Test
    void testRemoveGallery() {
        boolean result = service.removeGallery(3); // Assuming gallery with ID 5 exists
        assertTrue(result, "Gallery should be removed successfully.");
    }

    @Test
    void testSearchGalleries() {
        List<Gallery> galleries = service.searchGalleries("Museum");
        assertNotNull(galleries, "Search result should not be null.");
        assertFalse(galleries.isEmpty(), "Search should return at least one result.");
    }
}

