package com.test.restApi.dao

import com.test.restApi.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository:JpaRepository<Persona,Long> {
}