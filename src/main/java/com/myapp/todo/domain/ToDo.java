package com.myapp.todo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class ToDo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String id;

    @NonNull
    @NotBlank
    private String description;

    @Column(updatable = false, insertable = true)
    private LocalDateTime created;


    private LocalDateTime modified;

    private Boolean completed;

    @PrePersist
    public void onCreate(){
        this.setCreated(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate(){
        this.setModified(LocalDateTime.now());
    }

}
