package com.datpham.foodorder.service.Impl;

import com.datpham.foodorder.service.FileService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
@Transactional
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final String rootPath = "C:\\Users\\Admin\\Documents\\Project\\Food_Order_Repo\\backend\\src\\main\\resources\\static\\";
    private Path root;
    private void init(String target) {
        try {
            root = Paths.get(rootPath + "\\" + target);
            if(Files.notExists(root)) {
                Files.createDirectories(root);
            }
        }catch (Exception e) {
            System.out.println("Error create folder root: "+e.getMessage());
        }

    }

    @Override
    public boolean saveFile(MultipartFile file, String target) {

        try {
            init(target);
            Files.copy(file.getInputStream(),root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
            System.out.println("Error save file: "+e.getMessage());
        }
        return false;
    }

    @Override
    public Resource loadFile(String fileName, String target) {

        try {
            init(target);
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

    }
}
