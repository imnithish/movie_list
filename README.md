## MOVIE LIST

###### Data Binding

1. in app level gradle
```
apply plugin: 'kotlin-kapt'
apply plugin: "androidx.navigation.safeargs"
```

2. in app level gradle
```
android{
    dataBinding {
        enabled = true
    }
}
```

3. in project level gradle
```
dependencies{
classpath "android.arch.navigation:navigation-safe-args-gradle-plugin:1.0.0"
}
```

4. in gradle properties
```
android.databinding.enabledV2=true
```

###### Needed Dependencies

```
//Retrofit and GSON
implementation 'com.squareup.retrofit2:retrofit:2.6.0'
implementation 'com.squareup.retrofit2:converter-gson:2.6.0'

//Kotlin Coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.0"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0"

// ViewModel and LiveData
implementation "androidx.lifecycle:lifecycle-extensions:2.2.0"

//New Material Design
implementation 'com.google.android.material:material:1.3.0-alpha01'

//Kodein Dependency Injection
implementation "org.kodein.di:kodein-di-generic-jvm:6.2.1"
implementation "org.kodein.di:kodein-di-framework-android-x:6.2.1"

//Android Navigation Architecture
implementation "androidx.navigation:navigation-fragment-ktx:2.3.0-rc01"
implementation "androidx.navigation:navigation-ui-ktx:2.3.0-rc01"

implementation 'com.github.bumptech.glide:glide:4.11.0'
annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```

###### Install plug-in JSONToKotlin Class Converter

###### Steps

1. create MoviesApi interface
2. create data class
3. create SafeApiRequest
4. create repository to call MoviesApi using SafeApiRequest
5. create fragment with ViewModel
6. setup ViewModel
7. create MoviesViewModelFactory because there is a parameter in MoviesViewModel(so, you can't initialise viewModel in the onActivityCreated function of MoviesFragment)
8. setup onActivityCreated of MoviesFragment
9. create coroutines(so, we can fetch movies in io-thread and get callback to main-thread)
10. create RecyclerView Adapter and do data binding
11. getMovies from viewModel, observe viewModel also set adapter on onActivityCreated of MoviesFragment
```
        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_movies.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = MoviesAdapter(movies)
            }

        })
```
12. create navigation resource file main_nav
13. use NavHostFragment in activity_main layout
14. use data binding
