package com.beetle.backend.repository

import com.beetle.backend.entity.TargetEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TargetRepository : JpaRepository<TargetEntity, Long> {
    fun findByName(name: String): TargetEntity?
}