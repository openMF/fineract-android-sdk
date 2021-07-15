# Mifos Android Architecture
This is architecture repository for mifos-android-sdk

# Fineract API Client Library  [![GitHub Workflow Status](https://img.shields.io/github/workflow/status/openMF/mifos-android-sdk-arch/Project%20Build)](https://github.com/openMF/mifos-android-sdk-arch/actions/workflows/build_check.yml) [![Jitpack](https://jitpack.io/v/openMF/mifos-android-sdk-arch.svg)](https://jitpack.io/#openMF/mifos-android-sdk-arch) [![License: MPL 2.0](https://img.shields.io/badge/License-MPL%202.0-brightgreen.svg)](https://opensource.org/licenses/MPL-2.0)

A Kotlin based SDK that can be used to interact with the Apache Fineract 1.x Platform. This library depends on [Fineract Client Library](https://github.com/openMF/fineract-client) and exposes the use cases, providing abstraction layer and eliminating the need to take care of building the client. Client application can directly interact with the classes that provide simple methods for interacting with the API.

## Feature
1. Extend [`UserPreferences<USER>`](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/sharedpreference/UserPreferences.kt) and [`BasePreferenceManager`](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/sharedpreference/BasePreferenceManager.kt) classes for handling the preferences tasks.
2. The returned data can be easily casted as per client need using [`EntityMapper`](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/data/EntityMapper.kt) and [`AbstractMapper`](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/data/AbstractMapper.kt)
3. Single point of interaction for all the api services using [BaseApiManager](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/apimanager/BaseApiManager.kt).
4. Use of Kotlin provides endless possibilities to manipulate dat in our own way, client can define custom mapping logic and apply it to `Observable<T>`.

    ```kotlin
    fun <T, To> Observable<T>.map(entityMapper: EntityMapper<T, To>): Observable<To> {
            return this.map { entityMapper.mapFromEntity(it) }
    }
    ```

## Add Gradle Dependency

To add library in your gradle project follow the steps below:

1. Add this in your root `build.gradle` at the end of repositories:
    ```groovy
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
    ```
2. Add the dependency
   ```groovy
   dependencies {
       implementation 'com.github.openMF:mifos-android-sdk-arch:1.0.0'
   }
   ```

## Architecture
1. The core module in the SDK contains all the API requests written.
2. The entry point to the library is the [BaseApiManager](https://github.com/openMF/mifos-android-sdk-arch/blob/development/core/src/main/java/org/mifos/core/apimanager/BaseApiManager.kt).
3. Use companion object's `getInstance()` function to get the instance of the implementation of `BaseApiManager`.
4. For setting up the services, call `createService(username: String, password: String, baseUrl: String, tenant: String)` method of `BaseApiManager` providing valid credentials.
5. Currently only the selected number of APIs are exposed, as much required in [android-client](https://github.com/openMF/android-client).

## Building the Code
1. Clone the repository using command: `git clone https://github.com/openMF/mifos-android-sdk-arch.git`
2. Open Android Studio.
3. Click on 'Open an existing Android Studio project'
4. Browse to the directory where you cloned the android-client repo and click OK.
5. Let Android Studio import the project.
6. Build the application in your device by clicking run button.

## Contributing
1. Fork it
2. Create your feature branch `(git checkout -b my-new-feature)`
3. Commit your changes `(git commit -m 'Add some feature')`
4. In case of multiple commits squash them. You can find guide here: [how to squash commits](https://medium.com/@slamflipstrom/a-beginners-guide-to-squashing-commits-with-git-rebase-8185cf6e62ec)
4. Clear the checks and make sure build is successfull
5. Push your branch `(git push origin my-new-feature)`
6. Create a new Pull Request, following the template