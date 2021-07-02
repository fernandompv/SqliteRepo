package com.sdos.aplication.Sort;

import com.sdos.aplication.Model.DataClient;

import java.util.Comparator;

public class SortByCode implements Comparator<DataClient> {

    @Override
    public int compare(DataClient dataClient, DataClient t1) {
        if(!t1.getCode().equals("CODIGO") && dataClient.getVisit().equals("0"))
            return 0;
        else
            return 1;
    }
}
