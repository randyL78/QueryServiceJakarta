package com.randylayne.query_service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostWithCommentsRepository {
  private static final Map<UUID, PostWithCommentsEntity> entities = new HashMap<>();

  public static PostWithCommentsEntity get(UUID postUUID) {
    return entities.get(postUUID);
  }

  public static Map<UUID, PostWithCommentsEntity> getEntities() {
    return entities;
  }

  public static void setEntity(PostWithCommentsEntity entity) {
    entities.put(entity.getUuid(), entity);
  }
}
