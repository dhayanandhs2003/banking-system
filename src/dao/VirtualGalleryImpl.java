package dao;

import entity.Gallery;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VirtualGalleryImpl {

    private Connection connection;

    public VirtualGalleryImpl() {
        try {
            connection = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean addGallery(Gallery gallery) {
        String query = "INSERT INTO gallery (name, description, location, curator_id, opening_hours) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, gallery.getName());
            ps.setString(2, gallery.getDescription());
            ps.setString(3, gallery.getLocation());
            ps.setInt(4, gallery.getCurator_id());
            ps.setString(5, gallery.getOpening_hours());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateGallery(Gallery gallery) {
        String query = "UPDATE gallery SET name=?, description=?, location=?, curator_id=?, opening_hours=? WHERE gallery_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, gallery.getName());
            ps.setString(2, gallery.getDescription());
            ps.setString(3, gallery.getLocation());
            ps.setInt(4, gallery.getCurator_id());
            ps.setString(5, gallery.getOpening_hours());
            ps.setInt(6, gallery.getGallery_id());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean removeGallery(int galleryId) {
        String query = "DELETE FROM gallery WHERE gallery_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, galleryId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Gallery> searchGalleries(String keyword) {
        String query = "SELECT * FROM gallery WHERE name LIKE ?";
        List<Gallery> galleries = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                galleries.add(new Gallery(
                        rs.getInt("gallery_id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getString("location"),
                        rs.getInt("curator_id"),
                        rs.getString("opening_hours")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return galleries;
    }
}
