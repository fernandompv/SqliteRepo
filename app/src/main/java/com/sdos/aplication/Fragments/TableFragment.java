package com.sdos.aplication.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sdos.aplication.Model.DataClient;
import com.sdos.aplication.Model.ModeloBD;
import com.sdos.aplication.R;
import com.sdos.aplication.Sort.SortByCode;
import com.sdos.aplication.Sort.SortByName;
import com.sdos.aplication.Sort.SortByVisit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableFragment extends Fragment {

    private TableLayout mTable;
    private Button mBtFilterCode;
    private Button mBtFilterName;
    private Button mBtFilterVisit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_table,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeComponent();
        initializeListenersButtons();
        fillRows(false,"");
    }



    private void initializeComponent(){
        mTable = getActivity().findViewById(R.id.table_layout);
        mBtFilterCode = getActivity().findViewById(R.id.bt_filter_code);
        mBtFilterName = getActivity().findViewById(R.id.bt_filter_name);
        mBtFilterVisit = getActivity().findViewById(R.id.bt_filter_visit);
    }

    private void initializeListenersButtons(){
        mBtFilterCode.setOnClickListener(view -> {
            mTable.removeAllViews();
            fillRows(true,"C");
        });

        mBtFilterName.setOnClickListener(view -> {
            mTable.removeAllViews();
            fillRows(true,"N");
        });

        mBtFilterVisit.setOnClickListener(view -> {
            mTable.removeAllViews();
            fillRows(true,"V");
        });
    }

    private void fillRows(boolean inOrder,String tag){
        TableRow.LayoutParams lp = new TableRow.LayoutParams();
        lp.setMargins(10, 10, 10, 10);
        if(inOrder){
            //identificamos que venimos de uno de los botones que ordenan la lista
            List<DataClient> clientList = new ArrayList<>();
            for (int i = 1; i < ModeloBD.listaNombre().length; i++) {
                //ordenar la lista según el tag
                DataClient data = new DataClient(ModeloBD.listaCodigo()[i-1],ModeloBD.listaNombre()[i-1]
                        ,ModeloBD.listaTelefono()[i-1],ModeloBD.listaEmail()[0],ModeloBD.listaVisitado()[i-1]);
                clientList.add(data);
            }

            switch (tag){
                case "C":
                    orderByCode(clientList);
                    break;
                case "N":
                    //orderByName(clientList);
                    break;
                case "V":
                    orderByVisit(clientList);
                    break;
            }

            //En este punto la lista ya deberia venir ordenada y por tanto podemos rellena la tabla de nuevo
            fillListWithOrder(lp,clientList);

        }else {
            //no nos importa el orden
            for (int i = 1; i < ModeloBD.listaNombre().length; i++) {
                TableRow row = new TableRow(getActivity());
                row.setLayoutParams(lp);
                fillCode(ModeloBD.listaCodigo()[i-1],row, lp);
                fillName(ModeloBD.listaNombre()[i-1],row, lp);
                fillPhone(ModeloBD.listaTelefono()[i-1],row, lp);
                fillEmail(ModeloBD.listaEmail()[0],row, lp);
                fillVisit(ModeloBD.listaVisitado()[i-1],row, lp);
                mTable.addView(row);
            }
        }
    }

    private void fillListWithOrder(TableRow.LayoutParams lp,List<DataClient> clientList){
        //rellenamos la tabla ya ordenada desde la lista de objetos
        TableRow row = new TableRow(getActivity());
        row.setLayoutParams(lp);
        for(DataClient data : clientList){
            fillCode(data.getCode(),row, lp);
            fillName(data.getName(),row, lp);
            fillPhone(data.getPhone(),row, lp);
            fillEmail(data.getEmail(),row, lp);
            fillVisit(data.getVisit(),row, lp);
            mTable.addView(row);
        }
    }

    private void fillCode(String text,TableRow row, TableRow.LayoutParams lp){
        //rellenamos la columna correspondiente al codigo
        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(lp);
        tv.setText(text);
        row.addView(tv);
    }
    private void fillName(String text,TableRow row, TableRow.LayoutParams lp){
        //rellenamos la columna correspondiente al nombre
        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(lp);
        tv.setText(text);
        row.addView(tv);
    }
    private void fillPhone(String text,TableRow row, TableRow.LayoutParams lp){
        //rellenamos la columna correspondiente al telefono
        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(lp);
        tv.setText(text);
        if(!text.equals("TELEFONO"))
            tv.setTextColor(getActivity().getColor(R.color.blue));
        tv.setOnClickListener(view -> {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+tv.getText().toString()));
            startActivity(callIntent);
        });
        row.addView(tv);
    }
    private void fillEmail(String text,TableRow row,TableRow.LayoutParams lp){
        //rellenamos la columna correspondiente al email
        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(lp);
        tv.setText(text);
        row.addView(tv);
    }
    private void fillVisit(String text,TableRow row, TableRow.LayoutParams lp){
        //rellenamos la columna correspondiente al visitado
        TextView tv = new TextView(getActivity());
        tv.setLayoutParams(lp);
        tv.setText(text);
        row.addView(tv);
    }

    private void orderByCode(List<DataClient> clientList){
        //Ordenamos por codigo los valores de la lista pasada por parametros
        Collections.sort(clientList,new SortByCode());
    }

    private void orderByName(List<DataClient> clientList){
        Collections.sort(clientList, new SortByName());
    }
    private void orderByVisit(List<DataClient> clientList){
        //Ordenamos por visitado los valores de la lista pasada por parametros
        Collections.sort(clientList,new SortByVisit());
    }

}
