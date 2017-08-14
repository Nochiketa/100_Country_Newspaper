package com.example.nochiketa.hey;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

public class Main3Activity extends AppCompatActivity {
    private WebView myWebView;
    String country, paper;
    AdView mAdview;
    //private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        //Bundle extras = getIntent().getExtras();
        //int position1 = extras.getInt("POSITION");
        //int position2 = extras.getInt("POS");
        country = getIntent().getStringExtra("Country");
        paper = getIntent().getStringExtra("paper");

        myWebView = (WebView)findViewById(R.id.wb);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        myWebView.getSettings().setBuiltInZoomControls(true);
        myWebView.getSettings().setDisplayZoomControls(false);

        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo ninfo = cManager.getActiveNetworkInfo();
        if(ninfo != null && ninfo.isConnected())
        {
            ProgressDialog pdialog=new ProgressDialog(this);
            pdialog.setTitle("Loading");
            pdialog.setCancelable(true);
            pdialog.setMessage("Loading .... Please Wait");
            pdialog.show();

            if(country.equals("USA"))
            {
                if(paper.equals("The Washigton Post"))
                {
                    setTitle("The Washington Post");
                    myWebView.loadUrl("https://www.washingtonpost.com/");
                }
                else if(paper.equals("The New York Post"))
                {
                    setTitle("The New York Post");
                    myWebView.loadUrl("http://nypost.com/");
                }
                else if(paper.equals("The Wall Street Journal"))
                {
                    setTitle("The Wall Street Journal");
                    myWebView.loadUrl("https://www.wsj.com/asia");
                }
                else if(paper.equals("The Chicago Tribune"))
                {
                    setTitle("The Chicago Tribune");
                    myWebView.loadUrl("http://www.chicagotribune.com/");
                }
                else if(paper.equals("The Las Vegas Sun"))
                {
                    setTitle("The Las Vegas Sun");
                    myWebView.loadUrl("https://lasvegassun.com/");
                }
                else if(paper.equals("The USA Today"))
                {
                    setTitle("The USA Today");
                    myWebView.loadUrl("http://www.usatoday.com/");
                }
                else if(paper.equals("The Washington Times"))
                {
                    setTitle("The Washington Times");
                    myWebView.loadUrl("http://www.washingtontimes.com/");
                }
                else if(paper.equals("The Boston Herald"))
                {
                    setTitle("The Boston Herald");
                    myWebView.loadUrl("http://www.bostonherald.com/");
                }
                else if(paper.equals("The Dallas News"))
                {
                    setTitle("The Dallas News");
                    myWebView.loadUrl("http://www.dallasnews.com/");
                }
               else if(paper.equals("The Advocate"))
                {
                    setTitle("The Advocate");
                    myWebView.loadUrl("http://www.theadvocate.com/");
                }
            }
            else if(country.equals("India"))
            {
                if(paper.equals("The Times of India")) {
                    setTitle("The Times of India");
                    myWebView.loadUrl("http://timesofindia.indiatimes.com/");
                }
                else if(paper.equals("The Hindu"))
                {
                    setTitle("The Hindu");
                    myWebView.loadUrl("http://www.thehindu.com/");
                }
                else if(paper.equals("The Hindustan Times"))
                {
                    setTitle("The Hindustan Times");
                    myWebView.loadUrl("http://www.hindustantimes.com/");
                }
                else if(paper.equals("The Indian Express"))
                {
                    setTitle("The Indian Express");
                    myWebView.loadUrl("http://indianexpress.com/");
                }
                else if(paper.equals("The Sandesh"))
                {
                    setTitle("The Sandesh");
                    myWebView.loadUrl("http://sandesh.com/");
                }
                else if(paper.equals("The Tribune"))
                {
                    setTitle("The Tribune");
                    myWebView.loadUrl("http://www.tribuneindia.com/");
                }
                else if(paper.equals("The Ananda Bazar"))
                {
                    setTitle("The Ananda Bazar");
                    myWebView.loadUrl("http://www.anandabazar.com/");
                }
                else if(paper.equals("The Mumbai Mirror"))
                {
                    setTitle("The Mumbai Mirror");
                    myWebView.loadUrl("http://mumbaimirror.indiatimes.com/");
                }
                else if(paper.equals("The Jagaran"))
                {
                    setTitle("The Jagaran");
                    myWebView.loadUrl("http://www.jagran.com/");
                }
                else if(paper.equals("The Lokmat"))
                {
                    setTitle("The Lokmat");
                    myWebView.loadUrl("http://www.lokmat.com/");
                }
            }
            else if(country.equals("Bangladesh"))
            {
                if(paper.equals("The Prothom-Alo"))
                {
                    setTitle("The Prothom-Alo");
                    myWebView.loadUrl("http://www.prothom-alo.com/");
                }
                if(paper.equals("The Jugantor"))
                {
                    setTitle("The Jugantor");
                    myWebView.loadUrl("http://www.jugantor.com/");
                }
                if(paper.equals("The Kaler Kontho"))
                {
                    setTitle("The Kaler Kontho");
                    myWebView.loadUrl("http://www.kalerkantho.com/");
                }
                if(paper.equals("The Samakal"))
                {
                    setTitle("The Samakal");
                    myWebView.loadUrl("http://bangla.samakal.net/");
                }
                if(paper.equals("The Ittefaq"))
                {
                    setTitle("The Ittefaq");
                    myWebView.loadUrl("http://www.ittefaq.com.bd/");
                }
                if(paper.equals("The Daily Star"))
                {
                    setTitle("The Daily Star");
                    myWebView.loadUrl("http://www.thedailystar.net/");
                }
                if(paper.equals("The Amardesh Desh"))
                {
                    setTitle("The Amar Desh");
                    myWebView.loadUrl("http://www.amardesh.com/");
                }
                if(paper.equals("The Bangladesh Observer"))
                {
                    setTitle("The Bangladesh Observer");
                    myWebView.loadUrl("http://www.observerbd.com/");
                }
                if(paper.equals("The Naya Diganta"))
                {
                    setTitle("The Naya Diganta");
                    myWebView.loadUrl("http://www.dailynayadiganta.com/");
                }
                if(paper.equals("The Jonokontho"))
                {
                    setTitle("The Jonokontho");
                    myWebView.loadUrl("https://www.dailyjanakantha.com/");
                }
            }
            else if(country.equals("United Kingdom"))
            {
                if(paper.equals("The Daily Telegraph"))
                {
                    setTitle("The Daily Telegraph");
                    myWebView.loadUrl("http://www.telegraph.co.uk/");
                }
                if(paper.equals("The Guardian"))
                {
                    setTitle("The Guardian");
                    myWebView.loadUrl("https://www.theguardian.com/international");
                }
                if(paper.equals("The Daily Mail"))
                {
                    setTitle("The Daily Mail");
                    myWebView.loadUrl("http://www.dailymail.co.uk/home/index.html");
                }
                if(paper.equals("The Independent"))
                {
                    setTitle("The Independent");
                    myWebView.loadUrl("http://www.independent.co.uk/?CMP=ILC-refresh");
                }
                if(paper.equals("The Times"))
                {
                    setTitle("The Times");
                    myWebView.loadUrl("http://www.thetimes.co.uk/");
                }
                if(paper.equals("The Mirror"))
                {
                    setTitle("The Mirror");
                    myWebView.loadUrl("http://www.mirror.co.uk/");
                }
                if(paper.equals("The Sun"))
                {
                    setTitle("The Sun");
                    myWebView.loadUrl("https://www.thesun.co.uk/");
                }
                if(paper.equals("The Express"))
                {
                    setTitle("The Express");
                    myWebView.loadUrl("http://www.express.co.uk/");
                }
                if(paper.equals("The Observer"))
                {
                    setTitle("The Observer");
                    myWebView.loadUrl("https://www.theguardian.com/observer");
                }
                if(paper.equals("The Morning Star"))
                {
                    setTitle("The Morning Star");
                    myWebView.loadUrl("https://www.morningstaronline.co.uk/");
                }
            }
            else if(country.equals("Russia"))
            {

                if(paper.equals("The Pravada"))
                {
                    setTitle("The Pravada");
                    myWebView.loadUrl("http://www.pravdareport.com/");
                }
                if(paper.equals("The Novaya Gazetta"))
                {
                    setTitle("The Novaya Gazetta");
                    myWebView.loadUrl("http://www.pravdareport.com/");
                }
                if(paper.equals("The Komersant"))
                {
                    setTitle("The Komersant");
                    myWebView.loadUrl("http://www.kommersant.ru/");
                }
                if(paper.equals("The Izvestia"))
                {
                    setTitle("The Izvestia");
                    myWebView.loadUrl("http://izvestia.ru/");
                }
                if(paper.equals("The Komsomolskya Pravada"))
                {
                    setTitle("The Komsomolskya Pravada");
                    myWebView.loadUrl("http://www.kp.ru/");
                }
                if(paper.equals("The Argumenty i Fakty"))
                {
                    setTitle("The Argumenty i Fakty");
                    myWebView.loadUrl("http://www.aif.ru/");
                }
                if(paper.equals("The Nezavisimaya Gazeta"))
                {
                    setTitle("The Nezavisimaya Gazeta");
                    myWebView.loadUrl("http://www.ng.ru/");
                }
                if(paper.equals("The Trud"))
                {
                    setTitle("The Trud");
                    myWebView.loadUrl("http://www.express.co.uk/");
                }
                if(paper.equals("The Rosiskya Gazeta"))
                {
                    setTitle("The Rosiskya Gazeta");
                    myWebView.loadUrl("http://www.mk.ru/");
                }
                if(paper.equals("The Sport Express"))
                {
                    setTitle("The Sport Express");
                    myWebView.loadUrl("http://www.sport-express.ru/");
                }
            }
           else if(country.equals("Australia"))
            {

                if(paper.equals("The Australian"))
                {
                    setTitle("The Australian");
                    myWebView.loadUrl("http://www.theaustralian.com.au/");
                }
                if(paper.equals("The Herald Sun"))
                {
                    setTitle("The Herald Sun");
                    myWebView.loadUrl("http://www.heraldsun.com.au/");
                }
                if(paper.equals("The Daily Telegraph"))
                {
                    setTitle("The Daily Telegraph");
                    myWebView.loadUrl("http://www.dailytelegraph.com.au/");
                }
                if(paper.equals("The Sydney Morning Herald"))
                {
                    setTitle("The Sydney Morning Herald");
                    myWebView.loadUrl("http://www.smh.com.au/");
                }
                if(paper.equals("The Advertiser"))
                {
                    setTitle("The Advertiser");
                    myWebView.loadUrl("http://www.adelaidenow.com.au/");
                }
                if(paper.equals("The Courier-Mail"))
                {
                    setTitle("The Courier-Mail");
                    myWebView.loadUrl("http://www.couriermail.com.au/");
                }
                if(paper.equals("The West Australian"))
                {
                    setTitle("The West Australian");
                    myWebView.loadUrl("http://perthcatholic.org.au/Home.htm?gclid=Cj0KEQiA25rFBRC8rfyX1vjeg7YBEiQAFIb3bzBMkWAQcfE_Zr84aV2PxaRyzg4KKPgAtMUlsikVITUaAorj8P8HAQ");
                }
                if(paper.equals("The Age"))
                {
                    setTitle("The Age");
                    myWebView.loadUrl("http://www.theage.com.au/");
                }
                if(paper.equals("The Sunday Times"))
                {
                    setTitle("The Sunday Times");
                    myWebView.loadUrl("http://www.perthnow.com.au/");
                }
                if(paper.equals("The Australian Financial Review"))
                {
                    setTitle("The Australian Financial Review");
                    myWebView.loadUrl("https://subscribers.afr.com/subscribe-all/?eid=cpc:nnn-16omntA0367-acq-GA-06102016-Daily_Habit-nnn-FTR-nnn-AFR-nnn&campaign_code=Daily_Habit&promote_channel=AFR_A_SEM_GA_FTR&gclid=Cj0KEQiA25rFBRC8rfyX1vjeg7YBEiQAFIb3bwgob0SEiShmpRhmfs20Lx5ZxJDrHWXlfJpNYtOleSwaAoha8P8HAQ");
                }
            }
            else if(country.equals("Canada"))
            {
                if(paper.equals("The Medium"))
                {
                    setTitle("The Medium");
                    myWebView.loadUrl("https://themedium.ca/");
                }
                if(paper.equals("The Star"))
                {
                    setTitle("The Star");
                    myWebView.loadUrl("https://www.thestar.com/");
                }
                if(paper.equals("The Globe and Mail"))
                {
                    setTitle("The Globe and Mail");
                    myWebView.loadUrl("http://www.theglobeandmail.com/");
                }
                if(paper.equals("The National Post"))
                {
                    setTitle("The National Post");
                    myWebView.loadUrl("http://www.nationalpost.com/index.html");
                }
                if(paper.equals("The Calgary Herald"))
                {
                    setTitle("The Calgary Herald");
                    myWebView.loadUrl("http://calgaryherald.com/");
                }
                if(paper.equals("The Montreal Gazette"))
                {
                    setTitle("The Montreal Gazette");
                    myWebView.loadUrl("http://montrealgazette.com/");
                }
                if(paper.equals("The Toronto Sun"))
                {
                    setTitle("The Toronto Sun");
                    myWebView.loadUrl("http://www.torontosun.com/");
                }
                if(paper.equals("The London Free Press"))
                {
                    setTitle("The London Free Press");
                    myWebView.loadUrl("http://www.lfpress.com/");
                }
                if(paper.equals("The Financial Post"))
                {
                    setTitle("The Financial Post");
                    myWebView.loadUrl("http://www.financialpost.com/index.html");
                }
                if(paper.equals("The Telegram"))
                {
                    setTitle("The Telegram");
                    myWebView.loadUrl("http://www.thetelegram.com/");
                }
            }
           else if(country.equals("France"))
            {
                if(paper.equals("The Le Monde"))
                {
                    setTitle("The Le Monde");
                    myWebView.loadUrl("http://www.lemonde.fr/");
                }
                if(paper.equals("The Le Figaro"))
                {
                    setTitle("The Le Figaro");
                    myWebView.loadUrl("http://www.lefigaro.fr/");
                }
                if(paper.equals("The Le Parisien"))
                {
                    setTitle("The Le Parisien");
                    myWebView.loadUrl("http://www.leparisien.fr/");
                }
                if(paper.equals("The Liberation"))
                {
                    setTitle("The Liberation");
                    myWebView.loadUrl("http://www.liberation.fr/");
                }
                if(paper.equals("The Lesechos"))
                {
                    setTitle("The Lesechos");
                    myWebView.loadUrl("http://www.lesechos.fr/");
                }
                if(paper.equals("The Le Quipe"))
                {
                    setTitle("The Le Quipe");
                    myWebView.loadUrl("http://www.lequipe.fr/");
                }
                if(paper.equals("The 20 Minutes"))
                {
                    setTitle("The 20 Minutes");
                    myWebView.loadUrl("http://www.20minutes.fr/");
                }
                if(paper.equals("The Ouest-France"))
                {
                    setTitle("The Ouest-France");
                    myWebView.loadUrl("http://www.ouest-france.fr/");
                }
                if(paper.equals("The Humanite"))
                {
                    setTitle("The Humanite");
                    myWebView.loadUrl("http://www.humanite.fr/");
                }
                if(paper.equals("The La-Croix"))
                {
                    setTitle("The La-Croix");
                    myWebView.loadUrl("http://www.la-croix.com/");
                }
            }
              else if(country.equals("Germany"))
            {
                if(paper.equals("The Bild"))
                {
                    setTitle("Bild");
                    myWebView.loadUrl("http://www.bild.de/wa/ll/bild-de/unangemeldet-42925516.bild.html");
                }
                if(paper.equals("The Sudeutsche Zeitung"))
                {
                    setTitle("The Sudeutsche Zeitung");
                    myWebView.loadUrl("http://www.sueddeutsche.de/adblock");
                }
                if(paper.equals("The Die Weilt"))
                {
                    setTitle("The Die Weilt");
                    myWebView.loadUrl("https://www.welt.de/");
                }
                if(paper.equals("The Die Zeit"))
                {
                    setTitle("The Die Zeit");
                    myWebView.loadUrl("http://www.zeit.de/index");
                }
                if(paper.equals("The Die Tageszeitung"))
                {
                    setTitle("The Die Tageszeitung");
                    myWebView.loadUrl("http://www.taz.de/");
                }
                if(paper.equals("The Frankfurter Rundschau"))
                {
                    setTitle("The Frankfurter Rundschau");
                    myWebView.loadUrl("http://www.fr-online.de/home/1472778,1472778.html");
                }
                if(paper.equals("The Handelsblatt"))
                {
                    setTitle("The Handelsblatt");
                    myWebView.loadUrl("http://www.handelsblatt.com/impressum/nutzungshinweise/blocker/?callback=%2F");
                }
                if(paper.equals("The Berliner Morgenpost"))
                {
                    setTitle("The Berliner Morgenpost");
                    myWebView.loadUrl("http://www.morgenpost.de/");
                }
                if(paper.equals("The Der Taggespiegel"))
                {
                    setTitle("The Der Taggespiegel");
                    myWebView.loadUrl("http://www.tagesspiegel.de/");
                }
                if(paper.equals("The Kurier"))
                {
                    setTitle("The Kurier");
                    myWebView.loadUrl("https://kurier.at/");
                }
            }
            else if(country.equals("Japan"))
            {
                if(paper.equals("The Yomiuri shimbun"))
                {
                    setTitle("The Yomiuri Shimbun");
                    myWebView.loadUrl("https://info.yomiuri.co.jp/english/index.html");
                }
                if(paper.equals("The Japan Times"))
                {
                    setTitle("The Japan Times");
                    myWebView.loadUrl("http://www.japantimes.co.jp/");
                }
                if(paper.equals("The Asahi Shimbun"))
                {
                    setTitle("The Asahi Shimbun");
                    myWebView.loadUrl("http://www.asahi.com/ajw/");
                }
                if(paper.equals("The Mainichi Shimbun"))
                {
                    setTitle("The Mainichi Shimbun");
                    myWebView.loadUrl("http://mainichi.jp/english/");
                }
                if(paper.equals("The Sankei Shimbun"))
                {
                    setTitle("The Sankei Shimbun");
                    myWebView.loadUrl("http://www.sankei.com/");
                }
                if(paper.equals("The Chunichi Shimbun"))
                {
                    setTitle("The Chunichi Shimbun");
                    myWebView.loadUrl("http://www.chunichi.co.jp/");
                }
                if(paper.equals("The Japan Today"))
                {
                    setTitle("The Japan Today");
                    myWebView.loadUrl("https://www.japantoday.com/");
                }
                if(paper.equals("The Nishinippon Shimbun"))
                {
                    setTitle("The Nishinippon Shimbun");
                    myWebView.loadUrl("http://www.nishinippon.co.jp/");
                }
                if(paper.equals("The Tokyo Sports"))
                {
                    setTitle("The Tokyo Sports");
                    myWebView.loadUrl("http://www.tokyo-sports.co.jp/");
                }
                if(paper.equals("The Tokyo Shimbun"))
                {
                    setTitle("The Tokyo Shimbun");
                    myWebView.loadUrl("http://www.tokyo-np.co.jp/");
                }
            }
            else if(country.equals("Chaina"))
            {
                if(paper.equals("The Chaina Daily"))
                {
                    setTitle("The Chaina Daily");
                    myWebView.loadUrl("http://www.chinadaily.com.cn/");
                }
                if(paper.equals("The People's Daily"))
                {
                    setTitle("The People's Daily");
                    myWebView.loadUrl("http://en.people.cn/");
                }
                if(paper.equals("The South Chain Morning Post"))
                {
                    setTitle("The South Chain Morning Post");
                    myWebView.loadUrl("http://www.scmp.com/frontpage/international");
                }
                if(paper.equals("The Sanghai Daily"))
                {
                    setTitle("The Sanghai Daily");
                    myWebView.loadUrl("http://www.shanghaidaily.com/");
                }
                if(paper.equals("The Chaina Press"))
                {
                    setTitle("The Chaina Press");
                    myWebView.loadUrl("http://www.chinapress.com.my/");
                }
                if(paper.equals("The Chaina Post"))
                {
                    setTitle("The Chaina Post");
                    myWebView.loadUrl("http://www.chinapost.com.tw/");
                }
                if(paper.equals("The Chaina Times"))
                {
                    setTitle("The Chaina Times");
                    myWebView.loadUrl("http://thechinatimes.com/");
                }
                if(paper.equals("The Chaina Daily"))
                {
                    setTitle("The Chaina Daily");
                    myWebView.loadUrl("http://app1.chinadaily.com.cn/star/");
                }
                if(paper.equals("The Legal Daily"))
                {
                    setTitle("The Legal Daily");
                    myWebView.loadUrl("http://www.legaldaily.com.cn/");
                }
                if(paper.equals("The Xinhua Daily"))
                {
                    setTitle("The Xinhua Daily");
                    myWebView.loadUrl("http://www.xinhuanet.com/english/");
                }
            }
            else if(country.equals("South Africa"))
            {
                if(paper.equals("The Mail and Guardian"))
                {
                    setTitle("The Mail and Guardian");
                    myWebView.loadUrl("http://mg.co.za/");
                }
                if(paper.equals("The Swoetan"))
                {
                    setTitle("The Swoetan");
                    myWebView.loadUrl("http://www.sowetanlive.co.za/");
                }
                if(paper.equals("The City Press"))
                {
                    setTitle("The City Press");
                    myWebView.loadUrl("http://city-press.news24.com/");
                }
                if(paper.equals("The Star"))
                {
                    setTitle("The Star");
                    myWebView.loadUrl("http://www.iol.co.za/the-star");
                }
                if(paper.equals("The Cape Times"))
                {
                    setTitle("The Cape Times");
                    myWebView.loadUrl("http://www.iol.co.za/capetimes");
                }
                if(paper.equals("The Cape Argus"))
                {
                    setTitle("The Cape Argus");
                    myWebView.loadUrl("http://www.iol.co.za/capeargus");
                }
                if(paper.equals("The Sunday Times"))
                {
                    setTitle("The Sunday Times");
                    myWebView.loadUrl("http://www.timeslive.co.za/sundaytimes/");
                }
                if(paper.equals("The Beld"))
                {
                    setTitle("The Beld");
                    myWebView.loadUrl("http://www.netwerk24.com/");
                }
                if(paper.equals("The Times"))
                {
                    setTitle("The Times");
                    myWebView.loadUrl("http://www.timeslive.co.za/");
                }
                if(paper.equals("The Daily Sun"))
                {
                    setTitle("The Daily Sun");
                    myWebView.loadUrl("http://www.dailysun.co.za/");
                }
            }
            else if(country.equals("Spain"))
            {
                if(paper.equals("The El Pias"))
                {
                    setTitle("The El Pias");
                    myWebView.loadUrl("http://elpais.com/");
                }
                if(paper.equals("The Elmundo"))
                {
                    setTitle("The Elmundo");
                    myWebView.loadUrl("http://www.elmundo.es/");
                }
                if(paper.equals("The Marca"))
                {
                    setTitle("The Marca");
                    myWebView.loadUrl("http://www.marca.com/");
                }
                if(paper.equals("The ABC"))
                {
                    setTitle("The ABC");
                    myWebView.loadUrl("http://www.abc.es/");
                }
                if(paper.equals("The El Periodico de Cataluniya"))
                {
                    setTitle("The El Periodico de Cataluniya");
                    myWebView.loadUrl("http://www.elperiodico.com/es/");
                }
                if(paper.equals("The Cincon Dias"))
                {
                    setTitle("The Cinco Dias");
                    myWebView.loadUrl("http://cincodias.com/");
                }
                if(paper.equals("The El Correo"))
                {
                    setTitle("The El Correo");
                    myWebView.loadUrl("http://www.elcorreo.com/");
                }
                if(paper.equals("The La Razon"))
                {
                    setTitle("The La Razon");
                    myWebView.loadUrl("http://www.larazon.es/");
                }
                if(paper.equals("The Diario AS"))
                {
                    setTitle("The Diario AS");
                    myWebView.loadUrl("http://as.com/");
                }
                if(paper.equals("The Expansion"))
                {
                    setTitle("The Expansion");
                    myWebView.loadUrl("http://www.expansion.com/");
                }
            }
           else if(country.equals("Pakistan"))
            {
                if(paper.equals("The Dawn"))
                {
                    setTitle("The Dawn");
                    myWebView.loadUrl("http://www.dawn.com/");
                }
                if(paper.equals("The News International"))
                {
                    setTitle("The News International");
                    myWebView.loadUrl("https://www.thenews.com.pk/");
                }
                if(paper.equals("The Daily Jang"))
                {
                    setTitle("The Daily Jang");
                    myWebView.loadUrl("https://jang.com.pk/");
                }
                if(paper.equals("The National"))
                {
                    setTitle("The National");
                    myWebView.loadUrl("http://nation.com.pk/");
                }
                if(paper.equals("The Daily Times"))
                {
                    setTitle("The Daily Times");
                    myWebView.loadUrl("http://www.dailytimes.com.pk/");
                }
                if(paper.equals("The Daily Express"))
                {
                    setTitle("The Daily Express");
                    myWebView.loadUrl("https://www.express.com.pk/");
                }
                if(paper.equals("The Daily Pakistan"))
                {
                    setTitle("The Daily Pakistan");
                    myWebView.loadUrl("http://dailypakistan.com.pk/");
                }
                if(paper.equals("The Nawa-I-Waqt"))
                {
                    setTitle("The Nawa-I-Waqt");
                    myWebView.loadUrl("http://www.nawaiwaqt.com.pk/");
                }
                if(paper.equals("The Front Post"))
                {
                    setTitle("The Front Post");
                    myWebView.loadUrl("http://www.thefrontierpost.com/");
                }
                if(paper.equals("The Pakistan Observer"))
                {
                    setTitle("The Pakistan Observer");
                    myWebView.loadUrl("http://pakobserver.net/");
                }
            }
            else if(country.equals("Italy"))
            {
                if(paper.equals("The Corriere Della Cera"))
                {
                    setTitle("The Corriere Della Cera");
                    myWebView.loadUrl("http://www.corriere.it/?no-static&refresh_rum");
                }
                if(paper.equals("The La Reppublica"))
                {
                    setTitle("The La Reppublica");
                    myWebView.loadUrl("http://www.repubblica.it/");
                }
                if(paper.equals("The La Stumpa"))
                {
                    setTitle("The La Stumpa");
                    myWebView.loadUrl("http://www.lastampa.it/");
                }
                if(paper.equals("The La Gezzetta Delo Sport"))
                {
                    setTitle("The La Gezzetta Delo Sport");
                    myWebView.loadUrl("http://www.gazzetta.it/?refresh_rum");
                }
                if(paper.equals("The Messaggero"))
                {
                    setTitle("The Messaggero");
                    myWebView.loadUrl("http://www.ilmessaggero.it/");
                }
                if(paper.equals("The Sole 24 Ore"))
                {
                    setTitle("The Sole 24 Ore");
                    myWebView.loadUrl("http://www.ilsole24ore.com/");
                }
                if(paper.equals("The Giornale"))
                {
                    setTitle("The Giornale");
                    myWebView.loadUrl("http://www.ilgiornale.it/");
                }
                if(paper.equals("The Mattino"))
                {
                    setTitle("The Mattino");
                    myWebView.loadUrl("http://www.ilmattino.it/");
                }
                if(paper.equals("The L'Unita"))
                {
                    setTitle("The L'Unita");
                    myWebView.loadUrl("http://www.unita.tv/");
                }
                if(paper.equals("The Libero"))
                {
                    setTitle("The Libero");
                    myWebView.loadUrl("http://www.liberoquotidiano.it/");
                }
            }
            else if(country.equals("South Korea"))
            {
                if(paper.equals("The Chosun Ilbo"))
                {
                    setTitle("The Chosun Ilbo");
                    myWebView.loadUrl("http://english.chosun.com/");
                }
                if(paper.equals("The Korea Times"))
                {
                    setTitle("The Korea Times");
                    myWebView.loadUrl("http://www.koreatimes.co.kr/www2/index.asp");
                }
                if(paper.equals("The Korea Herald"))
                {
                    setTitle("The Korea Herald");
                    myWebView.loadUrl("http://www.koreaherald.com/");
                }
                if(paper.equals("The Hankyoreh"))
                {
                    setTitle("The Hankyoreh");
                    myWebView.loadUrl("http://english.hani.co.kr/");
                }
                if(paper.equals("The Hankook Ilbo"))
                {
                    setTitle("The Hankook Ilbo");
                    myWebView.loadUrl("http://www.hankookilbo.com/");
                }
                if(paper.equals("The Seoul Shinmun"))
                {
                    setTitle("The Seoul Shinmun");
                    myWebView.loadUrl("http://www.seoul.co.kr/");
                }
                if(paper.equals("The Korea Economic Daily"))
                {
                    setTitle("The Korea Economic Daily");
                    myWebView.loadUrl("http://english.hankyung.com/");
                }
                if(paper.equals("The JoongAng Daily"))
                {
                    setTitle("The JoongAng Dailay");
                    myWebView.loadUrl("http://koreajoongangdaily.joins.com/");
                }
                if(paper.equals("The Maeil Businees Newspaper"))
                {
                    setTitle("The Maeil Businees Newspaper");
                    myWebView.loadUrl("http://www.pulsenews.co.kr/");
                }
                if(paper.equals("The Kukmin Daily"))
                {
                    setTitle("The Kukmin Daily");
                    myWebView.loadUrl("http://www.kukmindaily.co.kr/");
                }
            }

            else if(country.equals("North Korea"))
            {
                if(paper.equals("The North Korea Times"))
                {
                    setTitle("The North Korea Times");
                    myWebView.loadUrl("http://www.northkoreatimes.com/");
                }
                if(paper.equals("The North Korea News"))
                {
                    setTitle("The North Korea News");
                    myWebView.loadUrl("https://www.nknews.org/");
                }
                if(paper.equals("The Daily North Korea"))
                {
                    setTitle("The Daily North Korea");
                    myWebView.loadUrl("http://www.dailynk.com/english/index.php");
                }
                if(paper.equals("The Korea Times"))
                {
                    setTitle("The Korea Times");
                    myWebView.loadUrl("http://www.koreatimes.co.kr/www2/index.asp");
                }
                if(paper.equals("The Korea Herald"))
                {
                    setTitle("The Korea Herald");
                    myWebView.loadUrl("http://www.koreaherald.com/");
                }
            }

            else if(country.equals("Indonesia"))
            {
                if(paper.equals("The Kompas"))
                {
                    setTitle("The Kompas");
                    myWebView.loadUrl("http://www.kompas.com/");
                }
                if(paper.equals("The Jakarta Post"))
                {
                    setTitle("The Jakarta Post");
                    myWebView.loadUrl("http://www.thejakartapost.com/");
                }
                if(paper.equals("The Bisnis Indonesia"))
                {
                    setTitle("The Bisnis Indonesia");
                    myWebView.loadUrl("http://www.bisnis.com/");
                }
                if(paper.equals("The Pikiran Rakiyat"))
                {
                    setTitle("The Pikiran Rakiyat");
                    myWebView.loadUrl("http://www.pikiran-rakyat.com/");
                }
                if(paper.equals("The Saura Mardeka"))
                {
                    setTitle("The Saura Merdeka");
                    myWebView.loadUrl("http://berita.suaramerdeka.com/");
                }
                if(paper.equals("The Jawa Pos"))
                {
                    setTitle("The Jawa Pos");
                    myWebView.loadUrl("http://www.jawapos.com/");
                }
                if(paper.equals("The Jakarta Globe"))
                {
                    setTitle("The Jakarta Globe");
                    myWebView.loadUrl("http://jakartaglobe.id/");
                }
                if(paper.equals("The Republica"))
                {
                    setTitle("The Republica");
                    myWebView.loadUrl("http://www.republika.co.id/");
                }
                if(paper.equals("The Media Indonesia"))
                {
                    setTitle("The Media Indonesia");
                    myWebView.loadUrl("http://mediaindonesia.com/");
                }
                if(paper.equals("The Koran Tempo"))
                {
                    setTitle("The Koran Tempo");
                    myWebView.loadUrl("https://koran.tempo.co/2017/02/20");
                }
            }

           else if(country.equals("Switzerland"))
            {
                if(paper.equals("The Neue Zurcher Zeitung"))
                {
                    setTitle("The Neue Zurcher Zeitung");
                    myWebView.loadUrl("https://www.nzz.ch/");
                }
                if(paper.equals("The Tages-Anzeiger"))
                {
                    setTitle("The Tages-Anzeiger");
                    myWebView.loadUrl("http://www.tagesanzeiger.ch/");
                }
                if(paper.equals("The Le Temps"))
                {
                    setTitle("The Le Temps");
                    myWebView.loadUrl("https://www.letemps.ch/");
                }
                if(paper.equals("The Blick"))
                {
                    setTitle("The Blick");
                    myWebView.loadUrl("http://www.blick.ch/");
                }
                if(paper.equals("The Basler Zeitung"))
                {
                    setTitle("The Basler Zeitung");
                    myWebView.loadUrl("http://bazonline.ch/");
                }
                if(paper.equals("The 24 Heures"))
                {
                    setTitle("The 24 Heures");
                    myWebView.loadUrl("http://www.24heures.ch/");
                }
                if(paper.equals("The Berner Zeitung"))
                {
                    setTitle("The Berner Zeitung");
                    myWebView.loadUrl("http://www.bernerzeitung.ch/");
                }
                if(paper.equals("The Le Matin"))
                {
                    setTitle("The Le Matin");
                    myWebView.loadUrl("http://www.lematin.ch/");
                }
                if(paper.equals("The 20 Minuten"))
                {
                    setTitle("The 20 Minuten");
                    myWebView.loadUrl("http://www.20min.ch/");
                }
                if(paper.equals("The St. Galler Tagblatt"))
                {
                    setTitle("The St. Galler Tagblatt");
                    myWebView.loadUrl("http://www.tagblatt.ch/");
                }
            }

             else if(country.equals("Argentina"))
            {
                if(paper.equals("The Clarin"))
                {
                    setTitle("The Clarin");
                    myWebView.loadUrl("http://www.clarin.com/");
                }
                if(paper.equals("The La Nacion1"))
                {
                    setTitle("The La Nacion");
                    myWebView.loadUrl("http://www.lanacion.com.ar/");
                }
                if(paper.equals("The El Cronista"))
                {
                    setTitle("The El Cronista");
                    myWebView.loadUrl("http://www.cronista.com/");
                }
                if(paper.equals("The Pagin/12"))
                {
                    setTitle("The Pagin/12");
                    myWebView.loadUrl("https://pagina12.com.ar/");
                }
                if(paper.equals("The Cronica"))
                {
                    setTitle("The Cronica");
                    myWebView.loadUrl("http://www.cronica.com.ar/");
                }
                if(paper.equals("The Ambito Financiero"))
                {
                    setTitle("The Ambito Financiero");
                    myWebView.loadUrl("http://www.ambito.com/");
                }
                if(paper.equals("The Buenos Aires Herald"))
                {
                    setTitle("The Buenos Aires Herald");
                    myWebView.loadUrl("http://www.buenosairesherald.com/");
                }
                if(paper.equals("The La Voz Del Interior"))
                {
                    setTitle("The La Voz Del Interior");
                    myWebView.loadUrl("http://www.lavoz.com.ar/");
                }
                if(paper.equals("The Ole"))
                {
                    setTitle("The Ole");
                    myWebView.loadUrl("http://www.ole.com.ar/");
                }
                if(paper.equals("The El Dia"))
                {
                    setTitle("The El Dia");
                    myWebView.loadUrl("http://www.eldia.com/");
                }
            }

           else if(country.equals("Turkey"))
            {
                if(paper.equals("The Cumhuriyet"))
                {
                    setTitle("The Cumhuriyet");
                    myWebView.loadUrl("http://www.cumhuriyet.com.tr/");
                }
                if(paper.equals("The Hurriyet Daily News"))
                {
                    setTitle("The Hurriyet Daily News");
                    myWebView.loadUrl("http://www.hurriyetdailynews.com/");
                }
                if(paper.equals("The Hurriyet"))
                {
                    setTitle("The Hurriyet");
                    myWebView.loadUrl("http://www.hurriyet.com.tr/");
                }
                if(paper.equals("The Sabah"))
                {
                    setTitle("The Sabah");
                    myWebView.loadUrl("http://www.sabah.com.tr/");
                }
                if(paper.equals("The Miliyet"))
                {
                    setTitle("The Miliyet");
                    myWebView.loadUrl("http://www.milliyet.com.tr/");
                }
                if(paper.equals("The Heberturk"))
                {
                    setTitle("The Heberturk");
                    myWebView.loadUrl("http://m.haberturk.com/htyazarlar");
                }
                if(paper.equals("The Yeni Safak"))
                {
                    setTitle("The Yeni Safak");
                    myWebView.loadUrl("http://www.yenisafak.com/");
                }
                if(paper.equals("The Sozcu"))
                {
                    setTitle("The Sozcu");
                    myWebView.loadUrl("http://www.sozcu.com.tr/reklamsiz/reklamlarkapali");
                }
                if(paper.equals("The Posta"))
                {
                    setTitle("The Posta");
                    myWebView.loadUrl("http://www.posta.com.tr/");
                }
                if(paper.equals("The Vatan"))
                {
                    setTitle("The Vatan");
                    myWebView.loadUrl("http://www.gazetevatan.com/");
                }
            }

            else if(country.equals("Vietnam"))
            {
                if(paper.equals("The VN Express"))
                {
                    setTitle("The VN Express");
                    myWebView.loadUrl("http://vnexpress.net/");
                }
                if(paper.equals("The Nhan Dan"))
                {
                    setTitle("The Nhan Dan");
                    myWebView.loadUrl("http://www.nhandan.com.vn/");
                }
                if(paper.equals("The Viet Nam News"))
                {
                    setTitle("The Viet Nam News");
                    myWebView.loadUrl("http://vietnamnews.vn/");
                }
                if(paper.equals("The Thanh Nien"))
                {
                    setTitle("The Thanh Nien");
                    myWebView.loadUrl("http://thanhnien.vn/");
                }
                if(paper.equals("The Tuoi Tre"))
                {
                    setTitle("The Tuoi Tre");
                    myWebView.loadUrl("http://tuoitre.vn/");
                }
                if(paper.equals("The Sai Gon Giai Phong"))
                {
                    setTitle("The Sai Gon Giai Phong");
                    myWebView.loadUrl("http://www.sggp.org.vn/");
                }
                if(paper.equals("The Quan Doi Nhan Dan"))
                {
                    setTitle("The Quan Doi Nhan Dan");
                    myWebView.loadUrl("http://www.qdnd.vn/");
                }
                if(paper.equals("The Le Courrier De Vietnam"))
                {
                    setTitle("The Le Courrier De Vietnam");
                    myWebView.loadUrl("http://lecourrier.vn/");
                }
                if(paper.equals("The Nguoi Viet Daily News"))
                {
                    setTitle("The Nguoi Viet Daily News");
                    myWebView.loadUrl("http://www.nguoi-viet.com/");
                }
                if(paper.equals("The Little Saigon News"))
                {
                    setTitle("The Little Saigon News");
                    myWebView.loadUrl("http://www.ocregister.com/sections/news/little-saigon/");
                }
            }
            else if(country.equals("Austria"))
            {
                if(paper.equals("The Die Presse"))
                {
                    setTitle("The Die Presse");
                    myWebView.loadUrl("http://diepresse.com/");
                }
                if(paper.equals("The Kronen Zeitung"))
                {
                    setTitle("The Kronen Zeitung");
                    myWebView.loadUrl("http://www.krone.at/");
                }
                if(paper.equals("The Der Standard"))
                {
                    setTitle("The Der Standard");
                    myWebView.loadUrl("http://derstandard.at/");
                }
                if(paper.equals("The Wiener Zeitung"))
                {
                    setTitle("The Wiener Zeitung");
                    myWebView.loadUrl("http://www.wienerzeitung.at/");
                }
                if(paper.equals("The Kurier"))
                {
                    setTitle("The Kurier");
                    myWebView.loadUrl("https://kurier.at/");
                }
                if(paper.equals("The Kleine Zeitung"))
                {
                    setTitle("The Kleine Zeitung");
                    myWebView.loadUrl("http://www.kleinezeitung.at/");
                }
                if(paper.equals("The Salzburger Nachrichten"))
                {
                    setTitle("The Salzburger Nachrichten");
                    myWebView.loadUrl("http://www.salzburg.com/");
                }
                if(paper.equals("The Österreich"))
                {
                    setTitle("The Österreich");
                    myWebView.loadUrl("http://www.oe24.at/");
                }
                if(paper.equals("The WirtschaftsBlatt"))
                {
                    setTitle("The WirtschaftsBlatt");
                    myWebView.loadUrl("http://www.wirtschaftsblatt-bg.com/");
                }
                if(paper.equals("The Vienna Review"))
                {
                    setTitle("The Vienna Review");
                    myWebView.loadUrl("http://www.viennareview.net/");
                }
            }
            else if(country.equals("Nepal"))
            {
                if(paper.equals("The Kantipur"))
                {
                    setTitle("The Kantipur");
                    myWebView.loadUrl("http://kantipur.ekantipur.com/");
                }
                if(paper.equals("The Annapurna Post"))
                {
                    setTitle("The Annapurna Post");
                    myWebView.loadUrl("http://annapurnapost.com/np");
                }
                if(paper.equals("The Nagarik"))
                {
                    setTitle("The Nagarik");
                    myWebView.loadUrl("http://www.nagariknews.com/");
                }
                if(paper.equals("The Nepali Times"))
                {
                    setTitle("The Nepali Times");
                    myWebView.loadUrl("http://nepalitimes.com/");
                }
                if(paper.equals("The Karobar Economic Daily"))
                {
                    setTitle("The Karobar Economic Dailyr");
                    myWebView.loadUrl("https://www.karobardaily.com/");
                }
                if(paper.equals("The Naya Patrika"))
                {
                    setTitle("The Naya Patrika");
                    myWebView.loadUrl("http://www.enayapatrika.com/");
                }
            }
            else if(country.equals("Sri Lanka"))
            {
                if(paper.equals("The Daily Mirror"))
                {
                    setTitle("The Daily Mirror");
                    myWebView.loadUrl("http://www.dailymirror.lk/");
                }
                if(paper.equals("The Sunday Times"))
                {
                    setTitle("The Sunday Times");
                    myWebView.loadUrl("http://www.sundaytimes.lk/");
                }
                if(paper.equals("The Sunday Leader"))
                {
                    setTitle("The Sunday Leader");
                    myWebView.loadUrl("http://www.thesundayleader.lk/");
                }
                if(paper.equals("The Lankadeepa"))
                {
                    setTitle("The Lankadeepa");
                    myWebView.loadUrl("http://www.lankadeepa.lk/");
                }
                if(paper.equals("The Uthayan"))
                {
                    setTitle("The Uthayan");
                    myWebView.loadUrl("http://newuthayan.com/");
                }
                if(paper.equals("The Virakesari"))
                {
                    setTitle("The Virakesari");
                    myWebView.loadUrl("http://www.virakesari.lk/");
                }
                if(paper.equals("The Lakbima"))
                {
                    setTitle("The Lakbima");
                    myWebView.loadUrl("http://www.lakbima.lk/");
                }
                if(paper.equals("The Rivira"))
                {
                    setTitle("The Rivira");
                    myWebView.loadUrl("http://www.rivira.lk/online/");
                }
                if(paper.equals("The Thinakkural"))
                {
                    setTitle("The Thinakkural");
                    myWebView.loadUrl("http://www.thinakkural.lk/");
                }
                if(paper.equals("The Mawbima"))
                {
                    setTitle("The Mawbima");
                    myWebView.loadUrl("http://www.mawbima.lk/");
                }
            }
            else if(country.equals("Portugal"))
            {
                if(paper.equals("Público"))
                {
                    setTitle("Público");
                    myWebView.loadUrl("http://www.publico.pt/");
                }
                if(paper.equals("Diário de Notícias"))
                {
                    setTitle("Diário de Notícias");
                    myWebView.loadUrl("http://www.dn.pt/");
                }
                if(paper.equals("Jornal de Notícias"))
                {
                    setTitle("Jornal de Notícias");
                    myWebView.loadUrl("http://www.jn.pt/");
                }
                if(paper.equals("Correio da Manhã"))
                {
                    setTitle("Correio da Manhã");
                    myWebView.loadUrl("http://www.cmjornal.pt/");
                }
                if(paper.equals("Expresso"))
                {
                    setTitle("Expresso");
                    myWebView.loadUrl("http://expresso.sapo.pt/");
                }
                if(paper.equals("O Jogo"))
                {
                    setTitle("O Jogo");
                    myWebView.loadUrl("http://www.ojogo.pt/");
                }
                if(paper.equals("Jornal de Negócios"))
                {
                    setTitle("Jornal de Negócios");
                    myWebView.loadUrl("http://www.jornaldenegocios.pt/");
                }
                if(paper.equals("Diário Económico"))
                {
                    setTitle("Diário Económico");
                    myWebView.loadUrl("http://www.jornaldenegocios.pt/");
                }
                if(paper.equals("Destak"))
                {
                    setTitle("Destak");
                    myWebView.loadUrl("http://www.destak.pt/");
                }
                if(paper.equals("Sol"))
                {
                    setTitle("Sol");
                    myWebView.loadUrl("https://sol.sapo.pt/");
                }
            }

            else if(country.equals("Brazil"))
            {
                if(paper.equals("Folha de S.Paulo"))
                {
                    setTitle("Folha de S.Paulo");
                    myWebView.loadUrl("http://www.folha.uol.com.br/");
                }
                if(paper.equals("O Globo"))
                {
                    setTitle("O Globo");
                    myWebView.loadUrl("http://www.dn.pt/");
                }
                if(paper.equals("Estadão"))
                {
                    setTitle("Estadão");
                    myWebView.loadUrl("http://www.estadao.com.br/");
                }
                if(paper.equals("The Rio Times"))
                {
                    setTitle("The Rio Times");
                    myWebView.loadUrl("http://riotimesonline.com/");
                }
                if(paper.equals("Jornal do Brasil"))
                {
                    setTitle("Jornal do Brasil");
                    myWebView.loadUrl("http://www.jb.com.br/");
                }
                if(paper.equals("Valor Econômico"))
                {
                    setTitle("Valor Econômico");
                    myWebView.loadUrl("http://www.valor.com.br/");
                }
                if(paper.equals("O Dia"))
                {
                    setTitle("O Dia");
                    myWebView.loadUrl("http://odia.ig.com.br/");
                }
                if(paper.equals("Diário de Pernambuco"))
                {
                    setTitle("Diário de Pernambuco");
                    myWebView.loadUrl("http://www.diariodepernambuco.com.br/");
                }
                if(paper.equals("Correio do Povo"))
                {
                    setTitle("Correio do Povo");
                    myWebView.loadUrl("http://www.correiodopovo.com.br/");
                }
                if(paper.equals("Zero Hora"))
                {
                    setTitle("Zero Hora");
                    myWebView.loadUrl("http://zh.clicrbs.com.br/rs/");
                }
            }
            else if(country.equals("Sweden"))
            {
                if(paper.equals("Aftonbladet"))
                {
                    setTitle("Aftonbladet");
                    myWebView.loadUrl("http://www.aftonbladet.se/");
                }
                if(paper.equals("Dagens Nyheter"))
                {
                    setTitle("Dagens Nyheter");
                    myWebView.loadUrl("http://www.dn.se/");
                }
                if(paper.equals("Svenska Dagbladet"))
                {
                    setTitle("Svenska Dagbladet");
                    myWebView.loadUrl("https://www.svd.se/");
                }
                if(paper.equals("Expressen"))
                {
                    setTitle("Expressen");
                    myWebView.loadUrl("http://www.expressen.se/");
                }
                if(paper.equals("Göteborgs-Posten"))
                {
                    setTitle("Göteborgs-Posten");
                    myWebView.loadUrl("http://www.gp.se/");
                }
                if(paper.equals("Dagens Industri"))
                {
                    setTitle("Dagens Industri");
                    myWebView.loadUrl("http://www.di.se/");
                }
                if(paper.equals("Sydsvenskan"))
                {
                    setTitle("Sydsvenskan");
                    myWebView.loadUrl("https://www.sydsvenskan.se/");
                }
                if(paper.equals("Arbetarbladet"))
                {
                    setTitle("Arbetarbladet");
                    myWebView.loadUrl("http://www.arbetarbladet.se/");
                }
                if(paper.equals("Norran"))
                {
                    setTitle("Norran");
                    myWebView.loadUrl("http://norran.se/");
                }
                if(paper.equals("Västerbottens-Kuriren"))
                {
                    setTitle("Västerbottens-Kuriren");
                    myWebView.loadUrl("http://www.vk.se/");
                }
            }
            else if(country.equals("Denmark"))
            {
                if(paper.equals("Politiken"))
                {
                    setTitle("Politiken");
                    myWebView.loadUrl("http://politiken.dk/");
                }
                if(paper.equals("Copenhagen Post"))
                {
                    setTitle("Copenhagen Post");
                    myWebView.loadUrl("http://cphpost.dk/");
                }
                if(paper.equals("Borsen"))
                {
                    setTitle("Borsen");
                    myWebView.loadUrl("https://www.borsen.dk/");
                }
                if(paper.equals("Fyens Stiftstidende"))
                {
                    setTitle("Fyens Stiftstidende");
                    myWebView.loadUrl("http://www.fyens.dk/");
                }
                if(paper.equals("JydskeVestkysten"))
                {
                    setTitle("JydskeVestkysten");
                    myWebView.loadUrl("http://www.jv.dk/");
                }
                if(paper.equals("Weekendavisen"))
                {
                    setTitle("Weekendavisen");
                    myWebView.loadUrl("https://www.weekendavisen.dk/");
                }
                if(paper.equals("Kristeligt Dagblad"))
                {
                    setTitle("Kristeligt Dagblad");
                    myWebView.loadUrl("https://www.kristeligt-dagblad.dk/");
                }
                if(paper.equals("Nordjyske Stiftstidende"))
                {
                    setTitle("Nordjyske Stiftstidende");
                    myWebView.loadUrl("https://nordjyske.dk/");
                }
                if(paper.equals("Midtjyllands Avis"))
                {
                    setTitle("Midtjyllands Avis");
                    myWebView.loadUrl("http://www.mja.dk/");
                }
                if(paper.equals("Søndagsavisen"))
                {
                    setTitle("Søndagsavisen");
                    myWebView.loadUrl("https://www.sondagsavisen.dk/");
                }
            }
            else if(country.equals("Cuba"))
            {
                if(paper.equals("Granma"))
                {
                    setTitle("Granma");
                    myWebView.loadUrl("http://en.granma.cu/");
                }
                if(paper.equals("Juventud Rebelde"))
                {
                    setTitle("Juventud Rebelde");
                    myWebView.loadUrl("http://www.juventudrebelde.cu/");
                }
                if(paper.equals("Miami Herald"))
                {
                    setTitle("Miami Herald");
                    myWebView.loadUrl("http://www.miamiherald.com/");
                }
                if(paper.equals("Trabajadores"))
                {
                    setTitle("Trabajadores");
                    myWebView.loadUrl("http://www.trabajadores.cu/");
                }
                if(paper.equals("Tribuna de La Habana"))
                {
                    setTitle("Tribuna de La Habana");
                    myWebView.loadUrl("http://www.tribuna.cu/capitalinas");
                }
                if(paper.equals("Ahora"))
                {
                    setTitle("Ahora");
                    myWebView.loadUrl("http://www.ahora.cu/en/");
                }
                if(paper.equals("Escambray"))
                {
                    setTitle("Escambray");
                    myWebView.loadUrl("http://en.escambray.cu/");
                }
                if(paper.equals("Girón"))
                {
                    setTitle("Girón");
                    myWebView.loadUrl("http://www.giron.cu/");
                }
                if(paper.equals("Guerrillero"))
                {
                    setTitle("Guerrillero");
                    myWebView.loadUrl("http://www.guerrillero.cu/");
                }
                if(paper.equals("Venceremos"))
                {
                    setTitle("Venceremos");
                    myWebView.loadUrl("http://venceremosutah.com/");
                }
            }
            else if(country.equals("Egypt"))
            {
                if(paper.equals("Daily News Egypt"))
                {
                    setTitle("Daily News Egypt");
                    myWebView.loadUrl("https://dailynewsegypt.com/");
                }
                if(paper.equals("Al-Ahram"))
                {
                    setTitle("Al-Ahram");
                    myWebView.loadUrl("http://www.ahram.org.eg/");
                }
                if(paper.equals("Youm7"))
                {
                    setTitle("Youm7");
                    myWebView.loadUrl("http://www.youm7.com/");
                }
                if(paper.equals("Egypt Independent"))
                {
                    setTitle("Egypt Independent");
                    myWebView.loadUrl("http://www.egyptindependent.com/");
                }
                if(paper.equals("Almasry Alyoum"))
                {
                    setTitle("Almasry Alyoum");
                    myWebView.loadUrl("http://www.almasryalyoum.com/");
                }
                if(paper.equals("Al-Shorouk"))
                {
                    setTitle("Al-Shorouk");
                    myWebView.loadUrl("http://www.shorouknews.com/");
                }
                if(paper.equals("Al-Wafd"))
                {
                    setTitle("Al-Wafd");
                    myWebView.loadUrl("https://alwafd.org/");
                }
                if(paper.equals("Al-Dustour"))
                {
                    setTitle("Al-Dustour");
                    myWebView.loadUrl("http://www.dostor.org/");
                }
                if(paper.equals("Akhbar el-Yom"))
                {
                    setTitle("Akhbar el-Yom");
                    myWebView.loadUrl("http://akhbarelyom.com/");
                }
                if(paper.equals("Al Akhbar"))
                {
                    setTitle("Al Akhbar");
                    myWebView.loadUrl("http://akhbar.akhbarelyom.com/");
                }
            }
            else if(country.equals("Mexico"))
            {
                if(paper.equals("The News"))
                {
                    setTitle("The News");
                    myWebView.loadUrl("http://www.thenews.mx/");
                }
                if(paper.equals("La Jornada"))
                {
                    setTitle("La Jornada");
                    myWebView.loadUrl("http://www.jornada.unam.mx/");
                }
                if(paper.equals("El Norte"))
                {
                    setTitle("El Norte");
                    myWebView.loadUrl("http://www.elnorte.com/");
                }
                if(paper.equals("Reforma"))
                {
                    setTitle("Reforma");
                    myWebView.loadUrl("http://www.reforma.com/");
                }
                if(paper.equals("Milenio"))
                {
                    setTitle("Milenio");
                    myWebView.loadUrl("http://www.milenio.com/");
                }
                if(paper.equals("Excélsior"))
                {
                    setTitle("Excélsior");
                    myWebView.loadUrl("http://www.excelsior.com.mx/");
                }
                if(paper.equals("El Mañana"))
                {
                    setTitle("El Mañana");
                    myWebView.loadUrl("http://www.elmanana.com.mx/");
                }
                if(paper.equals("El Siglo de Torreón"))
                {
                    setTitle("El Siglo de Torreón");
                    myWebView.loadUrl("https://www.elsiglodetorreon.com.mx/?pub=1");
                }
                if(paper.equals("la prensa de méxico"))
                {
                    setTitle("la prensa de méxico");
                    myWebView.loadUrl("https://www.la-prensa.com.mx/");
                }
                if(paper.equals("Santa Fe New Mexican"))
                {
                    setTitle("Santa Fe New Mexican");
                    myWebView.loadUrl("http://www.santafenewmexican.com/");
                }
            }
            else if(country.equals("Iran"))
            {
                if(paper.equals("The Iran"))
                {
                    setTitle("The Iran");
                    myWebView.loadUrl("http://www.iran-daily.com/");
                }
                if(paper.equals("The Kayhan"))
                {
                    setTitle("The Kayhan");
                    myWebView.loadUrl("http://kayhan.ir/en");
                }
                if(paper.equals("Ettela'at"))
                {
                    setTitle("Ettela'at");
                    myWebView.loadUrl("http://www.ettelaat.com/");
                }
                if(paper.equals("Shargh"))
                {
                    setTitle("Shargh");
                    myWebView.loadUrl("http://www.sharghdaily.ir/");
                }
                if(paper.equals("Etemaad"))
                {
                    setTitle("Etemaad");
                    myWebView.loadUrl("http://www.epaper.etemaaddaily.com/epapers/");
                }
                if(paper.equals("Jomhouri eslami"))
                {
                    setTitle("Jomhouri eslami");
                    myWebView.loadUrl("http://jomhourieslami.net/");
                }
                if(paper.equals("Tehran Times"))
                {
                    setTitle("Tehran Times");
                    myWebView.loadUrl("http://www.tehrantimes.com/");
                }
                if(paper.equals("Resalat"))
                {
                    setTitle("Resalat");
                    myWebView.loadUrl("http://www.resalat-news.com/Fa/");
                }
                if(paper.equals("Aftab Yazd"))
                {
                    setTitle("Aftab Yazd");
                    myWebView.loadUrl("");
                }
                if(paper.equals("Hamshahri"))
                {
                    setTitle("Hamshahri");
                    myWebView.loadUrl("http://www.hamshahrionline.ir/");
                }
            }
            else if(country.equals("Belgium"))
            {
                if(paper.equals("De Morgen"))
                {
                    setTitle("De Morgen");
                    myWebView.loadUrl("https://www.demorgen.be/");
                }
                if(paper.equals("Le Soir"))
                {
                    setTitle("Le Soir");
                    myWebView.loadUrl("http://www.lesoir.be/");
                }
                if(paper.equals("De Standaard"))
                {
                    setTitle("De Standaard");
                    myWebView.loadUrl("http://www.standaard.be/");
                }
                if(paper.equals("Het Laatste Nieuws"))
                {
                    setTitle("Het Laatste Nieuws");
                    myWebView.loadUrl("http://www.hln.be/");
                }
                if(paper.equals("L'Echo"))
                {
                    setTitle("L'Echo");
                    myWebView.loadUrl("http://www.lecho.be/");
                }
                if(paper.equals("Het Nieuwsblad"))
                {
                    setTitle("Het Nieuwsblad");
                    myWebView.loadUrl("http://www.nieuwsblad.be/");
                }
                if(paper.equals("La Dernière Heure"))
                {
                    setTitle("La Dernière Heure");
                    myWebView.loadUrl("http://www.dhnet.be/");
                }
                if(paper.equals("De Tijd"))
                {
                    setTitle("De Tijd");
                    myWebView.loadUrl("http://www.tijd.be/");
                }
                if(paper.equals("Gazet van Antwerpen"))
                {
                    setTitle("Gazet van Antwerpen");
                    myWebView.loadUrl("http://www.gva.be/");
                }
                if(paper.equals("Het Belang van Limburg"))
                {
                    setTitle("Het Belang van Limburg");
                    myWebView.loadUrl("http://www.hbvl.be/");
                }
            }
            else if(country.equals("Saudi Arabia"))
            {
                if(paper.equals("Arab News"))
                {
                    setTitle("Arab News");
                    myWebView.loadUrl("http://www.arabnews.com/");
                }
                if(paper.equals("Al Riyadh"))
                {
                    setTitle("Al Riyadh");
                    myWebView.loadUrl("http://sites.alriyadh.com/en");
                }
                if(paper.equals("Saudi Gazette"))
                {
                    setTitle("Saudi Gazette");
                    myWebView.loadUrl("http://saudigazette.com.sa/");
                }
                if(paper.equals("Al Jazirah"))
                {
                    setTitle("Al Jazirah");
                    myWebView.loadUrl("http://www.al-jazirah.com/");
                }
                if(paper.equals("Al Watan"))
                {
                    setTitle("Al Watan");
                    myWebView.loadUrl("http://www.alwatan.com.sa/Default.aspx?issueno=6164");
                }
                if(paper.equals("Okaz"))
                {
                    setTitle("Okaz");
                    myWebView.loadUrl("http://www.okaz.com.sa/");
                }
                if(paper.equals("Al Eqtisadiah"))
                {
                    setTitle("Al Eqtisadiah");
                    myWebView.loadUrl("http://www.aleqt.com/");
                }
                if(paper.equals("Al Madina"))
                {
                    setTitle("Al Madina");
                    myWebView.loadUrl("http://www.al-madina.com/");
                }
                if(paper.equals("Urdu News"))
                {
                    setTitle("Urdu News");
                    myWebView.loadUrl("http://www.urdunews.com/");
                }
            }
            else if(country.equals("Sudan"))
            {
                if(paper.equals("Sudan Vision Daily"))
                {
                    setTitle("Sudan Vision Daily");
                    myWebView.loadUrl("http://www.sudanvisiondaily.com/");
                }
                if(paper.equals("Sudan Tribune"))
                {
                    setTitle("Sudan Tribune");
                    myWebView.loadUrl("http://www.sudantribune.com/");
                }
            }
            else if(country.equals("Czech Republic"))
            {
                if(paper.equals("Mladá fronta DNES"))
                {
                    setTitle("Mladá fronta DNES");
                    myWebView.loadUrl("https://www.mfdnes.cz/");
                }
                if(paper.equals("Právo"))
                {
                    setTitle("Právo");
                    myWebView.loadUrl("http://www.pravo.cz/");
                }
                if(paper.equals("Lidové noviny"))
                {
                    setTitle("Lidové noviny");
                    myWebView.loadUrl("http://www.lidovky.cz/");
                }
                if(paper.equals("The Prague Post"))
                {
                    setTitle("The Prague Post");
                    myWebView.loadUrl("https://www.praguepost.com/");
                }
                if(paper.equals("Blesk"))
                {
                    setTitle("Blesk");
                    myWebView.loadUrl("http://www.blesk.cz/");
                }
                if(paper.equals("Hospodářské noviny"))
                {
                    setTitle("Hospodářské noviny");
                    myWebView.loadUrl("https://zpravy.aktualne.cz/");
                }
                if(paper.equals("Haló noviny"))
                {
                    setTitle("Haló noviny");
                    myWebView.loadUrl("http://www.halonoviny.cz/");
                }
                if(paper.equals("Aha!"))
                {
                    setTitle("Aha!");
                    myWebView.loadUrl("http://www.ahaonline.cz/");
                }
                if(paper.equals("Prague Business Journal"))
                {
                    setTitle("Prague Business Journal");
                    myWebView.loadUrl("https://www.pbj.cz/");
                }
                if(paper.equals("Pravý Břeh"))
                {
                    setTitle("Pravý Břeh");
                    myWebView.loadUrl("https://www.pravybreh.cz/");
                }
            }
            else if(country.equals("Bhutan"))
            {
                if(paper.equals("Kuensel"))
                {
                    setTitle("Kuensel");
                    myWebView.loadUrl("http://www.kuenselonline.com/");
                }
                if(paper.equals("The Bhutanese"))
                {
                    setTitle("The Bhutanese");
                    myWebView.loadUrl("http://thebhutanese.bt/");
                }
                if(paper.equals("Bhutan Observer"))
                {
                    setTitle("Bhutan Observer");
                    myWebView.loadUrl("http://www.bhutanobserver.bt/");
                }
                if(paper.equals("Bhutan Times"))
                {
                    setTitle("Bhutan Times");
                    myWebView.loadUrl("https://www.bhutantimes.com/");
                }
                if(paper.equals("Bhutan Today"))
                {
                    setTitle("Bhutan Today");
                    myWebView.loadUrl("http://www.onlinenewspapers.com/bhutan.htm");
                }
                if(paper.equals("Business Bhutan"))
                {
                    setTitle("Business Bhutan");
                    myWebView.loadUrl("https://www.businessbhutan.bt/businessbhutan/");
                }
                if(paper.equals("The Journalist"))
                {
                    setTitle("The Journalist");
                    myWebView.loadUrl("http://www.bhutanjournalist.com/journalist/");
                }
                if(paper.equals("Druk Yoedzer"))
                {
                    setTitle("Druk Yoedzer");
                    myWebView.loadUrl("http://www.drukyoedzer.com/");
                }
            }
            else if(country.equals("United Arab Emirates"))
            {
                if(paper.equals("Gulf News"))
                {
                    setTitle("Gulf News");
                    myWebView.loadUrl("http://gulfnews.com/");
                }
                if(paper.equals("Khaleej Times"))
                {
                    setTitle("Khaleej Times");
                    myWebView.loadUrl("http://www.khaleejtimes.com/");
                }
                if(paper.equals("The National"))
                {
                    setTitle("The National");
                    myWebView.loadUrl("https://www.thenational.ae/international");
                }
                if(paper.equals("Al Bayan"))
                {
                    setTitle("Al Bayan");
                    myWebView.loadUrl("http://www.albayan.ae/");
                }
                if(paper.equals("Al Khaleej"))
                {
                    setTitle("Al Khaleej");
                    myWebView.loadUrl("http://www.alkhaleej.ae/portal");
                }
                if(paper.equals("Al-Ittihad"))
                {
                    setTitle("Al-Ittihad");
                    myWebView.loadUrl("http://www.alittihad.ae/");
                }
                if(paper.equals("The Gulf Today"))
                {
                    setTitle("The Gulf Today");
                    myWebView.loadUrl("http://gulftoday.ae/");
                }
                if(paper.equals("7days"))
                {
                    setTitle("7days");
                    myWebView.loadUrl("http://www.7days.com/");
                }
                if(paper.equals("Emirates Business 24/7"))
                {
                    setTitle("Emirates Business 24/7");
                    myWebView.loadUrl("http://www.emirates247.com/");
                }
                if(paper.equals("Al Wahda"))
                {
                    setTitle("Al Wahda");
                    myWebView.loadUrl("http://alwahdanews.ae/");
                }
            }
            else if(country.equals("Hong Kong"))
            {
                if(paper.equals("South China Morning Post"))
                {
                    setTitle("South China Morning Post");
                    myWebView.loadUrl("http://www.scmp.com/frontpage/international");
                }
                if(paper.equals("Ming Pao"))
                {
                    setTitle("Ming Pao");
                    myWebView.loadUrl("https://www.mingpao.com");
                }
                if(paper.equals("Apple Daily"))
                {
                    setTitle("Apple Daily");
                    myWebView.loadUrl("http://hkm.appledaily.com/list.php?category_guid=4104");
                }
                if(paper.equals("Sing Tao Daily"))
                {
                    setTitle("Sing Tao Daily");
                    myWebView.loadUrl("http://www.singtaonewscorp.com/english/");
                }
                if(paper.equals("Wen Wei Po"))
                {
                    setTitle("Wen Wei Po");
                    myWebView.loadUrl("http://www.wenweipo.com/");
                }
                if(paper.equals("Oriental Daily"))
                {
                    setTitle("Oriental Daily");
                    myWebView.loadUrl("http://www.orientaldaily.com.my/");
                }
                if(paper.equals("The Standard"))
                {
                    setTitle("The Standard");
                    myWebView.loadUrl("http://www.thestandard.com.hk/");
                }
                if(paper.equals("Hong Kong Economic Journal"))
                {
                    setTitle("Hong Kong Economic Journal");
                    myWebView.loadUrl("http://www2.hkej.com/");
                }
                if(paper.equals("Hong Kong Commercial Daily"))
                {
                    setTitle("Hong Kong Commercial Daily");
                    myWebView.loadUrl("http://www.hkcd.com/");
                }
                if(paper.equals("Sing Pao"))
                {
                    setTitle("Sing Pao");
                    myWebView.loadUrl("https://www.singpao.com.hk/");
                }
            }
            else if(country.equals("New Zealand"))
            {
                if(paper.equals("New Zealand Herald"))
                {
                    setTitle("New Zealand Herald");
                    myWebView.loadUrl("http://www.nzherald.co.nz/");
                }
                if(paper.equals("The Press"))
                {
                    setTitle("The Press");
                    myWebView.loadUrl("http://deaths.press.co.nz/obituaries/the-press-nz/");
                }
                if(paper.equals("Dominion post"))
                {
                    setTitle("Dominion post");
                    myWebView.loadUrl("http://deaths.dompost.co.nz/obituaries/dominion-post-nz/");
                }
                if(paper.equals("Otago Daily Times"))
                {
                    setTitle("Otago Daily Times");
                    myWebView.loadUrl("https://www.odt.co.nz/");
                }
                if(paper.equals("Waikato Times"))
                {
                    setTitle("Waikato Times");
                    myWebView.loadUrl("http://deaths.waikatotimes.co.nz/");
                }
                if(paper.equals("Southland Times"))
                {
                    setTitle("Southland Times");
                    myWebView.loadUrl("http://deaths.southlandtimes.co.nz/");
                }
                if(paper.equals("Nelson Mail"))
                {
                    setTitle("Nelson Mail");
                    myWebView.loadUrl("http://deaths.nelsonmail.co.nz/");
                }
                if(paper.equals("Timaru Herald"))
                {
                    setTitle("Timaru Herald");
                    myWebView.loadUrl("http://deaths.timaruherald.co.nz/");
                }
                if(paper.equals("The Sunday Star-Times"))
                {
                    setTitle("The Sunday Star-Times");
                    myWebView.loadUrl("https://www.stuff.co.nz/sunday-star-times/");
                }
                if(paper.equals("Manawatu Standard"))
                {
                    setTitle("Manawatu Standard");
                    myWebView.loadUrl("http://deaths.manawatustandard.co.nz/");
                }
            }
            else if(country.equals("Singapore"))
            {
                if(paper.equals("Straits Times"))
                {
                    setTitle("Straits Times");
                    myWebView.loadUrl("http://www.straitstimes.com/global");
                }
                if(paper.equals("The Today"))
                {
                    setTitle("The Today");
                    myWebView.loadUrl("http://www.todayonline.com/singapore");
                }
                if(paper.equals("Lianhe Zaobao"))
                {
                    setTitle("Lianhe Zaobao");
                    myWebView.loadUrl("http://www.zaobao.com.sg/");
                }
                if(paper.equals("The New Paper"))
                {
                    setTitle("The New Paper");
                    myWebView.loadUrl("http://www.tnp.sg/");
                }
                if(paper.equals("The Business Times"))
                {
                    setTitle("The Business Times");
                    myWebView.loadUrl("http://www.businesstimes.com.sg/");
                }
                if(paper.equals("Berita Harian"))
                {
                    setTitle("Berita Harian");
                    myWebView.loadUrl("http://www.beritaharian.sg/");
                }
                if(paper.equals("Tamil Murasu"))
                {
                    setTitle("Tamil Murasu");
                    myWebView.loadUrl("http://www.tamilmurasu.org/");
                }
                if(paper.equals("My Paper"))
                {
                    setTitle("My Paper");
                    myWebView.loadUrl("http://www.tnp.sg/");
                }
                if(paper.equals("Lianhe Wanbao"))
                {
                    setTitle("Lianhe Wanbao");
                    myWebView.loadUrl("http://www.wanbao.com.sg/");
                }
                if(paper.equals("Shin Min Daily News"))
                {
                    setTitle("Shin Min Daily News");
                    myWebView.loadUrl("http://www.shinmin.sg/");
                }
            }
            else if(country.equals("Norway"))
            {
                if(paper.equals("Aftenposten"))
                {
                    setTitle("Aftenposten");
                    myWebView.loadUrl("https://www.aftenposten.no/");
                }
                if(paper.equals("Dagbladet"))
                {
                    setTitle("Dagbladet");
                    myWebView.loadUrl("http://www.dagbladet.no/");
                }
                if(paper.equals("Bergens Tidende"))
                {
                    setTitle("Bergens Tidende");
                    myWebView.loadUrl("https://www.bt.no/");
                }
                if(paper.equals("Adresseavisen"))
                {
                    setTitle("Adresseavisen");
                    myWebView.loadUrl("http://www.adressa.no/");
                }
                if(paper.equals("Stavanger Aftenblad"))
                {
                    setTitle("Stavanger Aftenblad");
                    myWebView.loadUrl("http://www.aftenbladet.no/");
                }
                if(paper.equals("Dagens Næringsliv"))
                {
                    setTitle("Dagens Næringsliv");
                    myWebView.loadUrl("https://www.dn.no/kundeservice");
                }
                if(paper.equals("Dagsavisen"))
                {
                    setTitle("Dagsavisen");
                    myWebView.loadUrl("http://www.dagsavisen.no/");
                }
                if(paper.equals("Fædrelandsvennen"))
                {
                    setTitle("Fædrelandsvennen");
                    myWebView.loadUrl("https://www.fvn.no/");
                }
                if(paper.equals("Bergensavisen"))
                {
                    setTitle("Bergensavisen");
                    myWebView.loadUrl("https://www.ba.no/");
                }
                if(paper.equals("ITromsø"))
                {
                    setTitle("ITromsø");
                    myWebView.loadUrl("http://www.itromso.no");
                }
            } else if(country.equals("Ukrain"))
            {
                if(paper.equals("Zerkalo Nedeli"))
                {
                    setTitle("Zerkalo Nedeli");
                    myWebView.loadUrl("https://zn.ua/");
                }
                if(paper.equals("Kyiv Post"))
                {
                    setTitle("Kyiv Post");
                    myWebView.loadUrl("https://www.kyivpost.com/");
                }
                if(paper.equals("Fakty i Kommentarii"))
                {
                    setTitle("Fakty i Kommentarii");
                    myWebView.loadUrl("http://fakty.ua/");
                }
                if(paper.equals("DELO"))
                {
                    setTitle("DELO");
                    myWebView.loadUrl("https://delo.ua/");
                }
                if(paper.equals("Uryadovy Kuryer"))
                {
                    setTitle("Uryadovy Kuryer");
                    myWebView.loadUrl("https://www.ukurier.gov.ua/uk/");
                }
            }
            else if(country.equals("Scotland"))
            {
                if(paper.equals("The Herald"))
                {
                    setTitle("The Herald");
                    myWebView.loadUrl("http://www.heraldscotland.com/");
                }
                if(paper.equals("The Scotsman"))
                {
                    setTitle("The Scotsman");
                    myWebView.loadUrl("http://www.scotsman.com/");
                }
                if(paper.equals("Daily Record"))
                {
                    setTitle("Daily Record");
                    myWebView.loadUrl("http://www.dailyrecord.co.uk/");
                }
                if(paper.equals("Daily Record"))
                {
                    setTitle("Daily Record");
                    myWebView.loadUrl("https://www.pressandjournal.co.uk/");
                }
                if(paper.equals("The Courier"))
                {
                    setTitle("The Courier");
                    myWebView.loadUrl("https://www.thecourier.co.uk/");
                }
                if(paper.equals("The National"))
                {
                    setTitle("The National");
                    myWebView.loadUrl("http://www.thenational.scot/");
                }
                if(paper.equals("Edinburgh Evening News"))
                {
                    setTitle("Edinburgh Evening News");
                    myWebView.loadUrl("http://www.edinburghnews.scotsman.com/");
                }
                if(paper.equals("The Sun"))
                {
                    setTitle("The Sun");
                    myWebView.loadUrl("https://www.thesun.co.uk/");
                }
                if(paper.equals("The Sunday Post"))
                {
                    setTitle("The Sunday Post");
                    myWebView.loadUrl("https://www.sundaypost.com/");
                }
                if(paper.equals("Sunday Herald"))
                {
                    setTitle("Sunday Herald");
                    myWebView.loadUrl("http://www.heraldscotland.com/");
                }
            }
            else if(country.equals("Venezuela"))
            {
                if(paper.equals("El Universal"))
                {
                    setTitle("El Universal");
                    myWebView.loadUrl("http://www.eluniversal.com/");
                }
                if(paper.equals("Últimas Noticias"))
                {
                    setTitle("Últimas Noticias");
                    myWebView.loadUrl("http://www.ultimasnoticias.com.ve/");
                }
                if(paper.equals("El Carabobeño"))
                {
                    setTitle("El Carabobeño");
                    myWebView.loadUrl("https://www.el-carabobeno.com/");
                }
                if(paper.equals("La Verdad"))
                {
                    setTitle("La Verdad");
                    myWebView.loadUrl("http://www.laverdad.com/");
                }
                if(paper.equals("Tal Cual"))
                {
                    setTitle("Tal Cual");
                    myWebView.loadUrl("http://www.talcualdigital.com/");
                }
                if(paper.equals("Diario 2001"))
                {
                    setTitle("Diario 2001");
                    myWebView.loadUrl("http://www.2001.com.ve/");
                }
                if(paper.equals("El Informador"))
                {
                    setTitle("El Informador");
                    myWebView.loadUrl("http://www.elinformador.com.ve/");
                }
                if(paper.equals("Correo del Orinoco"))
                {
                    setTitle("Correo del Orinoco");
                    myWebView.loadUrl("http://www.correodelorinoco.gob.ve/");
                }
                if(paper.equals("El Mundo"))
                {
                    setTitle("El Mundo");
                    myWebView.loadUrl("http://www.elmundo.com.ve/");
                }
                if(paper.equals("Diario Panorama"))
                {
                    setTitle("Diario Panorama");
                    myWebView.loadUrl("http://www.panorama.com.ve/");
                }
            }
            else if(country.equals("Angola"))
            {
                if(paper.equals("Club-K Angola"))
                {
                    setTitle("Club-K Angola");
                    myWebView.loadUrl("http://www.club-k.net/index.php?lang=pt");
                }
                if(paper.equals("Ebonet Noticias"))
                {
                    setTitle("Ebonet Noticias");
                    myWebView.loadUrl("http://www.nexus.ao/canais/noticias/");
                }
                if(paper.equals("Folha 8"))
                {
                    setTitle("Folha 8");
                    myWebView.loadUrl("http://jornalf8.net/");
                }
                if(paper.equals("Journal De Angola"))
                {
                    setTitle("Journal De Angola");
                    myWebView.loadUrl("http://jornaldeangola.sapo.ao//");
                }
            }
            else if(country.equals("Iraq"))
            {
                if(paper.equals("Azzaman"))
                {
                    setTitle("Azzaman");
                    myWebView.loadUrl("https://www.azzaman.com");
                }
                if(paper.equals("Al Mada"))
                {
                    setTitle("Al Mada");
                    myWebView.loadUrl("http://www.almadapaper.net/ar/");
                }
                if(paper.equals("Al-Mashriq"))
                {
                    setTitle("Al-Mashriq");
                    myWebView.loadUrl("http://www.al-mashriq.net/");
                }
                if(paper.equals("Al-Iraq"))
                {
                    setTitle("Al-Iraq");
                    myWebView.loadUrl("http://www.nationsonline.org/oneworld/iraq.htm");
                }
                if(paper.equals("Xebat"))
                {
                    setTitle("Xebat");
                    myWebView.loadUrl("http://www.xebat.net");
                }
                if(paper.equals("The Kurdish Globe"))
                {
                    setTitle("The Kurdish Globe");
                    myWebView.loadUrl("http://www.kurdishglobe.net/");
                }
                if(paper.equals("Al Sabaah"))
                {
                    setTitle("Al Sabaah");
                    myWebView.loadUrl("http://www.alsabaah.iq/");
                }
                if(paper.equals("Hawlati"))
                {
                    setTitle("Hawlati");
                    myWebView.loadUrl("https://issuu.com/hawlatikurd");
                }
                if(paper.equals("Al-Mutamar"))
                {
                    setTitle("Al-Mutamar");
                    myWebView.loadUrl("http://www.wikiwand.com/en/Al-Mutamar");
                }
                if(paper.equals("Iraq Today"))
                {
                    setTitle("Iraq Today");
                    myWebView.loadUrl("http://www.iraqinews.com/");
                }
            }
            else if(country.equals("Tunisia"))
            {
                if(paper.equals("Babnet Tunisie"))
                {
                    setTitle("Babnet Tunisie");
                    myWebView.loadUrl("https://www.babnet.net/index.php");
                }
                if(paper.equals("Info Tunisie"))
                {
                    setTitle("Info Tunisie");
                    myWebView.loadUrl("http://www.infotunisie.com/");
                }
                if(paper.equals("Tunis Daily News"))
                {
                    setTitle("Tunis Daily News");
                    myWebView.loadUrl("http://tdailynews.net/index.php?lang=ar");
                }
                if(paper.equals("Tunis Times"))
                {
                    setTitle("Tunis Times");
                    myWebView.loadUrl("http://www.thetunistimes.com/");
                }
                if(paper.equals("Tunisia Daily"))
                {
                    setTitle("Tunisia Daily");
                    myWebView.loadUrl("http://www.fiftyplus.com/");
                }
                if(paper.equals("Tunisie Focus"))
                {
                    setTitle("Tunisie Focus");
                    myWebView.loadUrl("http://www.tunisiefocus.com/");
                }
                if(paper.equals("Assabah"))
                {
                    setTitle("Assabah");
                    myWebView.loadUrl("http://www.assabah.com.tn/");
                }
            }
            myWebView.setWebViewClient(new WebViewClient());
        }

        else
        {
            Toast.makeText(this,"No Internet Connection!!!! Please Check your Internet Connection\n And try again..", Toast.LENGTH_LONG).show();
        }
    }

    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();

        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
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
            Intent i = new Intent(this, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //FLAG_ACTIVITY_PREVIOUS_IS_TOP
            startActivity(i);
        }
        if(id == R.id.home){
               /* onBackPressed();
                return true;*/
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
