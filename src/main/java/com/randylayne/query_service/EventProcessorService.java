package com.randylayne.query_service;

import com.randylayne.eventhandler.Event;
import com.randylayne.query_service.CommentEntity.Status;
import java.util.HashMap;
import java.util.UUID;

public class EventProcessorService {
  public static boolean process(Event event) {
    if(event.getType().equals("PostCreated")) {
      processPostCreated(event);
      return true;
    }

    if(event.getType().equals("CommentCreated")) {
      processCommentUpdated(event);
      return true;
    }

    if(event.getType().equals("CommentUpdated")) {
      processCommentUpdated(event);
      return true;
    }

    return false;
  }

  private static void processPostCreated(Event event) {
    UUID postUUID = UUID.fromString((String) ((HashMap) event.getData()).get("uuid"));
    PostWithCommentsEntity entity = getOrCreatePostWithComments(postUUID);

    entity.setTitle((String) ((HashMap) event.getData()).get("title"));
    PostWithCommentsRepository.setEntity(entity);
  }

  private static void processCommentUpdated(Event event) {
    UUID postUUID = UUID.fromString((String) ((HashMap) event.getData()).get("postUUID"));
    PostWithCommentsEntity entity = getOrCreatePostWithComments(postUUID);

    CommentEntity comment = new CommentEntity();
    comment.setUuid(UUID.fromString((String) ((HashMap) event.getData()).get("uuid")));
    comment.setContent((String) ((HashMap) event.getData()).get("content"));
    comment.setStatus(Status.valueOf((String) ((HashMap) event.getData()).get("status")));
    entity.replaceComment(comment);

    PostWithCommentsRepository.setEntity(entity);
  }

  private static PostWithCommentsEntity getOrCreatePostWithComments(UUID postUUID) {
    PostWithCommentsEntity entity = PostWithCommentsRepository.get(postUUID);
    if(entity == null) {
      entity = new PostWithCommentsEntity(postUUID);
    }
    return entity;
  }
}
