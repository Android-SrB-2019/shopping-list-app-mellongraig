package ca.nbcc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void shopGroceryStoreItem(View view) {
        switch (view.getId()) {
            case R.id.add_rice:
                break;
        }

    }


}
