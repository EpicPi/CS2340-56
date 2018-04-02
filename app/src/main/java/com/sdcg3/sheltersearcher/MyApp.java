package com.sdcg3.sheltersearcher;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.sdcg3.sheltersearcher.model.Shelter;
import com.sdcg3.sheltersearcher.model.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pi on 3/4/18.
 * MyApp
 */

public class MyApp extends Application {
    private final List<User> users = new ArrayList<>();
    private final List<Shelter> shelters = new ArrayList<>();
    private User current = null;
    private List<Shelter> filtered;
    private Shelter selected;

    public User getCurrent() {
        return current;
    }

    /**
     * reads ppl from csv
     */
    public void readPpl() {
        Context c = getBaseContext();
        try (
                Reader reader = Files.newBufferedReader(
                        Paths.get(c.getFilesDir() + "/ppl.csv"));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()
        ) {
            List<String[]> records = csvReader.readAll();
            for (String[] record : records) {
                users.add(new User(record[0], record[1], record[2], record[3]));
            }
        } catch (Exception e) {
            Log.e("hi ppl", e.toString());
            writePpl();
        }
    }

    /**
     * writes ppl to csv file
     */
    public void writePpl() {
        Context c = getBaseContext();
        try (
                Writer writer = Files.newBufferedWriter(
                        Paths.get(c.getFilesDir() + "/ppl.csv"));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)
        ) {
            String[] headerRecord = {"Name", "password", "shelter", "number"};
            csvWriter.writeNext(headerRecord);
            for (User usr : users) {
                csvWriter.writeNext(usr.getWritable());
            }
        } catch (Exception e) {
            Log.e("bye ppl", e.toString());
        }
    }

    /**
     * writes shelters to csv
     */
    public void writeShelters() {
        Context c = getBaseContext();
        try (
                Writer writer = Files.newBufferedWriter(
                        Paths.get(c.getFilesDir() + "/shelter.csv"));

                CSVWriter csvWriter = new CSVWriter(writer,
                        CSVWriter.DEFAULT_SEPARATOR,
                        CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                        CSVWriter.DEFAULT_LINE_END)
        ) {
            String[] headerRecord = {"id", "name", "capacity", "restrictions",
                    "longitude", "latitude", "address", "notes", "phone", "claimed"};
            csvWriter.writeNext(headerRecord);
            for (Shelter shelter : shelters) {

                csvWriter.writeNext(shelter.getWritable());
            }
        } catch (Exception e) {
            Log.e("bye shelters", e.toString());
        }
    }

    /**
     * reads shelters from csv file
     */
    public void readShelters() {
        Context c = getBaseContext();
        try (
                Reader reader = Files.newBufferedReader(
                        Paths.get(c.getFilesDir() + "/shelter.csv"));
                CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()
        ) {
            List<String[]> records = csvReader.readAll();
            for (String[] arr : records) {
                shelters.add(new Shelter(arr[0], arr[1], arr[2], arr[3], arr[4],
                        arr[5], arr[6], arr[7], arr[8], arr[9]));
            }
        } catch (Exception e) {
            Log.e("hi shelters", e.toString());
            readCSV();
            writeShelters();
        }
    }

    /**
     * reads shelter from original csv file
     */
    private void readCSV() {
        shelters.clear();
        Resources r = getResources();
        InputStream is = r.openRawResource(R.raw.csvfile);
        try {
            CSVReader reader = new CSVReaderBuilder(new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))).withSkipLines(1).build();
            List<String[]> myEntries = reader.readAll();
            for (String[] arr : myEntries) {
                shelters.add(new Shelter(arr[0], arr[1], arr[2], arr[3], arr[4],
                        arr[5], arr[6], arr[7], arr[8], "0"));
            }
        } catch (Exception e) {
            Log.e("read csv", e.toString());
        }

    }

    /**
     * adds user
     * @param user user to be added
     * @param pass pass of user
     */
    public void addUser(String user, String pass) {
        current = new User(user, pass);
        users.add(current);

        writePpl();
    }

    /**
     * claims spots at a shelter
     * @param amount amount to be claimed
     * @param shelter shelter
     */
    public void claim(int amount, Shelter shelter) {
        current.setShelter(shelter.getName());
        current.setNumber(amount);
        shelter.setCapacity(shelter.getCapacity() - amount);
        shelter.setClaimed(shelter.getClaimed() + amount);
    }

    /**
     * checks if user matches pass
     * @param user user to be checked
     * @param pass pass to be checed
     * @return true if match, false otherwise
     */
    public boolean isCorrect(String user, String pass) {
        if ((user == null) || (pass == null)) {
            return false;
        }
        List<User> curr = users.stream().filter((e) -> e.getName().equals(user))
                .collect(Collectors.toList());
        User u = curr.get(0);
        if (!curr.isEmpty() && u.checkPass(pass)) {
            current = curr.get(0);
            return true;
        }
        return false;
    }

    /**
     * returns list of shelters
     * @return shelters
     */
    public List<Shelter> getFiltered() {
        if (filtered != null) {
            return filtered;
        }
        return shelters;
    }

    /**
     * finds shelter
     * @param s shelter to be found
     * @return shelter object
     */
    public Shelter findByName(String s) {
        for (Shelter shelter :
                shelters) {
            if (shelter.getName().equals(s)) {
                return shelter;
            }
        }
        return null;
    }

    /**
     * resets filtered
     */
    public void resetFiltered() {
        filtered = null;
    }

    /**
     * returns selected
     * @return Shelter
     */
    public Shelter getSelected() {
        return selected;
    }

    /**
     * set selected
     * @param selected Shelter
     */
    public void setSelected(Shelter selected) {
        this.selected = selected;
    }

    /**
     * filters by gender, age, and name
     * @param gender male or female
     * @param age age
     * @param name name
     */
    public void filter(String gender, String age, String name) {
        //capital letters don't exist cause we .toLowerCase everything
        final String other = "men".equals(gender) ? "women" : "LOLOLOLOL";

        filtered = shelters.stream().filter((el) -> {
            String restrictions = el.restrictions.toLowerCase();

            return restrictions.contains(gender) && !restrictions.contains(other)
                    && restrictions.contains(age) && el.getName().toLowerCase().contains(name);
        }).collect(Collectors.toList());
    }
}