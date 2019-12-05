package ru.ariona.filesanddirectories.domen;


import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class Directory {

    @Id
    @GeneratedValue
    private long id;

    private Date date;

    private String link;

    private int countFiles;

    private int countDirs;

    private long filesSize;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "directory", targetEntity = Files.class)
    private List<Files> files;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        return format.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getCountFiles() {
        return countFiles;
    }

    public void setCountFiles(int countFiles) {
        this.countFiles = countFiles;
    }

    public int getCountDirs() {
        return countDirs;
    }

    public void setCountDirs(int countDirs) {
        this.countDirs = countDirs;
    }

    public String getFilesSize() {
        return Utils.humanReadableByteCountSI(filesSize);
    }

    public void setFilesSize(long filesSize) {
        this.filesSize = filesSize;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public List<Files> getOnlyFiles() {

        return files.stream().filter(f -> f.isFile()).sorted().collect(Collectors.toList());
    }

    public List<Files> getOnlyDirs() {
        return files.stream().filter(f -> !f.isFile()).sorted().collect(Collectors.toList());
    }

}
