package peliculas.com.peliculas.formularios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import peliculas.com.peliculas.MainActivity;
import peliculas.com.peliculas.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCrearCuenta;
    private Button btnIngresar;
    private EditText txtusuario;
    private EditText txtcontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnCrearCuenta =(Button) findViewById(R.id.btncrearcuenta);
        btnIngresar = (Button)   findViewById(R.id.btningresar);

        txtusuario =(EditText)  findViewById(R.id.txtusuario);
        txtcontrasena =(EditText)  findViewById(R.id.txtcontrasena);

        btnCrearCuenta.setOnClickListener(this);
        btnIngresar.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId() /*to get clicked view id**/) {
            case R.id.btncrearcuenta:
                startActivity(new Intent(this,RegistroActivity.class));
                break;
            case R.id.btningresar:
                validarUsuario();
                break;
            default:
                break;

        }

    }
    private void validarUsuario() {
        ParseUser.logInInBackground(txtusuario.getText().toString(), txtcontrasena.getText().toString(), new LogInCallback() {
           @Override
           public void done(ParseUser user, com.parse.ParseException e) {
               if (user != null) {
                   // Hooray! The user is logged in.
                   startActivity(new Intent(LoginActivity.this,MainActivity.class));
               } else {
                   // Signup failed. Look at the ParseException to see what happened.
                   Toast.makeText(LoginActivity.this, "Error! " + e.getMessage(), Toast.LENGTH_SHORT).show();
               }
           }

        });
    }
}
