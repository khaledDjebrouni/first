package SatK;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CNF 
{
	// ensemble de Clause
	Set<Clause>	set	=	new	HashSet<Clause>();
	// la valeur les clause
	private	boolean 	val;
	
	
	// ajouter une clause
	void addClause(String val[])
	{
		set.add( new Clause(val));	
	}
	
	
	// retourner la valeur de la CNF
	public boolean isVal(boolean	tabVal[]) 
	{
		// parcourir toutes les clause
		for (Clause clause : set) 
		{
			// si on trouve une clause false on retourne false
			if (!clause.isVal(tabVal))
			{
				val	=	false;
				return false;
			}
		}
		// si toutes les clause=true on retourne true
				val	=	true;
				return true;
	}




	// fonction pour transformer en String
	public String toString() 
	{
		return "CNF [set=" + set + ", \nval=" + val + "]";
	}
	

}
