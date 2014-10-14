package com.example.dht22.jersey;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqliteJdbc {
  public static void main(final String args[]) {
    Connection c = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:data/dht22.db");
      select(c);
    } catch (final Exception e) {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);
    }
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