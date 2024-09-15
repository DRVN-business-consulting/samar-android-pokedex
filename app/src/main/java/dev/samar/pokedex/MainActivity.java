package dev.samar.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    String userName = "sam";
    String password = "1";

    EditText uname, pass;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btn = findViewById(R.id.btnLogin);

        uname = findViewById(R.id.userName);
        pass = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String unameStr, passStr;
                unameStr = uname.getText().toString();
                passStr = pass.getText().toString();


                if (TextUtils.isEmpty(unameStr)){
                    Toast.makeText(MainActivity.this, "Enter username", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passStr)){
                    Toast.makeText(MainActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (unameStr.equals(userName) && passStr.equals(password)) {
                    Intent intent = new Intent(MainActivity.this, MyList.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Wrong username or/and password", Toast.LENGTH_SHORT).show();
                    return;
                }



            }
        });
    }




}