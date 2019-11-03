package com.test.restApi.model

import org.hibernate.mapping.ToOne
import java.util.*
import javax.persistence.*

@Entity
@Table(name="owner")
data class Owner (
        val firstName:String,
        val lastName:String,
        val adress: String
)
{
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val id:Int = 0
}


