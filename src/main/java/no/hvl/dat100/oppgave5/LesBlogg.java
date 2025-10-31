package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
        // forvirret om det er forventet å bruke alle importerte pakker
        File fil = new File(mappe + filnavn);

        try (BufferedReader reader = new BufferedReader(new FileReader(fil))) {
            String line;
            int antallInnlegg = Integer.parseInt(reader.readLine());
            Blogg blogg = new Blogg(antallInnlegg);

            while ((line = reader.readLine()) != null) {
                if (line.equals(TEKST)) {
                    int id = Integer.parseInt(reader.readLine());
                    String bruker = reader.readLine();
                    String dato = reader.readLine();
                    int likes = Integer.parseInt(reader.readLine());
                    String tekst = reader.readLine();

                    Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
                    blogg.leggTil(tekstInnlegg);
                } else if (line.equals(BILDE)) {
                    int id = Integer.parseInt(reader.readLine());
                    String bruker = reader.readLine();
                    String dato = reader.readLine();
                    int likes = Integer.parseInt(reader.readLine());
                    String tekst = reader.readLine();
                    String url = reader.readLine();

                    Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                    blogg.leggTil(bildeInnlegg);
                }
            }

            return blogg;
        } catch (IOException e) {
            System.err.println("Kunne ikke lese av fil" + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
