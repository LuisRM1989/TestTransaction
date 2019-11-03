package com.test.restApi.utils

class Constants {
    companion object {
        private const val URL_API_BASE="/api"
        private const val URL_API_VERSION="/v1"
        private const val URL_BASE = URL_API_BASE + URL_API_VERSION
        //Base API endpoint para personas
        const val URL_BASE_PERSONAS ="$URL_BASE/personas"
        const val URL_BASE_OWNER ="$URL_BASE/owner"
        const val URL_BASE_ACCOUNT ="$URL_BASE/account"
        const val URL_BASE_TRANSACTION ="$URL_BASE/transaction"
    }
}