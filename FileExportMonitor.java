import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileExportMonitor {
    private List<Observer> observers = new ArrayList<>();
    private List<User> registeredUsers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void registerUser(User user) {
        registeredUsers.add(user);
        System.out.println("Bonus: User registered - " + user.getUsername());
    }

    public void exportUserData() {
        try {
           
            File dir = new File("./txt");
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Генерируем имя файла с временной меткой
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = "./txt/digibank_export_" + timestamp + ".txt";
            
            // Пишем в файл
            FileWriter writer = new FileWriter(filename);
            writer.write("DigiBank Registered Users Export\n");
            writer.write("Generated at: " + LocalDateTime.now() + "\n\n");
            for(User u : registeredUsers) {
                writer.write("- " + u.getUsername() + "\n");
            }
            writer.close();
            
            System.out.println("Bonus: TXT file successfully exported to " + filename);
           
            notifyObservers("A new file was detected in ./txt path: " + filename + ". The file contains " + registeredUsers.size() + " users.");
            
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    private void notifyObservers(String message) {
        for(Observer o : observers) {
            o.update(message);
        }
    }
}