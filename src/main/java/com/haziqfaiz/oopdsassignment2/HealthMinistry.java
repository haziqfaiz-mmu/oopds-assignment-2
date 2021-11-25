package com.haziqfaiz.oopdsassignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * HealthMinistry representing MOH who will manage VCs and recipients.
 */
public class HealthMinistry extends User {
    private static int totalVaccineDistribute;
    private static HashMap <String, Integer> FirstDoseDateDone;
    private static HashMap <String, Integer> SecondDoseDateDone;
    private static ArrayList<Recipient>  recipients;
    private static ArrayList<VaccCentre> vaccCentres;


    /**
     * Load all current recipients' data from RecipientData.csv, then prints line-by-line.
     *
     * @throws IOException
     */
    protected static void viewAllRecipientsHealthMinistry() throws IOException {
        recipients = DataLoader();

        System.out.println ("\n");

        for (int i = 0; i < recipients.size(); i++) {
            System.out.printf ("%s %-3s %s", "Recipient #", (i+1), recipients.get(i));

            System.out.print ("\n");
        }
    }

    /**
     * Load all current recipients' data from RecipientData.csv, then prints the recipient with specified ID (if found).
     *
     * @param id
     * @throws IOException
     */
    protected static void searchRecipientHealthMinistry (String id) throws IOException {
        recipients = DataLoader();

        var isSearchSuccessful = false;

        for (int i = 0; i < recipients.size(); i++)
            if (recipients.get(i).getID().equals(id)) {
                System.out.printf ("%s %-3s %s", "Recipient #", (i+1), recipients.get(i) + "\n");
                isSearchSuccessful = true;
            }

        if (isSearchSuccessful == false)
            System.out.println ("ERROR: ID NOT FOUND.");
        else
            System.out.print ("\n");
    }

    /**
     * Automatically distribute recipients to vaccination centres based on availability.
     * If a recipient has not gotten an appointment and a vacc. centre still has availability,
     * then assign that recipient to the vaccination centre.
     *
     * @throws IOException
     */
    protected static void distributeRecipient() throws IOException {
        vaccCentres = vaccCentreDataLoader();
        recipients  = DataLoader();

        int countHowManyRecipientsDistributed = 0;

        for (int i = 0; i < vaccCentres.size(); i++) {
            for (int j = 0; j < recipients.size(); j++)
                if (recipients.get(j).getVaccCentrePlacement().equals("NULL") && vaccCentres.get(i).vaccCentreAvailability() > 0) {

                    recipients.get(j).setVaccCentrePlacement(vaccCentres.get(i).getVaccCentreId());
                    vaccCentres.get(i).setCurrentCapacity(1);

                    countHowManyRecipientsDistributed++;
                    System.out.printf ("\n#" + "%-2s %s", countHowManyRecipientsDistributed, "RECIPIENT DISTRIBUTED TO VACCINATION CENTRE " +
                            vaccCentres.get(i).getVaccCentreId() + "...");
                }
        }

        if (countHowManyRecipientsDistributed == 0)
            System.out.println ("\nNO VACCINATION CENTRES WITH AVAILABILITY\nNO RECIPIENTS DISTRIBUTED...");
        else
            System.out.print ("\n");

        saveVaccCentreToCSV (vaccCentres);
        saveRecipientToCSV  (recipients);
    }

    /**
     * Automatically distribute vaccines based on the capacity of the vaccination centres if
     * the vacc. centres requires new vaccines, i.e. they have used up at least 1 from their
     * current vaccine stock.
     *
     * @throws IOException
     */
    protected static Boolean distributeVaccine() throws IOException {
        vaccCentres = vaccCentreDataLoader();
        boolean exceeded = false;
        int countHowManyVaccCentresDistributedTo = 0;

        for (int i = 0 ; i < vaccCentres.size(); i++)
            if (vaccCentres.get(i).getCurrentVaccineStock() < vaccCentres.get(i).getMaxCapacity()) {

                vaccCentres.get(i).setCurrentVaccineStock(vaccCentres.get(i).getMaxCapacity());
                countHowManyVaccCentresDistributedTo++;

                System.out.printf ("\nVACCINES DISTRIBUTED TO VACCINATION CENTRE " + vaccCentres.get(i).getVaccCentreId() + "...");
            }

        if (countHowManyVaccCentresDistributedTo == 0){
            exceeded = true;
            System.out.println ("\nNO VACCINATION CENTRES REQUIRE NEW VACCINES FOR VC BELLOW:");
            for(int i =0 ; i < vaccCentres.size(); i++){
                System.out.println(vaccCentres.get(i).getVaccCentreId());
            }
            System.out.println("DO YOU STILL WANT TO DISTRIBUTE VACCINE?[y/n]\n-->");
        }
        else
            System.out.print ("\n");

        saveVaccCentreToCSV(vaccCentres);
        return exceeded;
    }

    /**
     * Save user-specified vacc. centre ID, name, and max capacity into VaccCentre.csv;
     * current capacity, current vaccine stock, and total doses done are set to 0.
     *
     * @param vaccCentreId
     * @param vaccCentreName
     * @param vaccCentreMaxCapacity
     * @throws IOException
     */
    protected static void createVaccCentre (String vaccCentreId, String vaccCentreName, int vaccCentreMaxCapacity) throws IOException {
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader(); // Load data from RecipientData.csv
        vaccCentres.add(new VaccCentre (vaccCentreId.toUpperCase(), vaccCentreName.toUpperCase(), vaccCentreMaxCapacity, 0, 0));

        saveVaccCentreToCSV (vaccCentres);
    }

    /**
     * Displays statistics showing all completed vaccinations undergone in all vacc. centres.
     */
    protected static void viewStatistic() throws IOException{
        recipients = DataLoader();
        vaccCentres = vaccCentreDataLoader();
        totalVaccineDistribute = 0;

        FirstDoseDateDone = new HashMap<>();
        SecondDoseDateDone = new HashMap<>();

        for (int i=0 ; i < recipients.size(); i++){
            if (recipients.get(i).getStatus().equals("1ST DOSE DONE")|| recipients.get(i).getStatus().equals("2ND DOSE SET") || recipients.get(i).getStatus().equals("2ND DOSE DONE")){
                FirstDoseDateDone.computeIfPresent(recipients.get(i).getFirstDoseDone(), (key, val) -> val + 1);
                FirstDoseDateDone.computeIfAbsent(recipients.get(i).getFirstDoseDone(),k -> 1);

            }
            if (recipients.get(i).getStatus().equals("2ND DOSE DONE")){
                SecondDoseDateDone.computeIfPresent(recipients.get(i).getSecondDoseDone(), (key, val) -> val + 1);
                SecondDoseDateDone.computeIfAbsent(recipients.get(i).getSecondDoseDone(),k -> 1);
            }

        }

        FirstDoseDateDone.forEach((key, value) -> System.out.println("Total First Dose completed for "+ key + " with " + value + " recipient completed"));
        SecondDoseDateDone.forEach((key, value) -> System.out.println("Total completed for both doses for " + key + " with " + value + " recipient completed"));

        FirstDoseDateDone.forEach((key, value) -> totalVaccineDistribute += value);
        SecondDoseDateDone.forEach((key, value) -> totalVaccineDistribute += value);

        for(int i = 0 ; i < vaccCentres.size(); i++)
            totalVaccineDistribute += vaccCentres.get(i).getCurrentVaccineStock();

        System.out.println("Total Vaccine Distributed " + totalVaccineDistribute);
    }
}
