package com.tecsup.demopatron.repository

import com.tecsup.demopatron.data.dao. InstructorDao
import com.tecsup.demopatron.data.model.Instructor
import kotlinx.coroutines.flow.Flow

class InstructorRepository(private val dao: InstructorDao) {
    suspend fun insert(instructor: Instructor): Long {
        return dao.insert(instructor)
    }

    fun getAll(): Flow<List<Instructor>> = dao.getAllInstructors()

    suspend fun deleteByCodigo(codigo: Int) {
        dao.deleteByCodigo(codigo)
    }


}