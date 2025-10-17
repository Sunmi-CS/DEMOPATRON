package com.tecsup.demopatron.presentacion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tecsup.demopatron.ui.theme.DemoPATRONTheme

import com.tecsup.demopatron.presentacion.screens.InstructorFormScreen
import com.tecsup.demopatron.presentacion.screens.InstructorListScreen
import com.tecsup.demopatron.viewmodel.InstructorViewModel


class MainActivity : ComponentActivity() {
    private val MainActivity.viewModel: InstructorViewModel by viewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.padding(8.dp)) {
                        InstructorFormScreen(onSave = { apellido, nombre, horas, pago ->
                            viewModel.insertInstructor(apellido, nombre, horas, pago)
                        })
                        InstructorListScreen(viewModel = viewModel)
                    }
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoPATRONTheme {
    }
}