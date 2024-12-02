package com.example.lab5;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.Toolbar;


import androidx.appcompat.app.AppCompatActivity;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> countryList;
    private CountryAdapter adapter;
    private Map<Integer, Integer> colorMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        countryList = new ArrayList<>(Arrays.asList(
                "Albánia", "Andorra", "Ausztria", "Belarusz", "Belgium",
                "Bosznia és Hercegovina", "Bulgária", "Horvátország", "Ciprus",
                "Csehország", "Dánia", "Észtország", "Finnország", "Franciaország",
                "Németország", "Görögország", "Magyarország", "Izland", "Írország",
                "Olaszország", "Lettország", "Liechtenstein", "Litvánia", "Luxemburg",
                "Málta", "Moldova", "Monaco", "Montenegró", "Hollandia",
                "Észak-Macedónia", "Norvégia", "Lengyelország", "Portugália",
                "Románia", "Oroszország", "San Marino", "Szerbia", "Szlovákia",
                "Szlovénia", "Spanyolország", "Svédország", "Svájc", "Törökország",
                "Ukrajna", "Egyesült Királyság", "Vatikánváros"));

        colorMap = new HashMap<>();

        listView = findViewById(R.id.countryListView);
        adapter = new CountryAdapter(this, countryList, colorMap);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.countryListView) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(countryList.get(info.position));
            menu.add(Menu.NONE, 1, 1, "Piros");
            menu.add(Menu.NONE, 2, 2, "Zöld");
            menu.add(Menu.NONE, 3, 3, "Sárga");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;
        switch (item.getItemId()) {
            case 1:
                colorMap.put(position, Color.RED);
                adapter.notifyDataSetChanged();
                return true;
            case 2:
                colorMap.put(position, Color.GREEN);
                adapter.notifyDataSetChanged();
                return true;
            case 3:
                colorMap.put(position, Color.YELLOW);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        try {
            Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
            method.setAccessible(true);
            method.invoke(menu, true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_sort) {
            Collections.sort(countryList, String.CASE_INSENSITIVE_ORDER);
            adapter.notifyDataSetChanged();
            return true;
        } else if (id == R.id.menu_delete) {
            countryList.clear();
            adapter.notifyDataSetChanged();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}
