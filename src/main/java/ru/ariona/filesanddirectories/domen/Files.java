package ru.ariona.filesanddirectories.domen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Files implements Comparable<Files>{

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Directory directory;

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

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
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

    @Override
    public int compareTo(Files o) {
        LinkedList<Character> first = new LinkedList<>(this.fileName.chars()
                                                    .mapToObj(c -> (char) c)
                                                    .collect(Collectors.toList()));
        LinkedList<Character> second = new LinkedList<>(o.fileName.chars()
                                                    .mapToObj(c -> (char) c)
                                                    .collect(Collectors.toList()));

        int length = (first.size()<second.size())?first.size():second.size();
        for (int i = 0; i < length; i++) {
            if (isDigit(first.peekFirst())
                && isDigit(second.peekFirst())) {

                StringBuilder sb1 = new StringBuilder();
                while (isDigit(first.peekFirst())) {
                    sb1.append(first.pollFirst());
                }

                StringBuilder sb2 = new StringBuilder();
                while (isDigit(second.peekFirst())) {
                    sb2.append((second.pollFirst()));
                }

                int int1 = Integer.parseInt(sb1.toString());
                int int2 = Integer.parseInt(sb2.toString());
                if (int1 != int2) {
                    return int1 - int2;
                }

            }
            char one = Character.toLowerCase(first.pollFirst());
            char two = Character.toLowerCase(second.pollFirst());
            if (one != two) {
                return one - two;
            }

        }
        return -1;
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }
}
