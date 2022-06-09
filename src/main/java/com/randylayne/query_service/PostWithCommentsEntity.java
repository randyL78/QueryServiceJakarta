package com.randylayne.query_service;

import java.util.ArrayList;
import java.util.UUID;

public class PostWithCommentsEntity {
  private UUID uuid;
  private String title;
  private ArrayList<CommentEntity> comments = new ArrayList<>();

  public PostWithCommentsEntity() {}

  public PostWithCommentsEntity(UUID uuid) {
    this.uuid = uuid;
  }

  public PostWithCommentsEntity(UUID uuid, String title, ArrayList<CommentEntity> comments) {
    this.uuid = uuid;
    this.title = title;
    this.comments = comments;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ArrayList<CommentEntity> getComments() {
    return comments;
  }

  public void setComments(ArrayList<CommentEntity> comments) {
    this.comments = comments;
  }

  public void addComment(CommentEntity comment) {
    comments.add(comment);
  }

  public void replaceComment(CommentEntity comment) {
    int index = comments.indexOf(comment);

    if (index > -1) {
      comments.set(index, comment);
      return;
    }

    comments.add(comment);
  }
}
