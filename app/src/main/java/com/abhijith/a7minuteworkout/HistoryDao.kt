package com.abhijith.a7minuteworkout

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("SELECT * FROM `history-table`")
    //No need to use the suspend function as the flow will take care of the coroutine stuffs
    fun fetchAllDates(): Flow<List<HistoryEntity>>

}