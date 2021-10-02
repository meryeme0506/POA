##Exercice 1 : Eclipse

2.  syst Crtl + sp in main :
   It shows  System.out.println();

3.  toStr + Crtl + sp in class :
   It shows the template proposals of "toStr", and by clicking on the first proposal it creates the function toString();

4.  main + Crtl + sp in class :
   It shows the template proposals of "main", and by clicking on the first proposal it creates the main method

5.  Crtl | space after creating the file foo :
    Creating automatically the constructor with the new int field foo
    
    set Crtl space :
    It shows the template proposals of "set", and by clicking on the first proposal it creates the setter of the integer field foo

6. Rename the class | Rename the int field

###Exercice 2 : Point

1. It works because we call the two private fields in the same class, so we have full access to the variables even if they are private.
        
2. It doesn't work because the two integer fields x and y are private in the class Point, so TestPoint has no access to them
   We can fix it by creating adding an accessor (getter) in the class Point, to have direct access to x and y.
                                                                    
3. To don't allow other classes to modify our variables.    
   To have control on the member variables.        
To put if we want some constraints check in the setter method to avoid setting an illogical value.

4. An accessor method is a method that we write to allow access to an instance variable of a class but denies the ability to modify it.
   This can be important when you have an instance variable that you want users of the class to read the value of but not modify.                                                   
                                                
5. If we initialize the x and y :       
   public Point(int px,int py) {    
   this.x=px;   
   this.y=py;   
   }    
   Then we get no warnings   
   Otherwise, if we don't initialize the values of x and y :    
   public Point(int px,int py) { }    
   Then, we get an error in the main method.      

6. The new nomination match with the private variables, and we initialize the values of x and y :   
   public Point(int x,int y) {  
   this.x=x;    
   this.y=y;    
   }
7. We create a static variable, and we increment it after every creation of a point 
   (See code)

8. When we have a constructor overloading, based on the object we create with the parameter list, the compiler executes the corresponding constructor.  
   Here, if we create a new Point using two integer arguments, the compiler will call the first argument, but if create a new Point with another point as argument the compiler will directly use the second constructor.

9. To have the (x,y) we define the toString function ( See code )

##Exercice 3 : Equality

1. True then False
   The first one is True because p2 and p1 both have the same addresses, and they both point to the same memory location    
   The second one is False, because p1 and p3 don't point to the same memory location, each one has different address.  
   Since the == operator is used for reference comparison (address comparison) then the result (True, False) is logic.  

2. See code

3. The first System.out.println prints the good index of the point p1 which is 0    
   The second one prints -1 which means,that the p3 isn't in the list   
   To fix that, we have to override the function equals used by indexOf, to compare only the content of the elements of the list, and the element which we are looking for.  
   In our case, I rename the function isSameAS(Point p) to the override function equals(Object obj) 

##Exercice 4 : Polyline
1. See code
2. If we use a simple array, and add a number of points more than the size of the array, we will get an exception : Index "x" out of bounds for length "y" , with y the size of the array.                  
To fix that we need to use a resizable array, to add and remove elements whenever we want. 
