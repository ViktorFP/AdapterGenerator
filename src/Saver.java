import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Saver {
    public static void saveToFile(String data, String path) throws IOException {
        File file = new File(path);
        /*if (file.exists()) {
            file.delete();
        }
        file.createNewFile();*/
        //--
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }
}
