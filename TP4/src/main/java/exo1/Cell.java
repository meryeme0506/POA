package main.java.exo1;

public class Cell {
    private String str;
    private Cell next;

    public Cell(String str){
        this.str=str;
        this.next=null;
    }
    public boolean hasNext(){
        return (this.next!=null);
    }
    public Cell getNext(){
        return next;
    }

    public String getString(){
        return str;
    }

    public void setNext(Cell c){
        next=c;
    }

}
