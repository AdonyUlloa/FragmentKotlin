package com.example.fragmentkotlin

  import android.os.Bundle
  import android.view.Menu
  import android.view.MenuItem
  import androidx.appcompat.app.AppCompatActivity
  import androidx.fragment.app.Fragment
  import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(Fragment_one())

        //declaramos variables

        //fragment para Calendarización
        btn1.setOnClickListener {
            replaceFragment(Fragment_one())
        }
        //fragment para Himno UGB
        btn2.setOnClickListener {
            replaceFragment(Fragment_two())
        }
        //fragment para notas UGB Portal del Estudiante(ver notas)
        btn3.setOnClickListener {
            replaceFragment(Fragment_three())
        }
    }
    //Metodo que los sirve para inflar el menu donde esta nuestra informacion
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    //Funcion que los muestra el fragment de nuestra informacion
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.info->{
                replaceFragment(information())
            }
        }
        return super.onOptionsItemSelected(item)
    }
    //Cambiamos al fragment selecionado
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}