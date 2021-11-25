package com.haziqfaiz.oopdsassignment2;



import java.util.ArrayList;
import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.time.LocalDate;

/**
 * Vaccination Centre representing a user (or 'staff') who will vaccinate the recipients.
 */
public class VaccCentre extends User {
    private String vaccCentreId;
    private String vaccCentreName;
    private int    maxCapacity;
    private int    currentCapacity;
    private int    currentVaccineStock;
    private int    totalFirstDoseDone;
    private int    totalSecondDoseDone;
    private HashMap <String, Integer> FirstDoseDone;

    private static LocalDate dateapp = LocalDate.now();
    private static ArrayList<Recipient> recipients;

    /**
     * Construct new vaccination centre with null values.
     */
    public VaccCentre() {};

    /**
     * Construct new vaccination centre with specified ID, name, max capacity, and current capacity.
     *
     * @param vaccCentreId
     * @param vaccCentreName
     * @param maxCapacity
     * @param currentCapacity
     */
    public VaccCentre (String vaccCentreId, String vaccCentreName, int maxCapacity, int currentCapacity, int currentVaccineStock) {
        this.vaccCentreId = vaccCentreId;
        this.vaccCentreName = vaccCentreName;
        this.maxCapacity = maxCapacity;
        this.currentCapacity = currentCapacity;
        this.currentVaccineStock = currentVaccineStock;
    };

    /**
     * Returns current vaccination centre's details in table format (for menu output).
     * @return vacc. centre's ID, name, max capacity, and current capacity; in table format.
     */
    public String toString() {
        return String.format("%s %-6s", " | VC_ID = "           , vaccCentreId) + String.format("%s %-25s", " | VC_NAME = "            , vaccCentreName) +
                String.format("%s %-4s", " | VC_MAX_CAPACITY = " , maxCapacity)  + String.format("%s %-4s" , " | VC_CURRENT_CAPACITY = ", getCurrentCapacity()) +
                String.format("%s %-4s", " | VC_VACCINE_STOCK = ", currentVaccineStock);
    }

    /**
     * Returns current vaccination centre's details (for saving into vaccCentreData.csv), separated by commas.
     * @return vacc. centre's ID, name, max capacity, current capacity, and current vaccine stock; separated by commas.
     */
    public String toCSVString() {
        return vaccCentreId + "," + vaccCentreName + "," + maxCapacity + "," + currentCapacity + "," + currentVaccineStock;
    }

    /**
     * Returns the current vaccination centre's details (for saving into VaccCentreStatistics.csv), separated by commas.
     * @return vacc. centre's ID, current time, total first doses done, and total second doses done; separated by commas.
     */
    public String toCSVStringStatisticsFirstDose() {
        return vaccCentreId  + ","  +  "Total First Dose done" +  "," + dateapp + "," + totalFirstDoseDone;
    }

    /**
     * Returns the current vaccination centre's details (for saving into VaccCentreStatistics.csv), separated by commas.
     * @return vacc. centre's ID, current time, total first doses done, and total second doses done; separated by commas.
     */
    public String toCSVStringStatisticsSecondDose() {
        return vaccCentreId + "," + "Total Second Dose done" + ","  + dateapp + "," + totalSecondDoseDone;
    }

    /**
     * Returns current vaccination centre's ID.
     * @return vacc. centre's ID.
     */
    public String getVaccCentreId() {
        return vaccCentreId;
    }

    /**
     * Returns current vacc. centre's max capacity.
     * @return vacc. centre's max capacity.
     */
    public int getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Returns current vacc. centre's current capacity.
     * @return vacc. centre's current capacity.
     */
    public int getCurrentCapacity() {
        return currentCapacity;
    }

    /**
     * Returns current vaccination centre's availability:
     * @return (max capacity) - (current capacity)
     */
    public int vaccCentreAvailability() {
        return maxCapacity - currentCapacity;
    }

    /**
     * Returns current vaccine stock.
     * @return current vaccine stock.
     */
    public int getCurrentVaccineStock() {
        return currentVaccineStock;
    }

