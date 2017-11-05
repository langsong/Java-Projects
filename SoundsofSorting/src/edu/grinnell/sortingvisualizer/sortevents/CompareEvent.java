package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CompareEvent<T> implements SortEvent<T>{
    
    public List<Integer> affectedIndices;
    
    public CompareEvent(int index1, int index2){
        this.affectedIndices = new ArrayList<Integer>();
        this.affectedIndices.add(index1);
        this.affectedIndices.add(index2);
    }
    
    public void apply(T[] arr){
        return;
    }
    
    public List<Integer> getAffectedIndices(){
        return this.affectedIndices;
    }
    
    public boolean isEmphasized(){
        return false;
    }

}
