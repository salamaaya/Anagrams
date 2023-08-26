//Aya Salama
//I pledge my honor that I have abided by the Stevens Honor System.

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnagramsTest {

    @Test
    void testBuildLetterTable(){
        Anagrams test = new Anagrams();
        Map<Character, Integer> values = new HashMap<>();
        values.put('a',2);
        values.put('b',3);
        values.put('c',5);
        values.put('d',7);
        values.put('e',11);
        values.put('f',13);
        values.put('g',17);
        values.put('h',19);
        values.put('i',23);
        values.put('j',29);
        values.put('k',31);
        values.put('l',37);
        values.put('m',41);
        values.put('n',43);
        values.put('o',47);
        values.put('p',53);
        values.put('q',59);
        values.put('r',61);
        values.put('s',67);
        values.put('t',71);
        values.put('u',73);
        values.put('v',79);
        values.put('w',83);
        values.put('x',89);
        values.put('y',97);
        values.put('z',101);
        test.buildLetterTable();
        assertEquals(values, test.letterTable);
    }

    @Test
    void addWord(){
        Anagrams test = new Anagrams();
        test.addWord("alerts");
        test.addWord("alters");
        test.addWord("artels");
        test.addWord("estral");
        test.addWord("laster");
        test.addWord("lastre");
        test.addWord("rastle");
        ArrayList<String> alertAnagram = new ArrayList<>();
        alertAnagram.add("alerts");
        alertAnagram.add("alters");
        alertAnagram.add("artels");
        alertAnagram.add("estral");
        alertAnagram.add("laster");
        alertAnagram.add("lastre");
        alertAnagram.add("rastle");
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("alerts")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("alters")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("artels")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("estral")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("laster")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("lastre")));
        assertEquals(alertAnagram, test.anagramTable.get(test.myHashCode("rastle")));
    }

    @Test
    void myHashCode() {
        Anagrams test = new Anagrams();
        assertEquals(236204078, test.myHashCode("alerts"));
        assertEquals(236204078, test.myHashCode("alters"));
        assertEquals(236204078, test.myHashCode("artels"));
        assertEquals(236204078, test.myHashCode("estral"));
        assertEquals(236204078, test.myHashCode("laster"));
        assertEquals(236204078, test.myHashCode("lastre"));
        assertEquals(236204078, test.myHashCode("rastle"));
        assertEquals(236204078, test.myHashCode("ratels"));
        assertEquals(236204078, test.myHashCode("relast"));
        assertEquals(602, test.myHashCode("and"));
        assertEquals(602, test.myHashCode("dan"));
        assertEquals(602, test.myHashCode("nad"));
        assertEquals(602, test.myHashCode("adn"));
    }

    @Test
    void getMaxEntries() throws IOException {
        Anagrams test = new Anagrams();
        test.processFile("words_alpha.txt");
        ArrayList<String> alertAnagram = new ArrayList<>();
        alertAnagram.add("alerts");
        alertAnagram.add("alters");
        alertAnagram.add("artels");
        alertAnagram.add("estral");
        alertAnagram.add("laster");
        alertAnagram.add("lastre");
        alertAnagram.add("rastle");
        alertAnagram.add("ratels");
        alertAnagram.add("relast");
        alertAnagram.add("resalt");
        alertAnagram.add("salter");
        alertAnagram.add("slater");
        alertAnagram.add("staler");
        alertAnagram.add("stelar");
        alertAnagram.add("talers");
        assertEquals(alertAnagram, test.getMaxEntries().get(0).getValue());
        assertEquals(236204078, test.getMaxEntries().get(0).getKey());
    }
}