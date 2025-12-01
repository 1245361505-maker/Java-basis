package 额外练习.图书管理系统;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {
    private static final String LOG_FILE = "src/额外练习/图书管理系统/system.log";

    public static void logInfo(String message) {
        writeLog("INFO", message);
    }

    public static void logError(String message) {
        writeLog("ERROR", message);
    }

    public static void logWarning(String message) {
        writeLog("WARNING", message);
    }

    private static void writeLog(String level, String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write(String.format("[%s] %s: %s%n", timestamp, level, message));
        } catch (IOException e) {
            System.err.println("日志写入失败: " + e.getMessage());
        }
    }
}
