package com.tecsup.demopatron.presentacion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tecsup.demopatron.viewmodel.InstructorViewModel
import com.tecsup.demopatron.data.model.Instructor

@Composable
fun InstructorListScreen(viewModel: InstructorViewModel) {
    val instructorsState = viewModel.instructors.collectAsState()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Lista de Instructores",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn {
                items(instructorsState.value) { instructor ->
                    InstructorRow(instructor)
                    Divider(modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}

@Composable
fun InstructorRow(instructor: Instructor) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "${instructor.apellido}, ${instructor.nombre}",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Horas dictadas: ${instructor.horasDictadas}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Pago por hora: S/. ${instructor.pagoPorHora}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
