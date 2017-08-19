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
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.view.View.GONE;

public class Main3Activity extends AppCompatActivity {
    private WebView myWebView;
    String country, paper;
    AdView mAdview;
    private ProgressBar progressBar;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        progressBar.setMax(100);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        //Bundle extras = getIntent().getExtras();
        //int position1 = extras.getInt("POSITION");
        //int position2 = extras.getInt("POS");
        country = getIntent().getStringExtra("Country");
        paper = getIntent().getStringExtra("paper");

        myWebView = (WebView)findViewById(R.id.wb);

        WebSettings webSettings = myWebView.getSettings();
        myWebView.setWebViewClient(new HelpClient());

        myWebView.setWebChromeClient(new WebChromeClient()
        {
            public void onProgressChanged(WebView view, int progress)
            {
                frameLayout.setVisibility(View.VISIBLE);
                progressBar.setProgress(progress);
                if(progress == 100)
                {
                    frameLayout.setVisibility(View.GONE);
                }
                super.onProgressChanged(view, progress);
            }
        });

        myWebView.setVerticalScrollBarEnabled(false);
        webSettings.setJavaScriptEnabled(true);
        myWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        myWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        myWebView.getSettings().setAppCacheEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSettings.setUseWideViewPort(true);
        webSettings.setSavePassword(true);
        webSettings.setSaveFormData(true);
        webSettings.setEnableSmoothTransition(true);
        myWebView.getSettings().setBuiltInZoomControls(true);



