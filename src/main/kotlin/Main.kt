import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

fun main() {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://655a20c06981238d054d2622.mockapi.io/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    val api = retrofit.create(ApiService::class.java)

    val response = api.getUsers().execute()

    if (response.isSuccessful) {

        val bod =  response.body()
        bod?.forEachIndexed { index, user ->
            println("User : ${index + 1} | name : ${user.name} | email : ${user.email} | password : ${user.password}")
        }
    }
}
