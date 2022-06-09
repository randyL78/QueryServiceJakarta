package com.randylayne.query_service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.randylayne.eventhandler.Event;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.logging.Logger;


@Path("")
public class QueryResource {

  private static final Logger logger = Logger.getLogger("QueryResource");
  private static final ObjectMapper mapper = new ObjectMapper();

  @GET
  @Path("posts")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPostsWithComments() {
    logger.info("GET /posts");
    String entitiesAsJsonString;
    try {
      entitiesAsJsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(PostWithCommentsRepository.getEntities());
    } catch (JsonProcessingException e) {
      return Response.serverError().build();
    }
    return Response.ok(entitiesAsJsonString).build();
  }

  @POST
  @Path("events")
  @Produces(MediaType.APPLICATION_JSON)
  public Response receiveEvent(Event event) {
    logger.info("POST  /events");
    boolean processed = EventProcessorService.process(event);
    return Response.ok("\"processed\" : " + processed).build();
  }
}