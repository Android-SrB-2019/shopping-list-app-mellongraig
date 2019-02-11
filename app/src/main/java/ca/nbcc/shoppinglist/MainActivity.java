package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //global text request and log
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    //my common ten shopping items
    public static final String RICE = "rice";
    public static final String PASTA = "pasta";
    public static final String APPLES = "apples";
    public static final String ORANGES = "oranges";
    public static final String WHEAT = "wheat";
    public static final String FLOUR = "flour";
    public static final String CEREAL = "cereal";
    public static final String TOMATOES = "tomatoes";
    public static final String TUNA = "tuna";
    public static final String SALMON = "salmon";

    //call global views
    private TextView add_rice;
    private TextView add_pasta;
    private TextView add_apples;
    private TextView add_oranges;
    private TextView add_wheat;
    private TextView add_flour;
    private TextView add_cereal;
    private TextView add_tomatoes;
    private TextView add_tuna;
    private TextView add_salmon;

    //call global integers
    private int rice = 0;
    private int pasta = 0;
    private int apples = 0;
    private int oranges = 0;
    private int wheat = 0;
    private int flour = 0;
    private int cereal = 0;
    private int tomatoes = 0;
    private int tuna = 0;
    private int salmon = 0;

    @Override
    protected void onStart(){
        //starts the activity
        super.onStart();
        Log.d(LOG_TAG, "My shopping activity has started");
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        //saves current state of the activity
        super.onSaveInstanceState(outState);
        outState.putInt(RICE, rice);
        outState.putInt(PASTA, pasta);
        outState.putInt(APPLES, apples);
        outState.putInt(ORANGES, oranges);
        outState.putInt(WHEAT, wheat);
        outState.putInt(FLOUR, flour);
        outState.putInt(CEREAL, cereal);
        outState.putInt(TOMATOES, tomatoes);
        outState.putInt(TUNA, tuna);
        outState.putInt(SALMON, salmon);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, "Creating shopping activity...");

        //Initialize the views
        add_rice = findViewById(R.id.shop_rice);
        add_pasta = findViewById(R.id.shop_pasta);
        add_apples = findViewById(R.id.shop_apples);
        add_oranges = findViewById(R.id.shop_oranges);
        add_wheat = findViewById(R.id.shop_wheat);
        add_flour = findViewById(R.id.shop_flour);
        add_cereal = findViewById(R.id.shop_cereal);
        add_tomatoes = findViewById(R.id.shop_tomatoes);
        add_tuna = findViewById(R.id.shop_tuna);
        add_salmon = findViewById(R.id.shop_salmon);

        //restore activity state
        if(savedInstanceState != null){
            rice = savedInstanceState.getInt(RICE);
            pasta = savedInstanceState.getInt(PASTA);
            apples = savedInstanceState.getInt(APPLES);
            oranges = savedInstanceState.getInt(ORANGES);
            wheat = savedInstanceState.getInt(WHEAT);
            flour = savedInstanceState.getInt(FLOUR);
            cereal = savedInstanceState.getInt(CEREAL);
            tomatoes = savedInstanceState.getInt(TOMATOES);
            tuna = savedInstanceState.getInt(TUNA);
            salmon = savedInstanceState.getInt(SALMON);
        }

        //initialize variables
        initialize();
    }

    public void initialize(){
        try{
            add_rice.setText(Integer.toString(rice) + " Rice");
            add_pasta.setText(Integer.toString(pasta) + " Pasta");
            add_apples.setText(Integer.toString(apples) + " Apples");
            add_oranges.setText(Integer.toString(oranges) + " Oranges");
            add_wheat.setText(Integer.toString(wheat) + " Wheat");
            add_flour.setText(Integer.toString(flour) + " Flour");
            add_cereal.setText(Integer.toString(cereal) + " Cereal");
            add_tomatoes.setText(Integer.toString(tomatoes) + " Tomatoes");
            add_tuna.setText(Integer.toString(tuna) + " Tuna");
            add_salmon.setText(Integer.toString(salmon) + " Salmon");
        } catch (Exception e){
            e.getMessage();
        }
    }

    public void pickNewItem(View view) {
        //launches the second activity for the shopping list
        Intent newItem = new Intent(this, SecondActivity.class);
        startActivityForResult(newItem, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if(requestCode == TEXT_REQUEST){
                if(resultCode == RESULT_OK){
                    String shopping = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                    //I use a for each loop to determine what the user clicked
                    for(int i = 0; i < shopping.length(); i++){
                        if(shopping.contains(RICE)){
                            rice += 1;
                        }
                        else if(shopping.contains(PASTA)){
                            pasta += 1;
                        }
                        else if(shopping.contains(APPLES)){
                            apples += 1;
                        }
                        else if(shopping.contains(ORANGES)){
                            oranges += 1;
                        }
                        else if(shopping.contains(WHEAT)){
                            wheat += 1;
                        }
                        else if(shopping.contains(FLOUR)){
                            flour += 1;
                        }
                        else if(shopping.contains(CEREAL)){
                            cereal += 1;
                        }
                        else if(shopping.contains(TOMATOES)){
                            tomatoes += 1;
                        }
                        else if(shopping.contains(TUNA)){
                            tuna += 1;
                        }
                        else if(shopping.contains(SALMON)){
                            salmon += 1;
                        }
                    }

                    //recall the method
                    initialize();
                }
            }
        } catch(Exception e){
            e.getMessage();
        }
    }

    @Override
    protected void onPause(){
        //pauses the current state
        super.onPause();
        Log.d(LOG_TAG, "Shopping activity list paused");
    }

    @Override
    protected void onRestart(){
        //restarts the activity
        super.onRestart();
        Log.d(LOG_TAG, "Shopping activity list restarted");
    }

    @Override
    protected void onResume(){
        //resumes the current state
        super.onResume();
        Log.d(LOG_TAG, "Shopping activity list resumed");
    }

    @Override
    protected void onStop(){
        //stops the activity
        super.onStop();
        Log.d(LOG_TAG, "Shopping activity list stopped");
    }

    @Override
    protected void onDestroy(){
        //destroys the current status
        super.onDestroy();
        Log.d(LOG_TAG, "Shopping activity list destroyed");
    }
}
