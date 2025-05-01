# 🔌 Flutter MethodChannel Example

This project demonstrates how to use **Flutter's platform channels (`MethodChannel`)** to communicate with native Android code (Kotlin/Java). It serves as a simple, clean example for calling Android platform-specific functionality from your Flutter app.

---

## 📱 Features

- Communication from Flutter to Android using `MethodChannel`
- Access to native Android APIs (e.g., battery level)
- Error handling for unavailable or failed method calls
- Easily extendable to more native functionality

---

## 📁 Project Structure
lib/
├── main.dart               # App entry point and HomePage
├── widget/
│   └── battery_widget.dart # UI widget to display battery info using FutureBuilder
└── service/
    └── battery_service.dart # Contains MethodChannel logic to communicate with native code

android/
└── app/
    └── src/
        └── main/
            └── kotlin/
                └── com/example/flutter_method_channel/
                    └── MainActivity.kt # Handles the MethodChannel on Android side

## ⚙️ How It Works – Step by Step
- Flutter UI loads → BatteryWidget is displayed in HomePage.
- BatteryWidget uses a FutureBuilder to call BatteryService.getBatteryStatus().
- BatteryService sets up a MethodChannel named 'battery_channel'.
- It calls invokeMethod('getBatteryLevel') to request battery level from Android.
- On the native side (MainActivity.kt):
  - A MethodChannel with the same name (battery_channel) listens for method calls.
  - When it receives 'getBatteryLevel', it fetches the battery level using Android’s BatteryManager.
  - The result is returned back to Flutter via result.success(...).
  - Flutter receives the battery level and displays it in the UI.
