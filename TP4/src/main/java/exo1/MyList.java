package main.java.exo1;

public class MyList {

    private Cell firstCell;
    private int size;

    public MyList(){
        firstCell = null;
        size = 0 ;
    }

    public void add(String str) throws NullPointerException{
        if(str==null)
            throw new NullPointerException("");
        else
            size++;
            if (this.firstCell==null)
                 this.firstCell = new Cell(str);
            else{
                Cell first = this.firstCell;
                this.firstCell = new Cell(str);
                this.firstCell.setNext(first);
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
        Cell cell = this.firstCell;
        res += cell.getString();
        while (cell.hasNext()) {
            res += ", ";
            cell = cell.getNext();
            res += cell.getString();
        }
        return res;

    }

     public void addLast(String str) throws NullPointerException{
         if(str==null)
             throw new NullPointerException("");
         else
             if(firstCell==null)
                 this.add(str);
             else {
                 size++;
                 Cell next=firstCell;
                 while (next.hasNext()) {
                     next = next.getNext();
                 }
                 Cell cell = new Cell(str);
                 next.setNext(cell);
             }
     }

     public void add(String str, int i) throws NullPointerException{
        if(str==null)
            throw new NullPointerException("");
        else
            if(i<this.size()){
                size++;
                Cell first = firstCell;
                int x = 0;
                while(x!=i){
                    first = first.getNext();
                    x++;
                }
                Cell cell = new Cell(str);
                Cell oldNext = first.getNext();
                first.setNext(cell);
                cell.setNext(oldNext);
            }else{
                System.out.println("Please enter a valid index !");
            }

     }

    public String get(int i)throws IllegalArgumentException{
        if (i<size && i >= 0) {
            Cell cell = firstCell;
            int j = 0;
            while (j<i) {
                cell = cell.getNext();
                j++;
            }
            return cell.getString();
        }
        else {
            throw new IllegalArgumentException("The index doesn't exist");
        }
    }

    public int sumLetter(){
        int sum = 0;
        for (int i = 0; i<this.size(); i++) {
            sum+=this.get(i).length();
        }
        return sum;
    }
     public static void main(String[] args){
        MyList ml = new MyList();
        ml.addLast("sara");
        ml.add("toto");
        ml.add("titi");
        ml.addLast("najib");

        System.out.println(ml.toString());
     }

}
