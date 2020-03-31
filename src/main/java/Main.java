import com.google.gson.Gson;
import dto.ResponseDto;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import processor.Processor;
import processor.ProcessorFactory;

public class Main {

  public static void main(String[] args) throws IOException {
    ServerSocket ding;
    Gson gson = new Gson();
    Socket dong = null;
    try {
      ding = new ServerSocket(1299);
      System.out.println("Opened socket " + 1299);
      String inputLine = null;
      while (true) {
        // keeps listening for new clients, one at a time
        try {
          dong = ding.accept(); // waits for client here
        } catch (IOException e) {
          System.out.println("Error opening socket");
          System.exit(1);
        }

        InputStream stream = dong.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));
        try {
          // read the first line to get the request method, URI and HTTP version
          String line = in.readLine();
          inputLine = line;
          System.out.println("----------REQUEST START---------");
          System.out.println(line);
//          // read only headers
//          line = in.readLine();
//          while (line != null && line.trim().length() > 0) {
//            int index = line.indexOf(": ");
//            if (index > 0) {
//              System.out.println(line);
//            } else {
//              break;
//            }
//            line = in.readLine();
//          }
          System.out.println("----------REQUEST END---------\n\n");
        } catch (IOException e) {
          System.out.println("Error reading");
          System.exit(1);
        }

        System.out.println(inputLine);
        String[] parts = inputLine.split(" ");
        String url = parts[1];
        String[] urlParts = url.split("\\?");
        Map<String,String> argMap = new HashMap<String,String>();
        if(urlParts.length == 2){
          String[] argArray = urlParts[1].split("&");
          for(String arg : argArray){
            String[] argParts = arg.split("=");
            argMap.put(argParts[0], argParts[1]);
          }
        }
        Processor processor = ProcessorFactory.getProcessor(urlParts[0]);
        ResponseDto response = processor.process(argMap);
        BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
        PrintWriter writer = new PrintWriter(out, true);  // char output to the client

        // every response will always have the status-line, date, and server name
        writer.println("HTTP/1.1 200 OK");
        writer.println("Server: TEST");
        writer.println("Connection: close");
        writer.println("Content-type: text/html");
        writer.println("");

        // Body of our response

        writer.println(gson.toJson(response));

        dong.close();
      }
    } catch (IOException e) {
      System.out.println("Error opening socket");
      System.exit(1);
    }
  }
}
