package ru.ariona.filesanddirectories.domen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Files {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Directory id_dir;

    private String fileName;

    private boolean isFile;

    private long size;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    public Directory getId_dir() {
        return id_dir;
    }

    public void setId_dir(Directory id_dir) {
        this.id_dir = id_dir;
    }

    public String getSize() {
        if (isFile) {
            return Utils.humanReadableByteCountSI(size);
        }
        return "&ltDIR&gt";
    }

    public void setSize(long size) {
        this.size = size;
    }
}
