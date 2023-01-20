package ua.cn.stu.http.sources

import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ua.cn.stu.http.app.Const
import ua.cn.stu.http.app.Singletons
import ua.cn.stu.http.app.model.SourcesProvider
import ua.cn.stu.http.app.model.settings.AppSettings
import ua.cn.stu.http.sources.base.OkHttpConfig
import ua.cn.stu.http.sources.base.OkHttpSourcesProvider

object SourceProviderHolder {

    val sourcesProvider: SourcesProvider by lazy<SourcesProvider> {
        val config = OkHttpConfig(
            baseUrl = Const.BASE_URL,
            client = createOkHttpClient(),
            gson = Gson()
        )
        OkHttpSourcesProvider(config)
    }

    private fun createOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(createAuthorizationInterceptor(Singletons.appSettings))
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    private fun createAuthorizationInterceptor(settings: AppSettings): Interceptor {
        TODO(
            "#10: create an Interceptor which adds Authorization header if " +
                    "there is a token in the app settings"
        )
    }

    private fun createLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor()

        TODO("#9: create HttpLoggingInterceptor")
    }
}