    package com.example.myapplicationdatabase.Repository


    import com.example.myapplicationdatabase.Services.MahasiswaService
    import com.example.myapplicationdatabase.model.Mahasiswa
    import com.example.myapplicationdatabase.model.MahasiswaResponse
    import okio.IOException

    interface MahasiswaRepository {
        suspend fun getMahasiswa(): MahasiswaResponse
        suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
        suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa)
        suspend fun deleteMahasiswa(nim: String)
        suspend fun getMahasiswaByNim(nim: String):Mahasiswa
    }

    class NetworkMahasiswaRepository(
        private val mahasiswaApiService: MahasiswaService
    ): MahasiswaRepository {
        override suspend fun insertMahasiswa(mahasiswa: Mahasiswa){
            mahasiswaApiService.insertMahasiswa(mahasiswa)
        }

        override suspend fun updateMahasiswa(nim: String, mahasiswa: Mahasiswa) {
            mahasiswaApiService.updateMahasiswa(nim, mahasiswa)
        }
        override suspend fun deleteMahasiswa(nim: String) {
            try {
                val response = mahasiswaApiService.deleteMahasiswa(nim)
                if(!response.isSuccessful){
                    throw IOException("gagal menghapus data Mahasiswa. HTTP kode: ${response.code()}")
                } else {
                    response.message()
                    println(response.message())
                }
            } catch (e:Exception){
                throw e
            }
        }

       // override suspend fun getMahasiswa(): List<Mahasiswa> = mahasiswaApiService.getMahasiswa()
      //  override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
      //      return mahasiswaApiService.getMahasiswaByNim(nim)
     //   }
       override suspend fun getMahasiswa(): MahasiswaResponse{
           return mahasiswaApiService.getMahasiswa()
       }
        override suspend fun getMahasiswaByNim(nim: String): Mahasiswa {
            return mahasiswaApiService.getMahasiswaByNim(nim).data
         }

    }