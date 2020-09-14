package layout

import java.net.URI.create

object ApiClient {
    fun buildService(java: Class<ApiInterface>): Any {

    }

    object ApiClient {
        var client = OkHttpClient.Builder().build()

        var retrofit = Retrozfit.Builder()
            .baseUrl("https://courses-service.herokuapp.com/")
            .apply(GsonConverterFactory.create())
            .client(client)
            .build()

        fun <T> buildService(service: Class<T>): T {
            return retrofit.create(service)
        }
    }
}

class GsonConverterFactory {

}

class Retrozfit {
    class Builder {
        fun baseUrl(s: String): Any {

        }

    }

}

class OkHttpClient {
    class Builder {
        fun build(): Any {

        }

    }

}
