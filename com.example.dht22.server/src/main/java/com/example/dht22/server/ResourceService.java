package com.example.dht22.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resource")
public class ResourceService {

  @GET
  @Path("/reading")
  @Produces(MediaType.APPLICATION_JSON)
  public Reading getReading() {
    Reading lastReading = new SqliteJdbc().getLastReading();
    return lastReading;
  }

}
