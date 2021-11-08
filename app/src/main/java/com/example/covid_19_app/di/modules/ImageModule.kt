package com.example.covid_19_app.di.modules

import android.widget.ImageView
import com.example.covid_19_app.mvp.model.image.IImageLoader
import com.example.covid_19_app.ui.image.GlideImageLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ImageModule {
    @Singleton
    @Provides
    fun imageLoader(): IImageLoader<ImageView> = GlideImageLoader()
}