 package ast.types;

 import visitor.*;
 
 //	typeError:type -> 
 
 public class TypeError extends AbstractType {
 
     private static TypeError typeError;
 
     private TypeError() {
     }
 
     public static TypeError getInstance() {
         if (typeError == null) {
            typeError = new TypeError();
         }
         return typeError;
     }
     
     public String toString() {
         return "{TypeError}";
     }
 
     @Override
     public boolean isSameType(Type type) {
         return type == getInstance();
     }

    @Override
    public Object accept(Visitor visitor, Object param) {
        return null;
    }

    @Override
	public int getMemorySize() {
		return 0;
	}
 }
 