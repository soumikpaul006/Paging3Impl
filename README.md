# AutoParts Catalog

An Android application showcasing modern Android development practices for displaying an automotive parts catalog with infinite scrolling functionality.

## Features

- Infinite scrolling product list using Jetpack Paging 3
- Clean Architecture with MVVM pattern
- Dependency injection using Hilt
- Reactive programming with Kotlin Flow
- Image loading with Glide
- REST API integration using Retrofit
- ViewBinding for view access

## Tech Stack

- **Kotlin** - Primary programming language
- **Coroutines & Flow** - Asynchronous programming
- **Jetpack Libraries**
  - Paging 3
  - ViewModel
  - ViewBinding
- **Dagger Hilt** - Dependency injection
- **Retrofit** - HTTP client
- **Glide** - Image loading
- **OkHttp** - Network interceptor

## Setup

1. Clone the repository
2. Open the project in Android Studio
3. Replace the API key in `AppModule.kt` with your own key
4. Build and run the application

## Architecture

The app follows MVVM architecture with clean code principles:

```
app/
├── model/
│   ├── di/          # Dependency injection
│   ├── dto/         # Data transfer objects
│   ├── network/     # API service
│   └── repository/  # Data repositories
├── view/            # UI components
└── viewmodel/       # ViewModels
```
