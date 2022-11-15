package com.linoop.myapp2023.di

import com.linoop.myapp2023.models.DefaultResponse
import com.linoop.myapp2023.models.MyData
import com.linoop.myapp2023.network.Api
import com.linoop.myapp2023.network.MyRetrofit
import com.linoop.myapp2023.storage.MyDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

@Module
@InstallIn(ActivityComponent::class)
object AppModule {

    @Provides
    fun providesMyDatabase(): MyDatabase = MyDatabase()

}

@Module
@InstallIn(ActivityComponent::class)
abstract class NetworkApis {
    @Binds
    abstract fun bindApi(apiImpl: ApiImpl): Api
}

class ApiImpl @Inject constructor(
    @RetrofitFirstServer private val firstServer: MyRetrofit,
    @RetrofitSecondServer private val secondServer: MyRetrofit
    ) : Api {
    override fun downloadData(): DefaultResponse {
        return DefaultResponse(
            status = true,
            message = "Downloaded successfully con: ${firstServer.connection}"
        )
    }

    override fun uploadData(myData: MyData): DefaultResponse {
        return DefaultResponse(true, "Uploaded successfully, con: ${secondServer.connection}, Data${myData.data}")
    }
}
