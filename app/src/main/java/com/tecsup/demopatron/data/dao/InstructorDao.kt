package com.tecsup.demopatron.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.tecsup.demopatron.data.model.Instructor
import kotlinx.coroutines.flow.Flow

@Dao
interface InstructorDao {
    @Insert
    suspend fun insert(instructor: Instructor): Long

    @Query("SELECT * FROM instructor ORDER BY apellido ASC")
    fun getAllInstructors(): Flow<List<Instructor>>

    @Query("DELETE FROM instructor WHERE codigo = :codigo")
    suspend fun deleteByCodigo(codigo: Int)
}
