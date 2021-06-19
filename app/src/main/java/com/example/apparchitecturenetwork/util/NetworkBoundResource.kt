package com.example.apparchitecturenetwork.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if (shouldFetch(data)) {
        emit(Resource.Loading(data))

        try {
            // if get the data from network
            saveFetchResult(fetch())
            query().map { Resource.Success(it) }
        } catch (throwable: Throwable) {
            // if error happened when call the api so get the data from room
            query().map { Resource.Error(throwable, it) }
        }
    } else {
        // get data from room directory
        query().map { Resource.Success(it) }
    }
    // emit all coz we want to emit list of restaurants
    emitAll(flow)
}