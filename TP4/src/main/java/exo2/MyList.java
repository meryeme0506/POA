package main.java.exo2;

public class MyList<E, T> {

    private T firstCell;
    private int size;

    public MyList(){
        firstCell = null;
        size = 0 ;
    }

    public void add(Object obj) throws NullPointerException{
        if(obj==null)
            throw new NullPointerException("");
        else {
            Cell cell = new Cell(obj);
            size++;
            if (this.firstCell == null)
                this.firstCell = (T) cell;
            else {
                Cell first =(Cell) this.firstCell;
                this.firstCell = (T) cell;
                ((Cell) this.firstCell).setNext(first);
            }
        }
     }

     public int size(){
        return size;
        /*if(firstCell==null)
            return 0;
        int size=1;
        Cell cell = firstCell;
        while (cell.hasNext()){
            cell=cell.getNext();
            size++;
        }
            return size;*/
     }

    public String toString() {
        if (firstCell == null)
            return "The Linkedlist is empty";
        String res = "";
        Cell cell = (Cell) this.firstCell;
        res += cell.getObject();
        while (cell.hasNext()) {
            res += ", ";
            cell = cell.getNext();
            res += cell.getObject();
        }
        return res;

    }

     public void addLast(Object obj) throws NullPointerException{
         if(obj==null)
             throw new NullPointerException("");
         else
             if(firstCell==null)
                 this.add(obj);
             else {
                 size++;
                 Cell next=(Cell) firstCell;
                 while (next.hasNext()) {
                     next = next.getNext();
                 }
                 Cell cell = new Cell(obj);
                 next.setNext(cell);
             }
     }

     public void add(Object obj, int i) throws NullPointerException{
        if(obj==null)
            throw new NullPointerException("");
        else
            if(i<this.size()){
                size++;
                Cell first = (Cell) firstCell;
                int x = 0;
                while(x!=i){
                    first = first.getNext();
                    x++;
                }
                Cell cell = new Cell(obj);
                Cell oldNext = first.getNext();
                first.setNext(cell);
                cell.setNext(oldNext);
            }else{
                System.out.println("Please enter a valid index !");
            }

     }

    public Object get(int i) throws IllegalArgumentException{
        if (i<size && i >= 0) {
            Cell cell = (Cell) firstCell;
            int j = 0;
            while (j<i) {
                cell = cell.getNext();
                j++;
            }
            return cell.getObject();
        }
        else {
            throw new IllegalArgumentException("The index doesn't exist");
        }
    }

    public String sumLetter(){
        Cell cell = (Cell) firstCell;
        String res = "";
        for (int i = 0; i<this.size(); i++) {
            res+=this.get(i).toString();
        }
        return res;
    }
    public boolean contains(Object o) {
        Cell cell =(Cell) firstCell;
        while(cell.hasNext()) {
            if(cell.getObject().equals(o)) {
                return true;
            }
            cell=cell.getNext();
        }
        return false;
    }


}
