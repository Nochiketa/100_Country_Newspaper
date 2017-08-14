package com.example.nochiketa.hey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.R.attr.name;

/**
 * Created by Nochiketa on 8/2/2017.
 */
public class Main2Activity extends AppCompatActivity {
    ListView listView;
    String[] val;
    String name;
    AdView mAdview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = getIntent().getStringExtra("name");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

      // Bundle extras = getIntent().getExtras();
        //final int position = extras.getInt("name");

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        listView = (ListView) findViewById(R.id.list2);

        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        if(name.equals("USA"))
        {
            setTitle("USA Newspapers");
            val = new String[] {"The Washington Post", "The New York Post", "The Wall Street Journal",
                    "Chicago Tribune", "Las Vegas Sun", "USA Today", "The Washington Times",
                    "The Boston Hehald", "The Dallas News", "The Advocate"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("India"))
        {
            setTitle("India Newspapers");
            val = new String[] {"The Times of India", "The Hindu", "The Hindustan Times",
                    "The Indian Express", "The Sandesh", "The Tribune", "The Ananda Bazar",
                    "The Mumbai Mirror", "The Jagaran", "The Lokmat"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Bangladesh"))
        {
            setTitle("Bangladesh Newspapers");
            val = new String[] {"The Prothom-Alo", "The Jugantor", "The Kaler Kontho",
                    "The Samakal", "The Ittefaq", "The Daily Star", "The Amar Desh",
                    "The Bangladesh Observer", "The Naya Diganta", "The Jonokontho"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("United Kingdom"))
        {
            setTitle("UK Newspapers");
            val = new String[] {"The Daily Telegraph", "The Guardian", "The Daily Mail",
                    "The Independent", "The Times", "The Mirror", "The Sun",
                    "The Express", "The Observer", "The Morning Star"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Russia"))
        {
            setTitle("Russia Newspapers");
            val = new String[] {"The Pravada", "The Novaya Gazetta", "The Komersant",
                    "The Izvestia", "The Komsomolskya Pravada", "The Argumenty i Fakty",
                    "The Nezavisimaya Gazeta", "The Trud", "The Rosiskya Gazeta", "The Sport Express"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Australia"))
        {
            setTitle("Australia Newspapers");
            val = new String[] {"The Australian", "The Herald Sun", "The Daily Telegraph",
                    "The Sydney Morning Herald", "The Advertiser", "The Courier-Mail", "The West Australian",
                    "The Age", "The Sunday Times", "The Australian Financial Review"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
       else if(name.equals("Canada"))
        {
            setTitle("Canada Newspapers");
            val = new String[] {"The Medium", "The Star", "The Globe and Mail",
                    "The National Post", "The Calgary Herald", "The Montreal Gazette", "The Toronto Sun",
                    "The London Free Press", "The Financial Post", "The Telegram"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("France"))
        {
            setTitle("France Newspapers");
            val = new String[] {"The Le Monde", "The Le Figaro", "The Le Perisian",
                    "The Liberation", "The Lesechos", "The Lequipe", "The 20 Minutes",
                    "The Ouest-France", "The L'Humanite", "The La Croix"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Germany"))
        {
            setTitle("Germany Newspapers");
            val = new String[] {"The Bild", "The Sudeutsche Zeitung", "The Die Weilt",
                    "The Die Zeit", "The Die Tageszeitung", "The Frankfurter Rundschau", "The Handelsblatt",
                    "The Berliner Morgenpost", "The Der Taggespiegel", "The Kurier"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
         else if(name.equals("Japan"))
        {
            setTitle("Japan Newspapers");
            val = new String[] {"The Yomiuri Shimbun", "The Japan Times", "The Asahi Shimbun",
                    "The Mainichi Shimbun", "The Sankei Shimbun", "The Chunichi Shimbun", "The Japan Today",
                    "The Nishinippon Shimbun", "The Tokyo Sports", "The Tokyo Shimbun"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("China"))
        {
            setTitle("China Newspapers");
            val = new String[] {"The Chaina Daily", "The People's Daily", "The South Chain Morning Post",
                    "The Sanghai Daily", "The Chaina Press", "The Chaina Post", "The Chaina Times",
                    "The Sanghai Star", "The Legal Daily", "The Xinhua Daily"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

      else if(name.equals("South Africa"))
        {
            setTitle("South Africa Newspapers");
            val = new String[] {"The Mail and Guardian", "The Swoetan", "The City Press", "The Star",
                    "The Cape Times", "The Cape Argus", "The Sunday Times",
                    "The Beld", "The Times", "The Daily Sun"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Spain"))
        {
            setTitle("Spain Newspapers");
            val = new String[] {"The El Pias", "The Elmundo", "The Marca", "The ABC",
                    "The El Periodico de Cataluniya", "The Cinco Dias", "The El Correo",
                    "The La Razon", "The Diario AS", "The Expansion"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Pakistan"))
        {
            setTitle("Pakistan Newspapers");
            val = new String[] {"The Dawn", "The News International", "The Daily Jang",
                    "The National", "The Daily Times", "The Daily Express", "The Pakistan",
                    "The Nawa-I-Waqt", "The Front Post", "The Pakistan Observer"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Italy"))
        {
            setTitle("Italy Newspapers");
            val = new String[] {"The Corriere Della Cera", "The La Reppublica", "The La Stumpa",
                    "The La Gezzetta Delo Sport", "The Messaggero", "The Sole 24 Ore",
                    "The Giornale", "The Mattino", "The L'Unita", "The Libero"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("South Korea"))
        {
            setTitle("South Korea Newspapers");
            val = new String[] {"The Chosun Ilbo", "The Korea Times", "The Korea Herald",
                    "The Hankyoreh", "The Hankook Ilbo", "The Seoul Shinmun", "The Korea Economic Daily",
                    "The JoongAng Dailay" , "The Maeil Businees Newspaper", "The Kukmin Daily"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("North Korea"))
        {
            setTitle("North Korea Newspapers");
            val = new String[] {"The North Korea Times", "The North Korea News",
                    "The Daily North Korea", "The Korea Times", "The Korea Herald"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Indonesia"))
        {
            setTitle("Indonesia Newspapers");
            val = new String[] {"The Kompas", "The Jakarta Post", "The Bisnis Indonesia",
                    "The Pikiran Rakiyat", "The Saura Merdeka", "The Jawa Pos", "The Jakarta Globe",
                    "The Republica" , "The Media Indonesia", "The Koran Tempo"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

       else if(name.equals("Switzerland"))
        {
            setTitle("Switzerland Newspapers");
            val = new String[] {"The Neue Zurcher Zeitung", "The Tages-Anzeiger", "The Le Temps",
                    "The Blick", "The Basler Zeitung", "The 24 Heures", "The Berner Zeitung",
                    "The Le Matin" , "The 20 Minuten", "The St. Galler Tagblatt"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

          else if(name.equals("Argentina"))
        {
            setTitle("Argentina Newspapers");
            val = new String[] {"The Clarin", "The La Nacion", "The El Cronista", "The Pagin/12",
                    "The Cronica", "The Ambito Financiero", "The Buenos Aires Herald",
                    "The La Voz Del Interior" , "The Ole", "The El Dia"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Turkey"))
       {
            setTitle("Turkey Newspapers");
            val = new String[] {"The Cumhuriyet", "The Hurriyet Daily News", "The Hurriyet",
                    "The Sabah", "The Miliyet", "The Haberturk", "The Yeni Safak", "The Sozcu",
                    "The Posta", "The Vatan"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        else if(name.equals("Vietnam"))
        {
            setTitle("Vietnam Newspapers");
            val = new String[] {"The VN Express", "The Nhan Dan", "The Viet Nam News",
                    "The Thanh Nien", "The Tuoi Tre", "The Sai Gon Giai Phong", "The Quan Doi Nhan Dan",
                    "The Le Courrier De Vietnam", "The Nguoi Viet Daily News", "The Little Saigon News"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Austria"))
        {
            setTitle("Austria Newspapers");
            val = new String[] {"The Die Presse", "The Kronen Zeitung", "The Der Standard",
                    "The Wiener Zeitung", "The Kurier", "The Kleine Zeitung", "The Salzburger Nachrichten",
                    "The Österreich", "The WirtschaftsBlatt", "The Vienna Review"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Nepal"))
        {
            setTitle("Nepal Newspapers");
            val = new String[] {"The Kantipur", "The Annapurna Post", "The Nagarik",
                    "The Nepali Times", "The Karobar Economic Daily", "The Naya Patrika"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Sri Lanka"))
        {
            setTitle("Sri Lanka Newspapers");
            val = new String[] {"The Daily Mirror", "The Sunday Times", "The Sunday Leader",
                    "The Lankadeepa", "The Uthayan", "The Virakesari", "The Lakbima",
                    "The Rivira", "The Thinakkural", "The Mawbima"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Portugal"))
        {
            setTitle("Portugal Newspapers");
            val = new String[] {"Público", "Diário de Notícias", "Jornal de Notícias",
                    "Correio da Manhã", "Expresso", "O Jogo", "Jornal de Negócios",
                    "Diário Económico", "Destak", "Sol"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Brazil"))
        {
            setTitle("Brazil Newspapers");
            val = new String[] {"Folha de S.Paulo", "O Globo", "Estadão",
                    "The Rio Times", "Jornal do Brasil", "Valor Econômico", "O Dia",
                    "Diário de Pernambuco", "Correio do Povo", "Zero Hora"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Sweden"))
        {
            setTitle("Sweden Newspapers");
            val = new String[] {"Aftonbladet", "Dagens Nyheter", "Svenska Dagbladet",
                    "Expressen", "Göteborgs-Posten", "Dagens Industri", "Sydsvenskan",
                    "Arbetarbladet", "Norran", "Västerbottens-Kuriren"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Denmark"))
        {
            setTitle("Denmark Newspapers");
            val = new String[] {"Politiken", "Copenhagen Post", "Borsen",
                    "Fyens Stiftstidende", "JydskeVestkysten", "Weekendavisen", "Kristeligt Dagblad",
                    "Nordjyske Stiftstidende", "Midtjyllands Avis", "Västerbottens-Kuriren"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Cuba"))
        {
            setTitle("Cuba Newspapers");
            val = new String[] {"Granma", "Juventud Rebelde", "Miami Herald",
                    "Trabajadores", "Tribuna de La Habana", "Ahora", "Escambray",
                    "Girón", "Guerrillero", "Venceremos"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Egypt"))
        {
            setTitle("Egypt Newspapers");
            val = new String[] {"Daily News Egypt", "Al-Ahram", "Youm7",
                    "Egypt Independent", "Almasry Alyoum", "Al-Shorouk", "Al-Wafd",
                    "Al-Dustour", "Akhbar el-Yom", "Al Akhbar"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Mexico"))
        {
            setTitle("Mexico Newspapers");
            val = new String[] {"The News", "La Jornada", "El Norte",
                    "Reforma", "Milenio", "Excélsior", "El Mañana",
                    "El Siglo de Torreón", "la prensa de méxico", "Santa Fe New Mexican"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Iran"))
        {
            setTitle("Iran Newspapers");
            val = new String[] {"The Iran", "The Kayhan", "Ettela'at",
                    "Shargh", "Etemaad", "Jomhouri eslami", "Tehran Times",
                    "Resalat", "Aftab Yazd", "Hamshahri"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Belgium"))
        {
            setTitle("Belgium Newspapers");
            val = new String[] {"De Morgen", "Le Soir", "De Standaard",
                    "Het Laatste Nieuws", "L'Echo", "Het Nieuwsblad", "La Dernière Heure",
                    "De Tijd", "Aftab Yazd", "Hamshahri"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Saudi Arabia"))
        {
            setTitle("Saudi Arabia Newspapers");
            val = new String[] {"Arab News", "Al Riyadh", "Saudi Gazette",
                    "Al Jazirah", "Al Watan", "Okaz", "Al Eqtisadiah",
                    "Al Madina", "Urdu News"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Sudan"))
        {
            setTitle("Sudan Newspapers");
            val = new String[] {"Sudan Vision Daily", "Sudan Tribune"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Czech Republic"))
        {
            setTitle("Czech Republic Newspapers");
            val = new String[] {"Mladá fronta DNES", "Právo", "Lidové noviny",
                    "The Prague Post", "Blesk", "Hospodářské noviny", "Haló noviny",
                    "Aha!", "Prague Business Journal", "Pravý Břeh"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Bhutan"))
        {
            setTitle("Bhutan Newspapers");
            val = new String[] {"Kuensel", "The Bhutanese", "Bhutan Observer",
                    "Bhutan Times", "Bhutan Today","Business Bhutan", "The Journalist", "Druk Yoedzer",
                    };

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("United Arab Emirates"))
        {
            setTitle("Czech Republic Newspapers");
            val = new String[] {"Gulf News", "Khaleej Times", "The National",
                    "Al Bayan", "Al Khaleej", "Al-Ittihad", "The Gulf Today",
                    "7days", "Emirates Business 24/7", "Al Wahda"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Hong Kong"))
        {
            setTitle("Hong Kong Newspapers");
            val = new String[] {"South China Morning Post", "Ming Pao", "Apple Daily",
                    "Sing Tao Daily", "Wen Wei Po", "Oriental Daily", "The Standard",
                    "Hong Kong Economic Journal", "Hong Kong Commercial Daily", "Sing Pao"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("New Zealand"))
        {
            setTitle("New Zealand Newspapers");
            val = new String[] {"New Zealand Herald", "The Press", "dominion post",
                    "Otago Daily Times", "Waikato Times", "Southland Times", "Nelson Mail",
                    "Timaru Herald", "The Sunday Star-Times", "Manawatu Standard"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Singapore"))
        {
            setTitle("Singapore Newspapers");
            val = new String[] {"Straits Times", "The Today", "Lianhe Zaobao",
                    "The New Paper", "The Business Times", "Berita Harian", "Tamil Murasu",
                    "My Paper", "Lianhe Wanbao", "Shin Min Daily News"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Norway"))
        {
            setTitle("Norway Newspapers");
            val = new String[] {"Aftenposten", "Dagbladet", "Bergens Tidende",
                    "Adresseavisen", "Stavanger Aftenblad", "Dagens Næringsliv", "Dagsavisen",
                    "Fædrelandsvennen", "Bergensavisen", "ITromsø"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Ukrain"))
        {
            setTitle("Ukrain Newspapers");
            val = new String[] {"Zerkalo Nedeli", "Kyiv Post", "Fakty i Kommentarii",
                    "DELO", "Uryadovy Kuryer"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Scotland"))
        {
            setTitle("Scotland Newspapers");
            val = new String[] {"The Herald", "The Scotsman", "Daily Record",
                    "Daily Record", "The Courier", "The National", "Edinburgh Evening News",
                    "The Sun", "The Sunday Post", "Sunday Herald"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Venezuela"))
        {
            setTitle("Venezuela Newspapers");
            val = new String[] {"El Universal", "Últimas Noticias", "El Carabobeño",
                    "La Verdad", "Tal Cual", "Diario 2001", "El Informador",
                    "Correo del Orinoco", "El Mundo", "Diario Panorama"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Angola"))
        {
            setTitle("Angola Newspapers");
            val = new String[] {"Club-K Angola", "Ebonet Noticias", "Folha 8",
                    "Journal De Angola"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Iraq"))
        {
            setTitle("Iraq Newspapers");
            val = new String[] {"Azzaman", "Al Mada", "Al-Mashriq",
                    "Al-Iraq", "Xebat", "The Kurdish Globe", "Al Sabaah",
                    "Hawlati", "Al-Mutamar", "Iraq Today"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Tunisia"))
        {
            setTitle("Tunisia Newspapers");
            val = new String[] {"Babnet Tunisie", "Info Tunisie", "Tunis Daily News",
                    "Tunis Times", "Tunisia Daily", "Tunisie Focus", "Assabah"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }
        else if(name.equals("Bahrain"))
        {
            setTitle("Bahrain Newspapers");
            val = new String[] {"Al-Wasat", "Gulf Daily News", "Al Ayam",
                    "Akhbar Al Khaleej", "Al-Watan", "Daily Tribune", "Al Bilad","Al-Waqt","Chandrika"};

            ListAdapter listAdapter = new ArrayAdapter<String>(this, R.layout.item, R.id.TV, val);
            listView.setAdapter(listAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                Intent intent= new Intent(Main2Activity.this, Main3Activity.class);
                //intent.putExtra("POS", pos);
                //intent.putExtra("POSITION", position);

                intent.putExtra("paper", adapterView.getItemAtPosition(pos).toString());
                intent.putExtra("Country", name);
               // intent.putExtra("POSITION", position);
                startActivity(intent);
            }
        });

    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();


        if(id == R.id.action_home)
        {
            Intent i = new Intent(Main2Activity.this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
        if(id == R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}