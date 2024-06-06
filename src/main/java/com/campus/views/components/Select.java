package com.campus.views.components;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import com.campus.controllers.Data;
import com.campus.models.Team;
import com.campus.views.Dialogs;
import com.campus.models.Person;
import com.campus.models.Person.Player;

public class Select {
    
    public static JComboBox<String> newSelect(String type, String category) {
        JComboBox<String> select = new JComboBox<>();
        ArrayList<String> options = new ArrayList<>();

        switch (type) {
            case "teams":
                for (Team team : Data.teams) {
                    options.add(team.getName());
                }
                select.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            if(category == "localTeam"){
                                Dialogs.localTeam = Data.findTeamByName(e.getItem().toString());
                            }else{
                                Dialogs.visitTeam = Data.findTeamByName(e.getItem().toString());
                            }
                          
                        }
                    }
                });
                break;
            // Agrega más casos según sea necesario para otros tipos
            case "players":
                for (Person player : Data.players) {
                    options.add(player.getName());
                }
                select.addItemListener(null);
                ;
                break;
            // Agrega más casos según sea necesario para otros tipos
            default:
                break;
        }
        
        for (String option : options) {
            select.addItem(option);
        }

        return select;
    }



}
