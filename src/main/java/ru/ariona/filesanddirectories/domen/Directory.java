package ru.ariona.filesanddirectories.domen;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id_dir", targetEntity = Files.class)
    private List<Files> files;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
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


}
