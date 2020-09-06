package co.edu.uac.apmoviles.example1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    TextView texto;
    EditText p1, p2;
    Button mayor, vocal, invertir, longitud;
    ToggleButton btnValidarBotones;
    CheckBox edtmaymin;
    String edt1,edt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i = getIntent();
        String user = i.getStringExtra("Usuario");
        texto = findViewById(R.id.texto);
        texto.setText(texto.getText().toString() + " " + user);
        p1 = findViewById(R.id.edtp1);
        p2 = findViewById(R.id.edtp2);

        mayor = findViewById(R.id.btnmayor);
        vocal = findViewById(R.id.btnvocales);
        invertir = findViewById(R.id.btninvertir);
        longitud = findViewById(R.id.btnlongitud);
        edtmaymin = findViewById(R.id.edtmaymin);
        btnValidarBotones = findViewById(R.id.toggleButton);

        longitud.setOnClickListener(this);

        invertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder invertir1 = new StringBuilder(p1.getText().toString());
                StringBuilder invertir2 = new StringBuilder(p2.getText().toString());
                p1.setText(invertir1.reverse().toString());
                p2.setText(invertir2.reverse().toString());

            }
        });

        mayor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(p1.getText().toString()) || TextUtils.isEmpty(p2.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Datos invalidos",Toast.LENGTH_LONG).show();
               }
                else{
                    if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())>0){
                        Toast.makeText(getApplicationContext(),"P1 es mayor que P2", Toast.LENGTH_LONG).show();
                    }
                    else{
                        if (p1.getText().toString().compareToIgnoreCase(p2.getText().toString())<00){
                            Toast.makeText(getApplicationContext(),"P1 es menor que P2", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Son iguales", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });


    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnlongitud: int l1 = p1.getText().toString().length();
                                  int l2 = p2.getText().toString().length();
                Toast.makeText(getApplicationContext(),"L1=" + l1 + " L2=" + l2, Toast.LENGTH_LONG).show();
                 break;
            case R.id.btninvertir:
                 break;

            case R.id.btnvocales:
                break;
        }
    }


    public void validarMayMin(View view) {
        edt2 = p2.getText().toString();
        edt1 = p1.getText().toString();

        if (edtmaymin.isChecked()) {
            edt1 = edt1.toUpperCase();
            edt2 = edt2.toUpperCase();
            p1.setText(edt1);
            p2.setText(edt2);
        }else{
            edt1 = edt1.toLowerCase();
            edt2 = edt2.toLowerCase();
            p1.setText(edt1);
            p2.setText(edt2);
        }
    }

    public void elimiarVocales(View view) {

        if (TextUtils.isEmpty(p1.getText().toString()))
            p1.setError("Este campo es requerido");


        if (TextUtils.isEmpty(p2.getText().toString()))
            p2.setError("Este campo es requerido");


        if (!p1.getText().toString().isEmpty() && !p2.getText().toString().isEmpty()) {
            String eliminar1 = p1.getText().toString().replaceAll("[AEIOUaeiou]", "");
            String eliminar2 = p2.getText().toString().replaceAll("[AEIOUaeiou]", "");

            p1.setText(eliminar1);
            p2.setText(eliminar2);
            Toast.makeText(SecondActivity.this, "Vocales eliminadas", Toast.LENGTH_LONG).show();
        }

    }

    public void validarBotones(View view) {
        if (btnValidarBotones.isChecked()){
            mayor.setEnabled(false);
            invertir.setEnabled(false);
            longitud.setEnabled(false);
            vocal.setEnabled(false);
        }else{
            mayor.setEnabled(true);
            invertir.setEnabled(true);
            longitud.setEnabled(true);
            vocal.setEnabled(true);
        }
    }
}
