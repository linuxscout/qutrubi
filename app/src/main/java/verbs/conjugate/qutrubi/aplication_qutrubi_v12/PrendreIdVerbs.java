package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.database.Cursor;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PrendreIdVerbs {

		   
		   
		   public static String[] fct_verbs( Cursor c,String[] table_verbs){

			   int i=0;


			   if(c!=null)
			   {
				   if (c.moveToFirst())
				   {
					   do {
						   String idverb = c.getString(0) + " ";
						   table_verbs[i]=idverb;
						   i++;
					   } while (c.moveToNext());
				   }
			   }
			      return table_verbs;
		   }
		   
		   public static int[] fct_idverbs( Cursor c,int[] table_idverbs){
			  // final int[] table_idverbs = new int[6000];
			  int i=0;


				   if(c!=null)
				   {
					   if (c.moveToFirst())
					   {
						   do {
							   int idverb = Integer.valueOf(c.getString(0));
							   table_idverbs[i]=idverb;
							   i++;
						   } while (c.moveToNext());
					   }
				   }

			      return table_idverbs;
		   }
	  
		   public static int[] ret_idverbssahih(String[] allverbs,int[] id_allverbs){
			   
			   final  int[] table_amill_id_sa7i7=new int[6000];
			  // final  int[] table_amill_verbs_sa7i7=new int[6000];

			   
			   for(int i=0;i<allverbs.length;i++){
				   
				   if((allverbs[i].trim().length()== 3 || allverbs[i].trim().length()== 2  )){
					   if( allverbs[i].contains("ا") || allverbs[i].contains("ي") || allverbs[i].contains("و") || allverbs[i].contains("ى")){
						}else{
						   //////////////////////////// Sa7i7 ///////////////////////////////////
						    	table_amill_id_sa7i7[i]= id_allverbs[i];
								 // System.out.println(id_allverbs[i]+"\t"+table_amill_verbs_sa7i7[i]+"\t"+table_amill_verbs_sa7i7[i].length()+"\t"+table_amill_verbs_sa7i7[i].contains("ا"));
							//	  System.out.println(table_amill_id_sa7i7[i]);
									 
						    }
					   
				   } 

			   }
			   return table_amill_id_sa7i7;
			
		   }

	public static int[] ret_idverbsMoAtal(String[] allverbs,int[] id_allverbs){


		final  int[] table_amill_id_mo3tal=new int[6000];
		final  int[] table_amill_verbs_mo3tal=new int[6000];

		for(int i=0;i<allverbs.length;i++){

			if((allverbs[i].trim().length()== 3 || allverbs[i].trim().length()== 2  )){
				if( allverbs[i].contains("ا") || allverbs[i].contains("ي") || allverbs[i].contains("و") || allverbs[i].contains("ى")){
					//////////////////////////// Mo3tal ///////////////////////////////////

					table_amill_verbs_mo3tal[i] = Integer.parseInt(allverbs[i]);
					table_amill_id_mo3tal[i] = id_allverbs[i];
					//table_amill_id[i]=id_allverbs[i];
					//  System.out.println(table_amill_verbs_mo3tal[i]+"\t"+table_amill_verbs_mo3tal[i].length()+"\t"+table_amill_verbs_mo3tal[i].contains("ا"));
					System.out.println(table_amill_id_mo3tal[i]);
				}

			}


		}
		return table_amill_id_mo3tal;

	}
		   
           public static int[] ret_idverbsquatre(String[] allverbs,int[] id_allverbs){
			   
			   final  int[] table_amill_id_quatr=new int[6000];
			   final  String[] table_amill_verbs_quatr=new String[6000];

			  
			   
			   for(int i=0;i<allverbs.length;i++){
				   
				   if((allverbs[i].trim().length()== 4 )){
					    //////////////////////////// Roba3i ///////////////////////////////////
						   
						   table_amill_verbs_quatr[i] = allverbs[i];
						   table_amill_id_quatr[i] = id_allverbs[i];
					    	
							 // System.out.println(table_amill_verbs_quatr[i]+"\t"+table_amill_verbs_quatr[i].length()+"\t"+table_amill_verbs_quatr[i].contains("ا"));
							//  System.out.println(table_amill_id_quatr[i]);   
					   
				   }


					   
				   }
			   return table_amill_id_quatr;
				  
				  
			   }
			


	public static int[] ret_idverbsNOquatre(String[] allverbs,int[] id_allverbs){


		final  int[] table_amill_id_plusquatr=new int[6000];

		final  String[] table_amill_verbs_plusquatr=new String[6000];


		for(int i=0;i<allverbs.length;i++){

			if((allverbs[i].trim().length()== 4 )){}

			else{
				if((allverbs[i].trim().length()== 5 ||allverbs[i].trim().length()== 6 )){


					//////////////////////////// khomasi_sodasi ///////////////////////////////////
					Log.i("ahmeeeeeeeeeeeeeeeeeeeeeeeeeeeeed",allverbs[i]+" "+i+"  id=  "+id_allverbs[i]);
					table_amill_verbs_plusquatr[i] = allverbs[i];
					table_amill_id_plusquatr[i] = i;
					//er[i]=Integer.parseInt(table_amill_id_plusquatr[i]);
					//System.out.println(table_amill_verbs_plusquatr[i]+"\t"+table_amill_verbs_plusquatr[i].length()+"\t"+table_amill_verbs_plusquatr[i].contains("ا"));
					//System.out.println(table_amill_id_plusquatr[i]);
				}

			}


		}

		return table_amill_id_plusquatr;

	}
		   

	}


