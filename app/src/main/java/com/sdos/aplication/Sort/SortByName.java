package com.sdos.aplication.Sort;

import com.sdos.aplication.Model.DataClient;

import java.util.Comparator;

public class SortByName implements Comparator<DataClient> {

    @Override
    public int compare(DataClient dataClient, DataClient t1) {
        return dataClient.getName().compareTo(t1.getName());
    }
}
