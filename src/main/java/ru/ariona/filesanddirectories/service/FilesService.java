package ru.ariona.filesanddirectories.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ariona.filesanddirectories.repo.FilesRepo;

@Service
public class FilesService {

    private FilesRepo filesRepo;

    @Autowired
    public FilesService(FilesRepo filesRepo) {
        this.filesRepo = filesRepo;
    }
}
