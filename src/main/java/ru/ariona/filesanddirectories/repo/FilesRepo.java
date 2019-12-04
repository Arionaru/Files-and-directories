package ru.ariona.filesanddirectories.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ariona.filesanddirectories.domen.Files;

public interface FilesRepo extends JpaRepository<Files,Long> {

}
