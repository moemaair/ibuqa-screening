# IBUQA interview solution

# Introduction

- solution is to build a Github issue tracker
- built using kotlin
- leverage [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/)
- clean Architecture
- MVVM
- etc

## Get the app 
use this link to get the latest APK  ➡️
[APK](https://appdistribution.firebase.dev/i/3740dbbed49e8ee8)


## Final look
<img src="https://github.com/moemaair/ibuqa-screening/blob/main/screenshots/ibuqa_interview_recording.gif" width="270"/> <img src="https://github.com/moemaair/ibuqa-screening/blob/main/screenshots/Screenshot_20240404_010737.png" width="270"/> 
<img src="https://github.com/moemaair/ibuqa-screening/blob/main/screenshots/Screenshot_20240404_011327.png" width="270"/>

### Prerequisites

Before running this app, you need to add your Github Personal Access Token, in your `local.properties` file:

```yaml
GITHUB_ACCESS_TOKEN="xxxx-xxxx-xxx"
```

### Background

Build an application that makes use of Github APIs to do a number of things:

* Search for a user repository on Github and display its details which is the issues count, who wrote them, are there comments, state of issue, and timeframe
* be able to showcase in a user friendly manner no complications in design just call the api and filter some logic needed

## Tech-stack

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) - a cross-platform, statically typed, general-purpose programming language with type inference.
    * [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations.
    * [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - handle the stream of data asynchronously that executes sequentially.
    * [Apollo GraphQL Client](https://www.apollographql.com/docs/android/essentials/get-started-kotlin/) - Apollo is a platform for building a data graph.
    * [Hilt - Dagger ](https://dagger.dev/hilt/) - a pragmatic lightweight dependency injection framework.
    * [Material-3](https://developer.android.com/develop/ui/compose/designsystems/material3) - aid personalization features like dynamic color, and is designed to be cohesive with the new visual style and system UI on Android 12 and above.
    * [Jetpack](https://developer.android.com/jetpack)
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - is an observable data holder.
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform action when lifecycle state changes.
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.

## Architecture
* MVVM - Model View View Model
*  Plugins
    * [Graphql](https://plugins.jetbrains.com/plugin/8097-graphql) - provides GraphQL language support to all JetBrains IDEs


## UI and Unit Tests

can be done


## License
```
MIT License

Copyright (c) 2024 Mohamed ibrahim

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
associated documentation files (the "Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN
NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF  TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```
