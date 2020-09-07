package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////
////// Maren Spongsveen Lund, s344057, s344057@oslomet.no /////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {

    public static void main(String[] args){
        int[] testArray = {2, 5, 3, 8, 5, 9, 3, 11, 1};
        System.out.println(maks(testArray));
        System.out.println(ombyttinger(testArray));
    }

    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    // Det blir gjort flest ombyttinger naar tabellen blir sortert synkende
    // Det blir gjort faerrest ombyttinger naar tabellen blir sortert stigende
    // Gjennomsnittet blir n(n-1)/4 ombyttinger
    // Husk å svare på denne senere!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    public static int maks(int[] a) {
        if(a.length == 0) {
            throw new NoSuchElementException("Error: Tabellen kan ikke være tom!");
        }

        for (int i = 1; i < a.length; i++){
            if (a[i-1] > a[i]){
                int greaterValue = a[i-1];
                 a[i-1] = a[i];
                 a[i] = greaterValue;
            }
        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int changes = 0;
        for (int i = 1; i < a.length; i++){
            if (a[i-1] > a[i]){
                int greaterValue = a[i-1];
                a[i-1] = a[i];
                a[i] = greaterValue;
                changes++;
            }
        }

        return changes;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int compareable = a[0];
        int values = 1;

        for (int i = 1; i < a.length; i++){
            if (compareable != a[i]) {
                values++;
            }
            if (a[i] < compareable) {
                throw new IllegalStateException("Error: Tabellen må være sortert stigende!");
            }
            else {
                compareable = a[i];
            }
        }

        return values;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();
    }

    //_____________________________________________________________________________________________
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
