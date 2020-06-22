import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server.runServer();
    }

    public static void runServer(){
        try{
            ServerSocket serverSocket = new ServerSocket(3000);
            Integer clientCounter = 0;

            InetAddress ip = InetAddress.getLocalHost();
            System.out.println("El Hostname del Server es: " + ip.getHostName() + " y la IP es: " + ip.getHostAddress());
            System.out.println("Esperando clientes");
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("Cliente[" + clientCounter + "]: " + socket.getInetAddress() + " " + socket.getPort());
                Connection conn = new Connection(socket, clientCounter++);
                conn.start();
            }

        }catch (Exception e){

        }
    }

}
