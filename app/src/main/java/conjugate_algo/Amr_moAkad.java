package conjugate_algo;

import android.database.Cursor;

import java.util.List;

public class Amr_moAkad {
    static final String sokon="ْ";
	static final String fatha="َ";
	static final String dama="ُ";
	static final String kasra="ِ";
	
	 public Amr_moAkad(Cursor c, List a){
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
	          //  String  verbe1 = verbe.substring(0, verbe_partager.length-3);
	           String abriv= verbe.substring(0, verbe_partager.length-2);
	           String    verbe1="";
	         
	            String ded = verbe.trim();
	            String [] verbe_partager1=ded.split("");
	           String de=ded.substring(0, verbe_partager1.length-5);
	            String dd=ded.substring(0, verbe_partager1.length-4);
	            if((dd.endsWith(sokon)||dd.endsWith(kasra)||dd.endsWith(dama)||dd.endsWith(fatha))&&de.endsWith("و")){
	            	 de=ded.substring(0, verbe_partager1.length-7);
	            	verbe1=de+kasra+"نَّ";
	            }else{
	             verbe1=de+kasra+"نَّ";
	            }

			   pronom="أنتِ";
			   String f2=pronom +"\t\t" +verbe1;
			   conj1[1]=f2;

	               
	            //   String  verbe2 = verbe.substring(0, verbe_partager.length-3);
	               String de1 = verbe.trim();
		            String [] verbe_partager2=de1.split("");
		            de1=de1.substring(0, verbe_partager2.length-5);

	               String verbe2=de1+"َا"+"نِّ";
			   pronom="أنتما(مذكر) " ;
			   String f3=pronom +"\t\t" +verbe2;
			   conj1[2]=f3;



			   pronom="أنتما(مؤنث) " ;
			   String f4=pronom +"\t\t" +verbe2;
			   conj1[3]=f4;

			               
			             //  String  verbe4 = verbe.substring(0, verbe_partager.length-3);
			               String ded2 = verbe.trim();
			               String     verbe4 =ded2;
				            String [] verbe_partager3=ded2.split("");
				           String de2=ded2.substring(0, verbe_partager3.length-5);
				          //  System.out.println("de2 = "+de2.length()+ " egal " +de2);
				            if(de2.length()==3){
				            	  de2=de2.substring(0, verbe_partager3.length-7);
							      verbe4 =de2+dama+"نَّ";
				            }else{
				            	 dd=ded2.substring(0, verbe_partager3.length-4);
				 	            if((dd.endsWith(sokon)||dd.endsWith(kasra)||dd.endsWith(dama)||dd.endsWith(fatha))&&de2.endsWith("و")){
				 	            	
						             
				 	            	de2=ded.substring(0, verbe_partager3.length-7);
				 	            	verbe4 =de2+dama+"نَّ";
				 	            }else{
				 	            	de2=de2.substring(0, verbe_partager3.length-5);
						             verbe4 =de2+dama+"نَّ";
				 	            }
				            
				            }
			   pronom="أنتم " ;
			   String f5=pronom +"\t\t" +verbe4;
			   conj1[4]=f5;

				               
				             //  String  verbe5 = verbe.substring(0, verbe_partager.length-3);
				               String ded3 = verbe.trim();
				               String   verbe5=ded3;
					            String [] verbe_partager4=ded3.split("");
					            String  de3=ded3.substring(0, verbe_partager4.length-5);
					            if(verbe_partager4[3].equals("و") || verbe_partager4[3].equals("ي") ){
					            	StringBuffer sb = new StringBuffer(ded3);
					            	
					            	
					            	
					            	if(ded3.length()!=3){
					            sb.setCharAt(2, 'ـ');
					            ded3=sb.toString();	
					            	 de3=ded3.substring(0, verbe_partager4.length-5);
					            	 verbe5=de3+sokon+"نَا"+"نِّ";
					            	String[] verbe_partager5=verbe5.split("");
					            	 ///////////
					            	
						            	if(verbe_partager5[4].equals("ن")&&verbe_partager5[5].equals(sokon)){
						            		
						            		 de3=ded3.substring(0, verbe_partager4.length-7);
						            		 verbe5=de3+"نَّا"+"نِّ";
						            	}else{ 
						            		sb.setCharAt(2, 'ي');
								            ded3=sb.toString();	
								            	 de3=ded3.substring(0, verbe_partager4.length-5);
						            		verbe5=de3+sokon+"نَا"+"نِّ";
						            		}
						            
					            	}else{
					            		
						            	verbe5=de3+sokon+"نَا"+"نِّ";
					            	}
					            }else{
					            	 dd=ded3.substring(0, verbe_partager3.length-4);
						 	            if((dd.endsWith(sokon)||dd.endsWith(kasra)||dd.endsWith(dama)||dd.endsWith(fatha))&&de3.endsWith("و")){
						 	            	
								             
						 	            	de3=ded3.substring(0, verbe_partager3.length-6);
						 	            	verbe5=de3+"نَا"+"نِّ";
						 	            }else{
						 	            	de3=ded3.substring(0, verbe_partager4.length-5);
								             verbe5=de3+sokon+"نَا"+"نِّ";
						 	            }
					            	
					            }
			   pronom="أنتن " ;
			   String f6=pronom +"\t\t" +verbe5;
			   conj1[5]=f6;

		               
	               
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
