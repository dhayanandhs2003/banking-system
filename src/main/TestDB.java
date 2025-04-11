package main;

import util.DBConnection;
import java.sql.Connection;
import java.io.IOException;
import java.sql.SQLException;

import exception.ArtworkNotFoundException;

public class TestDB {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ArtworkNotFoundException {
        Connection conn = DBConnection.getConnection();
        if (conn != null) {
            System.out.println("Test Successful");
        }
        
     // testing the exception
        // throw new exception.ArtworkNotFoundException("Testing artwork not found exception.");

    }
}

