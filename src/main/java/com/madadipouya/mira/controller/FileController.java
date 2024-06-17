package com.madadipouya.mira.controller;

import com.madadipouya.mira.controller.response.FileResponse;
import com.madadipouya.mira.exception.FileNotFoundException;
import com.madadipouya.mira.service.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.madadipouya.mira.util.UrlUtil.getBaseUrl;

@RestController
@RequestMapping()
public class FileController {

    private static final String CURL_RESPONSE_TEMPLATE = """
            =========================
            
            %s
                        
            =========================
            """;

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestPart("file") MultipartFile file, @RequestHeader(value = "User-Agent") String userAgent, HttpServletRequest request) throws IOException {
        FileResponse response = new FileResponse(fileService.storeFile(file, getBaseUrl(request)));
        return (StringUtils.contains(userAgent, "curl")) ? ResponseEntity.ok(CURL_RESPONSE_TEMPLATE.formatted(response.getCommand())) : ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{path}/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> downloadFile(@PathVariable String path, @PathVariable String fileName) throws FileNotFoundException {
        return new ResponseEntity<>(fileService.downloadFile(path, fileName), createContentDispositionHeader(fileName), HttpStatus.OK);
    }

    private HttpHeaders createContentDispositionHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDisposition(ContentDisposition.builder("attachment").filename(fileName).build());
        return headers;
    }
}
