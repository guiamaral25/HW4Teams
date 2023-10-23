/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hw4teams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author guiam
 */
public class HW4Teams {

    private static final String[] ADJECTIVES = {"Canada", "Brazil", "Japan", "Australia", "Italy", "India", "Mexico", "Russia", "Sweden", "Ireland", "Argentina", "China", "France", "Germany", "Egypt", "Peru", "Thailand", "Turkey", "United States", "South Africa"};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            List<Person> people = readDataFromFile("MOCK_DATA.csv");
            Collections.shuffle(people);

            List<String> availableAdjectives = new ArrayList<>(Arrays.asList(ADJECTIVES));
            List<Team> teams = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                List<Person> teamMembers = people.subList(i * 5, (i + 1) * 5);
                String teamName = teamName(availableAdjectives);
                Team team = new Team(teamName, teamMembers);
                teams.add(team);
            }

            // Print each team to the console
            for (Team team : teams) {
                System.out.println(team);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    private static List<Person> readDataFromFile(String filePath) throws IOException {
        List<Person> people = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                String firstName = fields[1].trim();
                String lastName = fields[2].trim();
                people.add(new Person(id, firstName, lastName));
            }
        }
        return people;
    }

 private static String teamName(List<String> availableAdjectives) {
        Random r = new Random();
        int index = r.nextInt(availableAdjectives.size());
        String adjective = availableAdjectives.remove(index);
        return adjective;
    }
}
    
    

