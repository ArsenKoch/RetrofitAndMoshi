package ua.cn.stu.http.sources.accounts

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import ua.cn.stu.http.sources.accounts.entities.GetAccountResponseEntity
import ua.cn.stu.http.sources.accounts.entities.SignInRequestEntity
import ua.cn.stu.http.sources.accounts.entities.SignUpRequestEntity
import ua.cn.stu.http.sources.accounts.entities.UpdateUsernameRequestEntity

interface AccountsApi {

    @POST("sign-in")
    suspend fun signIn(@Body signInRequestEntity: SignInRequestEntity): SignInRequestEntity

    @POST("sign-up")
    suspend fun signUp(@Body signUpRequestEntity: SignUpRequestEntity)

    @GET("me")
    suspend fun getAccount(): GetAccountResponseEntity

    @PUT("me")
    suspend fun setUsername(@Body usernameRequestEntity: UpdateUsernameRequestEntity)
}