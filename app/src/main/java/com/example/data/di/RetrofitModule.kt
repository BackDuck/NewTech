package com.example.data.di

import com.example.data.Requests
import com.example.newtechnology.BuildConfig
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val retrofitModule = Kodein.Module("RetrofitModule") {

    val BASE_URL = "https://pixabay.com/"

    bind<OkHttpClient>() with singleton {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        builder.build()
    }

    bind<Gson>() with singleton {
        Gson()
    }

    bind<Requests>() with singleton {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(instance()))
            .client(instance())
            .baseUrl(BASE_URL)
            .build()
            .create(Requests::class.java)
    }
}