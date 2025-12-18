# TodoMVVM

A simple Android Todo app demonstrating a basic MVVM architecture using Jetpack Compose and a ViewModel-driven UI state.

This exercise was the sixth weekly assignment for the course Mobile programming with Native Technologies in Oulu University of Applied Sciences.

## Overview
This project is a small example app that shows how to structure a Todo list using MVVM (Model-View-ViewModel) with Jetpack Compose UI. It demonstrates loading state, success (list) state, and error state handling in the UI.

## Features
- Jetpack Compose for UI
- ViewModel exposing a UI state (Loading / Success / Error)
- Simple Todo list display

## API
This sample app fetches todos from a public test API (JSONPlaceholder) using Retrofit. The Retrofit service is defined in `app/src/main/java/com/example/todo_mvvm/model/TodosApi.kt` and the network call is used by `app/src/main/java/com/example/todo_mvvm/viewmodel/TodoViewModel.kt`.

If you want to point the app to a different backend, replace `BASE_URL` in `TodosApi.kt` and update the API endpoints accordingly.

## Dependencies (network)
- Retrofit (in `app/build.gradle.kts`): `com.squareup.retrofit2:retrofit` and `com.squareup.retrofit2:converter-gson` are used to perform the HTTP requests and parse JSON.

## Quick start
1. Open the project in Android Studio.
2. Build and run the `app` module on an emulator or Android device running a compatible Android SDK.

No additional configuration is required for this sample project.

## Project structure (high level)
- `app/src/main/java/.../ui` - Compose UI and activity
- `app/src/main/java/.../viewmodel` - ViewModel and UI state classes
- `app/src/main/java/.../model` - Data models (e.g. `Todo`) and API service (`TodosApi.kt`)

## License
Use as you wish for learning and experimentation.