        mAdview = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);

        ConnectivityManager cManager = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo ninfo = cManager.getActiveNetworkInfo();
        if(ninfo != null && ninfo.isConnected())
        {
           /* ProgressDialog pdialog=new ProgressDialog(this);
            pdialog.setTitle("Loading");
            pdialog.setCancelable(true);
            pdialog.setMessage("Loading .... Please Wait");
            pdialog.show();*/

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
            else if(country.equals("Bahrain"))
            {
                if(paper.equals("Al-Wasat"))
                {
                    setTitle("Al-Wasat");
                    myWebView.loadUrl("http://www.alwasatnews.com/");
                }
                if(paper.equals("Gulf Daily News"))
                {
                    setTitle("Gulf Daily News");
                    myWebView.loadUrl("http://www.gdnonline.com/");
                }
                if(paper.equals("Al Ayam"))
                {
                    setTitle("Al Ayam");
                    myWebView.loadUrl("http://www.alayam.com/");
                }
                if(paper.equals("Akhbar Al Khaleej"))
                {
                    setTitle("Akhbar Al Khaleej");
                    myWebView.loadUrl("http://www.akhbar-alkhaleej.com/");
                }
                if(paper.equals("Al-Watan"))
                {
                    setTitle("Al-Watan");
                    myWebView.loadUrl("http://alwatannews.net/");
                }
                if(paper.equals("Daily Tribune"))
                {
                    setTitle("Daily Tribune");
                    myWebView.loadUrl("http://www.dailytrib.com/");
                }
                if(paper.equals("Al Bilad"))
                {
                    setTitle("Al Bilad");
                    myWebView.loadUrl("http://www.albiladpress.com/");
                }
                if(paper.equals("Al-Waqt"))
                {
                    setTitle("Al-Waqt");
                    myWebView.loadUrl("http://www.alwaqt.com/");
                }
                if(paper.equals("Chandrika"))
                {
                    setTitle("Chandrika");
                    myWebView.loadUrl("http://www.chandrikadaily.com/");
                }
            }
            else if(country.equals("Finland"))
            {
                if(paper.equals("Helsingin Sanomat"))
                {
                    setTitle("Helsingin Sanomat");
                    myWebView.loadUrl("http://www.hs.fi/");
                }
                if(paper.equals("Helsinki Times"))
                {
                    setTitle("Helsinki Times");
                    myWebView.loadUrl("http://www.helsinkitimes.fi/");
                }
                if(paper.equals("Aamulehti"))
                {
                    setTitle("Aamulehti");
                    myWebView.loadUrl("https://www.aamulehti.fi/");
                }
                if(paper.equals("Iltalehti"))
                {
                    setTitle("Iltalehti");
                    myWebView.loadUrl("http://www.iltalehti.fi/");
                }
                if(paper.equals("Hufvudstadsbladet"))
                {
                    setTitle("Hufvudstadsbladet");
                    myWebView.loadUrl("https://www.hbl.fi/");
                }
                if(paper.equals("Turun Sanomat"))
                {
                    setTitle("Turun Sanomat");
                    myWebView.loadUrl("http://www.ts.fi/");
                }
                if(paper.equals("Ilta-Sanomat"))
                {
                    setTitle("Ilta-Sanomat");
                    myWebView.loadUrl("http://www.is.fi/");
                }
                if(paper.equals("Kauppalehti"))
                {
                    setTitle("Kauppalehti");
                    myWebView.loadUrl("https://www.kauppalehti.fi/");
                }
                if(paper.equals("Kaleva"))
                {
                    setTitle("Kaleva");
                    myWebView.loadUrl("http://www.kaleva.fi/");
                }
                if(paper.equals("Keskisuomalainen"))
                {
                    setTitle("Keskisuomalainen");
                    myWebView.loadUrl("http://www.ksml.fi/");
                }
            }
            else if(country.equals("Bulgaria"))
            {
                if(paper.equals("Dnevnik"))
                {
                    setTitle("Dnevnik");
                    myWebView.loadUrl("http://www.dnevnik.bg/");
                }
                if(paper.equals("Standart"))
                {
                    setTitle("Standart");
                    myWebView.loadUrl("http://www.standartnews.com/");
                }
                if(paper.equals("Trud"))
                {
                    setTitle("Trud");
                    myWebView.loadUrl("https://trud.bg/");
                }
                if(paper.equals("Kapital"))
                {
                    setTitle("Kapital");
                    myWebView.loadUrl("http://www.capital.bg/");
                }
                if(paper.equals("24 Chasa"))
                {
                    setTitle("24 Chasa");
                    myWebView.loadUrl("https://www.24chasa.bg/");
                }
                if(paper.equals("The Sofia Echo"))
                {
                    setTitle("The Sofia Echo");
                    myWebView.loadUrl("http://www.sofia-guide.com/");
                }
                if(paper.equals("Meridian Match"))
                {
                    setTitle("Meridian Match");
                    myWebView.loadUrl("http://www.meridianmatch.bg/");
                }
                if(paper.equals("Novinar"))
                {
                    setTitle("Novinar");
                    myWebView.loadUrl("https://e-novinar.com/");
                }
                if(paper.equals("Telegraph"))
                {
                    setTitle("Telegraph");
                    myWebView.loadUrl("http://www.telegraph.bg/");
                }
                if(paper.equals("Makedonia"))
                {
                    setTitle("Makedonia");
                    myWebView.loadUrl("https://www.revolvy.com/");
                }
            }
            else if(country.equals("Algeria"))
            {
                if(paper.equals("El Watan"))
                {
                    setTitle("El Watan");
                    myWebView.loadUrl("http://www.elwatan.com/");
                }
                if(paper.equals("El Khabar"))
                {
                    setTitle("El Khabar");
                    myWebView.loadUrl("http://www.elkhabar.com/");
                }
                if(paper.equals("Liberté"))
                {
                    setTitle("Liberté");
                    myWebView.loadUrl("http://www.liberte-algerie.com/");
                }
                if(paper.equals("Echorouk"))
                {
                    setTitle("Echorouk");
                    myWebView.loadUrl("http://www.echoroukonline.com/ara/");
                }
                if(paper.equals("El Massa"))
                {
                    setTitle("El Massa");
                    myWebView.loadUrl("https://www.el-massa.com/");
                }
                if(paper.equals("El Moudjahid"))
                {
                    setTitle("El Moudjahid");
                    myWebView.loadUrl("http://www.elmoudjahid.com/");
                }
                if(paper.equals("El Heddaf"))
                {
                    setTitle("El Heddaf");
                    myWebView.loadUrl("http://www.elheddaf.com/");
                }
                if(paper.equals("Le Soir d'Algérie"))
                {
                    setTitle("Le Soir d'Algérie");
                    myWebView.loadUrl("http://www.presse-algerie.fr/lesoir.php");
                }
                if(paper.equals("El Djoumhouria"))
                {
                    setTitle("El Djoumhouria");
                    myWebView.loadUrl("https://www.eldjoumhouria.dz/");
                }
                if(paper.equals("El Acil"))
                {
                    setTitle("El Acil");
                    myWebView.loadUrl("http://www.elacil.com/");
                }
            }
            else if(country.equals("Afghanistan"))
            {
                if(paper.equals("Pajhwok Afgan News"))
                {
                    setTitle("Pajhwok Afgan News");
                    myWebView.loadUrl("https://www.pajhwok.com/");
                }
                if(paper.equals("Afghanistan Times"))
                {
                    setTitle("Afghanistan Times");
                    myWebView.loadUrl("http://afghanistantimes.af/");
                }
                if(paper.equals("The Afghanistan Sun"))
                {
                    setTitle("The Afghanistan Sun");
                    myWebView.loadUrl("http://www.afghanistansun.com/");
                }
                if(paper.equals("Bassirat"))
                {
                    setTitle("Bassirat");
                    myWebView.loadUrl("http://www.bassirat.net/");
                }
                if(paper.equals("Daily Afghanistan"))
                {
                    setTitle("Daily Afghanistan");
                    myWebView.loadUrl("http://www.dailyafghanistan.com/");
                }
                if(paper.equals("The Dawat"))
                {
                    setTitle("The Dawat");
                    myWebView.loadUrl("http://www.dawatfreemedia.org/");
                }
                if(paper.equals("Khaama Press"))
                {
                    setTitle("Khama Press");
                    myWebView.loadUrl("http://www.khaama.com/");
                }
                if(paper.equals("Kabul Press"))
                {
                    setTitle("Kabul Press");
                    myWebView.loadUrl("https://www.kabulpress.org/");
                }
                if(paper.equals("The Taand"))
                {
                    setTitle("The Taand");
                    myWebView.loadUrl("http://www.taand.com/");
                }
                if(paper.equals("The Tolafghan"))
                {
                    setTitle("The Tolafghan");
                    myWebView.loadUrl("http://www.tolafghan.com/");
                }
            }
            else if(country.equals("Cambodia"))
            {
                if(paper.equals("The Cambodia Daily"))
                {
                    setTitle("The Cambodia Daily");
                    myWebView.loadUrl("https://www.cambodiadaily.com/");
                }
                if(paper.equals("Phnom Penh Post"))
                {
                    setTitle("Phnom Penh Post");
                    myWebView.loadUrl("http://www.phnompenhpost.com/");
                }
                if(paper.equals("Moneaksekar Khmer"))
                {
                    setTitle("Moneaksekar Khmer");
                    myWebView.loadUrl("http://www.moneaksekar.com/");
                }
                if(paper.equals("Koh Santepheap"))
                {
                    setTitle("Koh Santepheap");
                    myWebView.loadUrl("http://www.khmer440.com/k/tag/koh-santepheap/");
                }
                if(paper.equals("The Voice of Khmer Youth"))
                {
                    setTitle("The Voice of Khmer Youth");
                    myWebView.loadUrl("http://www.wow.com/wiki/The_Voice_of_Khmer_Youth");
                }
                if(paper.equals("Kampuchea Thmei Daily"))
                {
                    setTitle("Kampuchea Thmei Daily");
                    myWebView.loadUrl("http://kampucheathmey.com/2016/");
                }
                if(paper.equals("Kohsantepheap Daily"))
                {
                    setTitle("Kohsantepheap Daily");
                    myWebView.loadUrl("https://archive.org/details/KohSantepheapDailyNewspaper");
                }
                if(paper.equals("Sralanh Khmer"))
                {
                    setTitle("Sralanh Khmer");
                    myWebView.loadUrl("https://ipfs.io/ipfs/QmXoypizjW3WknFiJnKLwHCnL72vedxjQkDDP1mXWo6uco/wiki/Sralanh_Khmer.html");
                }
                if(paper.equals("L'Écho du Cambodge"))
                {
                    setTitle("L'Écho du Cambodge");
                    myWebView.loadUrl("http://www.echoducambodge.com/");
                }
            }
            else if(country.equals("Latvia"))
            {
                if(paper.equals("Diena"))
                {
                    setTitle("Diena");
                    myWebView.loadUrl("https://www.diena.lv/");
                }
                if(paper.equals("The Baltic Times"))
                {
                    setTitle("The Baltic Times");
                    myWebView.loadUrl("https://www.baltictimes.com/");
                }
                if(paper.equals("Neatkarīgā Rīta Avīze"))
                {
                    setTitle("Neatkarīgā Rīta Avīze");
                    myWebView.loadUrl("http://nra.lv/");
                }
                if(paper.equals("Latvijas Avīze"))
                {
                    setTitle("Latvijas Avīze");
                    myWebView.loadUrl("http://www.la.lv/");
                }
                if(paper.equals("The Chas"))
                {
                    setTitle("The Chas");
                    myWebView.loadUrl("http://www.chas-daily.com/");
                }
                if(paper.equals("Malienas Ziņas"))
                {
                    setTitle("Malienas Ziņas");
                    myWebView.loadUrl("http://www.malienaszinas.lv/");
                }
                if(paper.equals("Novadnieks"))
                {
                    setTitle("Novadnieks");
                    myWebView.loadUrl("http://www.ventspilsnovads.lv/ct-menu-item-528");
                }
                if(paper.equals("Vesti segodnya"))
                {
                    setTitle("Vesti segodnya");
                    myWebView.loadUrl("http://vesti.lv/categories/vesti-segodnya");
                }
                if(paper.equals("Rīgas Apriņķa Avīze"))
                {
                    setTitle("Rīgas Apriņķa Avīze");
                    myWebView.loadUrl("http://www.aprinkis.lv/");
                }
                if(paper.equals("Ludzas Zeme"))
                {
                    setTitle("Ludzas Zeme");
                    myWebView.loadUrl("http://www.ludzaszeme.lv/");
                }
            }
            else if(country.equals("Guine"))
            {
                if(paper.equals("PNG post courier"))
                {
                    setTitle("PNG post courier");
                    myWebView.loadUrl("http://postcourier.com.pg/");
                }
                if(paper.equals("Le Lynx"))
                {
                    setTitle("Le Lynx");
                    myWebView.loadUrl("http://lelynx.net/");
                }
                if(paper.equals("The Independent"))
                {
                    setTitle("The Independent");
                    myWebView.loadUrl("http://www.independent.co.uk/travel/ausandpacific/papua-new-guinea-a-journey-into-the-unknown-1979648.html");
                }
                if(paper.equals("The National"))
                {
                    setTitle("The National");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/The_National_(Papua_New_Guinea)");
                }
            }
            else if(country.equals("Jordan"))
            {
                if(paper.equals("Jordan Times"))
                {
                    setTitle("Jordan Times");
                    myWebView.loadUrl("http://www.jordantimes.com/");
                }
                if(paper.equals("Al Ra'i"))
                {
                    setTitle("Al Ra'i");
                    myWebView.loadUrl("http://alrai.com/");
                }
                if(paper.equals("Ad-Dustour"))
                {
                    setTitle("Ad-Dustour");
                    myWebView.loadUrl("http://www.addustour.com/");
                }
                if(paper.equals("Al Ghad"))
                {
                    setTitle("Al Ghad");
                    myWebView.loadUrl("http://www.alghad.com/");
                }
                if(paper.equals("Assabeel"))
                {
                    setTitle("Assabeel");
                    myWebView.loadUrl("http://assabeel.net/");
                }
                if(paper.equals("Shihan"))
                {
                    setTitle("Shihan");
                    myWebView.loadUrl("http://www.shihan.press/");
                }
                if(paper.equals("Al Anbat"))
                {
                    setTitle("Al Anbat");
                    myWebView.loadUrl("http://www.alanbatnews.net/");
                }
                if(paper.equals("Al-Dustour"))
                {
                    setTitle("Al-Dustour");
                    myWebView.loadUrl("http://www.dostor.org/");
                }
                if(paper.equals("Al-Hadath"))
                {
                    setTitle("Al-Hadath");
                    myWebView.loadUrl("http://www.alhadath.net/");
                }
            }
            else if(country.equals("Yemen"))
            {
                if(paper.equals("Al Sahwa"))
                {
                    setTitle("Al Sahwa");
                    myWebView.loadUrl("http://www.alsahwa-yemen.net/en/");
                }
                if(paper.equals("Al-Thawra"))
                {
                    setTitle("Al-Thawra");
                    myWebView.loadUrl("http://www.althawranews.net/");
                }
                if(paper.equals("Yemen Post"))
                {
                    setTitle("Yemen Post");
                    myWebView.loadUrl("http://www.yemenpost.net/");
                }
                if(paper.equals("Yemen Observer"))
                {
                    setTitle("Yemen Observer");
                    myWebView.loadUrl("http://www.yobserver.com/");
                }
                if(paper.equals("14 October"))
                {
                    setTitle("14 October");
                    myWebView.loadUrl("http://www.14october.com/");
                }
                if(paper.equals("Al-Jumhuryah"))
                {
                    setTitle("Al-Jumhuryah");
                    myWebView.loadUrl("http://wikivisually.com/wiki/Al-Jumhuryah");
                }
                if(paper.equals("Yemen Times"))
                {
                    setTitle("Yemen Times");
                    myWebView.loadUrl("http://www.yementimes.com/");
                }
            }
            else if(country.equals("Nigeria"))
            {
                if(paper.equals("Vanguard"))
                {
                    setTitle("Vanguard");
                    myWebView.loadUrl("http://www.vanguardngr.com/");
                }
                if(paper.equals("The Punch"))
                {
                    setTitle("The Punch");
                    myWebView.loadUrl("http://punchng.com/");
                }
                if(paper.equals("The Nation"))
                {
                    setTitle("The Nation");
                    myWebView.loadUrl("http://thenationonlineng.net/");
                }
                if(paper.equals("Sahara Reports"))
                {
                    setTitle("Sahara Reports");
                    myWebView.loadUrl("http://saharareporters.com/");
                }
                if(paper.equals("This Day"))
                {
                    setTitle("This Day");
                    myWebView.loadUrl("http://www.thisdaylive.com/");
                }
                if(paper.equals("The Guardian"))
                {
                    setTitle("The Guardian");
                    myWebView.loadUrl("http://guardian.ng/");
                }
                if(paper.equals("The Daily Post"))
                {
                    setTitle("The Daily Post");
                    myWebView.loadUrl("http://dailypost.ng/");
                }
                if(paper.equals("Nigeria World"))
                {
                    setTitle("Nigeria World");
                    myWebView.loadUrl("http://www.nigeriaworld.com/");
                }
                if(paper.equals("The Nigeria Pilot"))
                {
                    setTitle("The Nigeria Pilot");
                    myWebView.loadUrl("http://nigerianpilot.com/");
                }
                if(paper.equals("The Nigerian Observer"))
                {
                    setTitle("The Nigerian Observer");
                    myWebView.loadUrl("");
                }
            }
            else if(country.equals("Belarus"))
            {
                if(paper.equals("Nasha Niva"))
                {
                    setTitle("Nasha Niva");
                    myWebView.loadUrl("http://nn.by/");
                }
                if(paper.equals("Zvyazda"))
                {
                    setTitle("Zvyazda");
                    myWebView.loadUrl("http://zviazda.by/be");
                }
                if(paper.equals("Sovetskaya Belorussiya"))
                {
                    setTitle("Sovetskaya Belorussiya");
                    myWebView.loadUrl("https://www.sb.by/");
                }
                if(paper.equals("BelGazeta"))
                {
                    setTitle("BelGazeta");
                    myWebView.loadUrl("http://www.belgazeta.by/");
                }
                if(paper.equals("Novy Chas"))
                {
                    setTitle("Novy Chas");
                    myWebView.loadUrl("https://novychas.by/");
                }
                if(paper.equals("Belorusskaya Delovaya Gazeta"))
                {
                    setTitle("Belorusskaya Delovaya Gazeta");
                    myWebView.loadUrl("http://bdg.by/");
                }
                if(paper.equals("Brestskiy Kurier"))
                {
                    setTitle("Brestskiy Kurier");
                    myWebView.loadUrl("http://www.bk-brest.by/");
                }
                if(paper.equals("Narodnaja Volya"))
                {
                    setTitle("Narodnaja Volya");
                    myWebView.loadUrl("http://www.nv-online.info/");
                }
                if(paper.equals("Hazeta Slonimskaya"))
                {
                    setTitle("Hazeta Slonimskaya");
                    myWebView.loadUrl("http://wikivisually.com/wiki/Hazeta_Slonimskaya");
                }
                if(paper.equals("Intex-Press"))
                {
                    setTitle("Intex-Press");
                    myWebView.loadUrl("https://www.intex-press.by/");
                }
            }
            else if(country.equals("Colombia"))
            {
                if(paper.equals("El Tiempo"))
                {
                    setTitle("El Tiempo");
                    myWebView.loadUrl("http://www.eltiempo.com/");
                }
                if(paper.equals("El Espectador"))
                {
                    setTitle("El Espectador");
                    myWebView.loadUrl("http://www.elespectador.com/noticias");
                }
                if(paper.equals("El Colombiano"))
                {
                    setTitle("El Colombiano");
                    myWebView.loadUrl("http://www.elcolombiano.com/");
                }
                if(paper.equals("El Heraldo"))
                {
                    setTitle("El Heraldo");
                    myWebView.loadUrl("https://www.elheraldo.co/");
                }
                if(paper.equals("Vanguardia Liberal"))
                {
                    setTitle("Vanguardia Liberal");
                    myWebView.loadUrl("http://www.vanguardia.com/");
                }
                if(paper.equals("La Crónica del Quindío"))
                {
                    setTitle("La Crónica del Quindío");
                    myWebView.loadUrl("http://www.cronicadelquindio.com/");
                }
                if(paper.equals("El País"))
                {
                    setTitle("El País");
                    myWebView.loadUrl("http://www.elpais.com.co/");
                }
                if(paper.equals("El Espacio"))
                {
                    setTitle("El Espacio");
                    myWebView.loadUrl("https://www.elespaciocolombia.com/");
                }
                if(paper.equals("Nashville City Paper"))
                {
                    setTitle("Nashville City Paper");
                    myWebView.loadUrl("http://nashvillecitypaper.com/");
                }
                if(paper.equals("El Mundo"))
                {
                    setTitle("El Mundo");
                    myWebView.loadUrl("http://www.elmundo.com/");
                }
            }
            else if(country.equals("Wales"))
            {
                if(paper.equals("Western Mail"))
                {
                    setTitle("Western Mail");
                    myWebView.loadUrl("https://www.britishnewspaperarchive.co.uk/titles/western-mail");
                }
                if(paper.equals("South Wales Evening Post"))
                {
                    setTitle("South Wales Evening Post");
                    myWebView.loadUrl("http://www.walesonline.co.uk/buy-sell-tell/family-notices/");
                }
                if(paper.equals("South Wales Echo"))
                {
                    setTitle("South Wales Echo");
                    myWebView.loadUrl("http://www.walesonline.co.uk/");
                }
                if(paper.equals("South Wales Argus"))
                {
                    setTitle("South Wales Argus");
                    myWebView.loadUrl("http://www.southwalesargus.co.uk/");
                }
                if(paper.equals("Cambrian News"))
                {
                    setTitle("Cambrian News");
                    myWebView.loadUrl("http://www.cambrian-news.co.uk/");
                }
                if(paper.equals("North Wales Daily Post"))
                {
                    setTitle("North Wales Daily Post");
                    myWebView.loadUrl("http://www.dailypost.co.uk/");
                }
                if(paper.equals("Carmarthen Journal"))
                {
                    setTitle("Carmarthen Journal");
                    myWebView.loadUrl("http://www.walesonline.co.uk/all-about/carmarthen");
                }
                if(paper.equals("Wrexham Evening Leader"))
                {
                    setTitle("Wrexham Evening Leader");
                    myWebView.loadUrl("http://www.leaderlive.co.uk/");
                }
                if(paper.equals("Y Dinesydd"))
                {
                    setTitle("Y Dinesydd");
                    myWebView.loadUrl("http://www.dinesydd.com/");
                }
                if(paper.equals("Penarth Times"))
                {
                    setTitle("Penarth Times");
                    myWebView.loadUrl("http://www.penarthtimes.co.uk/");
                }
            }
            else if(country.equals("Ghana"))
            {
                if(paper.equals("Daily Graphic"))
                {
                    setTitle("Daily Graphic");
                    myWebView.loadUrl("http://www.graphic.com.gh/");
                }
                if(paper.equals("News Ghana"))
                {
                    setTitle("News Ghana");
                    myWebView.loadUrl("https://www.newsghana.com.gh/");
                }
                if(paper.equals("Daily Guide"))
                {
                    setTitle("Daily Guide");
                    myWebView.loadUrl("http://dailyguideafrica.com/");
                }
                if(paper.equals("Ghanaian Times"))
                {
                    setTitle("Ghanaian Times");
                    myWebView.loadUrl("http://www.ghanaiantimes.com.gh/");
                }
                if(paper.equals("The Ghanaian Chronicle"))
                {
                    setTitle("The Ghanaian Chronicle");
                    myWebView.loadUrl("http://thechronicle.com.gh/category/news/");
                }
                if(paper.equals("Business Day"))
                {
                    setTitle("Business Day");
                    myWebView.loadUrl("http://www.businessdayonline.com/");
                }
            }
            else if(country.equals("Serbia"))
            {
                if(paper.equals("Večernje novosti"))
                {
                    setTitle("Večernje novosti");
                    myWebView.loadUrl("http://www.novosti.rs/");
                }
                if(paper.equals("Politika"))
                {
                    setTitle("Politika");
                    myWebView.loadUrl("http://www.politika.rs/");
                }
                if(paper.equals("Danas"))
                {
                    setTitle("Danas");
                    myWebView.loadUrl("http://www.danas.rs/danasrs.1.html");
                }
                if(paper.equals("Alo!"))
                {
                    setTitle("Alo!");
                    myWebView.loadUrl("http://www.alo.rs/");
                }
                if(paper.equals("Borba"))
                {
                    setTitle("Borba");
                    myWebView.loadUrl("http://www.blic.rs/borba");
                }
                if(paper.equals("Libertatea"))
                {
                    setTitle("Libertatea");
                    myWebView.loadUrl("http://libertatea.rs/");
                }
                if(paper.equals("Sportski žurnal"))
                {
                    setTitle("Sportski žurnal");
                    myWebView.loadUrl("http://www.zurnal.rs/");
                }
                if(paper.equals("Dnevni telegraf"))
                {
                    setTitle("Dnevni telegraf");
                    myWebView.loadUrl("http://www.telegraf.rs/");
                }
                if(paper.equals("Sutra"))
                {
                    setTitle("Sutra");
                    myWebView.loadUrl("https://sutranews.com/");
                }
            }
            else if(country.equals("Chad"))
            {
                if(paper.equals("The Afrik"))
                {
                    setTitle("The Afrik");
                    myWebView.loadUrl("http://www.afrik.com/tchad/");
                }
                if(paper.equals("Afrol News"))
                {
                    setTitle("Afrol News");
                    myWebView.loadUrl("http://www.afrol.com/countries/chad");
                }
                if(paper.equals("N'djamena Hebdo"))
                {
                    setTitle("N'djamena Hebdo");
                    myWebView.loadUrl("http://ndjamenahebdo.chez.com/");
                }
                if(paper.equals("NTA Newstime"))
                {
                    setTitle("NTA Newstime");
                    myWebView.loadUrl("http://www.newstimeafrica.com/archives/category/central-africa-news/chad");
                }
                if(paper.equals("Tchadien"))
                {
                    setTitle("Tchadien");
                    myWebView.loadUrl("http://tchadien.com/");
                }
            }
            else if(country.equals("Gabon"))
            {
                if(paper.equals("Eagle Reporters"))
                {
                    setTitle("Eagle Reporters");
                    myWebView.loadUrl("http://www.eaglereporters.com/");
                }
                if(paper.equals("Gabon News"))
                {
                    setTitle("Gabon News");
                    myWebView.loadUrl("http://www.gabonnews.com/");
                }
                if(paper.equals("NTA Newstime"))
                {
                    setTitle("NTA Newstime");
                    myWebView.loadUrl("http://www.newstimeafrica.com/archives/category/central-africa-news/gabon");
                }
                if(paper.equals("Times Gabon"))
                {
                    setTitle("Times Gabon");
                    myWebView.loadUrl("http://www.timesgabon.com/");
                }
                if(paper.equals("The Worldfolio"))
                {
                    setTitle("The Worldfolio");
                    myWebView.loadUrl("http://www.theworldfolio.com/gabon");
                }
            }
            else if(country.equals("Bolivia"))
            {
                if(paper.equals("Bol Press"))
                {
                    setTitle("Bol Press");
                    myWebView.loadUrl("http://bolpress.com/");
                }
                if(paper.equals("Bolivia Exterior"))
                {
                    setTitle("Bolivia Exterior");
                    myWebView.loadUrl("http://www.boliviaexterior.com/");
                }
                if(paper.equals("Bolivia Presana"))
                {
                    setTitle("Bolivia Presana");
                    myWebView.loadUrl("http://boliviaprensa.com/");
                }
                if(paper.equals("Bolivia Weekly"))
                {
                    setTitle("Bolivia Weekly");
                    myWebView.loadUrl("https://www.boliviaweekly.com/");
                }
                if(paper.equals("De Bolivia"))
                {
                    setTitle("De Bolivia");
                    myWebView.loadUrl("http://www.de-bolivia.com/");
                }
                if(paper.equals("Business News Americas"))
                {
                    setTitle("Business News Americas");
                    myWebView.loadUrl("http://www.bnamericas.com/");
                }
                if(paper.equals("Diez"))
                {
                    setTitle("Diez");
                    myWebView.loadUrl("http://www.diez.bo/");
                }
                if(paper.equals("El Dia"))
                {
                    setTitle("El Dia");
                    myWebView.loadUrl("https://www.eldia.com.bo/");
                }
            }
            else if(country.equals("Hungary"))
            {
                if(paper.equals("Népszabadság"))
                {
                    setTitle("Népszabadság");
                    myWebView.loadUrl("http://hvg.hu/cimke/N%C3%A9pszabads%C3%A1g");
                }
                if(paper.equals("Népszava"))
                {
                    setTitle("Népszava");
                    myWebView.loadUrl("http://nepszava.hu/");
                }
                if(paper.equals("Világgazdaság"))
                {
                    setTitle("Világgazdaság");
                    myWebView.loadUrl("https://www.vg.hu/");
                }
                if(paper.equals("Nemzeti Sport"))
                {
                    setTitle("Nemzeti Sport");
                    myWebView.loadUrl("http://www.nemzetisport.hu/");
                }
                if(paper.equals("The Budapest Times"))
                {
                    setTitle("The Budapest Times");
                    myWebView.loadUrl("http://www.budapesttimes.hu/");
                }
                if(paper.equals("Napi Gazdaság"))
                {
                    setTitle("Napi Gazdaság");
                    myWebView.loadUrl("http://www.napi.hu/");
                }
                if(paper.equals("The Budapest Sun"))
                {
                    setTitle("The Budapest Sun");
                    myWebView.loadUrl("http://www.budapesttimes.hu/");
                }
                if(paper.equals("Mai Nap"))
                {
                    setTitle("Mai Nap");
                    myWebView.loadUrl("http://www.mainap.hu/");
                }
                if(paper.equals("Reggel"))
                {
                    setTitle("Reggel");
                    myWebView.loadUrl("http://magyar-angol-szotar.hu/reggel.html");
                }
                if(paper.equals("A Szabadság"))
                {
                    setTitle("A Szabadság");
                    myWebView.loadUrl("http://www.aszabadsag.hu/");
                }
            }
            else if(country.equals("Poland"))
            {
                if(paper.equals("Gazeta Wyborcza"))
                {
                    setTitle("Gazeta Wyborcza");
                    myWebView.loadUrl("http://wyborcza.pl/0,0.html?disableRedirects=true");
                }
                if(paper.equals("Rzeczpospolita"))
                {
                    setTitle("Rzeczpospolita");
                    myWebView.loadUrl("http://www.rp.pl/");
                }
                if(paper.equals("Fakt"))
                {
                    setTitle("Fakt");
                    myWebView.loadUrl("http://www.fakt.pl/");
                }
                if(paper.equals("The Warsaw Voice"))
                {
                    setTitle("The Warsaw Voice");
                    myWebView.loadUrl("http://www.warsawvoice.pl");
                }
                if(paper.equals("Krakow Post"))
                {
                    setTitle("Krakow Post");
                    myWebView.loadUrl("http://www.krakowpost.com/");
                }
                if(paper.equals("Puls Biznesu"))
                {
                    setTitle("Puls Biznesu");
                    myWebView.loadUrl("https://www.pb.pl/");
                }
                if(paper.equals("Nasz Dziennik"))
                {
                    setTitle("Nasz Dziennik");
                    myWebView.loadUrl("http://www.naszdziennik.pl/");
                }
                if(paper.equals("Życie Warszawy"))
                {
                    setTitle("Życie Warszawy");
                    myWebView.loadUrl("http://www.zw.com.pl/");
                }
                if(paper.equals("Parkiet"))
                {
                    setTitle("Parkiet");
                    myWebView.loadUrl("http://www.parkiet.com/");
                }
                if(paper.equals("Warsaw Business Journal"))
                {
                    setTitle("Warsaw Business Journal");
                    myWebView.loadUrl("http://wbj.pl/");
                }
            }
            else if(country.equals("Greece"))
            {
                if(paper.equals("Eleftherotypia"))
                {
                    setTitle("Eleftherotypia");
                    myWebView.loadUrl("http://www.enet.gr/");
                }
                if(paper.equals("Rizospastis"))
                {
                    setTitle("Rizospastis");
                    myWebView.loadUrl("http://www.rizospastis.gr/");
                }
                if(paper.equals("Naftemporiki"))
                {
                    setTitle("Naftemporiki");
                    myWebView.loadUrl("http://www.naftemporiki.gr/");
                }
                if(paper.equals("Athens News"))
                {
                    setTitle("Athens News");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/Athens_News");
                }
                if(paper.equals("I Avgi"))
                {
                    setTitle("I Avgi");
                    myWebView.loadUrl("http://www.avgi.gr/");
                }
            }
            else if(country.equals("Albania"))
            {
                if(paper.equals("24 ORE"))
                {
                    setTitle("24 ORE");
                    myWebView.loadUrl("http://24-ore.com/");
                }
                if(paper.equals("Albanian News Agency"))
                {
                    setTitle("Albanian News Agency");
                    myWebView.loadUrl("http://www.noa.al/");
                }
                if(paper.equals("Albanian Daily News"))
                {
                    setTitle("Albanian Daily News");
                    myWebView.loadUrl("http://www.albaniannews.com/");
                }
                if(paper.equals("Albanian Economy News"))
                {
                    setTitle("Albanian Economy News");
                    myWebView.loadUrl("https://albanianeconomy.com/");
                }
                if(paper.equals("Albanian Telegraphy Agency"))
                {
                    setTitle("Albanian Telegraphy Agency");
                    myWebView.loadUrl("http://www.hri.org/news/balkans/ata/");
                }
                if(paper.equals("Albanian News"))
                {
                    setTitle("Albanian News");
                    myWebView.loadUrl("http://english.albeu.com/");
                }
                if(paper.equals("Alb News"))
                {
                    setTitle("Alb News");
                    myWebView.loadUrl("http://www.albnews.al/");
                }
                if(paper.equals("Koha Jone"))
                {
                    setTitle("Koha Jone");
                    myWebView.loadUrl("http://www.kohajone.com/");
                }
            }
            else if(country.equals("Croatia"))
            {
                if(paper.equals("Večernji list"))
                {
                    setTitle("Večernji list");
                    myWebView.loadUrl("https://www.vecernji.hr");
                }
                if(paper.equals("Jutarnji list"))
                {
                    setTitle("Jutarnji list");
                    myWebView.loadUrl("http://www.jutarnji.hr/");
                }
                if(paper.equals("Slobodna Dalmacija"))
                {
                    setTitle("Slobodna Dalmacija");
                    myWebView.loadUrl("http://www.slobodnadalmacija.hr/");
                }
                if(paper.equals("Novi list"))
                {
                    setTitle("Novi list");
                    myWebView.loadUrl("http://www.novilist.hr/Vijesti");
                }
                if(paper.equals("Vjesnik"))
                {
                    setTitle("Vjesnik");
                    myWebView.loadUrl("http://vjesnik.hr/");
                }
                if(paper.equals("24sata"))
                {
                    setTitle("24sata");
                    myWebView.loadUrl("https://www.24sata.hr/");
                }
                if(paper.equals("Glas Slavonije"))
                {
                    setTitle("Glas Slavonije");
                    myWebView.loadUrl("http://www.glas-slavonije.hr");
                }
                if(paper.equals("Glas Istre"))
                {
                    setTitle("Glas Istre");
                    myWebView.loadUrl("http://www.glasistre.hr/");
                }
                if(paper.equals("Poslovni dnevnik"))
                {
                    setTitle("Poslovni dnevnik");
                    myWebView.loadUrl("http://www.poslovni.hr/");
                }
                if(paper.equals("Nacional"))
                {
                    setTitle("Nacional");
                    myWebView.loadUrl("http://www.nacional.hr/");
                }
            }
            else if(country.equals("Luxembourg"))
            {
                if(paper.equals("Luxemburger Wort"))
                {
                    setTitle("Luxemburger Wort");
                    myWebView.loadUrl("https://www.wort.lu/");
                }
                if(paper.equals("Tageblatt"))
                {
                    setTitle("Tageblatt");
                    myWebView.loadUrl("http://www.tageblatt.lu/");
                }
                if(paper.equals("Lëtzebuerger Journal"))
                {
                    setTitle("Lëtzebuerger Journal");
                    myWebView.loadUrl("http://www.journal.lu/home/");
                }
                if(paper.equals("L'essentiel"))
                {
                    setTitle("L'essentiel");
                    myWebView.loadUrl("http://www.lessentiel.lu/fr/");
                }
                if(paper.equals("Le Quotidien"))
                {
                    setTitle("Le Quotidien");
                    myWebView.loadUrl("http://www.lequotidien.lu/");
                }
                if(paper.equals("Point24"))
                {
                    setTitle("Point24");
                    myWebView.loadUrl("http://www.point24.sk");
                }
            }
            else if(country.equals("Thailand"))
            {
                if(paper.equals("Bangkok Post"))
                {
                    setTitle("Bangkok Post");
                    myWebView.loadUrl("http://www.bangkokpost.com/");
                }
                if(paper.equals("The Nation"))
                {
                    setTitle("The Nation");
                    myWebView.loadUrl("http://www.nationmultimedia.com/");
                }
                if(paper.equals("The Daily News"))
                {
                    setTitle("The Daily News");
                    myWebView.loadUrl("https://www.dailynews.co.th/");
                }
                if(paper.equals("Kom Chad Luek"))
                {
                    setTitle("Kom Chad Luek");
                    myWebView.loadUrl("http://www.komchadluek.net/");
                }
                if(paper.equals("Thai Post"))
                {
                    setTitle("Thai Post");
                    myWebView.loadUrl("https://www.aftership.com/en/courier/thailand-post");
                }
                if(paper.equals("Phuket Gazette"))
                {
                    setTitle("Phuket Gazette");
                    myWebView.loadUrl("https://www.phuketgazette.net/");
                }
            }
            else if(country.equals("Philippines"))
            {
                if(paper.equals("The Philippine Star"))
                {
                    setTitle("The Philippine Star");
                    myWebView.loadUrl("http://www.philstar.com/");
                }
                if(paper.equals("Philippine Daily Inquirer"))
                {
                    setTitle("Philippine Daily Inquirer");
                    myWebView.loadUrl("http://www.inquirer.net/");
                }
                if(paper.equals("Manila Bulletin"))
                {
                    setTitle("Manila Bulletin");
                    myWebView.loadUrl("http://mb.com.ph/");
                }
                if(paper.equals("Manila Times"))
                {
                    setTitle("Manila Times");
                    myWebView.loadUrl("http://www.manilatimes.net/news/");
                }
                if(paper.equals("Sun.Star"))
                {
                    setTitle("Sun.Star");
                    myWebView.loadUrl("http://www.sunstar.com.ph/");
                }
                if(paper.equals("Malaya"))
                {
                    setTitle("Malaya");
                    myWebView.loadUrl("http://www.malaya.com.ph/");
                }
                if(paper.equals("BusinessWorld"))
                {
                    setTitle("BusinessWorld");
                    myWebView.loadUrl("http://bworldonline.com/");
                }
                if(paper.equals("The Daily Tribune"))
                {
                    setTitle("The Daily Tribune");
                    myWebView.loadUrl("http://www.tribune.net.ph/");
                }
                if(paper.equals("Manila Standard"))
                {
                    setTitle("Manila Standard");
                    myWebView.loadUrl("http://manilastandard.net/");
                }
                if(paper.equals("Abante"))
                {
                    setTitle("Abante");
                    myWebView.loadUrl("https://www.abante.com.ph/");
                }
            }
            else if(country.equals("Taiwan"))
            {
                if(paper.equals("China Times"))
                {
                    setTitle("China Times");
                    myWebView.loadUrl("http://www.chinatimes.com/");
                }
                if(paper.equals("Liberty Times"))
                {
                    setTitle("Liberty Times");
                    myWebView.loadUrl("http://www.ltn.com.tw/");
                }
                if(paper.equals("The China Post"))
                {
                    setTitle("The China Post");
                    myWebView.loadUrl("http://www.chinapost.com.tw/");
                }
                if(paper.equals("Taipei Times"))
                {
                    setTitle("Taipei Times");
                    myWebView.loadUrl("http://www.taipeitimes.com/");
                }
                if(paper.equals("United Daily News"))
                {
                    setTitle("United Daily News");
                    myWebView.loadUrl("http://eunited.com.my/");
                }
                if(paper.equals("Apple Daily"))
                {
                    setTitle("Apple Daily");
                    myWebView.loadUrl("http://www.appledaily.com.tw/");
                }
                if(paper.equals("Taiwan Daily"))
                {
                    setTitle("Taiwan Daily");
                    myWebView.loadUrl("http://www.taiwandaily.net/");
                }
                if(paper.equals("Taiwan Today"))
                {
                    setTitle("Taiwan Today");
                    myWebView.loadUrl("http://www.taiwantoday.tw/");
                }
                if(paper.equals("Mandarin Daily News"))
                {
                    setTitle("Mandarin Daily News");
                    myWebView.loadUrl("http://www.mdnkids.com/english_hp/");
                }
                if(paper.equals("Taiwan Times"))
                {
                    setTitle("Taiwan Times");
                    myWebView.loadUrl("http://www.taipeitimes.com/News/taiwan");
                }
            }
            else if(country.equals("Lebanon"))
            {
                if(paper.equals("An-Nahar"))
                {
                    setTitle("An-Nahar");
                    myWebView.loadUrl("https://www.annahar.com/");
                }
                if(paper.equals("As-Safir"))
                {
                    setTitle("As-Safir");
                    myWebView.loadUrl("https://assafir.com/");
                }
                if(paper.equals("Al-Mustaqbal"))
                {
                    setTitle("Al-Mustaqbal");
                    myWebView.loadUrl("http://www.almustaqbal.com/v4/Home.aspx");
                }
                if(paper.equals("Al Anwar"))
                {
                    setTitle("Al Anwar");
                    myWebView.loadUrl("http://www.alanwar.com/");
                }
                if(paper.equals("L'Orient-Le Jour"))
                {
                    setTitle("L'Orient-Le Jour");
                    myWebView.loadUrl("https://www.lorientlejour.com/");
                }
                if(paper.equals("Ad-Diyar"))
                {
                    setTitle("Ad-Diyar");
                    myWebView.loadUrl("http://www.addiyar.com/");
                }
                if(paper.equals("Al Liwaa"))
                {
                    setTitle("Al Liwaa");
                    myWebView.loadUrl("https://aliwaa.com.lb/");
                }
                if(paper.equals("Al-Balad"))
                {
                    setTitle("Al-Balad");
                    myWebView.loadUrl("http://www.albaladonline.com/ar/Default.aspx?pageid=11730");
                }
                if(paper.equals("Attamaddon"))
                {
                    setTitle("Attamaddon");
                    myWebView.loadUrl("http://www.attamaddon.com/new/news.php");
                }
                if(paper.equals("Aztag"))
                {
                    setTitle("Aztag");
                    myWebView.loadUrl("https://www.aztagdaily.com/");
                }
            }
            else if(country.equals("Mongolia"))
            {
                if(paper.equals("UB Post"))
                {
                    setTitle("UB Post");
                    myWebView.loadUrl("http://ubpost.mongolnews.mn/");
                }
                if(paper.equals("The Mongol Messenger"))
                {
                    setTitle("The Mongol Messenger");
                    myWebView.loadUrl("http://www.montsame.gov.mn/en/index.php/component/k2/itemlist/category/154-mongolmessenger");
                }
                if(paper.equals("Ünen"))
                {
                    setTitle("Ünen");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/%C3%9Cnen");
                }
            }
            else if(country.equals("Tanzania"))
            {
                if(paper.equals("24 Tanzania"))
                {
                    setTitle("24 Tanzania");
                    myWebView.loadUrl("http://www.24tanzania.com/");
                }
                if(paper.equals("Arusha Raha"))
                {
                    setTitle("Arusha Raha");
                    myWebView.loadUrl("http://www.arusharaha.com/");
                }
                if(paper.equals("Arusha Times"))
                {
                    setTitle("Arusha Times");
                    myWebView.loadUrl("http://www.arushatimes.co.tz/");
                }
                if(paper.equals("Business Times"))
                {
                    setTitle("Business Times");
                    myWebView.loadUrl("http://www.bcstimes.com/btimes/index.shtml");
                }
                if(paper.equals("The Citizen"))
                {
                    setTitle("The Citizen");
                    myWebView.loadUrl("http://www.thecitizen.co.tz/");
                }
                if(paper.equals("The Daily News"))
                {
                    setTitle("The Daily News");
                    myWebView.loadUrl("http://www.dailynews.co.tz/");
                }
                if(paper.equals("East Africa News Post"))
                {
                    setTitle("East Africa News Post");
                    myWebView.loadUrl("http://www.eastafricanewspost.com/");
                }
                if(paper.equals("The Express"))
                {
                    setTitle("The Express");
                    myWebView.loadUrl("http://www.theexpress.com/");
                }
                if(paper.equals("Guardian IPP"))
                {
                    setTitle("Guardian IPP");
                    myWebView.loadUrl("http://www.ippmedia.com/sw");
                }
                if(paper.equals("In2EastAfrica"))
                {
                    setTitle("In2EastAfrica");
                    myWebView.loadUrl("http://in2eastafrica.net/?hg=0&nr=0");
                }
            }
            else if(country.equals("Brunei"))
            {
                if(paper.equals("Borneo Bulletin"))
                {
                    setTitle("Borneo Bulletin");
                    myWebView.loadUrl("http://borneobulletin.com.bn/");
                }
                if(paper.equals("The Brunei Times"))
                {
                    setTitle("The Brunei Times");
                    myWebView.loadUrl("https://www.youtube.com/user/thebruneitimes");
                }
                if(paper.equals("Media Permata"))
                {
                    setTitle("Media Permata");
                    myWebView.loadUrl("http://mediapermata.com.bn/");
                }
            }
            else if(country.equals("Ecuador"))
            {
                if(paper.equals("Business News Americas"))
                {
                    setTitle("Business News Americas");
                    myWebView.loadUrl("http://www.bnamericas.com/");
                }
                if(paper.equals("The Correo"))
                {
                    setTitle("The Correo");
                    myWebView.loadUrl("http://www.orenses.com/");
                }
                if(paper.equals("The Cosas"))
                {
                    setTitle("The Cosas");
                    myWebView.loadUrl("http://cosas.com.ec/");
                }
                if(paper.equals("Cuenca High Life"))
                {
                    setTitle("Cuenca High Life");
                    myWebView.loadUrl("https://cuencahighlife.com");
                }
                if(paper.equals("Cuenca News Digest"))
                {
                    setTitle("Cuenca News Digest");
                    myWebView.loadUrl("http://www.cuencanewsdigest.com/");
                }
                if(paper.equals("Diario Cronica"))
                {
                    setTitle("Diario Cronica");
                    myWebView.loadUrl("https://www.cronica.com.ec/");
                }
                if(paper.equals("Diario El Extra"))
                {
                    setTitle("Diario El Extra");
                    myWebView.loadUrl("http://www.extra.ec/");
                }
                if(paper.equals("Diario Hoy"))
                {
                    setTitle("Diario Hoy");
                    myWebView.loadUrl("http://www.hoy.com.ec/");
                }
                if(paper.equals("Ecuador Mundo"))
                {
                    setTitle("Ecuador Mundo");
                    myWebView.loadUrl("http://www.ecuadormundo.com");
                }
                if(paper.equals("Ecuador Reporter"))
                {
                    setTitle("Ecuador Reporter");
                    myWebView.loadUrl("http://www.ecuadorreporter.com/");
                }
            }
            else if(country.equals("Hondurus"))
            {
                if(paper.equals("Diario Diez"))
                {
                    setTitle("Diario Diez");
                    myWebView.loadUrl("http://www.diez.hn/");
                }
                if(paper.equals("Diario La Prensa"))
                {
                    setTitle("Diario La Prensa");
                    myWebView.loadUrl("http://www.laprensa.hn/");
                }
                if(paper.equals("Diario Tiempo"))
                {
                    setTitle("Diario Tiempo");
                    myWebView.loadUrl("http://tiempo.hn/");
                }
                if(paper.equals("El Articulista"))
                {
                    setTitle("El Articulista");
                    myWebView.loadUrl("http://www.diarioelarticulista.com/");
                }
                if(paper.equals("El Escamoso"))
                {
                    setTitle("El Escamoso");
                    myWebView.loadUrl("http://elescamoso.es.tl/");
                }
                if(paper.equals("El Heraldo"))
                {
                    setTitle("El Heraldo");
                    myWebView.loadUrl("http://www.elheraldo.hn/");
                }
                if(paper.equals("El Libertador"))
                {
                    setTitle("El Libertador");
                    myWebView.loadUrl("http://www.web.ellibertador.hn/");
                }
                if(paper.equals("El Progreseno"))
                {
                    setTitle("El Progreseno");
                    myWebView.loadUrl("http://www.elprogreseno.hn/");
                }
            }

            else if(country.equals("Slovakia"))
            {
                if(paper.equals("The Slovak Spectator"))
                {
                    setTitle("The Slovak Spectator");
                    myWebView.loadUrl("https://spectator.sme.sk/");
                }
                if(paper.equals("Pravda"))
                {
                    setTitle("Pravda");
                    myWebView.loadUrl("https://www.pravda.sk/");
                }
                if(paper.equals("Új Szó"))
                {
                    setTitle("Új Szó");
                    myWebView.loadUrl("http://ujszo.com/");
                }
                if(paper.equals("Hospodárske noviny"))
                {
                    setTitle("Hospodárske noviny");
                    myWebView.loadUrl("http://hnonline.sk/");
                }
                if(paper.equals("Nový čas"))
                {
                    setTitle("Nový čas");
                    myWebView.loadUrl("https://www.cas.sk/");
                }
                if(paper.equals("Korzár"))
                {
                    setTitle("Korzár");
                    myWebView.loadUrl("https://korzar.sme.sk/");
                }
                if(paper.equals("Národná obroda"))
                {
                    setTitle("Národná obroda");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/N%C3%A1rodn%C3%A1_obroda");
                }
                if(paper.equals("Košický večer"))
                {
                    setTitle("Košický večer");
                    myWebView.loadUrl("https://kosice.korzar.sme.sk/");
                }
            }
            else if(country.equals("Chile"))
            {
                if(paper.equals("El Mercurio"))
                {
                    setTitle("El Mercurio");
                    myWebView.loadUrl("http://impresa.elmercurio.com/pages/LUNHomepage.aspx?BodyID=1&dtB=2017-08-16");
                }
                if(paper.equals("La Tercera"))
                {
                    setTitle("La Tercera");
                    myWebView.loadUrl("http://www.latercera.com/");
                }
                if(paper.equals("Las Últimas Noticias"))
                {
                    setTitle("Las Últimas Noticias");
                    myWebView.loadUrl("http://www.lun.com/");
                }
                if(paper.equals("La Segunda"))
                {
                    setTitle("La Segunda");
                    myWebView.loadUrl("http://impresa.lasegunda.com/2017/08/14/A");
                }
                if(paper.equals("La Cuarta"))
                {
                    setTitle("La Cuarta");
                    myWebView.loadUrl("http://www.lacuarta.com/");
                }
                if(paper.equals("elsur"))
                {
                    setTitle("elsur");
                    myWebView.loadUrl("http://www.elsur.cl/impresa/2017/08/16/papel/");
                }
                if(paper.equals("The Santiago Times"))
                {
                    setTitle("The Santiago Times");
                    myWebView.loadUrl("http://santiagotimes.cl/");
                }
                if(paper.equals("Diario Austral"))
                {
                    setTitle("Diario Austral");
                    myWebView.loadUrl("http://www.australtemuco.cl/impresa/2017/08/16/papel/");
                }
                if(paper.equals("La Nación"))
                {
                    setTitle("La Nación");
                    myWebView.loadUrl("http://lanacion.cl/");
                }
                if(paper.equals("El Rancagüino"))
                {
                    setTitle("El Rancagüino");
                    myWebView.loadUrl("http://elrancaguino.cl/");
                }
            }
            else if(country.equals("Paraguya"))
            {
                if(paper.equals("Última Hora"))
                {
                    setTitle("Última Hora");
                    myWebView.loadUrl("http://www.ultimahora.com/");
                }
                if(paper.equals("ABC Color"))
                {
                    setTitle("ABC Color");
                    myWebView.loadUrl("http://www.abc.com.py/");
                }
                if(paper.equals("The 1870 Digital"))
                {
                    setTitle("The 1870 Digital");
                    myWebView.loadUrl("http://1870digital.com/");
                }
                if(paper.equals("E'a"))
                {
                    setTitle("E'a");
                    myWebView.loadUrl("http://ea.com.py/v2/");
                }
                if(paper.equals("La Hoja Online"))
                {
                    setTitle("La Hoja Online");
                    myWebView.loadUrl("http://www.lahojaonline.com/");
                }
                if(paper.equals("La Nacion"))
                {
                    setTitle("La Nacion");
                    myWebView.loadUrl("http://www.lanacion.com.py/");
                }
                if(paper.equals("Neike"))
                {
                    setTitle("Neike");
                    myWebView.loadUrl("http://www.neike.com.py/");
                }
                if(paper.equals("Noticias El Diario"))
                {
                    setTitle("Noticias El Diario");
                    myWebView.loadUrl("http://www.diarionoticias.com.py/");
                }
                if(paper.equals("Viva Paraguay"))
                {
                    setTitle("Viva Paraguay");
                    myWebView.loadUrl("http://www.vivaparaguay.com/modules/news/");
                }
            }
            else if(country.equals("Botswana"))
            {
                if(paper.equals("The Botswana Gazette"))
                {
                    setTitle("The Botswana Gazette");
                    myWebView.loadUrl("http://www.thegazette.news/");
                }
                if(paper.equals("Mmegi"))
                {
                    setTitle("Mmegi");
                    myWebView.loadUrl("http://www.mmegi.bw/");
                }
                if(paper.equals("The Voice"))
                {
                    setTitle("The Voice");
                    myWebView.loadUrl("https://thevoicebw.com/home-2/");
                }
                if(paper.equals("Sunday Times"))
                {
                    setTitle("Sunday Times");
                    myWebView.loadUrl("https://www.timeslive.co.za/sunday-times/");
                }
                if(paper.equals("The Midweek Sun"))
                {
                    setTitle("The Midweek Sun");
                    myWebView.loadUrl("http://www.themidweeksun.co.bw/");
                }
                if(paper.equals("The NTA News Time"))
                {
                    setTitle("The NTA News Time");
                    myWebView.loadUrl("http://www.newstimeafrica.com/archives/category/southern-africa/botswana");
                }
            }
            else if(country.equals("Liberia"))
            {
                if(paper.equals("The Analyst Newspaper"))
                {
                    setTitle("The Analyst Newspaper");
                    myWebView.loadUrl("http://www.analystliberia.com/");
                }
                if(paper.equals("Concord Times"))
                {
                    setTitle("Concord Times");
                    myWebView.loadUrl("http://www.concordtimes-lib.com/");
                }
                if(paper.equals("Daily Observer"))
                {
                    setTitle("Daily Observer");
                    myWebView.loadUrl("https://www.liberianobserver.com/");
                }
                if(paper.equals("Global News Network"))
                {
                    setTitle("Global News Network");
                    myWebView.loadUrl("http://www.gnnliberia.com/");
                }
                if(paper.equals("Hints News Network"))
                {
                    setTitle("Hints News Network");
                    myWebView.loadUrl("http://hintsnewsnetwork.com/");
                }
                if(paper.equals("The Informer"))
                {
                    setTitle("The Informer");
                    myWebView.loadUrl("http://www.informerliberia.net/");
                }
                if(paper.equals("In Profile Daily"))
                {
                    setTitle("In Profile Daily");
                    myWebView.loadUrl("http://inprofiledaily.com/");
                }
            }
            else if(country.equals("Qatar"))
            {
                if(paper.equals("Gulf Times"))
                {
                    setTitle("Gulf Times");
                    myWebView.loadUrl("http://www.gulf-times.com/");
                }
                if(paper.equals("Al Sharq"))
                {
                    setTitle("Al Sharq");
                    myWebView.loadUrl("http://www.al-sharq.com/");
                }
                if(paper.equals("The Peninsula"))
                {
                    setTitle("The Peninsula");
                    myWebView.loadUrl("https://www.thepeninsulaqatar.com/");
                }
                if(paper.equals("Al-Watan"))
                {
                    setTitle("Al-Watan");
                    myWebView.loadUrl("http://www.al-watan.com/");
                }
                if(paper.equals("Al Raya"))
                {
                    setTitle("Al Raya");
                    myWebView.loadUrl("http://www.raya.com/portal");
                }
                if(paper.equals("Al Arab"))
                {
                    setTitle("Al Arab");
                    myWebView.loadUrl("http://www.alarab.co.uk/en/");
                }
                if(paper.equals("Qatar Tribune"))
                {
                    setTitle("Qatar Tribune");
                    myWebView.loadUrl("http://www.qatartribuneepaper.qa/QatarTribunepaper.aspx");
                }
            }
            else if(country.equals("Ireland"))
            {
                if(paper.equals("Irish Independent"))
                {
                    setTitle("Irish Independent");
                    myWebView.loadUrl("http://www.independent.ie/");
                }
                if(paper.equals("Irish News"))
                {
                    setTitle("Irish News");
                    myWebView.loadUrl("http://www.irishnews.com/");
                }
                if(paper.equals("Irish Times"))
                {
                    setTitle("Irish Times");
                    myWebView.loadUrl("https://www.irishtimes.com/");
                }
                if(paper.equals("Irish Examiner"))
                {
                    setTitle("Irish Examiner");
                    myWebView.loadUrl("http://www.irishexaminer.com/");
                }
                if(paper.equals("Evening Herald"))
                {
                    setTitle("Evening Herald");
                    myWebView.loadUrl("http://www.herald.ie/");
                }
                if(paper.equals("Freeman's Journal"))
                {
                    setTitle("Freeman's Journal");
                    myWebView.loadUrl("http://freemansjournal.ie/");
                }
                if(paper.equals("Belfast Newsletter"))
                {
                    setTitle("Belfast Newsletter");
                    myWebView.loadUrl("http://www.newsletter.co.uk/");
                }
                if(paper.equals("The Irish Press"))
                {
                    setTitle("The Irish Press");
                    myWebView.loadUrl("https://www.irishnewsarchive.com/irish-press-newspaper-archive");
                }
                if(paper.equals("Irish Daily Star"))
                {
                    setTitle("Irish Daily Star");
                    myWebView.loadUrl("http://thestar.ie/");
                }
                if(paper.equals("Belfast Telegraph"))
                {
                    setTitle("Belfast Telegraph");
                    myWebView.loadUrl("http://www.belfasttelegraph.co.uk/");
                }
            }
            else if(country.equals("Romania"))
            {
                if(paper.equals("Adevărul"))
                {
                    setTitle("Adevărul");
                    myWebView.loadUrl("http://adevarul.ro/");
                }
                if(paper.equals("Libertatea"))
                {
                    setTitle("Libertatea");
                    myWebView.loadUrl("http://www.libertatea.ro/");
                }
                if(paper.equals("Evenimentul Zilei"))
                {
                    setTitle("Evenimentul Zilei");
                    myWebView.loadUrl("http://evz.ro/");
                }
                if(paper.equals("România Liberă"))
                {
                    setTitle("România Liberă");
                    myWebView.loadUrl("http://romanialibera.ro/");
                }
                if(paper.equals("Cotidianul"))
                {
                    setTitle("Cotidianul");
                    myWebView.loadUrl("http://www.cotidianul.ro/");
                }
                if(paper.equals("Gazeta Sporturilor"))
                {
                    setTitle("Gazeta Sporturilor");
                    myWebView.loadUrl("http://www.gsp.ro/");
                }
                if(paper.equals("Ziarul Financiar"))
                {
                    setTitle("Ziarul Financiar");
                    myWebView.loadUrl("http://www.zf.ro/");
                }
                if(paper.equals("ProSport"))
                {
                    setTitle("ProSport");
                    myWebView.loadUrl("http://www.prosport.ro/");
                }
                if(paper.equals("Ziua"))
                {
                    setTitle("Ziua");
                    myWebView.loadUrl("http://www.ziuanews.ro/en");
                }
                if(paper.equals("Jurnalul Național"))
                {
                    setTitle("Jurnalul Național");
                    myWebView.loadUrl("http://jurnalul.ro/");
                }
            }
            else if(country.equals("Slovenia"))
            {
                if(paper.equals("The Delo"))
                {
                    setTitle("The Delo");
                    myWebView.loadUrl("http://www.delo.si/");
                }
                if(paper.equals("Dnevnik"))
                {
                    setTitle("Dnevnik");
                    myWebView.loadUrl("https://www.dnevnik.si/");
                }
                if(paper.equals("Večer"))
                {
                    setTitle("Večer");
                    myWebView.loadUrl("http://www.vecer.com/");
                }
                if(paper.equals("Primorske novice"))
                {
                    setTitle("Primorske novice");
                    myWebView.loadUrl("http://www.primorske.si/");
                }
                if(paper.equals("Žurnal24"))
                {
                    setTitle("Žurnal24");
                    myWebView.loadUrl("http://www.zurnal24.si/");
                }
                if(paper.equals("Finance"))
                {
                    setTitle("Finance");
                    myWebView.loadUrl("https://www.ft.com/?mhq5j=e4");
                }
                if(paper.equals("Primorski dnevnik"))
                {
                    setTitle("Primorski dnevnik");
                    myWebView.loadUrl("http://www.primorski.it/");
                }
                if(paper.equals("Dom in svet"))
                {
                    setTitle("Dom in svet");
                    myWebView.loadUrl("https://www.dlib.si/");
                }
            }
            else if(country.equals("Estonia"))
            {
                if(paper.equals("Postimees"))
                {
                    setTitle("Postimees");
                    myWebView.loadUrl("http://www.postimees.ee/");
                }
                if(paper.equals("Äripäev"))
                {
                    setTitle("Äripäev");
                    myWebView.loadUrl("http://www.aripaev.ee/");
                }
                if(paper.equals("Õhtuleht"))
                {
                    setTitle("Õhtuleht");
                    myWebView.loadUrl("http://www.ohtuleht.ee/");
                }
                if(paper.equals("Eesti Ekspress"))
                {
                    setTitle("Eesti Ekspress");
                    myWebView.loadUrl("http://ekspress.delfi.ee/");
                }
                if(paper.equals("The Baltic Times"))
                {
                    setTitle("The Baltic Times");
                    myWebView.loadUrl("https://www.baltictimes.com/");
                }
                if(paper.equals("Kesknädal"))
                {
                    setTitle("Kesknädal");
                    myWebView.loadUrl("http://www.kesknadal.ee/");
                }
                if(paper.equals("Põhjarannik"))
                {
                    setTitle("Põhjarannik");
                    myWebView.loadUrl("http://pr.pohjarannik.ee/");
                }
                if(paper.equals("Lääne Elu"))
                {
                    setTitle("Lääne Elu");
                    myWebView.loadUrl("http://online.le.ee/tag/hanila/");
                }
                if(paper.equals("Uma Leht"))
                {
                    setTitle("Uma Leht");
                    myWebView.loadUrl("http://umaleht.ee/");
                }
                if(paper.equals("Sakala"))
                {
                    setTitle("Sakala");
                    myWebView.loadUrl("http://sakala.postimees.ee/");
                }
            }
            else if(country.equals("Jamaica"))
            {
                if(paper.equals("The Jamaica Observer"))
                {
                    setTitle("The Jamaica Observer");
                    myWebView.loadUrl("http://www.jamaicaobserver.com/");
                }
                if(paper.equals("The Jamaica Gleaner"))
                {
                    setTitle("The Jamaica Gleaner");
                    myWebView.loadUrl("http://jamaica-gleaner.com/");
                }
                if(paper.equals("The Jamaica Star"))
                {
                    setTitle("The Jamaica Star");
                    myWebView.loadUrl("http://jamaica-star.com/");
                }
                if(paper.equals("The Commentator"))
                {
                    setTitle("The Commentator");
                    myWebView.loadUrl("http://www.thecommentatorjm.com/");
                }
                if(paper.equals("The Jamaica Patriot"))
                {
                    setTitle("The Jamaica Patriot");
                    myWebView.loadUrl("http://jamaicapatriot.com/");
                }
            }
            else if(country.equals("Moldova"))
            {
                if(paper.equals("Moldova Suverană"))
                {
                    setTitle("Moldova Suverană");
                    myWebView.loadUrl("http://moldova-suverana.md/");
                }
                if(paper.equals("Observatorul de Nord"))
                {
                    setTitle("Observatorul de Nord");
                    myWebView.loadUrl("https://observatorul.md/");
                }
                if(paper.equals("Unghiul"))
                {
                    setTitle("Unghiul");
                    myWebView.loadUrl("http://unghiul.info/");
                }
                if(paper.equals("Timpul de dimineață"))
                {
                    setTitle("Timpul de dimineață");
                    myWebView.loadUrl("http://www.timpul.md/");
                }
                if(paper.equals("Nezavisimaya Gazeta"))
                {
                    setTitle("Nezavisimaya Gazeta");
                    myWebView.loadUrl("http://www.ng.ru/");
                }
                if(paper.equals("Expresul de Ungheni"))
                {
                    setTitle("Expresul de Ungheni");
                    myWebView.loadUrl("https://www.expresul.md/");
                }
                if(paper.equals("Adevărul Moldova"))
                {
                    setTitle("Adevărul Moldova");
                    myWebView.loadUrl("http://adevarul.ro/moldova/");
                }
                if(paper.equals("Cuvântul"))
                {
                    setTitle("Cuvântul");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/Cuv%C3%A2ntul_(Moldovan_newspaper)");
                }
                if(paper.equals("Basarabia"))
                {
                    setTitle("Basarabia");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/Basarabia_(newspaper)");
                }
                if(paper.equals("Moldova"))
                {
                    setTitle("Moldova");
                    myWebView.loadUrl("http://www.onlinenewspapers.com/moldova.htm");
                }
            }
            else if(country.equals("Malaysia"))
            {
                if(paper.equals("The Star"))
                {
                    setTitle("The Star");
                    myWebView.loadUrl("http://www.thestar.com.my/");
                }
                if(paper.equals("New Straits Times"))
                {
                    setTitle("New Straits Times");
                    myWebView.loadUrl("https://www.nst.com.my/");
                }
                if(paper.equals("Utusan Malaysia"))
                {
                    setTitle("Utusan Malaysia");
                    myWebView.loadUrl("http://www.utusan.com.my/");
                }
                if(paper.equals("Malaysiakini"))
                {
                    setTitle("Malaysiakini");
                    myWebView.loadUrl("https://www.malaysiakini.com/");
                }
                if(paper.equals("Malay Mail"))
                {
                    setTitle("Malay Mail");
                    myWebView.loadUrl("http://www.themalaymailonline.com/");
                }
                if(paper.equals("Berita Harian"))
                {
                    setTitle("Berita Harian");
                    myWebView.loadUrl("https://www.bharian.com.my/");
                }
                if(paper.equals("Harian Metro"))
                {
                    setTitle("Harian Metro");
                    myWebView.loadUrl("https://www.hmetro.com.my/");
                }
                if(paper.equals("The Sun"))
                {
                    setTitle("The Sun");
                    myWebView.loadUrl("http://www.thesundaily.my/");
                }
                if(paper.equals("Sin Chew Daily"))
                {
                    setTitle("Sin Chew Daily");
                    myWebView.loadUrl("http://www.sinchew.com.my/");
                }
                if(paper.equals("China Press"))
                {
                    setTitle("China Press");
                    myWebView.loadUrl("http://www.chinapress.com.my/");
                }
            }
            else if(country.equals("Kuwait"))
            {
                if(paper.equals("Kuwait Times"))
                {
                    setTitle("Kuwait Times");
                    myWebView.loadUrl("http://news.kuwaittimes.net/website/");
                }
                if(paper.equals("Arab Times"))
                {
                    setTitle("Arab Times");
                    myWebView.loadUrl("http://www.arabtimesonline.com/news/");
                }
                if(paper.equals("Al-Watan"))
                {
                    setTitle("Al-Watan");
                    myWebView.loadUrl("http://alwatan.kuwait.tt");
                }
                if(paper.equals("Al-Anba"))
                {
                    setTitle("Al-Anba");
                    myWebView.loadUrl("http://www.alanba.com.kw/newspaper/");
                }
                if(paper.equals("Al-Qabas"))
                {
                    setTitle("Al-Qabas");
                    myWebView.loadUrl("http://alqabas.com/");
                }
                if(paper.equals("Al Rai"))
                {
                    setTitle("Al Rai");
                    myWebView.loadUrl("http://www.alraimedia.com/");
                }
                if(paper.equals("Al-Jarida"))
                {
                    setTitle("Al-Jarida");
                    myWebView.loadUrl("http://www.aljarida.com/");
                }
                if(paper.equals("Al-Seyassah"))
                {
                    setTitle("Al-Seyassah");
                    myWebView.loadUrl("https://al-seyassah.com/");
                }
                if(paper.equals("Al-Sabah"))
                {
                    setTitle("Al-Sabah");
                    myWebView.loadUrl("http://www.alsabaah.iq/");
                }
                if(paper.equals("Annahar"))
                {
                    setTitle("Annahar");
                    myWebView.loadUrl("http://www.annaharkw.com/Annahar/Default.aspx");
                }
            }
            else if(country.equals("Laos"))
            {
                if(paper.equals("Vientiane Times"))
                {
                    setTitle("Vientiane Times");
                    myWebView.loadUrl("http://www.vientianetimes.org.la/");
                }
                if(paper.equals("Vientiane Mai"))
                {
                    setTitle("Vientiane Mai");
                    myWebView.loadUrl("http://www.vientianemai.net/");
                }
                if(paper.equals("Pasason"))
                {
                    setTitle("Pasason");
                    myWebView.loadUrl("http://www.pasaxon.org.la/");
                }
                if(paper.equals("Pathet Lao"))
                {
                    setTitle("Pathet Lao");
                    myWebView.loadUrl("https://en.wikipedia.org/wiki/Pathet_Lao_(newspaper)");
                }
                if(paper.equals("Viengchanmay"))
                {
                    setTitle("Viengchanmay");
                    myWebView.loadUrl("http://wikivisually.com/wiki/Viengchanmay");
                }
            }
            else if(country.equals("Uzbekistan"))
            {
                if(paper.equals("Futbol Gazetasi"))
                {
                    setTitle("Futbol Gazetasi");
                    myWebView.loadUrl("http://futbol.uzbekworld.com/");
                }
                if(paper.equals("Hamkor"))
                {
                    setTitle("Hamkor");
                    myWebView.loadUrl("http://www.hamkor.uzpak.uz/");
                }
                if(paper.equals("Harakat"))
                {
                    setTitle("Harakat");
                    myWebView.loadUrl("http://www.harakat.net/");
                }
                if(paper.equals("The Nalog"))
                {
                    setTitle("The Nalog");
                    myWebView.loadUrl("http://www.nalog.uz/");
                }
                if(paper.equals("The Onlife"))
                {
                    setTitle("The Onlife");
                    myWebView.loadUrl("http://onlife.mnet.uz/");
                }
            }
            else if(country.equals("Macau"))
            {
                if(paper.equals("Macao Daily News"))
                {
                    setTitle("Macao Daily News");
                    myWebView.loadUrl("http://www.macaodaily.com/html/2017-08/16/node_2.htm");
                }
                if(paper.equals("Macau Post Daily"))
                {
                    setTitle("Macau Post Daily");
                    myWebView.loadUrl("http://www.macaupostdaily.com/");
                }
                if(paper.equals("Va Kio Daily"))
                {
                    setTitle("Va Kio Daily");
                    myWebView.loadUrl("http://www.vakiodaily.com/");
                }
                if(paper.equals("O Clarim"))
                {
                    setTitle("O Clarim");
                    myWebView.loadUrl("http://www.oclarim.com.mo/en/");
                }
                if(paper.equals("Hong Kong Economic Journal"))
                {
                    setTitle("Hong Kong Economic Journal");
                    myWebView.loadUrl("http://www2.hkej.com/landing/index");
                }
            }

            myWebView.setWebViewClient(new WebViewClient());
        }

        else
        {
            Toast.makeText(this,"No Internet Connection!!!! Please Check your Internet Connection\n And try again..", Toast.LENGTH_LONG).show();
        }
    }
    public class HelpClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            frameLayout.setVisibility(view.VISIBLE);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int KeyCode, KeyEvent event)
    {
        if(KeyCode == KeyEvent.KEYCODE_BACK)
        {
            if(myWebView.canGoBack())
            {
                myWebView.goBack();
                return true;
            }
        }
        return super.onKeyDown(KeyCode, event);
    }

   /* public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();

        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }
*/
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
