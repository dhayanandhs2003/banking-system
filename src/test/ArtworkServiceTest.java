package test;

import static org.junit.jupiter.api.Assertions.*;

import dao.VirtualArtGalleryImpl;
import entity.Artwork;
import exception.ArtworkNotFoundException;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ArtworkServiceTest {

    private static VirtualArtGalleryImpl service;

    @BeforeAll
    public static void setup() throws SQLException, IOException, ClassNotFoundException {
        service = new VirtualArtGalleryImpl();
    }

    @Test
    public void testAddArtwork() {
        Artwork artwork = new Artwork(6, "Artwork 0", "A sample test artwork", LocalDate.now(), "Oil", "test.jpg", 1);
        boolean result = service.addArtwork(artwork);
        assertTrue(result, "Artwork should be added successfully.");
    }

    @Test
    public void testGetArtworkById() throws SQLException {
        try {
            Artwork artwork = service.getArtworkById(1); // Fetching an existing artwork from your table
            assertNotNull(artwork, "Artwork should be found.");
            assertEquals(1, artwork.getArtworkId());
            assertEquals("Mona Lisa", artwork.getTitle());
        } catch (ArtworkNotFoundException e) {
            fail("ArtworkNotFoundException thrown unexpectedly.");
        }
    }

    @Test
    public void testUpdateArtwork() {
        Artwork artwork = new Artwork(1, "Mona Lisa", "Updated description", LocalDate.now(), "Acrylic", "updated.jpg", 1);
        boolean result = service.updateArtwork(artwork);
        assertTrue(result, "Artwork should be updated.");
    }

    @Test
    public void testRemoveArtwork() {
        boolean result = service.removeArtwork(8); // Remove the newly added artwork
        assertTrue(result, "Artwork should be removed.");
    }

    @Test
    public void testSearchArtworks() {
        List<Artwork> result = service.searchArtworks("Mona Lisa");
        assertNotNull(result, "Search should return a non-null list.");
        assertFalse(result.isEmpty(), "Search should return at least one result.");
        assertEquals("Mona Lisa", result.get(0).getTitle());
    }
}
