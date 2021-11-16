package com.cmps312.bankingapp.DAOS

import androidx.room.Dao
import androidx.room.Insert
import com.cmps312.bankingapp.models.Transaction
@Dao
interface TransactionDAO {
    @Insert
    suspend fun insert(transaction: Transaction)
}