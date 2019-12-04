package ru.ariona.filesanddirectories.domen;

public class Utils {
    public static String humanReadableByteCountSI(long bytes) {
        return bytes < 1000L ? bytes + " B"
                : bytes < 999_950L ? String.format("%.1f kB", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f MB", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f GB", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f TB", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f PB", bytes / 1e3)
                : String.format("%.1f EB", bytes / 1e6);
    }
}
