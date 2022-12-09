package com.yrys.domain.model

data class Note(
    val id: Int = DEFAULT_ID,
    var title: String,
    var description: String,
    var createdAt: Long
) : java.io.Serializable {
    companion object {
        const val DEFAULT_ID = 0
    }
}