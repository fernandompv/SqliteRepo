package com.sdos.aplication.SortList;

import com.sdos.aplication.Model.DataClient;

import java.util.Comparator;

public class SortByName implements Comparator<DataClient> {

    @Override
    public int compare(DataClient dataClient, DataClient t1) {
        //Clase que se encarga de ordenar las listas por el nombre
        if(t1.getName().equals("NOMBRE"))
            return 0;
        else
            return dataClient.getName().compareTo(t1.getName());
    }
}
