package kpy.annotations

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class MockableTest {

    @Test
    fun `TA extended Student`() {
        assertThat(TA()).isInstanceOf(Student::class.java)
    }
}

@Mockable
class Student

class TA : Student()