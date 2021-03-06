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
        //remélem jól értelmeztem a feladatot, 2 féle képpen oldottam meg (korábbi commit)

        int listaMerete = bejegyzesLista.size();

        for (int i = 0; i < 20; i++){
            int index = (int) (Math.random() * listaMerete);
            for (int j = 0; j < listaMerete; j++){
                bejegyzesLista.get(index).like();
            }
        }

        //2. e,

        System.out.print("A 2. bejegyzés módosítása erre: ");
        String modositas = sc.next();
        bejegyzesLista.get(1).setTartalom(modositas);
        sc.close();


        //2. f,

        for (Bejegyzes b: bejegyzesLista
             ) {
            System.out.println("\n");
            System.out.println(b.toString());
        }

        //3. a,

        int maxLike = bejegyzesLista.get(0).getLikeok();
        for (int i = 1; i < listaMerete; i++){
            if (bejegyzesLista.get(i).getLikeok() > maxLike) {
                maxLike = bejegyzesLista.get(i).getLikeok();
            }
        }

        System.out.println("\n\nA legnépszerűbb bejegyzés lájkjainak száma: " + maxLike);

        //3. b,

        boolean tobbLikeMint35 = false;

        for (int i = 0; i < listaMerete; i++){
            if (bejegyzesLista.get(i).getLikeok() > 35){
                tobbLikeMint35 = true;
                break;
            }
        }

        if (tobbLikeMint35){
            System.out.println("Van olyan bejegyzés ami 35-nél több lájkot kapott.");
        }
        else{
            System.out.println("Nincs olyan bejegyzés ami 35-nél több lájkot kapott.");
        }

        //3. c,

        int darabKevesebbMint15 = 0;

        for (int i = 0; i < listaMerete; i++){
            if (bejegyzesLista.get(i).getLikeok() < 15){
                darabKevesebbMint15 ++;
            }
        }

        System.out.println(darabKevesebbMint15 + " olyan bejegyzés van ami 15-nél kevesebb lájkot kapott.");

        //3. d,


    }
}
