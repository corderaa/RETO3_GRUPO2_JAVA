package cinesElorrieta.Files;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import cinesElorrieta.bbdd.pojo.Ticket;

public class FilesManager {
	private static final String NOMBRE_FICHERO = "ticket.txt";
	private static final String RUTA_FICHERO = "C:\\Users\\in1dm3-v\\Desktop\\";

	public void insertTicketIntoFile(ArrayList<Ticket> selectedSessions) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i < selectedSessions.size(); i++) {
				String datos = "NOMBRE DE LA PELICULA: "
						+ selectedSessions.get(i).getSession().getMovie().getMovieName() + "\n"
						+ "FECHA Y HORA DE LA SESION: " + selectedSessions.get(i).getSession().getSessionDate() + "\n"
						+ "CINE: " + selectedSessions.get(i).getSession().getCinema().getCinemaName() + "\n" + "SALA: "
						+ selectedSessions.get(i).getSession().getRoom().getRoomName() + "\n" + "PRECIO: "
						+ selectedSessions.get(i).getSession().getMovie().getMoviePrice() + "\n" + "HORA DE IMPRESION: "
						+ selectedSessions.get(i).getTicketBuyDate()+"\n" + "NOMBRE USUARIO: "
						+ selectedSessions.get(i).getUser().getUserName()+"\n" + "APELLIDO: "
						+ selectedSessions.get(i).getUser().getUserLasName();
				printWriter.println(datos);
			}

		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} catch (Exception e) {
			System.out.println("Exception - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}

	}
}