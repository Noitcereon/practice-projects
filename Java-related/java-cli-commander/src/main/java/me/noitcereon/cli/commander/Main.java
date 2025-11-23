package me.noitcereon.cli.commander;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder();
        pb.command(List.of("gradlew.bat", "build"));
        pb.environment().put("JAVA_HOME", System.getProperty("java.home"));
//        pb.command(List.of("java", "--version"));
        pb.redirectErrorStream(true);
        try {
            Process process = pb.start();
            List<String> processResults = readProcessOutcome(process);
            int exitCode = process.waitFor();
            System.out.println("processResults: %s".formatted(processResults));
            System.out.println("exitCode: %s".formatted(exitCode));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            System.out.println("Interrupted!");
            System.exit(0);
        }
    }

    private static List<String> readProcessOutcome(Process process) throws IOException {
        List<String> output = new ArrayList<>();
        Path logFilePath = Path.of("/cliCommander.log");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             BufferedWriter writer = Files.newBufferedWriter(logFilePath)) {
            String line = reader.readLine();
            while (line != null) {
                if (isNotBlank(line)) {
                    output.add(line);
                    writer.write(line);
                    writer.newLine();
                    writer.flush();
                }
                line = reader.readLine();
            }
        }
        System.out.println("log file located at '%s'".formatted(logFilePath.toAbsolutePath()));
        return output;
    }

    private static boolean isNotBlank(String str) {
        return str != null && !str.isBlank();
    }

}
