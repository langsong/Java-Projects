package edu.grinnell.sortingvisualizer.sortevents;

import java.util.ArrayList;
import java.util.List;

public class SwapEvent<T> implements SortEvent<T> {
    
	private List<Integer> affectedIndices;
    
    public SwapEvent(int pos1, int pos2){
        this.affectedIndices = new ArrayList<Integer>();
        this.affectedIndices.add(pos1);
        this.affectedIndices.add(pos2);
    }
    
    public void apply(T[] arr){
        int index1 = this.affectedIndices.get(0);
        int index2 = this.affectedIndices.get(1);
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    
    public List<Integer> getAffectedIndices(){
        return this.affectedIndices;
    }
    
    public boolean isEmphasized(){
        return true;
    }
}
