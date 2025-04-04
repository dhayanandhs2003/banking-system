package dao;

import entity.Artwork;
import exception.ArtworkNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IVirtualArtGallery {

    // Artwork Management
    boolean addArtwork(Artwork artwork);
    boolean updateArtwork(Artwork artwork);
    boolean removeArtwork(int artworkId);
    Artwork getArtworkById(int artworkID) throws SQLException, ArtworkNotFoundException;
    List<Artwork> searchArtworks(String keyword);

    // User Favorites
    boolean addArtworkToFavorite(int userId, int artworkId);
    boolean removeArtworkFromFavorite(int userId, int artworkId);
    List<Artwork> getUserFavoriteArtworks(int userId);
}
