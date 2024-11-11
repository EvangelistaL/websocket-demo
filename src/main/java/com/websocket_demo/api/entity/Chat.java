package com.websocket_demo.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatName;

    @NotNull
    private LocalDateTime createdDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat",
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST})
    private Set<User> involved;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat",
            cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Message> messages;
}
