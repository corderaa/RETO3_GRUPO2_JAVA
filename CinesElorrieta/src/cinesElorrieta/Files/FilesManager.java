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
				String datos = "-----------------------" + "\n" + "NOMBRE DE LA PELICULA: "
						+ selectedSessions.get(i).getSession().getMovie().getMovieName() + "\n"
						+ "DURACION DE LA PELICULA: "
						+ selectedSessions.get(i).getSession().getMovie().getMovieDuration().getHours() + ":"
						+ selectedSessions.get(i).getSession().getMovie().getMovieDuration().getMinutes() + ":"
						+ selectedSessions.get(i).getSession().getMovie().getMovieDuration().getSeconds() + "\n"
						+ "FECHA Y HORA DE LA SESION: " + selectedSessions.get(i).getSession().getSessionDate() + "\n"
						+ "CINE: " + selectedSessions.get(i).getSession().getCinema().getCinemaName() + "\n"
						+ "DIRECCION CINE: " + selectedSessions.get(i).getSession().getCinema().getCinemaAddress()
						+ "\n" + "SALA: " + selectedSessions.get(i).getSession().getRoom().getRoomName() + "\n"
						+ "PRECIO DE LA PELICULA: " + selectedSessions.get(i).getSession().getMovie().getMoviePrice()
						+ "\n" + "HORA DE IMPRESION: " + selectedSessions.get(i).getTicketBuyDate() + "\n"
						+ "-----------------------";

				printWriter.println(datos);
			}

			printWriter.println("PRECIO TOTAL: " + selectedSessions.get(0).getTicketPrice() + "\n" + "NOMBRE USUARIO: "
					+ selectedSessions.get(0).getUser().getUserName() + "\n" + "APELLIDO: "
					+ selectedSessions.get(0).getUser().getUserLasName());

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