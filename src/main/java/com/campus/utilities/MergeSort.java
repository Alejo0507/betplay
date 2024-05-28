package com.campus.utilities;

import java.util.ArrayList;
import java.util.List;


import com.campus.models.Team;

public class MergeSort {

    public static List<Team> mergeSort(ArrayList<Team> lista, String key) {
        if (lista.size() < 2)
            return lista;

        int medio = lista.size() / 2;
        ArrayList<Team> izquierda = new ArrayList<>(lista.subList(0, medio));
        ArrayList<Team> derecha = new ArrayList<>(lista.subList(medio, lista.size()));

        mergeSort(izquierda, key);
        mergeSort(derecha, key);

        return merge(lista, izquierda, derecha, key);
    }


    public static List<Team> merge(List<Team> lista, List<Team> izquierda, List<Team> derecha, String key) {
        int izqIndex = 0;
        int derIndex = 0;
        int index = 0;

        while (izqIndex < izquierda.size() && derIndex < derecha.size()) {
            if (izquierda.get(izqIndex).getKeyValue(key) <= derecha.get(derIndex).getKeyValue(key)) {
                lista.set(index++, izquierda.get(izqIndex++));
            } else {
                lista.set(index++, derecha.get(derIndex++));
            }
        }

        while (izqIndex < izquierda.size()) {
            lista.set(index++, izquierda.get(izqIndex++));
        }

        while (derIndex < derecha.size()) {
            lista.set(index++, derecha.get(derIndex++));
        }

        return lista;
    }
}
