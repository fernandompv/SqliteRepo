package com.sdos.aplication.Model;

import java.util.ArrayList;
import java.util.List;

public class ModeloBD {


    public static String[] listaCodigo(){
        return new String[] {
                "CODIGO","10","12","13","14","15","16","17","18",
        };
    }

    public static String[] listaNombre(){
        return new String[] {
               "NOMBRE","Laura","Fernando","Pablo","Poseidon","Irina","Helena","Atenea","Artemisa"
        };
    }

    public static String[] listaTelefono(){
        return new String[] {
                "TELEFONO","652525252","659848785","689456320","653589574","659874123","658784521","652541236","689847411"
        };
    }

    public static String[] listaEmail(){
        return new String[] {
                "EMAIL","example@gmail.com"
        };
    }

    public static String[] listaVisitado(){
        return new String[] {
                "VISITADO","1","1","1","0","1","0","0","0"
        };
    }

}
