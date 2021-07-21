package kpy.util.annotations

/**
 * ### Mockable annotate make classes open for inheritance or mock testing
 * * configuration in build.gradle
 * ```
 * plugins {
 *  ...
 *  id 'org.jetbrains.kotlin.plugin.allopen' version "VERSION"
 *  ...
 * }
 * allOpen {
 *  annotation("kpy.util.annotations.Mockable")
 * }
 * ```
 */
annotation class Mockable