    /**
     * Increase/Decrease current vaccination centre's current capacity by i.
     */
    public void setCurrentCapacity (int i) {
        this.currentCapacity = this.currentCapacity + i;
    }

    /**
     * Increase/Decrease current vaccine stock by i.
     *
     * @param currentVaccineStock
     */
    public void setCurrentVaccineStock (int currentVaccineStock) {
        this.currentVaccineStock = currentVaccineStock;
    }

    /**
     * Increase/Decrease total first doses done by i.
     *
     * @param i
     */
    public void setTotalFirstDoseDone (int i) {
        totalFirstDoseDone += i;
    }

    /**
     * Increase/Decrease total second doses done by i.
     *
     * @param i
     */
    public void setTotalSecondDoseDone (int i) {
        totalSecondDoseDone += i;
    }

    /**
     * View all vaccination centres.
     *
     * @throws IOException
     */
    protected static void viewAllVaccCentres() throws IOException {
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();

        System.out.print ("\n");
        for (int i = 0; i < vaccCentres.size(); i++)
            System.out.printf ("%s %-2s %s", "VC #", (i+1), vaccCentres.get(i)+"\n");
    }

    /**
     * View all recipients in current vaccination centre.
     *
     * @throws IOException
     */
    protected static void viewAllRecipients (int vaccCentreNumber) throws IOException, IllegalArgumentException {
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();
        recipients = DataLoader();

        int countHowManyRecipientListed = 0;

        for (int i = 0; i < recipients.size(); i++)
            if (recipients.get(i).getVaccCentrePlacement().equals(vaccCentres.get(vaccCentreNumber-1).vaccCentreId)) {
                System.out.printf ("%s %-3s %s", "Recipient #", (i+1), recipients.get(i) + "\n");
                countHowManyRecipientListed++;
            }

        if (countHowManyRecipientListed == 0)
            throw new IllegalArgumentException ("ERROR: NO RECIPIENTS IN SELECTED VACC. CENTRE");
    }


