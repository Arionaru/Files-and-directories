package ru.ariona.filesanddirectories.domen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        List<Integer> first = getNumbers(fileName);
        List<Integer> second = getNumbers(o.fileName);

        int iter_count;
        if (first.size() >= second.size()) {
            iter_count = second.size();
        } else {
            iter_count = first.size();
        }

        for (int i = 0; i < iter_count; i++) {
            int comp = first.get(i).compareTo(second.get(i));
            if (comp != 0) {
                return comp;
            }
        }

        return fileName.compareToIgnoreCase(o.fileName);
    }

    private List<Integer> getNumbers(String s) {
        List<Integer> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        int start = 0;
        while (matcher.find(start)) {
            String value = s.substring(matcher.start(), matcher.end());
            list.add(Integer.parseInt(value));
            start = matcher.end();
        }
        return list;
    }

}
