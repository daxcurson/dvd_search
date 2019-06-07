package ar.com.strellis.app_dvd_search;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private MenuItem scanBarcode;
    private MenuItem enterUPC;
    private MenuItem addManually;
    public static final int BARCODE_ACTIVITY=0;
    public static final int ENTER_UPC=1;
    public static final int ADD_MANUALLY=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.dvd_list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FloatingActionButton fab = findViewById(R.id.fab);
        PopupMenu menu=new PopupMenu(this,fab);
        scanBarcode=menu.getMenu().add("Scan barcode...");
        enterUPC=menu.getMenu().add("Enter UPC");
        addManually=menu.getMenu().add("Add manually");
        menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(scanBarcode.equals(menuItem))
                {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "PRODUCT_MODE");
                    intent.putExtra("SCAN_FORMATS","UPC_E,UPC_A,EAN_8,EAN_13,UPC_EAN_EXTENSION,CODE_39,CODE_93,CODE_128,DATA_MATRIX,ITF,CODABAR");

                    try
                    {
                        startActivityForResult(intent, MainActivity.BARCODE_ACTIVITY);
                    }
                    catch (ActivityNotFoundException exc)
                    {
                        Log.d("INFO","No scanner application installed");
                    }
                }
                if(enterUPC.equals(menuItem))
                {

                }
                if(addManually.equals(menuItem))
                {

                }
                return true;
            }
        });
        fab.setOnClickListener(new View.OnClickListener()
                               {
                                   @Override
                                   public void onClick(View view)
                                   {
                                       menu.show();
                                   }
                               }
        );
        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if (requestCode == MainActivity.BARCODE_ACTIVITY)
        {
            if (resultCode == RESULT_OK)
            {
                String barcodeContents = intent.getStringExtra("SCAN_RESULT");
                Log.d("INFO","Barcode: "+barcodeContents);
                // Here we launch an operation to create a database record and
                // a query to some website for the product data.
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
