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

4.
