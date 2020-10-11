import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    ExecutorService threadPool = Executors.newCachedThreadPool();
    
    public void startup() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("New client connects");
            threadPool.execute(() -> {
                handle(socket);
                System.out.println("A client close the connection");
            });
        }
    }

    public static void handle(Socket socket) {
        try {
            System.out.println("Current thread name:" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];
            var input = socket.getInputStream();
            while (true) {
                var result = input.read(bytes);
                if (result != -1) {
                    System.out.println(new String(bytes));
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            BIOServer server = new BIOServer();
            server.startup();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}