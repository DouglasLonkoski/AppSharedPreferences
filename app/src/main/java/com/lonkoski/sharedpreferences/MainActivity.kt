package com.lonkoski.sharedpreferences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var textoNome: EditText
    private lateinit var botaoSalvar: Button
    private lateinit var textoExibicao: TextView
    private val ARQUIVO_PREFERENCIA :String = "ArquivoPreferencia"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoNome = nome
        textoExibicao = texto_exibicao
        botaoSalvar = salvar

        botaoSalvar.setOnClickListener {
            val sharedPrefereces = getSharedPreferences(ARQUIVO_PREFERENCIA, 0)
            var editor = sharedPrefereces.edit()

            if(textoNome.text.toString().equals("")){
                Toast.makeText(applicationContext, "Por favor, preencha o nome. ", Toast.LENGTH_SHORT).show()
            }else{
                editor.putString("nome", textoNome.text.toString())
                editor.apply()
                textoExibicao.setText("Olá, "+textoNome.text.toString())
            }
        }
        //Recuperar os dados salvos

        val sharedPreferes = getSharedPreferences(ARQUIVO_PREFERENCIA, 0)
        if (sharedPreferes.contains("nome")){
            var nomeUsuario = sharedPreferes.getString("nome", "Usuário não definido")
            textoExibicao.setText("Olá, "+nomeUsuario)
        }else{
            textoExibicao.setText("Olá, usuário não definido")
        }
    }
}
