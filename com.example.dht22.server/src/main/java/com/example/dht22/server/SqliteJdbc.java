package com.example.dht22.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.example.dht22.server.database.ConnectionManager;

public class SqliteJdbc {
  public static void main(final String args[]) {
    // TODO use injection
    Connection connection = new ConnectionManager().getConnection();
    System.out.println("Opened database successfully");
  }

  private static void select(final Connection c) {
    Statement stmt = null;
    try {
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      final ResultSet rs = stmt.executeQuery("SELECT * FROM DATA;");
      while (rs.next()) {
        final double temperature = rs.getDouble("temperature");
        final double humidity = rs.getDouble("humidity");
        final String date = rs.getString("stamp");
        System.out.println("TEMPERATURE = " + temperature);
        System.out.println("HUMIDITY = " + humidity);
        System.out.println("DATE = " + date);
        System.out.println();
      }
      rs.close();
      stmt.close();
      c.close();
    } catch (final Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
    System.out.println("Operation done successfully");
  }
}