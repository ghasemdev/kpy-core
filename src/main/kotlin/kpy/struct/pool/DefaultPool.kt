package kpy.struct.pool

/**
 * ### Object Pool Design Pattern
 * The pool stores commonly used objects that must be created
 * throughout the project and take a long time to build.
 * @author jakode2020
 * @since 1.0.0 7/27/2021
 */
object DefaultPool : ObjectPool<Any>() {

    @Throws(IllegalArgumentException::class)
    override fun getObject(key: String?): Any {
        require(poolSize > 0) { "Pool is empty" }
        return key?.let { objects[key] } ?: objects.values.last()
    }

    override fun putObject(key: String, `object`: Any) {
        objects[key] = `object`
    }
}