package com.example.core.domain.entity.specific

import java.lang.reflect.Type

interface ServiceProxy {
    fun onData(data: List<Type>);
    fun onFailed(t: Throwable);
}