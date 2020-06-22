import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        Client cliente = new Client();
        cliente.runClient();
    }

    public void runClient(){
        try {
            boolean credentialsAccepted = false;
            Scanner credentialsScaner = new Scanner(System.in);
            InetAddress ip = InetAddress.getLocalHost();
            String hostIp = "";
            Integer port = 0;

            while (!credentialsAccepted){

                System.out.println("Ingresa el ip del host: ");
                hostIp = credentialsScaner.next();

                System.out.println("\nIngresa el puerto: ");
                port = credentialsScaner.nextInt();

                if(!(hostIp.equals("127.0.0.1") || hostIp.equals("localhost") || hostIp.equals(ip.getHostAddress()) || hostIp.equals(ip.getHostName())) && port != 3000){
                    System.out.println("Direccion Ip y puerto erroneo, intente nuevamente.\n");
                }else if(!(hostIp.equals("127.0.0.1") || hostIp.equals("localhost") || hostIp.equals(ip.getHostAddress()) || hostIp.equals(ip.getHostName()))){
                    System.out.println("Direccion Ip erronea, intente nuevamente.\n");
                }else if(port != 3000){
                    System.out.println("Puerto erroneo, intente nuevamente.\n");
                }else{
                    credentialsAccepted = true;
                }
            }

            Socket socket = new Socket(hostIp, port);

            InputStream inputStream = socket.getInputStream();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(inputStream));

            String msgServer = "";
            String msgCliente = "";

            while((msgServer = serverReader.readLine()) != null){

                System.out.println(msgServer); //mensaje del Cliente - Servidor
                msgCliente = clientReader.readLine();

                printWriter.write(msgCliente + System.lineSeparator());
                printWriter.flush();
            }

        }catch (Exception e){

        }
    }
}
