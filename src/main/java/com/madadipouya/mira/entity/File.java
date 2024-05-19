package com.madadipouya.mira.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 2, max = 4096)
    private String name;

    @Column(name = "content", columnDefinition = "BLOB", nullable = false)
    @NotNull
    @Lob
    private byte[] content;

    @Column(name = "path", nullable = false)
    @NotBlank
    @Size(min = 6, max = 1024)
    private String path;

    @Column(name = "url", nullable = false)
    @NotBlank
    private String url;

    protected File() {

    }

    public File(String name, byte[] content, String path, String url) {
        this.name = name;
        this.content = content;
        this.path = path;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
