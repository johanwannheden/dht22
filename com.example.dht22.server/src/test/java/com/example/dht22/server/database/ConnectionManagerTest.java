package com.example.dht22.server.database;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ConnectionManagerTest {

  private Connection connection;

  @Test
  public void read() {
    try {
      Client client = Client.create();
      WebResource webResource = client
          .resource("http://localhost:8080/com.example.dht22.server/resource/reading");
      ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

      if (response.getStatus() != 200) {
        throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
      }

      String output = response.getEntity(String.class);
      assertNotNull(output);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @After
  public void cleanUp() throws SQLException {
    if (connection != null) {
      connection.close();
    }
  }

}
