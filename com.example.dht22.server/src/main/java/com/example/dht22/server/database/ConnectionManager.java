package com.example.dht22.server.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.MessageFormat;

public class ConnectionManager {

  private static final String DEFAULT_LOCAL_PATH = "jdbc:sqlite:data/dht22.db";

  public Connection getConnection() {
    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException exception) {
      throw new AssertionError("SQLite not found on classpath", exception);
    }
    final String path = getPath();
    try {
      return DriverManager.getConnection(path);
    } catch (SQLException exception) {
      throw new IllegalArgumentException(MessageFormat.format(
          "No database found at given path: {0}", path), exception);
    }
  }

  private String getPath() {
    return System.getProperty("com.example.dht22.database.path", DEFAULT_LOCAL_PATH);
  }

}
