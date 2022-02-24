package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SEcondActivity extends AppCompatActivity {
    // Unique tag for the intent reply.
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";

    // EditText for the reply.
    private EditText mReply;

    /**
     * Initializes the activity.
     *
     * @param savedInstanceState The current state data
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Initialize view variables.
        mReply = findViewById(R.id.editText_second);

        // Get the intent that launched this activity, and the message in
        // the intent extra.
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Put that message into the text_message TextView
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    /**
     * Handles the onClick for the "Reply" button. Gets the message from the
     * second EditText, creates an intent, and returns that message back to
     * the main activity.
     *
     * @param view The view (Button) that was clicked.
     */
    public void returnReply(View view) {
        // Get the reply message from the edit text.
        String reply = mReply.getText().toString();

        // Create a new intent for the reply, add the reply message to it
        // as an extra, set the intent result, and close the activity.
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}