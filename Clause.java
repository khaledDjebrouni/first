package SatK;

import java.util.Arrays;

public class Clause 
{
	// un tableau d'indice de littereaux
	int tabLitteral[]	=	new	int[3];
	// la valeur de la clause
	private	boolean val;
	
	
	// constructeur d'une clause
	public	Clause(String val[])
	{
		// les indices des litteraux ex :  69 -63 -22 0
		for (int i = 0; i < val.length-1; i++) 
		{
			// transformer le type String vers int
			tabLitteral[i]	=	Integer.parseInt(val[i].trim());
		}
	}
	
	// fonction qui retourne la valeur de la clause
	public	boolean isVal(boolean	tabVal[])
	{
		int	indiceDeVariable;
		
		// parcourir tous les littereaux de cette clause
		for (int i = 0; i < tabLitteral.length; i++) 
		{
			// la valeur de l'indice
			indiceDeVariable	=	tabLitteral[i];
			// si on trouve un litteral=true on retourne true
			if (indiceDeVariable>0	?	tabVal[indiceDeVariable-1]	:	!tabVal[-indiceDeVariable-1])
			{
				val	=	true;
				return true;
			}	
		}
		// si toutes les litteraux=false on retourne false
				val	=	false;
				return val;			
	}



	// fonction pour transformer en String
	public String toString()
	{
		return "\nClause [tabLitteral=" + Arrays.toString(tabLitteral) + "\t,val=" + val + "]";
	}


	

	
	
	
	
}
