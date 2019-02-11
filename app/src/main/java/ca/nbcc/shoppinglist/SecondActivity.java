package ca.nbcc.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "ca.nbcc.shoppinglist.extra.REPLY";
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView checkOutItem;

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "Second activity check has started");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        checkOutItem = (TextView)findViewById(R.id.check_out);
    }

    public void shopGroceryStoreItem(View view) {
        //I use a switch case statement for which item to check out
        switch (view.getId()) {
            case R.id.add_rice:
                checkOutList(MainActivity.RICE);
                break;
            case R.id.add_pasta:
                checkOutList(MainActivity.PASTA);
                break;
            case R.id.add_apples:
                checkOutList(MainActivity.APPLES);
                break;
            case R.id.add_oranges:
                checkOutList(MainActivity.ORANGES);
                break;
            case R.id.add_wheat:
                checkOutList(MainActivity.WHEAT);
                break;
            case R.id.add_flour:
                checkOutList(MainActivity.FLOUR);
                break;
            case R.id.add_cereal:
                checkOutList(MainActivity.CEREAL);
                break;
            case R.id.add_tomatoes:
                checkOutList(MainActivity.TOMATOES);
                break;
            case R.id.add_tuna:
                checkOutList(MainActivity.TUNA);
                break;
            case R.id.add_salmon:
                checkOutList(MainActivity.SALMON);
                break;
            default:
                break;
        }
    }

    public void checkOutList(String total){
        try {
            Intent checkout = new Intent();
            checkout.putExtra(EXTRA_REPLY, total);
            setResult(RESULT_OK, checkout);
            finish();
        } catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "Second activity has been paused");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "Second activity is now restarting...");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(LOG_TAG, "Second activity has resumed");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "Second activity has stopped");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "Second activity has been destroyed");
    }
}
