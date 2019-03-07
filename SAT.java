package SatK;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;

import TestSAT.Clause;
import TestSAT.Litteral;

public class SAT
{
	// tableau de valeurs possible
	static	boolean	tabVal[]	;
	//	implimentation de la classe CNF
	static	CNF	cnf			=	new	CNF();
	//	le chemin de fichiers
	static	String	nomF	=	"/home/dell/Documents/TPs/MetaH/uf20-91/uf20-0100.cnf";
//	static	String	nomF	=	"/home/dell/Documents/TPs/MetaH/uf50-218/uf50-01.cnf";
	
	
	
	public static void main(String[] args) throws IOException 
	{
		//	fonction pour lire le fichier
		inputStream();
		
		//	parcourProfondeur	avec x0=false
		parcourProfondeur(false,0);
		//	parcourProfondeur	avec x0=true
		parcourProfondeur(true,0);
		
		System.out.print("Y'a pas de solution");

		System.exit(0);
	}
	
	
	//	fonction pour lire le fichier
	public static void inputStream() throws IOException
	{
		FileInputStream 	fis	=	null;
		InputStreamReader	isr	=	null;
		BufferedReader 		br	=	null;
		try 
		{
			fis		=	new FileInputStream(nomF);
			isr		=	new InputStreamReader(fis);
			br		=	new BufferedReader(isr);
			
			String ligne;
			String[]	tabString;
			while ((ligne=br.readLine())!=null	&&	ligne.startsWith("c"));
			
			tabString	=	ligne.trim().split(" ");
			tabVal		=	new	boolean[Integer.parseInt(tabString[2])];
			System.out.println("tabVal="+tabVal.length);
			while ((ligne=br.readLine())!=null	&&	!ligne.startsWith("%"))
			{
				tabString	=	ligne.trim().split(" ");
				//System.out.println(Arrays.toString(tabString));
				cnf.addClause(tabString);
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			br.close();
			e.printStackTrace();
		}
	}
	//	fonction pour le parcourProfondeur
	public static void parcourProfondeur(boolean val , int pos) 
	{
		// affecter la valeurs 'val' au litteral 'pos'
		tabVal[pos]	=	val;
		if(pos<tabVal.length-1)	// condition pour arrêter la récursivité
		{
			parcourProfondeur(false	,	pos+1);
			parcourProfondeur(true	,	pos+1);	
		}
		else
		{
			// quand on arrêve au feuile on teste la solution 
			boolean valLog	=	cnf.isVal(tabVal);
			// si on trouve une solution ,on arrête
			if(valLog)
			{
				System.out.print(Arrays.toString(tabVal)+"\t");
				System.out.println(valLog);
				System.exit(0);
			}	
		}
	}
}
