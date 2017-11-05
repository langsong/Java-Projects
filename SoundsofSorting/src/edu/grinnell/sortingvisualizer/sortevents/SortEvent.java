package edu.grinnell.sortingvisualizer.sortevents;

import java.util.List;

public interface SortEvent<T> {
    
    public void apply(T[] arr);
    
    List<Integer> getAffectedIndices();
    
    boolean isEmphasized();

}
