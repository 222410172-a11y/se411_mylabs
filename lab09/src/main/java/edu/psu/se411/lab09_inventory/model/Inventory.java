package edu.psu.se411.lab09_inventory.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory<T> {

    private List<T> elements;

    public Inventory() {
        elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public void add(T item) {
        elements.add(item);
    }

    public void remove(T item) {
        elements.remove(item);
    }

    public List<T> findItems(SearchStrategy<T> strategy) {

        List<T> results = new ArrayList<>();

        for (T item : elements) {

            if (strategy.matches(item)) {
                results.add(item);
            }
        }

        return results;
    }
    
    
    @Override
    public String toString() {
        return elements.toString();
    }
}