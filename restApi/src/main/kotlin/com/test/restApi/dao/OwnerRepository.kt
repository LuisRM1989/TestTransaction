package com.test.restApi.dao

import com.test.restApi.model.Owner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OwnerRepository:JpaRepository<Owner,Int> {
}