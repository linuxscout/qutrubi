package conjugate_algo;

import android.database.Cursor;

import java.util.List;

public class Modari3_mansob_majhol {

	
	public Modari3_mansob_majhol(Cursor c,List a){
		travail(c,a);
	}

	public static String[]anta_ana_anahno_howa_hiya(String pronom,String verbe){
		String [] conj1 = new String[5];
		String[] verbe_partager;
		pronom=delet_space(pronom);
		if(pronom.equals("أنتَ")){
			String f1=pronom +"\t\t" +verbe;
			conj1[0]=f1;

			verbe_partager=verbe.split("");
			String  verbe2 = verbe.substring(1, verbe_partager.length-1);
			if(verbe_partager[3].equals("أ")){
				verbe2 = verbe.substring(4, verbe_partager.length-1);
				verbe2="آ"+verbe2;
			}else{
				verbe2="أ"+verbe2;}
			pronom="أنا";
			String f2=pronom +"\t\t" +verbe2;
			conj1[1]=f2;
			String  verbe3 = verbe.substring(1, verbe_partager.length-1);
			verbe3="ن"+verbe3;
			pronom="نحن";
			String f3=pronom +"\t\t" +verbe3;
			conj1[2]=f3;
			String  verbe4 = verbe.substring(1, verbe_partager.length-1);
			verbe4="ي"+verbe4;
			pronom="هو";
			String f4=pronom +"\t\t" +verbe4;
			conj1[3]=f4;
			String  verbe5 = verbe.substring(1, verbe_partager.length-1);
			verbe5="ت"+verbe5;
			pronom="هي";
			String f5=pronom +"\t\t" +verbe5;
			conj1[4]=f5;
			return conj1;
		}
		return conj1;
	}

	public static String[] anti_antoma_antom_homa_hom(String pronom,String verbe){
		String [] conj1 = new String[7];
		String[] verbe_partager;
		pronom=delet_space(pronom);
		if(pronom.equals("أنتِ")){
			String f1=pronom +"\t\t" +verbe;
			conj1[0]=f1;
			verbe_partager=verbe.split("");
			String vrb = verbe.substring(0, verbe_partager.length-1);
			pronom = "أنتما(مذكر) ";
			verbe_partager=verbe.split("");
			String verbe1 = verbe.substring(0, verbe_partager.length-3);
			if(vrb.endsWith("ْ")){
				verbe1=verbe1+"َ"+"يَ"+"ا";
			}else{
				verbe1=verbe1+"َ"+"ا";}
			String f2=pronom +"\t\t" +verbe1;
			conj1[1]=f2;
			pronom = "أنتما(مؤنث) ";
			String f3=pronom +"\t\t" +verbe1;
			conj1[2]=f3;
			pronom = "أنتم ";
			verbe_partager=verbe.split("");
			String verbe2 = verbe.substring(0, verbe_partager.length-3);
			if (verbe2.endsWith("و")){
				verbe2=verbe2+"ا";
			}else{
				if(vrb.endsWith("ْ")){
					verbe2=verbe2+"ُ"+"و"+"ْ"+"ا";
				}else{
					verbe2=verbe2+"ُ"+"و"+"ا";}
			}
			String f4=pronom +"\t\t" +verbe2;
			conj1[3]=f4;

			pronom = "هما(مذكر) ";
			verbe_partager=verbe.split("");
			String verbe3 = verbe.substring(1, verbe_partager.length-3);
			if(vrb.endsWith("ْ")){
				verbe3="ي"+verbe3+"َ"+"يَ"+"ا";
			}else{
				verbe3="ي"+verbe3+"َ"+"ا";}
			String f5=pronom +"\t\t" +verbe3;
			conj1[4]=f5;

			pronom = "هما(مؤنث) ";
			verbe_partager=verbe.split("");
			String verbe4 = verbe.substring(1, verbe_partager.length-3);
			if(vrb.endsWith("ْ")){
				verbe4="ت"+verbe4+"َ"+"يَ"+"ا";
			}else{
				verbe4="ت"+verbe4+"َ"+"ا";}
			String f6=pronom +"\t\t" +verbe4;
			conj1[5]=f6;
			pronom = "هم ";
			verbe_partager=verbe.split("");
			String verbe5 = verbe.substring(1, verbe_partager.length-3);
			if(verbe5.endsWith("و")){
				verbe5="ي"+verbe5+"ا";
			}else{
				if(vrb.endsWith("ْ")){
					verbe5="ي"+verbe5+"ُ"+"و"+"ْ"+"ا";
				}else{
					verbe5="ي"+verbe5+"ُ"+"و"+"ا";
				}
			}
			String f7=pronom +"\t\t" +verbe5;
			conj1[6]=f7;
			return conj1;
		}
		return conj1;
	}

	public static String[] antonna_honna(String pronom,String verbe){
		String [] conj1 = new String[2];
		String[] verbe_partager;
		pronom=delet_space(pronom);
		if(pronom.equals("أنتن") ){
			String f1=pronom +"\t\t" +verbe;
			conj1[0]=f1;

			pronom = "هن ";
			verbe_partager=verbe.split("");
			String verbe1 = verbe.substring(1, verbe_partager.length-1);
			verbe1="ي"+verbe1;
			String f2=pronom +"\t\t" +verbe1;
			conj1[1]=f2;
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
	public static void travail(Cursor cursor1, List modariE){
		int vrb=0;int vrb1=0,vrb2=0;


		String st, rt;
		if (cursor1 != null) {
			if (cursor1.moveToFirst()) {
				do {
					st = cursor1.getString(0);
					rt = cursor1.getString(1);
					String[] conj_verb  =   anta_ana_anahno_howa_hiya(st, rt);
					String[] conj_verb0 =   anti_antoma_antom_homa_hom(st, rt);
					String[] conj_verb1 =   antonna_honna(st, rt);

					if(st.equals("أنتَ")){
						while(vrb<conj_verb.length){
							//all_conj_verb[vrb]=conj_verb[vrb];

							modariE.add(conj_verb[vrb]);
							vrb++;
						}}
					if(st.equals("أنتِ")){
						while(vrb1<conj_verb0.length){
							// int i=vrb+conj_verb.length;
							//all_conj_verb[i]=conj_verb0[vrb];

							modariE.add(conj_verb0[vrb1]);
							vrb1++;
						}}
					if(st.equals("أنتن")){
						while(vrb2<conj_verb1.length){
							//all_conj_verb[vrb]=conj_verb[vrb];

							modariE.add(conj_verb1[vrb2]);
							vrb2++;
						}}




				} while (cursor1.moveToNext());


			}
		}
	}

}
