package ru.ariona.filesanddirectories.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ariona.filesanddirectories.domen.Directory;

import java.util.List;

public interface DirectoryRepo extends JpaRepository<Directory, Long> {
    @Query("select d from Directory d order by d.date desc")
    @Override
    List<Directory> findAll();
}
