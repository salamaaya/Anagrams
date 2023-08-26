//Aya Salama
//I pledge my honor that I have abided by the Stevens Honor System.

import java.io.*;
import java.util.*;

public class Anagrams {
    final Integer[] primes =
            {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                    31, 37, 41, 43, 47, 53, 59, 61, 67,
                    71, 73, 79, 83, 89, 97, 101};
    Map<Character,Integer> letterTable;
    Map<Long,ArrayList<String>> anagramTable;

    /**
     * builds the hash table letterTable
     */
    public void buildLetterTable() {
        letterTable = new HashMap<>();
        int i = 0;
        for(char letter = 'a'; letter <= 'z'; letter++){
            letterTable.put(letter, primes[i]);
            i++;
        }
    }

    /**
     * constructor
     * calls buildLetterTable()
     */
    public Anagrams() {
        buildLetterTable();
        anagramTable = new HashMap<Long,ArrayList<String>>();
    }

    /**
     * adds s to the hash table anagramTable
     * @param s
     */
    public void addWord(String s) {
        long hash = myHashCode(s);
        if(anagramTable.get(hash) != null)
            anagramTable.get(hash).add(s.toLowerCase());
        else {
            ArrayList<String> anagram = new ArrayList<>();
            anagram.add(s.toLowerCase());
            anagramTable.put(hash, anagram);
        }
    }

    /**
     * computes a string's hash code using the fundamental theorem of arithmetic
     * @param s
     * @return s's hash code
     */
    public long myHashCode(String s) {
        if(s == null)
            throw new IllegalArgumentException();
        long hashCode = 1;
        for(int i = 0; i < s.length(); i++)
            hashCode *= letterTable.get(s.toLowerCase().charAt(i));
        return hashCode;
    }

    public void processFile(String s) throws IOException {
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        while ((strLine = br.readLine()) != null)   {
            this.addWord(strLine);
        }
        br.close();
    }

    /**
     *
     * @return a list of the entries in the anagramTable that have the
     * largest number of anagrams
     */
    public ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
        ArrayList<Map.Entry<Long,ArrayList<String>>> listOfMax = new ArrayList<>();
        int max = 0;
        for(Map.Entry<Long, ArrayList<String>> findMax: anagramTable.entrySet()){
            if(findMax.getValue().size() > max)
                max = findMax.getValue().size();
        }
        for(Map.Entry<Long, ArrayList<String>> findMax: anagramTable.entrySet()){
            if(findMax.getValue().size() == max)
                listOfMax.add(findMax);
        }
        return listOfMax;
    }

    public static void main(String[] args) {
        Anagrams a = new Anagrams();

        final long startTime = System.nanoTime();
        try {
            a.processFile("words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double) estimatedTime/1000000000);
        System.out.println("Time: "+ seconds);
        System.out.println("List of max anagrams: "+ maxEntries);
    }
}
