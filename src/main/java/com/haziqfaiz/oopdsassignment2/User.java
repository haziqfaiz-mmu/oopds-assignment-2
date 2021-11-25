package com.haziqfaiz.oopdsassignment2;


import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.time.LocalDate;

/**
 * User superclass containing methods universally used by most, if not all user types/roles.
 */
public abstract class User {
    /**
     * Load RecipientData.csv into recipients ArrayList.
     *
     * @throws IOException
     */
    public static ArrayList<Recipient> DataLoader() throws IOException {
        ArrayList<Recipient> recipients = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get("/home/haziq/Documents/oopds-assignment-2/csv/RecipientData.csv"));

        for (int i = 0; i < lines.size(); i++) {
            String[] items = lines.get(i).split(",");
            recipients.add (new Recipient(items[0], items[1], items[2], items[3], items[4], items[5], items[6]));
        }

        return recipients;
    }

    /**
     * Save recipients ArrayList into RecipientsData.csv.
     *
     * @param recipients
     * @throws IOException
     */
    public static void saveRecipientToCSV (ArrayList<Recipient> recipients) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recipients.size(); i++) {
            sb.append (recipients.get(i).toCSVString() + "\n");
        }
        Files.write(Paths.get("/home/haziq/Documents/oopds-assignment-2/csv/RecipientData.csv"), sb.toString().getBytes());
    }

    /**
     * Load vaccCentreData.csv into vaccCentres ArrayList.
     *
     * @throws IOException
     */
    public static ArrayList<VaccCentre> vaccCentreDataLoader() throws IOException {
        ArrayList<VaccCentre> vaccCentres = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("/home/haziq/Documents/oopds-assignment-2/csv/VaccCentreData.csv"));

        for (int i = 0; i < lines.size(); i++) {
            String[] items = lines.get(i).split(",");

            vaccCentres.add (new VaccCentre (items[0], items[1], Integer.parseInt(items[2]), Integer.parseInt(items[3]), Integer.parseInt(items[4])));
        }

        return vaccCentres;
    }

    /**
     * Save vaccCentres ArrayList into vaccCentreData.csv.
     *
     * @param vaccCentres
     * @throws IOException
     */
    public static void saveVaccCentreToCSV (ArrayList<VaccCentre> vaccCentres) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vaccCentres.size(); i++) {
            sb.append (vaccCentres.get(i).toCSVString() + "\n");
        }
        Files.write(Paths.get("/home/haziq/Documents/oopds-assignment-2/csv/vaccCentreData.csv"), sb.toString().getBytes());
    }

    /**
     * Save vaccinations statistics into vaccCentreStatistics.csv.
     *
     * @param vaccCentres
     * @throws IOException
     */
    public static void saveVaccCentreToCSVStatistics (ArrayList<VaccCentre> vaccCentres) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vaccCentres.size(); i++) {
            sb.append (vaccCentres.get(i).toCSVStringStatistics() + "\n");
        }
        Files.write(Paths.get("/home/haziq/Documents/oopds-assignment-2/csv/vaccCentreStatistics.csv"), sb.toString().getBytes());
    }
}