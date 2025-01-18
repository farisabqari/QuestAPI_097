        package com.example.myapplicationdatabase.model

        import androidx.test.services.events.TestStatus.Status
        import kotlinx.serialization.SerialName
        import kotlinx.serialization.Serializable


        @Serializable
        data class Mahasiswa (
            val nim: String,
            val nama: String,
            val alamat: String,

            @SerialName("jenisKelamin")
            val jenisKelamin: String,

            val kelas: String,
            val angkatan: String
        )

        @Serializable
        data class MahasiswaDetailResponse(
            val status: Boolean,
            val message: String,
            val data: Mahasiswa
        )
        @Serializable
        data class MahasiswaResponse(
            val status: Boolean,
            val message: String,
            val data: List<Mahasiswa>
        )