    /**
     * Set appointments automatically for all recipients who have yet to have one, provided
     * that there are vaccination centres with availability:
     * 1st dose is set 7 days after current date;
     * 2nd dose is set 21 days after current date / 14 days after 1st dose.
     *
     * @param vaccCentreNumber specifies which vacc. centre to set appointments for.
     * @throws IOException
     */
    protected static void setAppointment (int vaccCentreNumber) throws IOException {
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();
        recipients = DataLoader();

        int countNumberOfAppointmentsCreated = 0;
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).getAppointmentDate().equals("NULL") && recipients.get(i).getVaccCentrePlacement().equals(vaccCentres.get(vaccCentreNumber-1).vaccCentreId)) {
                recipients.get(i).setAppointment(dateapp.plusDays(7).toString());
                recipients.get(i).setStatus("1ST DOSE SET");

                countNumberOfAppointmentsCreated++;
                System.out.printf ("\n1ST DOSE APPOINTMENTS MADE FOR " + "%-2s %s", countNumberOfAppointmentsCreated, "RECIPIENT(S)...");
            }
            if (recipients.get(i).getStatus().equals("1ST DOSE DONE") && recipients.get(i).getVaccCentrePlacement().equals(vaccCentres.get(vaccCentreNumber-1).vaccCentreId)) {
                recipients.get(i).setAppointment(dateapp.plusDays(21).toString());
                recipients.get(i).setStatus("2ND DOSE SET");

                countNumberOfAppointmentsCreated++;
                System.out.printf ("\n2ND DOSE APPOINTMENTS MADE FOR " + "%-2s %s", countNumberOfAppointmentsCreated, "RECIPIENT(S)...");
            }
        }

        if (countNumberOfAppointmentsCreated == 0)
            System.out.println ("\nERROR: NO APPOINTMENTS MADE...\nVACC. CENTRE EITHER IN FULL CAPACITY OR IS EMPTY");
        else
            System.out.print ("\n");

        saveVaccCentreToCSV (vaccCentres);
        saveRecipientToCSV  (recipients);
    }

    /**
     * Update a particular recipient's status.
     *
     * @param recipientNumber specifies which recipeient to update status for.
     * @throws IOException
     */
    protected static void updateRecipientStatus (int recipientNumber) throws IOException, IllegalArgumentException {
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();
        recipients = DataLoader();

        var id = recipients.get(recipientNumber-1).getID();
        var isUpdateSuccessful = false;

        for (int i = 0 ; i < recipients.size(); i++) {
            if (recipients.get(i).getID().equals(id) && recipients.get(i).getStatus().equals("1ST DOSE SET")) {
                recipients.get(i).setStatus("1ST DOSE DONE");
                recipients.get(i).recordFirstDoseDate(recipients.get(i).getAppointmentDate());

                for (int j = 0 ; j < vaccCentres.size(); j++) {
                    if (vaccCentres.get(j).getCurrentVaccineStock() == 0)
                        throw new IllegalArgumentException("ERROR: NO VACCINE IN STOCK");

                    if (vaccCentres.get(j).getVaccCentreId().equals(recipients.get(i).getVaccCentrePlacement())) {

                        vaccCentres.get(j).setCurrentVaccineStock(vaccCentres.get(j).getCurrentVaccineStock()-1);

                        vaccCentres.get(j).setTotalFirstDoseDone(1);
                        System.out.println ("\n1ST DOSE APPOINTMENT UPDATED...");
                        isUpdateSuccessful = true;
                    }
                }

                saveVaccCentreToCSVStatisticsFirstDose(vaccCentres);
            }
            else if (recipients.get(i).getID().equals(id) && recipients.get(i).getStatus().equals("2ND DOSE SET")) {
                recipients.get(i).setStatus("2ND DOSE DONE");
                recipients.get(i).recordSecondDoseDate(recipients.get(i).getAppointmentDate());

                for (int j = 0 ; j < vaccCentres.size(); j++) {
                    if (vaccCentres.get(j).getVaccCentreId().equals(recipients.get(i).getVaccCentrePlacement())) {

                        vaccCentres.get(j).setCurrentVaccineStock(vaccCentres.get(j).getCurrentVaccineStock()-1);
                        vaccCentres.get(j).setCurrentCapacity(-1);

                        vaccCentres.get(j).setTotalSecondDoseDone(1);
                        System.out.println ("\n2ND DOSE APPOINTMENT UPDATED...");
                        isUpdateSuccessful = true;
                    }
                }

                saveVaccCentreToCSVStatisticsSecondDose(vaccCentres);
            }

        }
        if (!isUpdateSuccessful)
            System.out.println ("\nERROR: APPOINTMENT NOT UPDATED...\nRECIPIENT NOT FOUND IN THIS VACC. CENTRE, OR\nRECIPIENT EITHER DOES NOT HAVE APPOINTMENT YET OR HAS ALREADY UNDERGONE COMPLETE VACCINATION");

        saveVaccCentreToCSV (vaccCentres);
        saveRecipientToCSV  (recipients);
    }

    /**
     * View current vaccination centre's statistics.
     */
    protected static void viewStatisticsFirst (int vaccCentreNumber) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("VaccCentreStatisticsFirstDose.csv"));
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();

        for (int x = 0; x < vaccCentres.size(); x++) {
            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");
                for (int j = 0; j < items.length; j++)
                    if (vaccCentres.get(x).getVaccCentreId().equals(items[0]) && vaccCentres.get(vaccCentreNumber-1).vaccCentreId.equals(items[0]) )
                        System.out.println (items[j]);
            }
        }
    }

    protected static void viewStatisticsSecond (int vaccCentreNumber) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("VaccCentreStatisticsSecondDose.csv"));
        ArrayList<VaccCentre> vaccCentres = vaccCentreDataLoader();

        for (int x = 0; x < vaccCentres.size(); x++) {
            for (int i = 0; i < lines.size(); i++) {
                String[] items = lines.get(i).split(",");
                for (int j = 0; j < items.length; j++)
                    if (vaccCentres.get(x).getVaccCentreId().equals(items[0]) && vaccCentres.get(vaccCentreNumber-1).vaccCentreId.equals(items[0]) )
                        System.out.println (items[j]);
            }
        }
    }


}