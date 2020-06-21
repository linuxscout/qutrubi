package verbs.conjugate.qutrubi.aplication_qutrubi_v12;

import android.app.Activity;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ahmed on 06/05/16.
 */
;import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by ahmed on 06/05/16.
 */
;
public class MainIntrnet extends Activity {

    /*
     *first we cerate the constant for my projet XML
     */

    private ListView l;
    private Adapter adapt;
    private ArrayList<Item> array = new ArrayList();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_intrnet);

        Button back = (Button) findViewById(R.id.Back) ;
        l=(ListView)findViewById(R.id.maList);

        AsyncDownloader asyncDownloader=new AsyncDownloader();

        asyncDownloader.execute();


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    private void handNewRecod(String tense,String prnoun ,  String verb  ){


        Item item = new Item();


        item.setTense(tense);
        item.setPronoun(prnoun);
        item.setVerb(verb);


        array.add(item);
        adapt = new Adapter(this, R.layout.list_item_intenet, array);
        l.setAdapter(adapt);
        adapt.notifyDataSetChanged();
    }


    /*
    we cerate class for backgroun dowlaond
     */
    
    public class AsyncDownloader extends AsyncTask<Object,String,Integer> {

        @Override
        protected Integer doInBackground(Object... params) {
            XmlPullParser recivedData = tryDownloadingXMlData();
            int RecordsFound = tryParsingData(recivedData);
            return RecordsFound;
        }

        private int tryParsingData(XmlPullParser recivedData) {
            if (recivedData != null) {
                try {
                    return ProcessRecivedData(recivedData);
                } catch (XmlPullParserException e) {

                } catch (IOException e) {

                }
            }
            return 0;
        }

        private int ProcessRecivedData(XmlPullParser xmlData) throws IOException, XmlPullParserException {
            int eventType = -1;
            int recordsFound = 0;

// fin valuse from XML

            String AppId = "";
            String ItemId = "";
            String TimeStamp = "";
            String data = "";
            while (eventType != XmlResourceParser.END_DOCUMENT) {
                String tagName = xmlData.getName();
                switch (eventType) {

                    case XmlResourceParser.START_TAG:
                        if (tagName.equals("tense")) {
                             AppId = xmlData.getAttributeValue(null, "name");
                        }
                        if (tagName.equals("conjugation")) {
                            TimeStamp = xmlData.getAttributeValue(null, "pronoun");
                            ItemId = xmlData.getAttributeValue(null, "value");
                            data = "";
                        }


                        break;
                    case XmlResourceParser.TEXT:
                        data += xmlData.getText();
                        break;

                    case XmlResourceParser.END_TAG:
                        if (tagName.equals("conjugation")) {
                            recordsFound++;
                            publishProgress(AppId, ItemId, TimeStamp, data);

                        }
                        break;


                }
                eventType = xmlData.next();
            }
            if (recordsFound == 0) {
                publishProgress();
            }
            return recordsFound;
            // return 0;
        }



        private XmlPullParser tryDownloadingXMlData() {
            String  QUIRY_URL ="http://qutrub.arabeyes.org/?verb="+verbs()+"&all=1&transitive=1&past=1&future=1&imperative=1&passive=1&future_moode=1&confirmed=1&haraka=%D9%81%D8%AA%D8%AD%D8%A9&display_format=XML";


            try {
                URL XmlUrl = new URL(QUIRY_URL);
                XmlPullParser recivedData = XmlPullParserFactory.newInstance().newPullParser();
                recivedData.setInput(XmlUrl.openStream(), null);
                return recivedData;
            } catch (XmlPullParserException e) {
            } catch (IOException e) {

            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            String tense ;
            String pronoun;
            String verb;
            if (values.length == 0) {

            }
            if (values.length == 4) {

                tense = values[0];
                pronoun = values[1];
                verb = values[2];

                handNewRecod(tense, pronoun, verb);





            }
        }


    }

    public  String verbs (){

        Bundle bundle = getIntent().getExtras();
        String new_verb= bundle.getString("new_verbs");
        try{
            String url =
                    new_verb;
            String result = java.net.URLEncoder.encode(url, "UTF-8");
            return  result;

        }
        catch(Exception E){
        }



        return  null;
    }

}
