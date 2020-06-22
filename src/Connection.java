import java.io.*;
import java.net.Socket;

public class Connection extends  Thread {

    Socket socket;
    Integer clientCounter;

    public Connection(Socket socket, Integer clientCounter) {

        this.socket = socket;
        this.clientCounter = clientCounter;
    }


    public void run() {
        try {

            InputStream inputStream = socket.getInputStream();
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

            String msgServidor = "Servidor: Usted se ha conectado con el servidor \n";
            printWriter.write(msgServidor);
            printWriter.flush();

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(inputStream));
            BufferedReader serverReader = new BufferedReader(new InputStreamReader(System.in));

            String msgCliente = "";
            Boolean boolMsgServidor = false;

            while((msgCliente = "Cliente: " + clientReader.readLine()) != null){

                if("Cliente: X".equalsIgnoreCase(msgCliente)){
                    break;
                }
                System.out.println(clientCounter + "." + msgCliente); //mensaje del Cliente
                msgServidor = "Servidor: " + serverReader.readLine();

                if("Servidor: X".equalsIgnoreCase(msgServidor)){
                    boolMsgServidor = true;
                    break;
                }
                System.out.println(clientCounter + "." + msgServidor);
                printWriter.write(msgCliente + " - " + msgServidor + System.lineSeparator());
                printWriter.flush();
            }

            if (boolMsgServidor){
                msgServidor = "Servidor: Lo hemos desconectado del servidor";
                System.out.println("El cliente ha sido desconectado del servidor");
            }else{
                msgServidor = "Servidor: Usted se ha desconectado del servidor";
            }

            printWriter.write(msgServidor + System.lineSeparator());
            printWriter.flush();

            socket.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

    }
}
