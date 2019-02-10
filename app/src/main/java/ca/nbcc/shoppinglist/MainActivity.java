package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
                }
            }
        } catch(Exception e){
            e.getMessage();
        }
    }
}
