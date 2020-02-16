/*
 * @author   Anoop Maddasseri <anoopmaddasseri@gmail.com>
 * @version  1
 * @since    16th Feb 2020
 *
 * P.S. Increment version when editing
 */
package com.gojek.trendingrepos

import android.app.Application
import com.gojek.trendingrepos.di.AppComponent
import com.gojek.trendingrepos.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

open class GojekTrendingReposApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory()
            .create(applicationContext)

        getApplicationComponent().inject(this)
    }

    open fun getApplicationComponent(): AppComponent = appComponent

    override fun androidInjector(): AndroidInjector<Any> = androidInjector


}