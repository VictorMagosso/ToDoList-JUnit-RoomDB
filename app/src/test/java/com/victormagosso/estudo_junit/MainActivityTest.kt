package com.victormagosso.estudo_junit

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class MainActivityTest {
    @Test
    fun `empty_user_name_returns_FALSE`() {
        val result = MainActivity().isValidUser("", "john@magosso", "1234", "1234")
        assertThat(result).isFalse()
    }
    @Test
    fun `all_fields_valid_returns_TRUE`() {
        val result = MainActivity().isValidUser("Victor", "mark@magosso", "1234", "1234")
        assertThat(result).isTrue()
    }
    @Test
    fun `email_already_exists_returns_FALSE`() {
        val result = MainActivity().isValidUser("Victor", "victor@magosso", "1234", "1234")
        assertThat(result).isFalse()
    }
    @Test
    fun `password_different_from_confirm_returns_FALSE`() {
        val result = MainActivity().isValidUser("Victor", "markm@magosso", "1234", "asbd")
        assertThat(result).isFalse()
    }
    @Test
    fun `email_is_empty_returns_FALSE`() {
        val result = MainActivity().isValidUser("Victor", "", "1234", "1234")
        assertThat(result).isFalse()
    }
    @Test
    fun `password_is_empty_returns_FALSE`() {
        val result = MainActivity().isValidUser("Victor", "test@email", "", "1234")
        assertThat(result).isFalse()
    }
}