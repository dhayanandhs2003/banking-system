package dao;

import util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Artwork;
import exception.ArtworkNotFoundException;

public class VirtualArtGalleryImpl implements IVirtualArtGallery {

    private static Connection connection;

    public VirtualArtGalleryImpl() throws SQLException, ClassNotFoundException, IOException {
        connection = DBConnection.getConnection();
    }

    @Override
    public boolean addArtwork(Artwork artwork) {
        String query = "INSERT INTO artwork (artwork_id, title, description, creation_date, medium, image_url, artist_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, artwork.getArtworkId());
            ps.setString(2, artwork.getTitle());
            ps.setString(3, artwork.getDescription());
            ps.setDate(4, java.sql.Date.valueOf(artwork.getCreationDate()));
            ps.setString(5, artwork.getMedium());
            ps.setString(6, artwork.getImageUrl());
            ps.setInt(7, artwork.getArtistId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Returns true if artwork is added
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateArtwork(Artwork artwork) {
        String query = "UPDATE artwork SET title = ?, description = ?, creation_date = ?, medium = ?, image_url = ?, artist_id = ? WHERE artwork_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, artwork.getTitle());
            ps.setString(2, artwork.getDescription());
            ps.setDate(3, java.sql.Date.valueOf(artwork.getCreationDate()));
            ps.setString(4, artwork.getMedium());
            ps.setString(5, artwork.getImageUrl());
            ps.setInt(6, artwork.getArtistId());
            ps.setInt(7, artwork.getArtworkId());

            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Returns true if update is successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeArtwork(int artworkId) {
        String query = "DELETE FROM artwork WHERE artwork_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, artworkId);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Artwork getArtworkById(int artworkID) throws SQLException, ArtworkNotFoundException {
        String query = "SELECT * FROM artwork WHERE artwork_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, artworkID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Artwork(
                    rs.getInt("artwork_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDate("creation_date").toLocalDate(),
                    rs.getString("medium"),
                    rs.getString("image_url"),
                    rs.getInt("artist_id")
                );
            } else {
                throw new ArtworkNotFoundException("Artwork with ID " + artworkID + " not found.");
            }
        }
    }

    @Override
    public List<Artwork> searchArtworks(String keyword) {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT * FROM artwork WHERE title LIKE ? OR description LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Artwork artwork = new Artwork(
                    rs.getInt("artwork_id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getDate("creation_date").toLocalDate(),
                    rs.getString("medium"),
                    rs.getString("image_url"),
                    rs.getInt("artist_id")
                );
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }


    @Override
    public boolean addArtworkToFavorite(int userId, int artworkId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeArtworkFromFavorite(int userId, int artworkId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Artwork> getUserFavoriteArtworks(int userId) {
        // TODO Auto-generated method stub
        return null;
    }
}
