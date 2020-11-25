package cc.insistor.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author cc
 */
public interface FileUploadService {
    public String upload(MultipartFile uploadFile, HttpServletRequest req);
}
