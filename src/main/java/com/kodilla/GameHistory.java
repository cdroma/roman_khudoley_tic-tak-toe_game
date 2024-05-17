package com.kodilla;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GameHistory {

    private final List<String> history;
    private final DateTimeFormatter formatter;

    public GameHistory() {
        history = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void addToHistory(String playerName, int gamesPlayed, int gamesWon) {
        LocalDateTime now = LocalDateTime.now();
        String entry = String.format("%s|%d|%d|%s", playerName, gamesPlayed, gamesWon, now.format(formatter));
        history.add(entry);
    }

    public void saveToFile(String filePath) {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (String entry : history) {
                writer.write(entry);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku: " + e.getMessage());
        }
    }
}
