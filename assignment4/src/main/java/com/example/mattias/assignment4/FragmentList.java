package com.example.mattias.assignment4;

/**
 * Created by Mattias on 15-04-22.
 */

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class FragmentList extends Fragment {

 // Create an arraylist of planets.

    public static ArrayList<Planet> planets = new ArrayList<Planet>();
public static int currentPlanet;
    //This method comes first so lets create the books here
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Clear arraylist and add desired planets, giving them a the following values; "name", "radius" and "avarage temperature" and a drawable image

        planets.clear();
        Drawable d = getResources().getDrawable(R.drawable.mars);
        planets.add(new Planet("Mars","Mars är den fjärde planeten från solen och solsystemets näst minsta planet. Den har fått sitt namn efter den romerska krigsguden Mars och kallas ibland för \"den röda planeten\" på grund av sitt rödaktiga utseende. Den röda färgen beror på stora mängder järnoxid (rost) som finns fördelat över ytan och i atmosfären. Mars är en av de fyra stenplaneterna och har en tunn atmosfär som till största delen består av koldioxid. Ytan är täckt av kratrar av olika storlekar likt månen, men Mars har precis som jorden även många vulkaner, dalgångar, vidsträckta slätter och iskalotter vid polerna. Under stora delar av Mars historia skedde långvariga vulkanutbrott vilka bland annat skapade Olympus Mons, solsystemets största berg. De stora utbrotten har sedan länge upphört, men på ett fåtal platser bedöms mindre utbrott ha skett för endast ett par miljoner år sedan. Då detta är en kort period i ett geologiskt perspektiv förmodas planeten kunna ha en viss kvarvarande geologisk aktivitet än idag. Till skillnad från jorden har dock Mars ingen aktiv plattektonik och inget globalt magnetfält.", "3376 ± 0,1 ", "227.", d));
        d = getResources().getDrawable(R.drawable.earth);
        planets.add(new Planet("Jorden","Jorden är den tredje planeten från solen och den största av de så kallade stenplaneterna i solsystemet. Jorden är hemvist för alla kända levande varelser, inklusive människan. Dess latinska namn, Tellus eller Terra används ibland om den, och astronomer betecknar den ibland med symbolen ⊕. Jorden har en naturlig satellit kallad månen, eller Luna på latin.\n" +
                "\n" +
                "Med flera miljoner arter är jorden den enda himlakropp där man vet att liv existerar. Planeten bildades för 4,54 miljarder år sedan och liv uppstod inom en miljard år därefter (äldsta tecken på liv är ett kol-lager 3,8 miljarder år gammalt, äldsta säkra spår av celler är stromatoliter 3,5 miljarder år gamla)[11]. Sedan dess har jordens biosfär markant förändrat atmosfären och andra icke biologiska förhållanden, vilket till exempel tillåtit aerobiska organismer att utvecklas i den syrerika miljön.\n" +
                "\n" +
                "Sedd från rymden är jorden formad som ett nästan perfekt klot. Cirka 71 procent av ytan är täckt av hav med saltvatten, återstoden består av öar och kontinenter. Jordens inre är fortsatt aktiv med en relativt fast mantel, en flytande yttre kärna som genererar ett magnetfält, samt en fast inre kärna främst bestående av järn. Jordskorpan, jordens yttre lager, är uppdelad i en rad olika segment, kallade kontinentalplattor, som långsamt rör sig över ytan. Jorden har en atmosfär som till största delen består av kväve (78 %) och syre (21 %).", "6 371", "287", d));
        d = getResources().getDrawable(R.drawable.jupiter);
        planets.add(new Planet("Jupiter","Jupiter (symbol: Jupiter symbol.svg) är den femte planeten från solen och är med stor marginal solsystemets största planet. Dess massa är 2,5 gånger så stor som alla de andra planeternas sammanlagda massa. Planeten är en så kallad gasjätte och man är inte säker på om planeten ens har en fast kärna. Planeten har fått sitt namn efter den största guden inom romerska mytologin, Jupiter.[8] Även om namnet är romerskt har planeten varit känd, under andra namn, sedan urminnes tider (till exempel Δίας/Dias på grekiska).", "71 492 ± 4", "165", d));
        d = getResources().getDrawable(R.drawable.merkurius);
        planets.add(new Planet("Merkurius","Merkurius (symbol: Mercury symbol.svg) är den innersta och minsta planeten i solsystemet och har en omloppstid runt solen på 88 dygn. På grund av sin närhet till solen är den svår att observera från jorden och kan bara ses i gryning eller skymning, men Merkurius har ändå varit känd i åtminstone 5 000 år. Planeten saknar, liksom Venus, naturliga satelliter (månar).\n" +
                "\n" +
                "Man vet relativt lite om Merkurius. Mycket av informationen om planeten samlades in av den första rymdsonden som varit i närheten, Mariner 10 (1974–1976). Den 14 januari 2008 passerade dock den betydligt mer avancerade sonden MESSENGER planeten. Ytterligare två passager har gjorts. Den 18 mars 2011 lade sig MESSENGER i bana runt planeten och den 4 april påbörjade sonden officiellt att samla in data.\n" +
                "\n" +
                "Ytan är ganska lik månens då den har relativt många kratrar. Merkurius har ingen atmosfär att tala om, och yttemperaturen varierar mellan –173 grader Celsius i botten av kratrarna vid polerna och +427 grader Celsius på de varmaste ställena på solsidan.\n" +
                "\n" +
                "Planetens namn kommer från romarna, som namngav den efter den romerske guden Mercurius. Den astronomiska symbolen för Merkurius är en stiliserad kaducé.", "2 439,7 ± 1,0", "340", d));
        d = getResources().getDrawable(R.drawable.saturnus);
        planets.add(new Planet("Saturnus","Saturnus (symbol: Saturn symbol.svg) är den sjätte planeten från solen och den näst största i solsystemet. Den är en gasjätte, känd sedan förhistorisk tid. Galileo Galilei var den första att observera den genom ett teleskop år 1610. Han såg planeten när ringarnas läge fick planeten att se ut som tre planeter i en klump, vilket gjorde dåtidens forskare mycket förbryllade. Saturnus har nittiofem gånger så stor massa som jorden och har nio gånger så stor diameter.[9]\n Saturnus och de övriga gasjättarna måste ha bildats på ett annat sätt än det inre solsystemet. Man vet dock inte hur det gick till. I likhet med alla de andra planeterna bildades Saturnus av rester från det gasmoln och det rymdstoft som givit upphov till solen. Det finns två teorier om hur gasjättarna bildades. Den ena är att partiklar av is och stoft kolliderade och slogs ihop till de yttre planeternas fasta kärnor, som sedan drog till sig gaser genom sin tyngdkraft. Den andra är att den skiva av rymdgrus som omgav den unga solen sprack upp i mindre klot av gas och stoft, vilka sedan drogs samman till planeter. Under miljontals år kolliderade fasta partiklar med varandra och byggde därigenom upp de stora klumpar av sten och metall som kallas planetesimaler. De blev tillräckligt stora för att deras egen tyngdkraft skulle dra till sig mer materia och ibland kolliderade de och slogs ihop med varandra. Enligt en teori bildades Saturnus kärna av stoftpartiklar som samlades i centrum.", "60 268 ± 4", "134", d));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment_with_list, container, false);
        Log.i("FragmentList", "Number of planets added: " + planets.size());
        MyListAdapter la = new MyListAdapter(getActivity(),planets);
        GridView lv = (GridView) v.findViewById(R.id.gridView);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentPlanet = position;

                // Log and toast on list interaction
                Log.i("FragmentList", "Clicked on position: " + position +"/ " + planets.get(position).getName());
                //display in short period of time
                Toast.makeText(getActivity(), planets.get(position).getName(),
                        Toast.LENGTH_SHORT).show();

                // Fragment transaction on list interaction

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentPlanet bf = new FragmentPlanet();
                // byt layout till fragment2
                ft.replace(R.id.main_layout,bf);
                ft.commit();

            }

        });
        return v;
    }

    // Methods to use in order to get desired info for the fragment_planet fragment

    public String getName(){
        return planets.get(currentPlanet).getName();
    }

    public String getFacts(){
        return planets.get(currentPlanet).getInfo();

}
    public String getStats(){
        return planets.get(currentPlanet).getSummary();

    }
public Drawable getImage(){
return planets.get(currentPlanet).getImage();
}

}
