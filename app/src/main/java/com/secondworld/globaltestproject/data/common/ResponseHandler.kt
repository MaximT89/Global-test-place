package com.secondworld.globaltestproject.data.common

import android.util.Log
import com.secondworld.globaltestproject.domain.common.BaseResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

interface ResponseHandler{
//
//    suspend fun <T> handle(
//        apiCall: suspend () -> Response<T>,
//    ): Flow<BaseResult>
//
//    class Base @Inject constructor(private val networkHelper: NetworkHelper) : ResponseHandler {
//
//        override suspend fun <T> handle(apiCall: suspend () -> Response<T>): Flow<BaseResult> {
//            Log.d("TAG", "ResponseHandler: start")
//            return flow {
//                if (networkHelper.isNetworkConnected()) {
//                    try {
//                        val response = apiCall()
//                        Log.d("TAG", "ResponseHandler: получили ответ от апи")
//
//                        val body = response.body()
//                        if (response.isSuccessful && body != null) {
//
//                            Log.d("TAG", "ResponseHandler: записали ответ")
//                            emit(BaseResult.Success(response))
//                        } else {
//                            emit(BaseResult.Error(response.errorBody().toString()))
//                        }
//                    } catch (e: Exception) {
//
//                        Log.d("TAG", "ResponseHandler: ошибка")
//                        emit(BaseResult.Error(e.printStackTrace().toString()))
//                    }
//                } else {
//                    Log.d("TAG", "ResponseHandler: ошибка инета")
//                    emit(BaseResult.Error("No internet connection"))
//                }
//            }
//        }
//    }
}