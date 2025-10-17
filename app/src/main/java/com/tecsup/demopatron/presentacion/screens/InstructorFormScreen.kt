package com.tecsup.demopatron.presentacion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InstructorFormScreen(
    onSave: (apellido: String, nombre: String, horas: Int, pagoHora: Double) -> Unit
) {
    var apellido by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var pago by remember { mutableStateOf("") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Registrar Instructor",
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = apellido,
                onValueChange = { apellido = it },
                label = { Text("Apellido") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = horas,
                onValueChange = { horas = it.filter { ch -> ch.isDigit() } },
                label = { Text("Horas dictadas") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = pago,
                onValueChange = { pago = it.filter { ch -> ch.isDigit() || ch == '.' } },
                label = { Text("Pago por hora") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val horasInt = horas.toIntOrNull() ?: 0
                    val pagoDouble = pago.toDoubleOrNull() ?: 0.0

                    if (apellido.isNotBlank() && nombre.isNotBlank() && horasInt > 0 && pagoDouble > 0) {
                        onSave(apellido.trim(), nombre.trim(), horasInt, pagoDouble)

                        apellido =""
                        nombre=""
                        horas=""
                        pago=""
                    }
                },
                modifier=Modifier.fillMaxWidth()
            ) {
                Text("Guardar Instructor")
            }
        }
    }
}
