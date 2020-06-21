package conjugate_algo;

import android.database.Cursor;

import java.util.List;

public class Amr {
	
	public Amr(Cursor c,List a){
		travail(c,a);
		
	}

	private static String[] anta_anti_antoma_antom_antonna(String pronom, String verbe) {
		String [] conj1 = new String[6];
		String[] verbe_partager;
		pronom=delet_space(pronom);
		   if(pronom.equals("أنتَ")){
			   String f1=pronom +"\t\t" +verbe;
			   conj1[0]=f1;
	             
	              verbe_partager=verbe.split("");
	            String  verbe1 = verbe.substring(0, verbe_partager.length-2);
	            String abriv= verbe.substring(0, verbe_partager.length-1);
	          
	            if(delet_techkil(verbe).length()- 1 == 1){
         		   verbe1 = verbe.substring(0, verbe_partager.length-1);
         		   if(verbe1.endsWith("َ")){
         			  verbe1=verbe1+"يْ"; 
         		   }else{verbe1=verbe1+"ي";}
         		  
	            }else{
	            	if(abriv.endsWith("َ")){
	            		verbe1= verbe.substring(0, verbe_partager.length-1);
	            		 
	            		verbe1=verbe1+"يْ";
	            	}else{
	              verbe1=verbe1+"ِ"+"ي";
	            	}
	            }
			   pronom="أنتِ" ;
			   String f2=pronom +"\t\t" +verbe1;
			   conj1[1]=f2;
	               
	               String  verbe2 = verbe.substring(0, verbe_partager.length-2);
	              
	               if(delet_techkil(verbe1).length() == 4 && delet_techkil(verbe1).startsWith("ا") && !abriv.endsWith("َ")){
	            	   verbe2=verbe2+"َ"+"وَ"+"ا";
	               }else{
	            	   if(delet_techkil(verbe).length()- 1 == 1){
	            		   verbe2 = verbe.substring(0, verbe_partager.length-1);
	            		 verbe2=verbe2+"يَ"+"ا";
	            	   }else{
	            		   if(abriv.endsWith("َ")){
	   	            		verbe2= verbe.substring(0, verbe_partager.length-1);
	   	            		 
	   	            		verbe2=verbe2+"يَ"+"ا";
	   	            	}else{ 
		              verbe2=verbe2+"َ"+"ا";}
	            	   }
	               }
		              pronom="أنتما(مذكر) " ;
			   String f3=pronom +"\t\t" +verbe2;
			   conj1[2]=f3;
		               
			              pronom="أنتما(مؤنث) " ;
			   String f4=pronom +"\t\t" +verbe2;
			   conj1[3]=f4;
			               String  verbe4 = verbe.substring(0, verbe_partager.length-2);
			               if(delet_techkil(verbe).length()- 1 == 1){
			         		   verbe4 = verbe.substring(0, verbe_partager.length-1);
			         		   if(verbe4.endsWith("َ")){
			         			  verbe4=verbe4+"وْ"+"ا"; 
			         		   }else{verbe4 = verbe.substring(0, verbe_partager.length-2);
			         			   verbe4=verbe4+"ُ"+"و"+"ا";}
			         		  
				            }else{
				            	if(abriv.endsWith("َ")){
			   	            		verbe4= verbe.substring(0, verbe_partager.length-1);
			   	            		 
			   	            		verbe4=verbe4+"وْ"+"ا";
			   	            	}else{
				              verbe4=verbe4+"ُ"+"و"+"ا";
			   	            	}
				            }
				              pronom="أنتم " ;
			   String f5=pronom +"\t\t" +verbe4;
			   conj1[4]=f5;
				               
				               String  verbe5 = verbe.substring(0, verbe_partager.length-2);
				               if(delet_techkil(verbe1).length() == 4 && delet_techkil(verbe1).startsWith("ا") && !abriv.endsWith("َ")){
				            	   verbe5=verbe5+"ُ"+"و"+"ن"+"َ";
				               }else{
				            	   
					               if(delet_techkil(verbe).length()- 1 == 1){
					         		   verbe5 = verbe.substring(0, verbe_partager.length-1);
					         		   if(verbe5.endsWith("َ")){
					         			  verbe5=verbe5+"يْ"+"نَ"; 
					         		   }else{verbe5=verbe5+"ي"+"نَ";}
					         		  
						            }else{
						            	if(abriv.endsWith("َ")){
					   	            		verbe5= verbe.substring(0, verbe_partager.length-1);
					   	            		 
					   	            		verbe5=verbe5+"يْ"+"نَ";
					   	            	}else{
						            	
					              verbe5=verbe5+"ْ"+"ن"+"َ";
					   	            	}
						            }
				               }
					              pronom="أنتن "  ;
			   String f6=pronom +"\t\t" +verbe5;
			   conj1[5]=f6;
		          return conj1;
	               
		   }
		return conj1;

	}
		   public static String delet_techkil (String verbe){
		          String new_verbs="";
		          String []verbe_partager=verbe.split("");
		          for(int i =0;i<verbe_partager.length;i++){
		              if (verbe_partager[i].equals("َ")||verbe_partager[i].equals("ُ")||verbe_partager[i].equals("ْ")||verbe_partager[i].equals("ِ")||verbe_partager[i].equals("َُ")||verbe_partager[i].equals("ُُ")||verbe_partager[i].equals("ََ")||verbe_partager[i].equals("ِِ")){
		                  verbe_partager[i]="";
		              }
		              new_verbs +=(verbe_partager[i]);

		          }
		          return new_verbs;
		      }


	public static String delet_space (String verbe){
		String new_pro="";
		String []pro_partager=verbe.split("");
		for(int i =0;i<pro_partager.length;i++){
			if (pro_partager[i].equals(" ")){
				pro_partager[i]="";
			}
			new_pro +=(pro_partager[i]);

		}
		return new_pro;
	}

	public static void travail(Cursor cursor1, List amr){
		int vrb=0;


		String st, rt;
		if (cursor1 != null) {
			if (cursor1.moveToFirst()) {
				do {
					st = cursor1.getString(0);
					rt = cursor1.getString(1);
					String[] conj_verb  =  anta_anti_antoma_antom_antonna(st,rt);

						while(vrb<conj_verb.length){


							amr.add(conj_verb[vrb]);
							vrb++;
						}

				} while (cursor1.moveToNext());


			}
		}
	}


}




