# Android GooglePlayHelper Library

This library allows developers to easily integrate Google Play intents in an Android application.

## Features

- Display an application's details
- Search an application
- List the applications of a publisher
- Fallback to the web version of Google Play if the Android application is not available

## Sample

A sample application is available: [WebImage Sample](https://play.google.com/store/apps/details?id=org.pierrre.googleplayhelper.sample).

The source code is available in this repository.

## Compatibility

This library is compatible from API 7 (Android 2.1).

## Usage

``` java
GooglePlayHelper.details(this, "org.pierrre.googleplayhelper.sample");
GooglePlayHelper.search(this, "foo bar");
GooglePlayHelper.publisher(this, "Pierre Durand");
```

## Contact

- Email: pierredurand@gmail.com
- Twitter: [@pierredurand87](https://twitter.com/pierredurand87)
- Google+: [Pierre Duraand](https://plus.google.com/115978530878583279430)
- GitHub: [pierrre](https://github.com/pierrre)