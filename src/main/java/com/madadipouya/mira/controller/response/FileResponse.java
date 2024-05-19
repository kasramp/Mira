package com.madadipouya.mira.controller.response;

public class FileResponse {

    private final String url;

    private final String command;

    public FileResponse(String url) {
        this.url = url;
        this.command = "wget %s".formatted(url);
    }

    public String getUrl() {
        return url;
    }

    public String getCommand() {
        return command;
    }
}
