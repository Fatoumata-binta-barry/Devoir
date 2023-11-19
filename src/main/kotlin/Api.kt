import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Users")
    fun getUsers(): Call<List<Users>>
}