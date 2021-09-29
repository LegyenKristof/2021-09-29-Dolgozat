package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
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

        //2. c,

        try{
            FileReader fr = new FileReader("bejegyzesek.txt");
            BufferedReader bf = new BufferedReader(fr);

            String sor = bf.readLine();
            while (sor != null){
                String[] adatok = sor.split(";");
                bejegyzesLista.add(new Bejegyzes(adatok[0], adatok[1]));
                sor = bf.readLine();
            }

            fr.close();
            bf.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        //2. d,

        int listaMerete = bejegyzesLista.size();
        int hanyszor = 20 * listaMerete;

        for (int i = 0; i < hanyszor; i++){
            int index = (int) (Math.random() * listaMerete);
            bejegyzesLista.get(index).like();
        }

        //2. e,

        System.out.print("A 2. bejegyzés módosítása erre: ");
        String modositas = sc.next();
        bejegyzesLista.get(1).setTartalom(modositas);
        sc.close();




        for (Bejegyzes b: bejegyzesLista
             ) {
            System.out.println("\n");
            System.out.println(b.toString());
        }
    }
}
