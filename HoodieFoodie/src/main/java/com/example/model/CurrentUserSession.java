package com.example.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class CurrentUserSession {
    @Id
    @Column(unique = true)
    private String userId;

    private String uuid;
    private LocalDateTime localDateTime;

//    public CurrentUserSession() {
//    }
//
//    public CurrentUserSession(String userId, String uuid, LocalDateTime localDateTime) {
//        this.userId = userId;
//        this.uuid = uuid;
//        this.localDateTime = localDateTime;
//    }
//
//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }
//
//    public String getUuid() {
//        return uuid;
//    }
//
//    public void setUuid(String uuid) {
//        this.uuid = uuid;
//    }
//
//    public LocalDateTime getLocalDateTime() {
//        return localDateTime;
//    }
//
//    public void setLocalDateTime(LocalDateTime localDateTime) {
//        this.localDateTime = localDateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "CurrentUserSession{" +
//                "userId='" + userId + '\'' +
//                ", uuid='" + uuid + '\'' +
//                ", localDateTime=" + localDateTime +
//                '}';
//    }
}
