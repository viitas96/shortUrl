package dev.clima.redirect.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@DynamicUpdate
public class Link {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Path cant be empty!")
    @Size(min = 12, max = 1023, message = "the length must be greater than 12 and less than 1023")
    @NotBlank(message = "it cant contains only white spaces")
    private String path;

    public Link() {

    }

    public Long getId() {
        return id;
    }

    public Link(String path) {
        this.path = path;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
