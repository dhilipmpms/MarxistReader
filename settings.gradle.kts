pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Marxist Reader"
include(":app")
include(":ui:theme")
include(":ui:common")
include(":network")
include(":navigation")
include(":core")
include(":feature:feed")
include(":feature:books")
include(":feature:search")
include(":feature:saved")
include(":feature:feeddetails")
include(":feature:settings")
include(":feature:welcome")
include(":data")
include(":domain")
include(":use-cases")
include(":reader")
