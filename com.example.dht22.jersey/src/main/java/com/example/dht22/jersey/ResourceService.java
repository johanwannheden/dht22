package com.example.dht22.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resource")
public class ResourceService {

  // @GET
  // @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
  // public Reading getXml() {
  // Reading reading = new Reading();
  // reading.setHumidity(55.5);
  // reading.setTemperature(25.4);
  // return reading;
  // }

  @GET
  @Path("/hej")
  @Produces(MediaType.TEXT_HTML)
  public String getHej() {
    return "<h1>Hej</h1>";
  }

  @GET
  @Path("/reading")
  @Produces(MediaType.APPLICATION_JSON)
  public Reading getHtml() {
    Reading reading = new Reading();
    reading.setHumidity(55.5);
    reading.setTemperature(25.4);
    return reading;
  }

}
