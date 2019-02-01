package ta.jokeviewermodule;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    private TextView jokeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        jokeTV = (TextView) findViewById(R.id.tv_joke);

        if (getIntent().getExtras() != null) {
            String jokeContent = getIntent().getExtras().getString("jokeContent");
            jokeTV.setText(jokeContent);
        }
    }
}
