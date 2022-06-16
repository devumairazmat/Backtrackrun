package backtrackrun;
import java.util.Vector;
class Var{
	public String var_Name;
	public String var_Val;
	public Vector<String> Vals;
	public Vector<Var> Neighbour;
	Var(String n){ 
		var_Name = n;
		var_Val = "";
		Vals = new Vector<String>();
		Vals.add("BLUE");Vals.add("RED");Vals.add("GREEN");
		}
	}
    
class CSP{
	public Vector<Var> varCSP;
	public boolean assignment;

	CSP(){
		assignment = false;
		varCSP = new Vector<Var>();
		Var WA = new Var("WA");
		varCSP.add(WA); // Adding WA variable
		Var NT = new Var("NT");
		varCSP.add(NT); // Adding NT variable
		Var Q = new Var("Q");
		varCSP.add(Q); // Adding Q variable
		Var NSW = new Var("NSW");
		varCSP.add(NSW); // Adding NSW variable
		Var V = new Var("V");
		varCSP.add(V); // Adding NT variable
		Var T = new Var("T");
		varCSP.add(T); // Adding NT variable
		Var SA = new Var("SA");
		varCSP.add(SA); // Adding NT variable

		//Neighbours of Var WA
		Vector<Var> vec1 = new Vector<Var>();
		vec1.add(NT);vec1.add(SA);
		WA.Neighbour = vec1;

		//Neighbours of Var NT
		Vector<Var> vec2 = new Vector<Var>();
		vec2.add(WA);vec2.add(SA);vec2.add(Q);
		NT.Neighbour = vec2;

		//Neighbours of Var Q
		Vector<Var> vec3 = new Vector<Var>();
		vec3.add(NT);vec3.add(SA);vec3.add(NSW);
		Q.Neighbour = vec3;

		//Neighbours of Var NSW
		Vector<Var> vec4 = new Vector<Var>();
		vec4.add(Q);vec4.add(SA);vec4.add(V);
		NSW.Neighbour = vec4;

		//Neighbours of Var V
		Vector<Var> vec5 = new Vector<Var>();
		vec5.add(NSW);vec5.add(SA);
		V.Neighbour = vec5;

		//Neighbours of Var SA
		Vector<Var> vec6 = new Vector<Var>();
		vec6.add(WA);vec6.add(NT);vec6.add(Q);vec6.add(NSW);vec6.add(V);
		SA.Neighbour = vec6;

		//Neighbours of Var T
		Vector<Var> vec7 = new Vector<Var>();
		T.Neighbour = vec7;
		}

	public boolean BackTrackingSearch(int I){
		boolean violate; 
		for(int var = I; var < varCSP.size(); var++){
		//  System.out.println(varCSP.elementAt(var).var_Name+", Var for loop");
		 for(int vl = 0; vl < varCSP.elementAt(var).Vals.size(); vl++){
			violate = false;
		//  System.out.println(varCSP.elementAt(var).Vals.elementAt(vl)+", color for loop");
		  for(int neigh = 0; neigh < varCSP.elementAt(var).Neighbour.size(); neigh++){
		//    System.out.println(varCSP.elementAt(var).Neighbour.elementAt(neigh).var_Val+", neighbour for loop");
		   if (varCSP.elementAt(var).Vals.elementAt(vl) == 
		       varCSP.elementAt(var).Neighbour.elementAt(neigh).var_Val && 
		       varCSP.elementAt(var).Neighbour.elementAt(neigh).var_Val != ""){
						violate = true;
						}//End if
					}//End for(neigh)
		if(!violate){
		   varCSP.elementAt(var).var_Val = varCSP.elementAt(var).Vals.elementAt(vl);

		   System.out.println(varCSP.elementAt(var).var_Name+", "+
		                  varCSP.elementAt(var).Vals.elementAt(vl));

		   boolean result = BackTrackingSearch(var+1);
		   if(result) 
		     return true;
	 	   else
		     varCSP.elementAt(var).var_Val=" ";
		  }//End if

		}//End for(vl)

	return false;
	}//End for(var)
    return true;
   }//End of BackTracking

}//End of class CSP

public class BackTrackRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 CSP dummy = new CSP();
		 dummy.BackTrackingSearch(0);

	}

}
