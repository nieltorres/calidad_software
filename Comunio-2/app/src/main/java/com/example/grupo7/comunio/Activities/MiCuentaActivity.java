package com.example.grupo7.comunio.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.grupo7.comunio.R;
import com.example.grupo7.comunio.SourceCode.StaticElements;

public class MiCuentaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_cuenta);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView usuario = (TextView) findViewById(R.id.textNombreUsuario);
        TextView email = (TextView) findViewById(R.id.textEmail);
        TextView liga = (TextView) findViewById(R.id.textLiga);
        TextView saldoActual = (TextView) findViewById(R.id.textSaldoActual);
        usuario.setText(StaticElements.getUser().substring(0, StaticElements.getUser().indexOf('@')));
        email.setText(StaticElements.getUser());
        liga.setText("Mi liga");
        saldoActual.setText(StaticElements.customFormat(StaticElements.getSaldo()));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_mi_cuenta);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_mi_cuenta);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_item_micuenta);

        //Se pone el nombre de usuario en el nav_header
        TextView campoNombreUsuario = (TextView) findViewById(R.id.textViewUsuarioMenu);
        String nombreUsuario = StaticElements.getUser();
        campoNombreUsuario.setText((nombreUsuario.substring(0, nombreUsuario.indexOf('@'))));
        //Se pone los puntos actuales en el nav_header
        TextView campoPuntosUsuario = (TextView) findViewById(R.id.textViewPuntosMenu);
        String puntosUsuario = Integer.toString(StaticElements.puntosUsuario);
        campoPuntosUsuario.setText(puntosUsuario + " puntos");
        //Se pone el saldo actual en el nav_header
        TextView campoSaldoUsuario = (TextView) findViewById(R.id.textViewSaldoMenu);
        String saldoUsuario = Integer.toString(StaticElements.getSaldo());
        campoSaldoUsuario.setText("   -   " + StaticElements.customFormat(StaticElements.getSaldo()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cerrarsesion) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("¿Desea cerrar la sesión?");
            builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                    onCerrarSesionPressed();
                }
            });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    //TODO
                    dialog.dismiss();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void onCerrarSesionPressed() {
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        System.exit(0); //Limpiamos la pila de memoria
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_item_inicio) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            //animation
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            finish();
        } else if (id == R.id.nav_item_equipo) {
            Intent intent = new Intent(this, EquipoActivity.class);
            startActivity(intent);
            //animation
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            finish();
        } else if (id == R.id.nav_item_mercado) {
            Intent intent = new Intent(this, MercadoActivity.class);
            startActivity(intent);
            //animation
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            finish();
        } else if (id == R.id.nav_item_liga) {
            Intent intent = new Intent(this, LigaActivity.class);
            startActivity(intent);
            //animation
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
            finish();
        }
        /*else if (id == R.id.nav_item_micuenta) {
            Intent intent = new Intent(this, MiCuentaActivity.class);
            startActivity(intent);
            //animation
            overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        }*/
        else if (id == R.id.nav_item_reglas) {
            Intent intent = new Intent(this, ReglasActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_item_politicaprivacidad) {
            Intent intent = new Intent(this, PoliticaPrivacidadActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_mi_cuenta);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
