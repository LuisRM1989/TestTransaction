package com.test.restApi.model

import org.hibernate.mapping.ToOne
import java.util.*
import javax.persistence.*

@Entity()
@Table(name="account")
data class Account(
        var balance:Float,
        var createAt: Date,
        var ownerId: Int )
{
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        var clave:Int = 0
}