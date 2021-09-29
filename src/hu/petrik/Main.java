package hu.petrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //2. a,

        List<Bejegyzes> bejegyzesLista = new ArrayList<>();
	    Bejegyzes b1 = new Bejegyzes("Én", "XDDDDD");
	    Bejegyzes b2 = new Bejegyzes("Te", "NEM!");
	    bejegyzesLista.add(b1);
	    bejegyzesLista.add(b2);

        //2. b,

        Scanner sc = new Scanner(System.in);
        System.out.print("Adjon meg egy darabszámot: ");
        int darab = sc.nextInt();
        for (int i = 0; i < darab; i++){
            System.out.print("Adja meg a nevét: ");
            String nev = sc.next();
            System.out.print("Tartalom: ");
            String tartalom = sc.next();
            bejegyzesLista.add(new Bejegyzes(nev, tartalom));
        }
        sc.close();
    }
}
