/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hw4teams;

import java.util.List;

/**
 *
 * @author guiam
 */
public class Team {
 
    private String name;
    private List<Person> members;

    public Team(String name, List<Person> members) {
        this.name = name;
        this.members = members;
    }

    @Override
    public String toString() {
        StringBuilder teamInfo = new StringBuilder(name + ": ");
        for (Person person : members) {
            teamInfo.append(person.getFirstName()).append(" ").append(person.getLastName()).append(", ");
        }
        // Remove the trailing comma and space
        teamInfo.setLength(teamInfo.length() - 2);
        return teamInfo.toString();
    }
}

    

