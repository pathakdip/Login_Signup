package pathak.com.uidesigning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvsignup;
    EditText usernameET;
    EditText pwdloginET;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvsignup=(TextView)findViewById(R.id.main_tv_signup);
        btnlogin=(Button)findViewById(R.id.btn_login_btn);
        final EditText usernameET = (EditText) findViewById(R.id.et_uname_et);
        final EditText pwdloginET = (EditText) findViewById(R.id.et_pwd_et);

        tvsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String struname = usernameET.getText().toString();
                String strpwd = pwdloginET.getText().toString();
                if (struname.isEmpty())
                {
                  Toast.makeText(MainActivity.this, "Userame cannot be empty!", Toast.LENGTH_SHORT).show();
                }
                else if (strpwd.isEmpty())
                {
                      Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {
                  Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
