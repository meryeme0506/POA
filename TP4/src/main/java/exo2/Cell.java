package main.java.exo2;

public class Cell {
    private Object obj;
    private Cell next;

    public Cell(Object obj){
        this.obj=obj;
        this.next=null;
    }
    public boolean hasNext(){
        return (this.next!=null);
    }
    public Cell getNext(){
        return next;
    }

    public Object getObject(){
        return obj;
    }

    public void setNext(Cell c){
        next=c;
    }



}
