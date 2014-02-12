/**
 * 
 */
package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A TCP server that runs on port 9090. When a client connects, it sends the
 * client the current date and time, then closes the connection with that
 * client. Arguably just about the simplest server you can write.
 */
public class Server {

    /**
     * Runs the server.
     */
    public static void main(String[] args) throws IOException {
	ServerSocket listener = new ServerSocket(9090);
	try {
	    while (true) {
		Socket socket = listener.accept();

		try {

		    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		    out.println(new Date().toString());
		    out.flush();
		    System.out.println("server write ...");
		    Thread.sleep(3000);

		    out.println(new Date().toString());
		    out.flush();
		    System.out.println("server write ...");
		    Thread.sleep(3000);

		    out.println(new Date().toString());
		    out.flush();
		    System.out.println("server write ...");
		    Thread.sleep(3000);

		    out.println(new Date().toString());
		    out.flush();
		    System.out.println("server write ...");
		    Thread.sleep(10000);

		    out.println(new Date().toString());
		    out.flush();
		    System.out.println("server write ...");
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    System.err.println(e);
		} finally {
		    System.out.println("server close client socket ...");
		    socket.close();
		}
	    }
	} finally {
	    listener.close();
	}
    }
}