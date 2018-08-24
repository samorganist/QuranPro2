package samorganist.com.quranpro2.Utils;

/**
 * Created by Samorganist on 24/08/2018.
 */

public  class StringsOperations {

    public static String getFilePathFromPage(int nb_page){
        String path;
        String stpage=String.valueOf(nb_page);
        if(nb_page<10){
            stpage="00"+String.valueOf(nb_page);
        }else if (nb_page>10&&nb_page<100){
            stpage="0"+String.valueOf(nb_page);
        }
        path="Quran/"+"page"+stpage+".png";

        return path;
    }
}
