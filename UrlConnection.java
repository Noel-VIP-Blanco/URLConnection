    import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class UrlConnection{
    public static void main(String[] args){
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("data.txt"));
            // Get the URL from the text field
            URL url = new URL("https://gutenberg.org/cache/epub/70700/pg70700.txt");

            // Open a connection to the URL
            URLConnection connection = url.openConnection();

            // Read the contents of the URL
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.write(line + "\n");
            }
            reader.close();
            output.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
