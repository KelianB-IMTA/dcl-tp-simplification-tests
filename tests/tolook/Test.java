package tolook;
import simplification.Binary;
import simplification.Entier;
import simplification.InvalidVariableNameException;
import simplification.Operator;
import simplification.Variable;


public class Test {

	
	public static void main(String[] args){
		Variable x = null, y = null, z = null;
		try {
			x=new Variable("x");
			z= new Variable("z");
			y=new Variable("y");
		}
		catch(InvalidVariableNameException e) {
			e.printStackTrace();
		}
		Entier trois=new Entier(3);
		Entier deux=new Entier(2);
		Entier cinq=new Entier(5);
		Entier un=new Entier(1);
		Entier six=new Entier(6);
		//Entier zero=new Entier(0);

		Binary b1=new Binary(x,Operator.MULT,x);
		Binary ex=new Binary(un,Operator.MOINS,x);
		Binary b2=new Binary(un,Operator.PLUS,x);
		Binary b3= new Binary(b1,Operator.PLUS,b2);
		Binary b4=new Binary(ex,Operator.MULT,b3);
		Binary exp1=new Binary(x,Operator.PLUS,z);
		Binary e=new Binary(x,Operator.MOINS,z);
		Binary f=new Binary(e,Operator.MULT,exp1);
		Binary exp2=new Binary(z,Operator.MOINS,x);
		Binary exp3=new Binary(exp2,Operator.MULT,exp1);
		Binary exp4=new Binary(trois,Operator.PLUS,six);
		Binary exp5=new Binary(exp4,Operator.MULT,exp3);
		Binary exp=new Binary(un,Operator.PLUS,deux);
		Binary duo=new Binary(ex,Operator.MULT,exp);
		Binary trio=new Binary(cinq,Operator.MOINS,y);
		Binary t= new Binary(duo,Operator.MULT,trio);
		//Binary a=new Binary(x,Operator.plus,zero);
		//Binary b= new Binary(z,Operator.moins,zero);
		//Binary c =new Binary(a,Operator.plus,b);
		Binary fi=new Binary(exp2,Operator.MULT,duo);
		System.out.println("======================");
		System.out.println(" (^_^) Simplification des expressions algebriques (^_^)");
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+exp5);
		System.out.println("sa valeur apres simplification est:"+exp5.engine());
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+b4);
		System.out.println("sa valeur apres simplification est:"+b4.engine());
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+t);
		System.out.println("sa valeur apres simplification est:"+t.engine());
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+f);
		System.out.println("sa valeur apres simplification est:"+f.engine());
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+fi);
		System.out.println("sa valeur apres simplification est:"+fi.engine());
		// ---
		Binary f1= new Binary(fi,Operator.MULT,Entier.ZERO);
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+f1);
		System.out.println("sa valeur apres simplification est:"+f1.engine());
		// ---
		Binary f2= new Binary(fi,Operator.MULT,new Entier(1));
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+f2);
		System.out.println("sa valeur apres simplification est:"+f2.engine());
		//
		Binary f3= new Binary(f1,Operator.MULT,f2);
		System.out.println("======================");
		System.out.println("l'equation saisie est la suivante:"+f3);
		System.out.println("sa valeur apres simplification est:"+f3.engine());

	}
}

