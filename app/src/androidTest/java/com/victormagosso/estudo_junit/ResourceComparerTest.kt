package com.victormagosso.estudo_junit

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {

    //nao é boa pratica inicial globalmente em um teste
    //pois causa dependencia dos testes
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setup() {
        resourceComparer = ResourceComparer()
    }

    @After
    fun teardown() {
        //fecha uma consulta no banco, por exemplo
    }

    @Test
    fun stringResourceSameAsGiven_returns_TRUE() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Estudo_Junit")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceDifferentAsGiven_returns_FALSE() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Different")
        assertThat(result).isFalse()
    }
}