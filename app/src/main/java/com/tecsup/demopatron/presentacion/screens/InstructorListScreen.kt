package com.tecsup.demopatron.presentacion.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
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
                    InstructorRow(instructor, onDelete = {
                        viewModel.deleteInstructor(instructor.codigo)
                    })
                    HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
                }
            }
        }
    }
}

@Composable
fun InstructorRow(
    instructor: Instructor,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
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

        Button(
            onClick = onDelete,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.errorContainer
            ),
            modifier = Modifier.alignByBaseline()
        ) {
            Text("Eliminar", color = MaterialTheme.colorScheme.onErrorContainer)
        }
    }
}
