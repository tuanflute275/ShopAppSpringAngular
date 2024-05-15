package vn.tuanflutte.services.uploadFile;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IUploadFileService {
    public String uploadImage(String folderName, MultipartFile image);
    public List<String> uploadListImage(String folderName, List<MultipartFile> listImages);
}
