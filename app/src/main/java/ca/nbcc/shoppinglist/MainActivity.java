package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pickNewItem(View view) {
        Intent newItem = new Intent(this, SecondActivity.class);
        startActivityForResult(newItem, TEXT_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        try{
            if(requestCode == TEXT_REQUEST){
                if(resultCode == RESULT_OK){
                    String shopping = data.getStringExtra(SecondActivity.EXTRA_REPLY);

                    for(int i = 0; i < shopping.length; i++){
                        if(shopping.contains(RICE)){
                            rice += 1;
                        }
                    }
                }
            }
        } catch(Exception e){
            e.getMessage();
        }
    }
}
