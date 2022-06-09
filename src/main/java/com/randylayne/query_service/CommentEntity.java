package com.randylayne.query_service;

import java.util.UUID;

public class CommentEntity {

  public enum Status {
    PENDING, APPROVED, REJECTED
  }
  private UUID uuid;
  private String content;
  private Status status;

  public CommentEntity() {
  }

  public CommentEntity(UUID uuid) {
    this.uuid = uuid;
  }

  public CommentEntity(UUID uuid, String content) {
    this.uuid = uuid;
    this.content = content;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }
}
