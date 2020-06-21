package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.database.Cursor;

/**
 * Created by ahmed and redouane on 2016.
 */
public class verbs_prop {
    public static final  String cheda="ّ";
    public static final  String hamza="أ";
    public static final  String hamza1="ء";
    public static final  String hamza2="ئ";
    public static final  String hamza3="ؤ";



    public static boolean isMoutel(String Verbs){
        String verbs_char[]=Verbs.split("");
        if(is_trilitaire(Verbs).equals("ثلاثي")){
            for(int i=0;i<verbs_char.length;i++){

                if (verbs_char[i].equals("ى") ||verbs_char[i].equals("و") ||verbs_char[i].equals("ا") ||verbs_char[i].equals("ي")){
                    return true ;}

            }}return false;

    }

    public static boolean isMoudaef(String Verbs) {
        String verbs_char[]=Verbs.split("");
        if(is_trilitaire(Verbs)=="ثلاثي"){

            if (verbs_char[3].equals(cheda))
                return true ;
        }
        else{
            if (verbs_char[1].equals(verbs_char[3])&&(verbs_char[2].equals(verbs_char[4]))){

            return true;
        }return false;
        }
        return false;
    }

    public static  boolean isMhmouz(String Verbs , boolean hamza_root) {
        String verbs_char[]=Verbs.split("");
if(hamza_root==true){


        for(int i =0; i<verbs_char.length-1;i++){
            if (verbs_char[i].equals(hamza)||verbs_char[i].equals(hamza1)||verbs_char[i].equals(hamza2)||verbs_char[i].equals(hamza3)){

                return true ;
            }
        }
    }
        return false;
    }


    public static String  Noua_Sahih(String Verbs,boolean hamza_root){

        if(!isMoutel(Verbs)){
            if(!isMhmouz(Verbs,hamza_root)){
                if(!isMoudaef(Verbs)){
                    return "سالم";
                }else if(isMoudaef(Verbs))return "مضاعف";
            }else if(isMhmouz(Verbs,hamza_root))return "مهموز";
        }



        return "";
    }

    // pour savoir si le verbs is trilitaire;
    public  static  String is_trilitaire(String Verbs){
        String verbs_char[]=Verbs.split("");

        if(verbs_char.length-1==3){
            return  "ثلاثي" ;}
        return  "غير ثلاثي" ;
    }

    public static String  NouA_ila(String Verbs){
      if(isMoutel(Verbs)){
            //
            String verbs_char[]=Verbs.split("");

            System.out.println(String.valueOf(verbs_char.length));
            if (((verbs_char[1].equals("ى") ||verbs_char[1].equals("و") ||verbs_char[1].equals("ا") ||verbs_char[1].equals("ي"))&&(verbs_char[2].equals("ى") ||verbs_char[2].equals("و") ||verbs_char[2].equals("ا") ||verbs_char[2].equals("ي"))
                    && (verbs_char[3].equals("ى") ||verbs_char[3].equals("و") ||verbs_char[3].equals("ا") ||verbs_char[3].equals("ي")) )){
                return ("الفعل خاطئ");
            }else if (((verbs_char[1].equals("ى") ||verbs_char[1].equals("و") ||verbs_char[1].equals("ا") ||verbs_char[1].equals("ي"))&&(verbs_char[2].equals("ى") ||verbs_char[2].equals("و") ||verbs_char[2].equals("ا") ||verbs_char[2].equals("ي")))
                    ||(	(verbs_char[2].equals("ى") ||verbs_char[2].equals("و") ||verbs_char[2].equals("ا") ||verbs_char[2].equals("ي"))&& (verbs_char[3].equals("ى") ||verbs_char[3].equals("و") ||verbs_char[3].equals("ا") ||verbs_char[3].equals("ي")) )){
                return ("لفيف مقرون");
            }else 	if (((verbs_char[1].equals("ى") ||verbs_char[1].equals("و") ||verbs_char[1].equals("ا") ||verbs_char[1].equals("ي"))&&(verbs_char[3].equals("ى") ||verbs_char[3].equals("و") ||verbs_char[3].equals("ا") ||verbs_char[3].equals("ي")) )){
                return ("لفيف مفروق");
            }else if (verbs_char[1].equals("ى") ||verbs_char[1].equals("و") ||verbs_char[1].equals("ا") ||verbs_char[1].equals("ي")){
                return ("مثال");
            }else 	if (verbs_char[2].equals("ى") ||verbs_char[2].equals("و") ||verbs_char[2].equals("ا") ||verbs_char[2].equals("ي")){

                return ("أجوف");
            }else 	if (verbs_char[3].equals("ى") ||verbs_char[3].equals("و") ||verbs_char[3].equals("ا") ||verbs_char[3].equals("ي")){

                return ("ناقص");
            }
        }

        return "";
    }



}
