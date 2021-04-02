plugins {
    kotlin("multiplatform") version "1.4.31"
}

val mingwPath = File(System.getenv("MINGW64_DIR") ?: "C:/msys64/mingw64")

kotlin {
    // Determine host preset.
    val hostOs = System.getProperty("os.name")
    val isMingwX64 = hostOs.startsWith("Windows")

    // Create a target for the host platform.
    val hostTarget = when {
        hostOs == "Mac OS X" -> macosX64("gtk")
        hostOs == "Linux" -> linuxX64("gtk")
        isMingwX64 -> mingwX64("gtk")
        else -> throw GradleException("Host OS '$hostOs' is not supported in Kotlin/Native $project.")
    }

    hostTarget.apply {
        binaries {
            executable {
                entryPoint = "org.mrlem.gtk.sample.main"
                if (isMingwX64) {
                    linkerOpts("-L${mingwPath.resolve("lib")}")
                    runTask?.environment("PATH" to mingwPath.resolve("bin"))
                }
            }
        }
    }

    sourceSets {
        get("gtkMain")?.dependencies {
            implementation(project(":gtk"))
        }
    }
}