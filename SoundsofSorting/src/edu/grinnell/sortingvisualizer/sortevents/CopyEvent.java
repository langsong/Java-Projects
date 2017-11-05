package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class CopyEvent<T> implements SortEvent<T> {
    
public List<Integer> affectedIndices;
public T element;
    
    public CopyEvent(int pos, T element){
        this.affectedIndices = new ArrayList<Integer>();
        this.affectedIndices.add(pos);
        this.element = element;
    }
    
    public void apply(T[] arr){
        int pos = this.affectedIndices.get(0);
        arr[pos] = this.element;        
    }
    
    public List<Integer> getAffectedIndices(){
        return this.affectedIndices;
    }
    
    public boolean isEmphasized(){
        return true;
    }

}
