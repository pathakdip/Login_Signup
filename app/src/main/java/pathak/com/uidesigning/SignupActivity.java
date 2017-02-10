package pathak.com.uidesigning;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HP on 2/8/2017.
 */

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        final EditText nameET=(EditText)findViewById(R.id.sname);
        final EditText emailET=(EditText)findViewById(R.id.semail);
        final EditText passwordET=(EditText)findViewById(R.id.spwd);
        final EditText cpET=(EditText)findViewById(R.id.scpwd);
        Button btnsignup;
        btnsignup=(Button) findViewById(R.id.sbtn);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strname=nameET.getText().toString();
                String stremail=emailET.getText().toString();
                String strpassword=passwordET.getText().toString();
                String strcp=cpET.getText().toString();

                if(strname.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Name cannot be empty!", Toast.LENGTH_SHORT).show();
                }

                else if (stremail.isEmpty())
                {
                     Toast.makeText(SignupActivity.this, "Enter email", Toast.LENGTH_SHORT).show();
                }

                else if (!isValidEmail(stremail)){
                     Toast.makeText(SignupActivity.this, "Enter valid email", Toast.LENGTH_SHORT).show();
                 }

                 else if (strpassword.isEmpty())
                 {
                    Toast.makeText(SignupActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                 }

                else if (strcp.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "please enter confirm password", Toast.LENGTH_SHORT).show();
                }

                else if (!strcp.equals(strpassword))
                 {
                    Toast.makeText(SignupActivity.this, "passwords don't match", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(SignupActivity.this, "Congratulations! Signed up successfully", Toast.LENGTH_SHORT).show();
                  }

            }

            private boolean isValidEmail(CharSequence target) {
                Pattern pattern;
                Matcher matcher;
                final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(EMAIL_PATTERN);
                matcher = pattern.matcher(target);
                return matcher.matches();
            }
        });
    }
}
