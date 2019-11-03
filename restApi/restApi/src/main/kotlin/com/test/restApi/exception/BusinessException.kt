package com.test.restApi.exception

import java.lang.Exception

class BusinessException(mensaje:String?): Exception(mensaje) {
}