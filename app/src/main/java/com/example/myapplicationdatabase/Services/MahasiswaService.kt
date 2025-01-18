package com.example.myapplicationdatabase.Services

import com.example.myapplicationdatabase.model.Mahasiswa
import com.example.myapplicationdatabase.model.MahasiswaDetailResponse
import com.example.myapplicationdatabase.model.MahasiswaResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

    //interface MahasiswaService {
    //    @Headers(
    //        "Accept: application/json",
    //        "Content-Type: application/json",
    //    )
    //    @GET("bacamahasiswa.php")
    //    suspend fun getMahasiswa(): List<Mahasiswa>
    //
    //    @GET("baca1mahasiswa.php/{nim}")
    //    suspend fun getMahasiswaByNim(@Query("nim")nim:String):Mahasiswa
    //
    //    @POST("insertmahasiswa.php")
    //    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa)
    //
    //    @PUT("editmahasiswa.php")
    //    suspend fun updateMahasiswa(@Query("nim")nim: String, @Body mahasiswa: Mahasiswa)
    //
    //    @DELETE("deletemahasiswa.php")
    //    suspend fun deleteMahasiswa(@Query("nim")nim: String):Response<Void>
    //}

interface MahasiswaService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json",
    )
    @GET(".")
    suspend fun getMahasiswa(): MahasiswaResponse

    @GET("{nim}")
    suspend fun getMahasiswaByNim(@Query("nim")nim:String): MahasiswaDetailResponse

    @POST("store")
    suspend fun insertMahasiswa(@Body mahasiswa: Mahasiswa)

    @PUT("{nim}")
    suspend fun updateMahasiswa(@Query("nim")nim: String, @Body mahasiswa: Mahasiswa)

    @DELETE("{nim}")
    suspend fun deleteMahasiswa(@Query("nim")nim: String):Response<Void>
}