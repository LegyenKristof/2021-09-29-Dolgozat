package hu.petrik;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //2. a,

        List<Bejegyzes> bejegyzesLista = new ArrayList<>();
	    Bejegyzes b1 = new Bejegyzes("Én", "XDDDDD");
	    Bejegyzes b2 = new Bejegyzes("Te", "NEM!");
	    bejegyzesLista.add(b1);
	    bejegyzesLista.add(b2);
        System.out.println(bejegyzesLista.get(0).toString());
        System.out.println(bejegyzesLista.get(1).toString());
    }
}
