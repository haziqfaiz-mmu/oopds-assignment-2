package com.haziqfaiz.oopdsassignment2;


import java.util.ArrayList;
import java.util.Date;
import java.io.IOException;

/**
 * Recipient representing a user who will undergo vaccination.
 */
public class Recipient extends User {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String status;
    private String vcId;
    private String appointmentDate;
    private String FirstDoseDone;
    private String SecondDoseDone;
    private String age;
    private String batchNumber;


    /**
     * Constructs new recipient data with null values.
     */
    public Recipient() {}

    /**
     * Constructs new recipient data with specified details.
     *
     * @param id
     * @param password
     * @param name
     * @param phone
     * @param vcId
     * @param appointmentDate
     */
    public Recipient (String id, String password, String name, String phone, String status, String vcId, String appointmentDate,
                      String FirstDoseDone, String SecondDoseDone,String age, String batchNumber) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.status = status;
        this.vcId = vcId;
        this.appointmentDate = appointmentDate;
        this.FirstDoseDone = FirstDoseDone;
        this.SecondDoseDone = SecondDoseDone;
        this.age = age;
        this.batchNumber = batchNumber;
    }

    Recipient (String id, String password, String name, String phone, String age){
        this.id = id;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.status = "PENDING";
        this.vcId = "NULL";
        this.appointmentDate = "NULL";
        this.FirstDoseDone = "NULL";
        this.SecondDoseDone = "NULL";
        this.batchNumber = "NULL";
    }

    /**
     * Returns current recipient's ID.
     * @return recipient's ID.
     */
    public String getID() {
        return id;
    }

    /**
     * Returns current recipient's password.
     * @return recipient's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns current recipient's name.
     * @return recipient's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns current recipient's phone.
     * @return recipient's phone.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Returns current recipient's vaccination status.
     * @return recipient's vaccination status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Returns current recipient's vaccination centre ID.
     * @return recipient's vaccination centre ID.
     */
    public String getVaccCentrePlacement() {
        return vcId;
    }

    /**
     * Returns current recipient's appointment date.
     * @return recipient's appointment date.
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getFirstDoseDone() {
        return FirstDoseDone;
    }

    public String getSecondDoseDone() {
        return SecondDoseDone;
    }

    public String getAge(){return age;}

    public String getBatchNumber(){return batchNumber;}

    /**
     * Returns current recipient's details in table format (for menu output).
     * @return id, password, name, phone, and status; in table format.
     */
    public String toString() {
        return String.format("%s %-11s", " | ID = ", id)         + String.format("%s %-11s", " | PASSWORD = ", password) +
                String.format("%s %-16s", " | NAME = ", name)     + String.format("%s %-11s", " | PHONE = ", phone) +
                String.format("%s %-13s", " | STATUS = ", status) + String.format("%s %-6s" , " | VC_ID = ", vcId) +
                String.format("%s %-16s", " | VACCINE DATE = ", appointmentDate);
    }

    /**
     * Returns current recipient's data fields (for saving into RecipientData.csv), separated by commas.
     * @return ID, password, name, phone, status, and VC ID; separated by commas.
     */
    public String toCSVString() {
        return id + "," + password + "," + name + "," + phone + "," +  status + "," + vcId + "," +
                appointmentDate + "," + FirstDoseDone + "," + SecondDoseDone+ "," + age+ "," + batchNumber;
    }

    /**
     * Assign current recipient to a vaccination centre.
     *
     * @param vcId specifies which vacc. centre to assign recipient to.
     */
    public void setVaccCentrePlacement(String vcId) {
        this.vcId = vcId;
    }

    /**
     * Set current recipient's appointment date (as String).
     *
     * @param appointment
     */
    public void setAppointment (String appointment) {
        appointmentDate = appointment;
    }

    public void recordFirstDoseDate (String record){
        FirstDoseDone = record;
    }

    public void recordSecondDoseDate (String record){
        SecondDoseDone = record;
    }

    /**
     * Set current recipient's vaccination status.
     *
     * @param status
     */
    public void setStatus (String status) {
        this.status = status;
    }

    /**
     * Login verification:
     *      Checks for match in ID & password.
     *
     * @param id
     * @param password
     * @return true if matching id & password found;
     *         false otherwise.
     */
    protected static Recipient login (String id, String password) throws IOException {
        ArrayList<Recipient> recipients = DataLoader(); // Load data from RecipientData.csv

        for (int i = 0; i < recipients.size(); i++)
            if (recipients.get(i).id.equals(id) && recipients.get(i).password.equals(password))
                return recipients.get(i);
        return null;
    }

    /**
     * Register process:
     *      Save user-specified ID, password, name, & phone infos into RecipientData.csv.
     *
     * @param id
     * @param password
     * @param name
     * @param phone
     */
    protected static void register (String id, String password, String name, String phone, String age) throws IOException {
        ArrayList<Recipient> recipients = DataLoader(); // Load data from RecipientData.csv

        recipients.add(new Recipient (id, password, name.toUpperCase(), phone.replaceAll("\\D", ""), "PENDING", "NULL", "NULL", "NULL",
                "NULL",age,"NULL"));

        saveRecipientToCSV(recipients);
    }
}
