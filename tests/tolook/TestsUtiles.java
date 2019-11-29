package tolook;

import simplification.Binary;
import simplification.Entier;
import simplification.InvalidVariableNameException;
import simplification.Operator;
import simplification.Variable;

public class TestsUtiles {

    public static void main(String[] args){
    	Variable x = null, z = null;
    	try {
    		x=new Variable("x");
    		z= new Variable("z");
    	}
    	catch(InvalidVariableNameException e) {
    		e.printStackTrace();
    	}
        Entier deux=new Entier(2);
        Entier un=new Entier(1);
        Binary ex=new Binary(un,Operator.MOINS,x);
        Binary exp2=new Binary(z,Operator.MOINS,x);
        Binary exp=new Binary(un,Operator.PLUS,deux);
        Binary duo=new Binary(ex,Operator.MULT,exp);
        Binary fi=new Binary(exp2,Operator.MULT,duo);
    // --- tests utiles
    // ---
    Binary f0= new Binary(Entier.UN,Operator.MULT,Entier.UN);
    System.out.println("======================");
    System.out.println("l'equation saisie est la suivante: "+f0);
    System.out.println("sa valeur apres simplification est: "+f0.engine());
    // ---
    Binary f1= new Binary(fi,Operator.MULT,Entier.ZERO);
    System.out.println("======================");
    System.out.println("l'equation saisie est la suivante: "+f1);
    System.out.println("sa valeur apres simplification est: "+f1.engine());
    // ---
    Binary f2= new Binary(fi,Operator.MULT,new Entier(1));
    System.out.println("======================");
    System.out.println("l'equation saisie est la suivante: "+f2);
    System.out.println("sa valeur apres simplification est: "+f2.engine());
      // ---
    Binary f1a= new Binary(fi,Operator.PLUS,Entier.ZERO);
    System.out.println("======================");
    System.out.println("l'equation saisie est la suivante: "+f1a);
    System.out.println("sa valeur apres simplification est: "+f1a.engine());
    

    }
    
}
