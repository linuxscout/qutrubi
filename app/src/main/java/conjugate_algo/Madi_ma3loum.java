package conjugate_algo;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Madi_ma3loum {
	
	public Madi_ma3loum(Cursor c,List a){

        travail(c,a);
	}

	   public static String[] ana_anta_anti(String pronom,String verbe){
		   String [] conj1 = new String[3];
		   String[] verbe_partager;
           pronom=delet_space(pronom);
		   if(pronom.equals("أنا")){
               String f1=pronom +"\t\t" +verbe;
	       	     conj1[0]=f1;
	             
	              verbe_partager=verbe.split("");
	            String  verbe2 = verbe.substring(0, verbe_partager.length-2);
	              verbe2=verbe2+"َ";
               pronom="أنتَ";
               String f2=pronom +"\t\t" +verbe2;
               conj1[1]=f2;

	             String  verbe3 = verbe.substring(0, verbe_partager.length-2);
	               verbe3=verbe3+"ِ";
               pronom="أنتِ" ;
               String f3=pronom +"\t\t" +verbe3;
               conj1[2]=f3;

	             return conj1;
	              }
           return conj1;
	   }
	   
	   public static String[] antoma_antom(String pronom,String verbe){
           String [] conj1 = new String[3];
		   String[] verbe_partager;
           pronom=delet_space(pronom);
		   if(pronom.equals("أنتما(مذكر)")){
			   pronom = "أنتما(مذكر)";
               String f1=pronom +"\t\t" +verbe;
               conj1[0]=f1;
	           pronom = "أنتما(مؤنث)";
               String f2=pronom +"\t\t" +verbe;
               conj1[1]=f2;
	              verbe_partager=verbe.split("");
	              String verbe2 = verbe.substring(0, verbe_partager.length-3);
	               verbe2=verbe2+"ْ";
	            pronom = "أنتم";
               String f3=pronom +"\t\t" +verbe2;
               conj1[2]=f3;
		               
	             return conj1;
	              }
           return conj1;
       }
	 
	   public static String[] antonna(String pronom,String verbe){
           String [] conj1 = new String[1];
           pronom=delet_space(pronom);
		   if(pronom.equals("أنتن") ){
               String f1=pronom +"\t\t" +verbe;
               conj1[0]=f1;
               return conj1;
		   }
           return conj1;
	}
	
	   public static String[] howa_hiya_homa(String pronom,String verbe){
           String [] conj1 = new String[4];
			    String[] verbe_partager;
           pronom=delet_space(pronom);
			   if(pronom.equals("هو")){
                   String f1=pronom +"\t\t" +verbe;
                   conj1[0]=f1;

		              String verb2=verbe;
		              verbe_partager=verbe.split("");
		              String verbe4 = verbe.substring(0, verbe_partager.length-2);
		              verbe4=verbe4+"َ"+"ت"+"ْ";
                   pronom="هي" ;
                   String f2=pronom +"\t\t" +verbe4;
                   conj1[1]=f2;

		               verbe_partager=verbe.split("");
		          String     verbe3 = verbe.substring(0, verbe_partager.length-2);
		              
		               verb2 = verb2.substring(0, verbe_partager.length-1);
		               if(verb2.endsWith("ى")== true){
		            	   verbe3=verbe3+"ي"+"َ"; 
		               }
		               verbe3=verbe3+"َ"+"ا";

                   pronom="هما(مذكر) " ;
                   String f3=pronom +"\t\t" +verbe3;
                   conj1[2]=f3;

			              
			              String verbe5 = verbe.substring(0, verbe_partager.length-2);
			               verbe5=verbe5+"َ"+"ت"+"َ"+"ا";
                   pronom="هما(مؤنث)" ;
                   String f4=pronom +"\t\t" +verbe5;
                   conj1[3]=f4;


			             return conj1;
		              }
           return conj1;
		   }

	   public static String[] hom(String pronom,String verbe){
           String [] conj1 = new String[1];
           pronom=delet_space(pronom);
		   if(pronom.equals("هم") ){
               String f1=pronom +"\t\t" +verbe;
               conj1[0]=f1;
               return conj1;
		   }
           return conj1;
	}
	   
	   public static String[] honna(String pronom,String verbe){
         String [] conj1 = new String[1];
           pronom=delet_space(pronom);
		   if(pronom.equals("هن") ){
               String f1=pronom +"\t\t" +verbe;
               conj1[0]=f1;
               return conj1;
		   }
           return conj1;
	}
	   
	   public static String[] nahno(String pronom,String verbe){
           String [] conj1 = new String[1];
           pronom=delet_space(pronom);
		   if(pronom.equals("نحن") ){
               String f1=pronom +"\t\t" +verbe;
               conj1[0]=f1;
               return conj1;
		   }
           return conj1;
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

	public static void travail(Cursor cursor1, List madi){
        int vrb=0;int vrb1=0,vrb2=0,vrb3=0,vrb4=0,vrb5=0,vrb6=0;

        String [] all_conj_verb=new String[14];
        String st, rt;
        if (cursor1 != null) {
            if (cursor1.moveToFirst()) {
                do {
                    st = cursor1.getString(0);
                    rt = cursor1.getString(1);
                    String[] conj_verb  =   Madi_ma3loum.ana_anta_anti(st, rt);
                    String[] conj_verb0 =   Madi_ma3loum.nahno(st, rt);
                    String[] conj_verb1 =   Madi_ma3loum.antoma_antom(st, rt);
                    String[] conj_verb2 =   Madi_ma3loum.howa_hiya_homa(st, rt);
                    String[] conj_verb3 =   Madi_ma3loum.antonna(st, rt);
                    String[] conj_verb4 =   Madi_ma3loum.hom(st, rt);
                    String[] conj_verb5 =   Madi_ma3loum.honna(st, rt);
                    if(st.equals("أنا")){
                    while(vrb<conj_verb.length){
                        //all_conj_verb[vrb]=conj_verb[vrb];

                        madi.add(conj_verb[vrb]);
                        vrb++;
                    }}
                    if(st.equals("نحن")){
                    while(vrb1<conj_verb0.length){
                        // int i=vrb+conj_verb.length;
                        //all_conj_verb[i]=conj_verb0[vrb];

                        madi.add(conj_verb0[vrb1]);
                        vrb1++;
                    }}
                    if(st.equals("أنتما(مذكر)")){
                    while(vrb2<conj_verb1.length){
                        //all_conj_verb[vrb]=conj_verb[vrb];

                        madi.add(conj_verb1[vrb2]);
                        vrb2++;
                    }}
                    if(st.equals("هو")){
                    while(vrb3<conj_verb2.length){
                        // int i=vrb+conj_verb.length;
                        //all_conj_verb[i]=conj_verb0[vrb];

                        madi.add(conj_verb2[vrb3]);
                        vrb3++;
                    }}
                    if(st.equals("أنتن")){
                    while(vrb4<conj_verb3.length){
                        //all_conj_verb[vrb]=conj_verb[vrb];

                        madi.add(conj_verb3[vrb4]);
                        vrb4++;
                    }}
                    if(st.equals("هم")){
                    while(vrb5<conj_verb4.length){
                        // int i=vrb+conj_verb.length;
                        //all_conj_verb[i]=conj_verb0[vrb];

                        madi.add(conj_verb4[vrb5]);
                        vrb5++;
                    }}
                    if(st.equals("هن")){
                    while(vrb6<conj_verb5.length){
                        //all_conj_verb[vrb]=conj_verb[vrb];

                        madi.add(conj_verb5[vrb6]);
                        vrb6++;
                    }}


                } while (cursor1.moveToNext());


            }
        }
	}




}

