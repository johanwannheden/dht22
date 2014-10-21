package com.example.dht22.server;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.dht22.server.database.ConnectionManager;

// TODO injectable bean
public class SqliteJdbc {

  private static final String SELECT_LAST_READING = "select * from data where id = (select max(id) from data);";
  // 2014-10-14 21:40:03
  private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

  private static final Logger LOG = LogManager.getLogger(SqliteJdbc.class.getName());

  private void initializeConnection(final Connection connection) throws SQLException {
    connection.setAutoCommit(false);
  }

  public Reading getLastReading() {
    // TODO use injection
    Connection connection = new ConnectionManager().getConnection();
    try {
      initializeConnection(connection);
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(SELECT_LAST_READING);
      if (resultSet.next()) {
        final double temperature = resultSet.getDouble("temperature");
        final double humidity = resultSet.getDouble("humidity");
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        try {
          Date date = dateFormat.parse(resultSet.getString("stamp"));
          Reading reading = new Reading();
          reading.setHumidity(humidity);
          reading.setTemperature(temperature);
          reading.setDate(date);
          return reading;
        } catch (ParseException e) {
          LOG.error("Could not parse date", e);
        }
      } else {
        LOG.error("No reading found");
      }
    } catch (SQLException e) {
      LOG.error(e);
    } finally {
      if (connection != null) {
        try {
          connection.close();
        } catch (SQLException e) {
          LOG.error("Could not close connection", e);
        }
      }
    }
    return null;
  }
}