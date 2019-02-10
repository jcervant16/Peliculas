package peliculas.com.peliculas.formularios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import peliculas.com.peliculas.R;


public class RegistroActivity extends AppCompatActivity {
    private Button btnVolver;
    private Button btnRegistro;

    private EditText txtcorreo;
    private EditText txtusuario;
    private EditText txtcontrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtcorreo = (EditText) findViewById(R.id.txtEmail);
        txtusuario = (EditText) findViewById(R.id.txtUsuario);
        txtcontrasena = (EditText) findViewById(R.id.txtPass);

        btnVolver = (Button) findViewById(R.id.btnregresar);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            }
        });
        btnRegistro = (Button) findViewById(R.id.btnregistrarme);
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser user = new ParseUser();
                user.setUsername(txtusuario.getText().toString());
                user.setPassword(txtcontrasena.getText().toString());
                user.setEmail(txtcorreo.getText().toString());

                user.signUpInBackground(new SignUpCallback() {
                    public void done(ParseException e) {
                        if (e == null) {
                            Toast.makeText(RegistroActivity.this, "Usuario Creado", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(RegistroActivity.this, "Error al crear" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}





