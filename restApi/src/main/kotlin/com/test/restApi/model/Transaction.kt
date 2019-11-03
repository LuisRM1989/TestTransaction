package com.test.restApi.model

import java.util.*
import javax.persistence.*


@Entity
@Table(name="transaction")
class Transaction(
        val amount:Float,
        val idAccountFrom: Int,
        val idAccountTo: Int,
        val sentAt: Date ) {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        val idTransaction:Int = 0
}