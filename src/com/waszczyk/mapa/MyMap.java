package com.waszczyk.mapa;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
 
/**
 * Mapa przyjmuj¹ca 2 typy generyczne. K okreœla typ klucza,
 * natomiast V okreœla typ wartoœci przyjmowanej.
 * Przyk³adem mo¿e byæ MyMap<String, Integer> oceny.
 *
 * Dwie listy przechowuj¹ce klucze oraz wartoœci bêdziemy
 * traktowaæ jak¹ ca³¹ mapê.
 */
public class MyMap<K, V> implements Map<K, V> {
 
    //Klucze mapy powi¹zane z wartoœciami
    private ArrayList<K> keys;
     
    //Wartoœci mapy powi¹zane z kluczami
    private ArrayList<V> values;
     
    //Czyœæ mapê
    public void clear() {
        keys.clear();
        values.clear();
    }
 
    //SprawdŸ, czy klucz 'key' istnieje w mapie
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }
 
    //SprawdŸ, czy wartoœæ 'value" istnieje w mapie
    public boolean containsValue(Object value) {
        return values.contains(values);
    }
 
    /**
     * Trochê ciê¿szej magii
     *
     * Przerób mapê na 'Set' - Set jest kolekcj¹ przechowuj¹c¹ indiwidualne, nie
     * powtarzaj¹ce siê elementy.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        //sprawdŸ, czy iloœæ kluczy zgadza siê z iloœci¹ wartoœci
        if (keys.size() != values.size())
            //jeœli nie, wyrzuæ wyj¹tek
            throw new IllegalStateException("InternalError: nie mo¿na zsynchronizowaæ " +
                    "kluczy z wartoœæiami");
        /**
         * w przeciwnym wypadku..
         *
         * Stwórz nowy Set, w moim wypadku obiekt klasy TreeSet
         *
         * Widzimy tutaj, ¿e nasz TreeSet przechowuje obiekty typu
         * Map.Entry<K, V>.
         * Map.Entry - jest to obiekt przechowuj¹cy parê klucz-wartoœæ, czyli to co
         * przechowuj¹ mapy. <K, V> oznacza, ¿e dana para jest typem K klucz + V wartoœæ
         */
        Set set = new TreeSet<Map.Entry<K, V>>();  
        /**
         * Wrzuæ wszystkie elementy mapy do TreeSetu.
         * Dziêki temu zabiegowi, elementy mapy nie bêdê siê powtarzaæ
         * i otrzymamy kolecje indiwidualnych par klucz-wartoœæ.
         */
        for (int i=0; i<size(); i++) {
            /**
             * Nie zra¿aæ siê s³owem Abstract. AbstractMap jest zwyk³¹ klas¹,
             * która potrafi trochê wiêcej. SimpleEntry obiektem reprezentuj¹cy parê,
             * któr¹ mo¿na dodaæ do Setu. 
             */
            set.add((new AbstractMap.SimpleEntry<K, V>(keys.get(i), values.get(i))));
        }
        //zwróæ set
        return set;
    }
 
    //Pobierz wartoœæ z mapy na podstawie klucza 'key'
    public V get(Object key) {
        int i = keys.indexOf(key);
        if (i == -1)
            return null;
        return values.get(i);
    }
 
    //sprawdŸ, czy mapa jest pusta
    public boolean isEmpty() {
        return keys.isEmpty();
    }
 
    //Zwróc kolekcje indiwidualnych kluczy mapy
    public Set<K> keySet() {
        return new TreeSet<K>(keys);
    }
 
    //Dodaj parê key-value do mapy
    @SuppressWarnings("unchecked")
    @Override
    public V put(K key, V value) {
        /**
         * Pêtla, w której sprawdzamy, czy dany klucz
         * ju¿ nie wyst¹pi³
         */
        for (int i=0; i<keys.size(); i++) {
            //przechowaj star¹ wartoœæ klucza, jeœli istnieje
            V oldValue = values.get(i);
             
            //jeœli klucz istnieje w mapie to
            if(((Comparable<K>) key).compareTo(keys.get(i)) == 0) {
                //przypisz kluczowi now¹ wartoœæ zachowuj¹c kolejnoœæ
                values.set(i, value);
                //i zwróæ star¹
                return oldValue;
            }
        }
        //w przeciwnym wypadku dodaj na koniec mapy parê
        keys.add(key);
        values.add(value);
        return null;
    }
    /**
     * Dodaj mapê 'm' do aktualnej mapy.
     *
     * Ciekawostka, tutaj stosuje wzorzec Iterator. Iterator
     * jest bytem, który przechodzi przez elementy kolekcji.
     * Standardowy Itereator przechodzi po wszystkich elementach
     * kolekcji. Ale to tak na marginesie.
     */
    public void putAll(Map<? extends K, ? extends V> m) {
         
        /**
         * Stwórz na podstawie kluczy mapy 'm' iterator.
         */
         
        Iterator<? extends K> keyIterator = m.keySet().iterator();
        //wykonuj, dopóki iterator ma nastêpn¹ wartoœæ
        while(keyIterator.hasNext()) {
            K key = keyIterator.next();
            V value = m.get(key);
            put(key, value);
        }
    }
    /**
     * Usuñ wartoœæ klucza 'key' i zwróæ
     * j¹, jeœli istnieje. W przeciwnym wypadku
     * zwróæ null'a.
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
 
    //Zwróæ wielkoœæ mapy
    public int size() {
        return keys.size();
    }
 
    //Zwróc kolekcje wartoœci
    public Collection<V> values() {
        return values;
    }
 
}
 



//Czytaj wiêcej na: http://javastart.pl/algorytmy/struktury-danych-mapa/#ixzz32I4kYnV0
