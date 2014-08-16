package com.waszczyk.mapa;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
 
/**
 * Mapa przyjmuj�ca 2 typy generyczne. K okre�la typ klucza,
 * natomiast V okre�la typ warto�ci przyjmowanej.
 * Przyk�adem mo�e by� MyMap<String, Integer> oceny.
 *
 * Dwie listy przechowuj�ce klucze oraz warto�ci b�dziemy
 * traktowa� jak� ca�� map�.
 */
public class MyMap<K, V> implements Map<K, V> {
 
    //Klucze mapy powi�zane z warto�ciami
    private ArrayList<K> keys;
     
    //Warto�ci mapy powi�zane z kluczami
    private ArrayList<V> values;
     
    //Czy�� map�
    public void clear() {
        keys.clear();
        values.clear();
    }
 
    //Sprawd�, czy klucz 'key' istnieje w mapie
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }
 
    //Sprawd�, czy warto�� 'value" istnieje w mapie
    public boolean containsValue(Object value) {
        return values.contains(values);
    }
 
    /**
     * Troch� ci�szej magii
     *
     * Przer�b map� na 'Set' - Set jest kolekcj� przechowuj�c� indiwidualne, nie
     * powtarzaj�ce si� elementy.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        //sprawd�, czy ilo�� kluczy zgadza si� z ilo�ci� warto�ci
        if (keys.size() != values.size())
            //je�li nie, wyrzu� wyj�tek
            throw new IllegalStateException("InternalError: nie mo�na zsynchronizowa� " +
                    "kluczy z warto��iami");
        /**
         * w przeciwnym wypadku..
         *
         * Stw�rz nowy Set, w moim wypadku obiekt klasy TreeSet
         *
         * Widzimy tutaj, �e nasz TreeSet przechowuje obiekty typu
         * Map.Entry<K, V>.
         * Map.Entry - jest to obiekt przechowuj�cy par� klucz-warto��, czyli to co
         * przechowuj� mapy. <K, V> oznacza, �e dana para jest typem K klucz + V warto��
         */
        Set set = new TreeSet<Map.Entry<K, V>>();  
        /**
         * Wrzu� wszystkie elementy mapy do TreeSetu.
         * Dzi�ki temu zabiegowi, elementy mapy nie b�d� si� powtarza�
         * i otrzymamy kolecje indiwidualnych par klucz-warto��.
         */
        for (int i=0; i<size(); i++) {
            /**
             * Nie zra�a� si� s�owem Abstract. AbstractMap jest zwyk�� klas�,
             * kt�ra potrafi troch� wi�cej. SimpleEntry obiektem reprezentuj�cy par�,
             * kt�r� mo�na doda� do Setu. 
             */
            set.add((new AbstractMap.SimpleEntry<K, V>(keys.get(i), values.get(i))));
        }
        //zwr�� set
        return set;
    }
 
    //Pobierz warto�� z mapy na podstawie klucza 'key'
    public V get(Object key) {
        int i = keys.indexOf(key);
        if (i == -1)
            return null;
        return values.get(i);
    }
 
    //sprawd�, czy mapa jest pusta
    public boolean isEmpty() {
        return keys.isEmpty();
    }
 
    //Zwr�c kolekcje indiwidualnych kluczy mapy
    public Set<K> keySet() {
        return new TreeSet<K>(keys);
    }
 
    //Dodaj par� key-value do mapy
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        /**
         * P�tla, w kt�rej sprawdzamy, czy dany klucz
         * ju� nie wyst�pi�
         */
        for (int i=0; i<keys.size(); i++) {
            //przechowaj star� warto�� klucza, je�li istnieje
            V oldValue = values.get(i);
             
            //je�li klucz istnieje w mapie to
            if(((Comparable<K>) key).compareTo(keys.get(i)) == 0) {
                //przypisz kluczowi now� warto�� zachowuj�c kolejno��
                values.set(i, value);
                //i zwr�� star�
                return oldValue;
            }
        }
        //w przeciwnym wypadku dodaj na koniec mapy par�
        keys.add(key);
        values.add(value);
        return null;
    }
    /**
     * Dodaj map� 'm' do aktualnej mapy.
     *
     * Ciekawostka, tutaj stosuje wzorzec Iterator. Iterator
     * jest bytem, kt�ry przechodzi przez elementy kolekcji.
     * Standardowy Itereator przechodzi po wszystkich elementach
     * kolekcji. Ale to tak na marginesie.
     */
    public void putAll(Map<? extends K, ? extends V> m) {
         
        /**
         * Stw�rz na podstawie kluczy mapy 'm' iterator.
         */
         
        Iterator<? extends K> keyIterator = m.keySet().iterator();
        //wykonuj, dop�ki iterator ma nast�pn� warto��
        while(keyIterator.hasNext()) {
            K key = keyIterator.next();
            V value = m.get(key);
            put(key, value);
        }
    }
    /**
     * Usu� warto�� klucza 'key' i zwr��
     * j�, je�li istnieje. W przeciwnym wypadku
     * zwr�� null'a.
     */
    public V remove(Object key) {
        int i = keys.indexOf(key);
        if ( i == -1 )
            return null;
        V value = values.get(i);
        keys.remove(i);
        values.remove(i);
        return value;
    }
 
    //Zwr�� wielko�� mapy
    public int size() {
        return keys.size();
    }
 
    //Zwr�c kolekcje warto�ci
    public Collection<V> values() {
        return values;
    }
 
}
 



//Czytaj wi�cej na: http://javastart.pl/algorytmy/struktury-danych-mapa/#ixzz32I4kYnV0
