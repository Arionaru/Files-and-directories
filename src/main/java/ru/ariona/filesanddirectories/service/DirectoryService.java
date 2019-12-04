package ru.ariona.filesanddirectories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.ariona.filesanddirectories.domen.Directory;
import ru.ariona.filesanddirectories.domen.Files;
import ru.ariona.filesanddirectories.repo.DirectoryRepo;
import ru.ariona.filesanddirectories.repo.FilesRepo;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class DirectoryService {

    private DirectoryRepo directoryRepo;
    private FilesRepo filesRepo;

    @Autowired
    public DirectoryService(DirectoryRepo directoryRepo, FilesRepo filesRepo) {
        this.directoryRepo = directoryRepo;
        this.filesRepo = filesRepo;
    }

    public String save(String dirPath) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        Resource resource = ctx.getResource("file:" + dirPath);
        File dir;
        try {
            dir = resource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
            return "Директория не найдена";
        }
        if (!dir.isDirectory()) {
            return "Директория не найдена";
        }
        convertFileToDirectory(dir);
        return "";
    }

    private void convertFileToDirectory(File dir) {
        Directory directory = new Directory();
        directory.setDate(new Date());
        directory.setLink(dir.getAbsolutePath());
        directoryRepo.save(directory);

        File[] filesAndDirs = dir.listFiles();
        if (filesAndDirs != null && filesAndDirs.length != 0) {
            int countFiles = 0;
            long size = 0;
            for (File file : filesAndDirs) {
                Files dirFile = new Files();
                dirFile.setDirectory(directory);
                dirFile.setFileName(file.getName());
                if (file.isFile()) {
                    dirFile.setFile(true);
                    dirFile.setSize(file.length());
                    countFiles ++;
                    size += file.length();
                }
                filesRepo.save(dirFile);
            }

            directory.setCountFiles(countFiles);
            directory.setCountDirs(filesAndDirs.length-countFiles);
            directory.setFilesSize(size);
            directoryRepo.save(directory);
        }
    }

    public List<Directory> findAll() {
        return directoryRepo.findAll();
    }

}
