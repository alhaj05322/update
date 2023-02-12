package taskone;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

class StringList {
    
    List<String> strings = new ArrayList<String>();

    public void add(String str) {
        int pos = strings.indexOf(str);
        if (pos < 0) {
            strings.add(str);
        }
    }
    
    public void clear() {
        
        if (!strings.isEmpty()) {
            strings.clear();
        }
    }
    
    public int find(String str) {
        int index = 0;
        if (!strings.isEmpty()) {
           index = strings.indexOf(str);
        }
        return index;
    }
    
    public void sort(List list){
       Collections.sort(strings);
    }
    public StringBuilder prepend(int i, StringBuilder s){
        s.insert(i, strings);
        return s;
    }

    public boolean contains(String str) {
        return strings.indexOf(str) >= 0;
    }

    public int size() {
        return strings.size();
    }

    public String toString() {
        return strings.toString();
    }
}