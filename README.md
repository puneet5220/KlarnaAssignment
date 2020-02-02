# Klarna Assignment

## This app allows users to see all the following weather details for Klarna's HQ in Europe/Stockholm-
 - TimeZone
 - Current Weather Summary
 - Hourly Weather Summary
 - Daily Weather Summary

## If the user is connected to the internet, the response is fetched from the API on the Splash Screen.
## If offline, toast error message is displayed to the user.

### Setup

Clone from - https://github.com/puneet5220/KlarnaAssignment.git

### APP details

- Splash screen is displayed to the user and in background, fetching the weather details for the hardcoded latitude and longitude.
- Rotation is supported in this application.
- Unit Test cases included

### Tech Stack used

- [x] MVVM: MVVM used as the pattern along with ViewModel and LiveData to maintain updated state of UI.
- [x] Dagger : Dependency injector.
- [x] RxJava : To fetch the response from JSON read.
- [x] Jackson : For JSON parsing.
- [x] Mockito : For Unit tests. Unit tests are covered for ViewModel and Repository.
- [x] ButterKnife : Used for View Binding.
