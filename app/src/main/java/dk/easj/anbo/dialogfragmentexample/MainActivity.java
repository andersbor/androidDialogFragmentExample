package dk.easj.anbo.dialogfragmentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tryButtonClicked(View view) {
        MyDialogFragment dialogFragment = MyDialogFragment.newInstance("Are you sure ...", "Yes", "No");
        dialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    public void doPositiveClick() {
        Log.d("DialogFragmentExample", "User clicked OK");
        TextView view =findViewById(R.id.textViewResult);
        view.setText("You are sure! Nice!!");
    }

    public void doNegativeClick() {
        Log.d("DialogFragmentExample", "User clicked Cancel");
        TextView view = findViewById(R.id.textViewResult);
        view.setText("You are NOT sure! ");
    }
}
