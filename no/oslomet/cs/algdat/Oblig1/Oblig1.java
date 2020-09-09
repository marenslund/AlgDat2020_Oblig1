package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////
////// Maren Spongsveen Lund, s344057, s344057@oslomet.no /////////////////

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Oblig1 {

    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    // Det blir gjort flest ombyttinger naar tabellen blir sortert synkende
    // Det blir gjort faerrest ombyttinger naar tabellen blir sortert stigende
    // Gjennomsnittet blir n(n-1)/4 ombyttinger
    // Metoden maks() er daarligere enn de vi har sett på tidligere fordi de
    // Gjoer ingen ombyttinger, altsaa de endres ikke, dermed gjoer de også faerre operasjoner

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
        if (a.length == 0) {
            return 0;
        }

        int values = a.length;

        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    values--;
                    break;
                }
            }
        }
        return values;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int left = 0;
        int right = a.length - 1;
        int counter = 0;
        while (left < right) {
            while (a[left] % 2 != 0) {
                left++;
                counter++;
                if(left==a.length-1) {
                    counter++;
                    break;
                }
            }
            while (a[right] % 2 == 0 && left < right) {
                right--;
            }
            if (left < right)
                switchPlace(a, left, right);
        }
        quickSort(a,0,counter-1);
        quickSort(a,counter,a.length-1);
    }

    private static int parter0(int[] a, int left, int right, int pivot) {
        while (true)
        {
            while (left <= right && a[left] < pivot) { left++; }
            while (left <= right && a[right] >= pivot) { right--; }

            if (left < right) {
                switchPlace(a,left++,right--);
            }
            else {
                return left;
            }
        }
    }
    private static int sParter0(int[] a, int left, int right, int index) {
        switchPlace(a, index, right);
        int pos = parter0(a, left, right - 1, a[right]);
        switchPlace(a, pos, right);
        return pos;
    }
    private static void quickSort(int[] a, int begin, int end) {
        if (begin >= end) { return; }
        int i = sParter0(a, begin, end, (begin + end)/2);
        quickSort(a, begin, i - 1);
        quickSort(a, i + 1, end);
    }

    private static void switchPlace(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        char[] b = Arrays.copyOf(a, a.length);

        if(a.length > 1) {
            a[0] = b[a.length-1];
            System.arraycopy(b, 0, a, 1, a.length - 1);
        }
    }
/*
    //_____________________________________________________________________________________________
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }*/

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        String[] sArray = s.split("");
        String[] tArray = t.split("");
        int k = 0;
        int limit = Math.min(sArray.length, tArray.length);

        String[] newArray = new String[sArray.length + tArray.length];

        for (int i = 0; i < limit; i++) {
            newArray[k++] = sArray[i];
            newArray[k++] = tArray[i];
        }

        if (limit == sArray.length) {
            for (int i = limit; i < tArray.length; i++) {
                newArray[k++] = tArray[i];
            }
        } else {
            for (int i = limit; i < sArray.length; i++) {
                newArray[k++] = sArray[i];
            }
        }

        return String.join("", newArray);
    }

    /// 7b)
    public static String flett(String... s) {
        int charCounter = 0;
        for (String value : s) {
            charCounter += value.length();
        }

        String[] newArray = new String[charCounter];

        int j = 0;
        int k = 0;

        for (int i = 0; i < s.length; i++) {
            if (j < s[i].length()) {
                newArray[k++] = String.valueOf(s[i].charAt(j));
            }
            if (j == newArray.length + 1) {
                break;
            }
            if (i == s.length - 1) {
                i = -1;
                j++;
            }
        }
        return String.join("", newArray);
    }

    /*///// Oppgave 8 //////////////////////////////////////
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
    }*/

}  // Oblig1
