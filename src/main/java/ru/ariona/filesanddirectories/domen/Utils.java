package ru.ariona.filesanddirectories.domen;

class Utils {
    static String humanReadableByteCountSI(long bytes) {
        return bytes < 1000L ? bytes + " B"
                : bytes < 999_950L ? String.format("%.1f Kb", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f Mb", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f Gb", bytes / 1e3)
                : (bytes /= 1000) < 999_950L ? String.format("%.1f Tb", bytes / 1e3)
                : String.format("%.1f EB", bytes / 1e6);
    }
}
